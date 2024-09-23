package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactCreationTest extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();

//        for (var firstname : List.of("", "firstname")) {
//            for (var lastname : List.of("", "lastname")) {
//                result.add(new ContactData()
//                        .withFirstname(firstname)
//                        .withMiddlename("")
//                        .withLastname(lastname)
//                        .withNickname("")
//                        .withPhoto("src/test/resources/images/avatar.png")
//                        .withTitle("")
//                        .withCompany("")
//                        .withAddress("")
//                        .withHome("")
//                        .withEmail("")
//                        .withHomepage("")
//                        .withBday("-")
//                        .withBmonth("-")
//                        .withByear("")
//                        .withAday("-")
//                        .withAmonth("-")
//                        .withAyear(""));
//            }
//        }
//-------------------------------------------------------------------------------------------------------------
//Чтение json построчно
// файлы бывают очень большими, если можно читать файл строчка за строчкой, тогда все остальные просто игнорируются
//        var json = "";
//        try (var reader = new FileReader("contacts.json");
//             var breader = new BufferedReader(reader)) {
//            var line = breader.readLine();
//            while (line != null) {
//                json = json + line;
//                line = breader.readLine();
//            }
//        }
//        Чтение json целым файлом
//    var json = Files.readString(Paths.get("contacts.json"));
//-------------------------------------------------------------------------------------------------------------
//Чтение json
//        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
//        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {} );
//-------------------------------------------------------------------------------------------------------------
//        Чтение xml
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
//        for (int i = 0; i < 5; i++) {
//            result.add(new ContactData()
//                    .withFirstname(CommonFunctions.randomString(i * 5))
//                    .withMiddlename("")
//                    .withLastname(CommonFunctions.randomString(i * 5))
//                    .withNickname("")
//                    .withPhoto("src/test/resources/images/avatar.png")
//                    .withTitle("")
//                    .withCompany("")
//                    .withAddress("")
//                    .withHome("")
//                    .withEmail("")
//                    .withHomepage("")
//                    .withBday("-")
//                    .withBmonth("-")
//                    .withByear("")
//                    .withAday("-")
//                    .withAmonth("-")
//                    .withAyear(""));
//        }
        return result;
    }

    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withMiddlename(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withNickname(CommonFunctions.randomString(10))
                .withPhoto("src/test/resources/images/avatar.png")
                .withTitle(CommonFunctions.randomString(10))
                .withCompany(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
                .withHome(CommonFunctions.randomString(10))
                .withEmail(CommonFunctions.randomString(10))
                .withHomepage(CommonFunctions.randomString(10))
                .withBday(CommonFunctions.randomIntDay())
                .withBmonth(CommonFunctions.randomIntMonth())
                .withByear(CommonFunctions.randomIntYear())
                .withAday(CommonFunctions.randomIntDay())
                .withAmonth(CommonFunctions.randomIntMonth())
                .withAyear(CommonFunctions.randomIntYear())
        );
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateSingleContact(ContactData contact) {
//        var oldContacts = app.jdbc().getContactList();
//        app.contacts().createContact(contact);
//        var newContacts = app.jdbc().getContactList();
        //Получение списка контактов с применением Hibernate
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var maxId = newContacts.get(newContacts.size() - 1).id();

        var expectedList = new ArrayList<>(oldContacts);

        expectedList.add(contact.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var expectedList = new ArrayList<>(oldContacts);

        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id())
                .withMiddlename("")
                .withNickname("")
                .withPhoto("src/test/resources/images/avatar.png")
                .withTitle("")
                .withCompany("")
                .withAddress("")
                .withHome("")
                .withEmail("")
                .withHomepage("")
                .withBday("1")
                .withBmonth("-")
                .withByear("")
                .withAday("1")
                .withAmonth("-")
                .withAyear(""));

        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));

        app.contacts().createContact(contact);
    }

    @Test
    void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withPhoto("src/test/resources/images/avatar.png");
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.groups().getList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        var maxId = newRelated.get(newRelated.size() - 1).id();

        var expectedList = new ArrayList<>(oldRelated);

        expectedList.add(contact.withId(maxId));
        Assertions.assertEquals(newRelated, expectedList);
    }

    @Test
    void canRemoveContactFromGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.groups().getList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        if (oldRelated.isEmpty()) {
            System.out.println("null");
            var contact = new ContactData()
                    .withFirstname(CommonFunctions.randomString(10))
                    .withLastname(CommonFunctions.randomString(10))
                    .withPhoto("src/test/resources/images/avatar.png");
            app.contacts().createContact(contact, group);
            oldRelated = app.hbm().getContactsInGroup(group);
        }
        var rnd = new Random();
        var index = rnd.nextInt(oldRelated.size());
        app.contacts().removeContactFromGroup(oldRelated.get(index), group);
        var newRelated = app.hbm().getContactsInGroup(group);
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.remove(index);
        Assertions.assertEquals(newRelated, expectedList);
    }
}

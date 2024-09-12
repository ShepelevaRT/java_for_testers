package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {} );
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
                .withBday("-")
                .withBmonth("-")
                .withByear("")
                .withAday("-")
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
}

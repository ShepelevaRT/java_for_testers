package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactFailTest extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData()
                .withFirstname(CommonFunctions.randomString(10))

                .withLastname(CommonFunctions.randomString(10))
                .withMiddlename(CommonFunctions.randomString(10))
                .withNickname(CommonFunctions.randomString(10))
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
    @MethodSource("contactProvider")
    public void canCreateFailContact(ContactData contact) {
        var oldContacts = app.jdbc().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.jdbc().getContactList();
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
}

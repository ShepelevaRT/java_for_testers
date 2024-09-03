package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTest extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData(),
                new ContactData().withFirstname("Rozaliia"),
                new ContactData().withLastname("Shepeleva"),
                new ContactData().withAddress("Ufa city"),
                new ContactData().withEmail("rt.mail@gmail.com"),
                new ContactData().withHome("89999050055"),
                new ContactData("firstname",
                        "middlename",
                        "lastname",
                        "nickname",
                        "title",
                        "company",
                        "address",
                        "home",
                        "email",
                        "homepage",
                        "19",
                        "April",
                        "1993",
                        "16",
                        "May",
                        "2024")));
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomIntDay(),
                    randomIntMonth(),
                    randomIntYear(),
                    randomIntDay(),
                    randomIntMonth(),
                    randomIntYear()
            ));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
}

package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTest extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();

        for (var firstname : List.of("", "firstname")) {
            for (var middlename : List.of("", "middlename")) {
                for (var lastname : List.of("", "lastname")) {
                    result.add(new ContactData()
                            .withFirstname(firstname)
                            .withMiddlename(middlename)
                            .withLastname(lastname)
                    );
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstname(randomString(i * 5))
                    .withMiddlename(randomString(i * 5))
                    .withLastname(randomString(i * 5))
                    .withNickname(randomString(i * 5))
                    .withTitle(randomString(i * 5))
                    .withCompany(randomString(i * 5))
                    .withAddress(randomString(i * 5))
                    .withHome(randomString(i * 5))
                    .withEmail(randomString(i * 5))
                    .withHomepage(randomString(i * 5))
                    .withBday(randomIntDay())
                    .withBmonth(randomIntMonth())
                    .withByear(randomIntYear())
                    .withAday(randomIntDay())
                    .withAmonth(randomIntMonth())
                    .withAyear(randomIntYear())
            );
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

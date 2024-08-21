package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
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
                            "April",
                            "2024"));
        }
        app.contacts().modifyContact(new ContactData().withFirstname("modified name"));
    }
}

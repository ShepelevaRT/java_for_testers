package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTest extends TestBase{

    @Test
    public void canRemoveContact() {
        if(!app.contacts().isContactPresent()) {
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
        app.contacts().removeContact();
    }
}

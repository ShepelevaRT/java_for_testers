package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTest extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
                    new ContactData("", "firstname",
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

        // int contactCount = app.contacts().getCount();
        var oldContact = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        app.contacts().removeContact(oldContact.get(index));
        var newContact = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.remove(index);
        // int newContactCount = app.contacts().getCount();
         Assertions.assertEquals(newContact, expectedList);
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
                    new ContactData("", "firstname",
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
                            "2024"));
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}

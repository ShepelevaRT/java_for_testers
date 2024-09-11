package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTest extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(
                    new ContactData("",
                            "",
                            "",
                            "",
                            "",
                            "src/test/resources/images/avatar.png",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "-",
                            "-",
                            "",
                            "-",
                            "-",
                            ""));
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
                    new ContactData("",
                            "",
                            "",
                            "",
                            "",
                            "src/test/resources/images/avatar.png",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "-",
                            "-",
                            "",
                            "-",
                            "-",
                            ""));
        }
        app.contacts().removeAllContact();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}

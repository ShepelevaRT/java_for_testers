package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
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
                    new ContactData()
                            .withFirstname(CommonFunctions.randomString(10))
                            .withMiddlename(CommonFunctions.randomString(10))
                            .withLastname(CommonFunctions.randomString(10))
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
                            .withAyear(CommonFunctions.randomIntYear()));
        }
//получить количество контактов. что бы сравнить с новым количеством
        // int contactCount = app.contacts().getCount();
//--------------------------------------------------------------------
//получение списка контактов с интерфейса
//        var oldContact = app.contacts().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContact.size());
//        app.contacts().removeContact(oldContact.get(index));
//        var newContact = app.contacts().getList();
//--------------------------------------------------------------------
//получение списка групп с БД
        var oldContacts = app.jdbc().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.jdbc().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
//получить количество контактов. что бы сравнить со старым количеством
        // int newContactCount = app.contacts().getCount();
//--------------------------------------------------------------------
        Assertions.assertEquals(newContacts, expectedList);
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

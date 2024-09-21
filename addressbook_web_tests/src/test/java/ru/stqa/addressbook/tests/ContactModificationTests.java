package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("",
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
                    "1",
                    "-",
                    "",
                    "1",
                    "-",
                    ""));
        }
//Получение списка из интерфейса
//        var oldContacts = app.contacts().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContacts.size());
//        var testData = new ContactData().withFirstname("modified").withLastname("modified_last");
//        app.contacts().modifyContact(oldContacts.get(index), testData, index);
//        var newContacts = app.contacts().getList();
//--------------------------------------------------------------------
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstname("modified_name").withLastname("modified_last");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);

        Assertions.assertEquals(newContacts, expectedList);

    }
}

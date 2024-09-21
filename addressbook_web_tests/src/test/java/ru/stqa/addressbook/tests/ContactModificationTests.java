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
        if (app.contacts().getCount() == 0) {
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
//Получение списка из интерфейса
//        var oldContacts = app.contacts().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldContacts.size());
//        var testData = new ContactData().withFirstname("modified").withLastname("modified_last");
//        app.contacts().modifyContact(oldContacts.get(index), testData, index);
//        var newContacts = app.contacts().getList();
//--------------------------------------------------------------------
//Получение списка из БД
        var oldContacts = app.jdbc().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstname("modified_name").withLastname("modified_last");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.jdbc().getContactList();
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

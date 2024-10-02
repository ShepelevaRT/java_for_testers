package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstname(CommonFunctions.randomString(5))
                    .withMiddlename(CommonFunctions.randomString(5))
                    .withLastname(CommonFunctions.randomString(5))
                    .withNickname(CommonFunctions.randomString(5))
                    .withPhoto("src/test/resources/images/avatar.png")
                    .withTitle(CommonFunctions.randomString(5))
                    .withCompany(CommonFunctions.randomString( 5))
                    .withHome(CommonFunctions.randomString( 5))
                    .withMobile(CommonFunctions.randomString(8))
                    .withWork(CommonFunctions.randomString(5))
                    .withPhone2(CommonFunctions.randomString(5))
                    .withEmail(CommonFunctions.randomString( 5))
                    .withEmail2(CommonFunctions.randomString(5))
                    .withEmail3(CommonFunctions.randomString(5))
                    .withHome(CommonFunctions.randomString( 5))
                    .withEmail(CommonFunctions.randomString(5))
                    .withHomepage(CommonFunctions.randomString( 5))
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
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstname(CommonFunctions.randomString(10)).withLastname(CommonFunctions.randomString(10));
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));

        Assertions.assertEquals(Set.copyOf(newContacts), Set.copyOf(expectedList));

    }
}

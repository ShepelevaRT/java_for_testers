package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

//    @Test
//    void testPhones() {
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//        var phones = app.contacts().getPhones(contact);
//        var expected = Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
//                .filter(s -> s != null && !"".equals(s))
//                .collect(Collectors.joining("\n"));
//        Assertions.assertEquals(expected, phones);
//    }

    @Test
    void testAddress() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var address = app.contacts().getAddress(contact);
        var expected = Stream.of(contact.address())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, address);
    }

//    @Test
//    void testEmails() {
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//        var emails = app.contacts().getEmails(contact);
//        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
//                .filter(s -> s != null && !"".equals(s))
//                .collect(Collectors.joining("\n"));
//        Assertions.assertEquals(expected, emails);
//    }
//
//
//    @Test
//    void testPhones2() {
//        var contacts = app.hbm().getContactList();
//        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
//                Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
//                        .filter(s -> s != null && !"".equals(s))
//                        .collect(Collectors.joining("\n"))));
//        var allData = app.contacts().getPhones();
//        Assertions.assertEquals(expected, allData);
//    }

    @Test
    void testAllInfo() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var address = app.contacts().getAddress(contact);
        var emails = app.contacts().getEmails(contact);

        app.contacts().initContactModification(contact);
        var phonesFromEdit = app.contacts().getPhonesFromEdit();

        var addressFromEdit = app.contacts().getAddressFromEdit();

        var emailsfromEdit = app.contacts().getEmailsFromEdit();

        Assertions.assertEquals(phonesFromEdit, phones);
        Assertions.assertEquals(addressFromEdit, address);
        Assertions.assertEquals(emailsfromEdit, emails);
    }
}

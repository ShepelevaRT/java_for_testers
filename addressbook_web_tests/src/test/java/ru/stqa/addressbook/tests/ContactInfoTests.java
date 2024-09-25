package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones () {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        System.out.println("phones " + phones);
        var expected = Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testAddress () {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var address = app.contacts().getAddress(contact);
        System.out.println("address " + address);
        var expected = Stream.of(contact.address())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, address);
    }

    @Test
    void testEmails () {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var emails = app.contacts().getEmails(contact);
        System.out.println("emails " + emails);
        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, emails);
    }
}

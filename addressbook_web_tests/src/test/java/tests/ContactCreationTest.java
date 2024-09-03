package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTest extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();

        for (var firstname : List.of("", "firstname")) {
            for (var middlename : List.of("", "middlename")) {
                for (var lastname : List.of("", "lastname")) {
                    for (var nickname : List.of( "nickname")) {
                        for (var title : List.of( "title")) {
                            for (var company : List.of( "company")) {
                                for (var address : List.of( "address")) {
                                    for (var home : List.of( "home")) {
                                        for (var email : List.of( "email")) {
                                            for (var homepage : List.of( "homepage")) {
                                                for (var bday : List.of("19")) {
                                                    for (var bmonth : List.of( "April")) {
                                                        for (var byear : List.of( "1993")) {
                                                            for (var aday : List.of( "16")) {
                                                                for (var amonth : List.of( "May")) {
                                                                    for (var ayear : List.of( "2024")) {
                                                                    result.add(new ContactData(
                                                                            firstname,
                                                                            middlename,
                                                                            lastname,
                                                                            nickname,
                                                                            title,
                                                                            company,
                                                                            address,
                                                                            home,
                                                                            email,
                                                                            homepage,
                                                                            bday,
                                                                            bmonth,
                                                                            byear,
                                                                            aday,
                                                                            amonth,
                                                                            ayear
                                                                            ));
                                                                    }}}}}}}}}}}}}}}}

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomString(i * 5),
                    randomIntDay(),
                    randomIntMonth(),
                    randomIntYear(),
                    randomIntDay(),
                    randomIntMonth(),
                    randomIntYear()
            ));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
}

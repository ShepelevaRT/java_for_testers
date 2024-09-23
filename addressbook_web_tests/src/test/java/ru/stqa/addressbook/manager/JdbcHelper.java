package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.awt.desktop.PreferencesEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {

    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }


    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery("select group_id, group_name, group_header, group_footer from group_list")) {
            while (result.next()) {
                groups.add(new GroupData()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<ContactData> getContactList() {
        var contacts = new ArrayList<ContactData>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery("select id, firstname, middlename, lastname, nickname, company, title, address, home, email, homepage, bday, bmonth, byear, aday, amonth, ayear from addressbook")) {
            //var result = statement.executeQuery("select id, firstname, lastname from addressbook")) {

            while (result.next()) {
                contacts.add(new ContactData()
                        .withId(result.getString("id"))
                        .withFirstname(result.getString("firstname"))
                        .withMiddlename(result.getString("middlename"))
                        .withLastname(result.getString("lastname"))
                        .withNickname(result.getString("nickname"))
                        .withTitle(result.getString("title"))
                        .withCompany(result.getString("company"))
                        .withAddress(result.getString("address"))
                        .withHome(result.getString("home"))
                        .withEmail(result.getString("email"))
                        .withHomepage(result.getString("homepage"))
                        .withBday(result.getString("bday"))
                        .withBmonth(result.getString("bmonth"))
                        .withByear(result.getString("byear"))
                        .withAday(result.getString("aday"))
                        .withAmonth(result.getString("amonth"))
                        .withAyear(result.getString("ayear"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    public void checkConsistency() {
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery(
                     "SELECT * FROM address_in_groups ag LEFT JOIN addressbook ab ON ab.id = ag.id WHERE ab.id IS NULL")) {
            if (result.next()) {
                throw new IllegalStateException("DB is corrupted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

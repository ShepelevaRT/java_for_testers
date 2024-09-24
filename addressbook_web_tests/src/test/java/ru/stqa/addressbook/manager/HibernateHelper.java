package ru.stqa.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.manager.hbm.ContactRecord;
import ru.stqa.addressbook.manager.hbm.GroupRecord;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertGroupList(List<GroupRecord> records) {
        return records.stream().map(HibernateHelper::convertGroup).collect(Collectors.toList());
//        List<GroupData> result = new ArrayList<>();
//        for (var record : records) {
//            result.add(convertGroup(record));
//        }
//        return result;
    }

    private static GroupData convertGroup(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convertGroup(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    public List<GroupData> getGroupList() {
        return convertGroupList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public List<ContactData> getContactList() {
        return convertContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    static List<ContactData> convertContactList(List<ContactRecord> records) {
        return records.stream().map(HibernateHelper::convertContact).collect(Collectors.toList());
//        List<ContactData> result = new ArrayList<>();
//        for (var record : records) {
//            result.add(convertContact(record));
//        }
//        return result;
    }

    private static ContactData convertContact(ContactRecord record) {
        var photo = record.photo;
        if (photo != null) {
            photo = "src/test/resources/images/avatar.png";
        }
        return new ContactData("" + record.id, record.firstname, record.middlename, record.lastname, record.nickname, photo, record.title, record.company, record.address, record.home, record.email, record.homepage, "" + record.bday, record.bmonth, record.byear, "" + record.aday, record.amonth, record.ayear);
    }

    private static ContactRecord convertContact(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        var bday = data.bday();
        if ("".equals(bday)) {
            bday = "1";
        }
        var aday = data.aday();
        if ("".equals(aday)) {
            aday = "1";
        }
        return new ContactRecord(Integer.parseInt(id), data.firstname(), data.middlename(), data.lastname(), data.nickname(), data.photo(), data.title(), data.company(), data.address(), data.home(), data.email(), data.homepage(), Integer.parseInt(bday), data.bmonth(), data.byear(), Integer.parseInt(aday), data.amonth(), data.ayear());
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertGroup(groupData));
            session.getTransaction().commit();
        });
    }

    public long getContactCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertContact(contactData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
       return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }
}

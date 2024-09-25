package ru.stqa.addressbook.manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")

public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "middlename")
    public String middlename;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "photo")
    public String photo;

    @Column(name = "nickname")
    public String nickname;

    @Column(name = "title")
    public String title;

    @Column(name = "company")
    public String company;

    @Column(name = "address")
    public String address;

    @Column(name = "home")
    public String home;

    @Column(name = "mobile")
    public String mobile;

    @Column(name = "work")
    public String work;

    @Column(name = "phone2")
    public String phone2;

    @Column(name = "email")
    public String email;

    @Column(name = "email2")
    public String email2;

    @Column(name = "email3")
    public String email3;

    @Column(name = "homepage")
    public String homepage;

    @Column(name = "bday")
    public int bday;

    @Column(name = "bmonth")
    public String bmonth;

    @Column(name = "byear")
    public String byear;

    @Column(name = "aday")
    public int aday;

    @Column(name = "amonth")
    public String amonth;

    @Column(name = "ayear")
    public String ayear;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String middlename, String lastname, String nickname, String photo, String title, String company, String address, String home, String mobile, String work, String phone2, String email, String email2, String email3, String homepage, int bday, String bmonth, String byear, int aday, String amonth, String ayear) {

        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.photo = photo;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.phone2 = phone2;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
    }
}

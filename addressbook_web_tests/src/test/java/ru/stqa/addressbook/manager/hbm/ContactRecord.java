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

    @Column(name = "email")
    public String email;

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
}

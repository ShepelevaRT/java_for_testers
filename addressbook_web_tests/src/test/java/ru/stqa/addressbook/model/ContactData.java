package ru.stqa.addressbook.model;

public record ContactData(String id, String firstname, String middlename, String lastname, String nickname,
                          String photo, String title,
                          String company, String address, String home, String mobile, String work, String phone2,
                          String email, String email2, String email3, String homepage, String bday,
                          String bmonth, String byear, String aday, String amonth, String ayear) {

    public ContactData() {
        this("",
                "",
                "",
                "",
                "",
                "src/test/resources/images/avatar.png",
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
                "",
                "1",
                "-",
                "",
                "1",
                "-",
                "");
    }
    //contact.mobile(), contact.work(), contact.secondary()

    public ContactData withId(String id) {
        return new ContactData(id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id,
                firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withMiddlename(String middlename) {
        return new ContactData(this.id,
                this.firstname,
                middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withTitle(String title) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withHomepage(String homepage) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withBday(String bday) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withAday(String aday) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, aday, this.amonth, this.ayear);
    }

    public ContactData withBmonth(String bmonth) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withAmonth(String amonth) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, amonth, this.ayear);
    }

    public ContactData withByear(String byear) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withAyear(String ayear) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, ayear);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                mobile,
                this.work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                work,
                this.phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }
    public ContactData withPhone2(String phone2) {
        return new ContactData(this.id,
                this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.photo,
                this.title,
                this.company,
                this.address,
                this.home,
                this.mobile,
                this.work,
                phone2,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear, this.aday, this.amonth, this.ayear);
    }
}
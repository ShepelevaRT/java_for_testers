package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String home, String email, String homepage, String bday,
                          String bmonth, String byear, String aday, String amonth, String ayear) {

    public ContactData () {
        this("",
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
                "",
                "",
                "",
                "");
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.firstname,
                this.middlename,
                lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                address,
                this.home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                this.home,
                email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.firstname,
                this.middlename,
                this.lastname,
                this.nickname,
                this.title,
                this.company,
                this.address,
                home,
                this.email,
                this.homepage,
                this.bday,
                this.bmonth,
                this.byear,
                this.aday,
                this.amonth,
                this.ayear);
    }
}
package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(
                new ContactData("firstname",
                        "middlename",
                        "lastname",
                        "nickname",
                        "title",
                        "company",
                        "address",
                        "home",
                        "email",
                        "homepage",
                        "19",
                        "April",
                        "1993",
                        "16",
                        "April",
                        "2024"));
    }

    @Test
    public void canCreateContactWithEmptyName() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstnameOnly() {
      app.contacts().createContact(new ContactData().withFirstname("Rozaliia"));
    }

  @Test
  public void canCreateContactWithLastnameOnly() {
    app.contacts().createContact(new ContactData().withLastname("Shepeleva"));
  }

  @Test
  public void canCreateContactWithAddressOnly() {
    app.contacts().createContact(new ContactData().withAddress("Ufa city"));
  }

  @Test
  public void canCreateContactWithEmailOnly() {
    app.contacts().createContact(new ContactData().withEmail("rt.mail@gmail.com"));
  }

  @Test
  public void canCreateContactWithHomeNumberOnly() {
    app.contacts().createContact(new ContactData().withHome("89999050055"));
  }
}

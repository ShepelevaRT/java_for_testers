import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void canCreateContact() {
        app.createContact(
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
        app.createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstnameOnly() {
      app.createContact(new ContactData().withFirstname("Rozaliia"));
    }

  @Test
  public void canCreateContactWithLastnameOnly() {
    app.createContact(new ContactData().withLastname("Shepeleva"));
  }

  @Test
  public void canCreateContactWithAddressOnly() {
    app.createContact(new ContactData().withAddress("Ufa city"));
  }

  @Test
  public void canCreateContactWithEmailOnly() {
    app.createContact(new ContactData().withEmail("rt.mail@gmail.com"));
  }

  @Test
  public void canCreateContactWithHomeNumberOnly() {
    app.createContact(new ContactData().withHome("89999050055"));
  }
}

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void canCreateContact() {
        createContact(
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
        createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstnameOnly() {
      createContact(new ContactData().withFirstname("Rozaliia"));
    }

  @Test
  public void canCreateContactWithLastnameOnly() {
    createContact(new ContactData().withLastname("Shepeleva"));
  }

  @Test
  public void canCreateContactWithAddressOnly() {
    createContact(new ContactData().withAddress("Ufa city"));
  }

  @Test
  public void canCreateContactWithEmailOnly() {
    createContact(new ContactData().withEmail("rt.mail@gmail.com"));
  }

  @Test
  public void canCreateContactWithHomeNumberOnly() {
    createContact(new ContactData().withHome("89999050055"));
  }
}

package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }

    public void modifyContact(ContactData modifiedContact) {
        selectContact(null);
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactPage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("email"), contact.email());
        type(By.name("homepage"), contact.homepage());
        dropdownClick(By.xpath("//select[@name='bday']"), contact.bday());
        dropdownClick(By.xpath("//select[@name='bmonth']"), contact.bmonth());
        type(By.name("byear"), contact.byear());
        dropdownClick(By.xpath("//select[@name='aday']"), contact.aday());
        dropdownClick(By.xpath("//select[@name='amonth']"), contact.amonth());
        type(By.name("ayear"), contact.ayear());
    }

    private void dropdownClick(By locator, String text) {
        click(locator);
        WebElement dropdown = manager.driver.findElement(locator);
        dropdown.findElement(By.xpath("//option[. = '" + text + "']")).click();
    }

    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContacts();
        returnToContactPage();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void returnToContactPage() {
        click(By.linkText("home"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void removeAllContact() {
        selectAllContact();
        removeSelectedContacts();
        returnToContactPage();
    }

    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));

        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public int getCount() {
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var main_locators = manager.driver.findElements(By.cssSelector("tr:not(:first-child)"));

        for (var locator : main_locators) {
            var lastname = locator.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var firstname =  locator.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var checkbox_locator = locator.findElement(By.name("selected[]"));
            var id = checkbox_locator.getAttribute("value");

            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withMiddlename("")
                    .withLastname(lastname)
                    .withNickname("")
                    .withTitle("")
                    .withCompany("")
                    .withAddress("")
                    .withHome("")
                    .withEmail("")
                    .withHomepage("")
                    .withBday("")
                    .withBmonth("-")
                    .withByear("")
                    .withAday("")
                    .withAmonth("-")
                    .withAyear(""));
        }

        return contacts;
    }
}

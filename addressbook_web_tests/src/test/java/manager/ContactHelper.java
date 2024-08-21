package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper {

    public final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {

        this.manager = manager;
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }

    public void modifyContact(ContactData modifiedContact) {
        selectContact();
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
        dropdownClick(By.name("bday"), contact.bday());
        dropdownClick(By.name("bmonth"), contact.bmonth());
        type(By.name("byear"), contact.byear());
        dropdownClick(By.name("aday"), contact.aday());
        dropdownClick(By.name("amonth"), contact.amonth());
        type(By.name("ayear"), contact.ayear());
    }

    private void dropdownClick(By locator, String text) {
        click(locator);
        {
            WebElement dropdown = manager.driver.findElement(locator);
            dropdown.findElement(By.xpath("//option[. = '" + text + "']")).click();
        }
    }

    public void removeContact() {
        selectContact();
        removeSelectedContact();
        returnToContactPage();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void removeSelectedContact() {
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

    private void selectContact() {
       click(By.name("selected[]"));
    }

    private void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        manager.driver.findElement(locator).click();
    }
}

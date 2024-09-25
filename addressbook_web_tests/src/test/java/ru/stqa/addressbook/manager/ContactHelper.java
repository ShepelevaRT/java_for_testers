package ru.stqa.addressbook.manager;

import org.openqa.selenium.support.ui.Select;
import ru.stqa.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.GroupData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        returnToContactPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactPage();
    }

    public void createContact(ContactData contact, GroupData group) {
        returnToContactPage();
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToContactPage();
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        returnToContactPage();
        selectRemoveGroup(group);
        selectContact(contact);
        removeFromGroup();
        returnToContactPage();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        returnToContactPage();
        selectContact(contact);
        selectAddGroup(group);
        addToGroup();
        returnToContactPage();
    }

    private void addToGroup() {
        click(By.name("add"));
    }

    private void selectAddGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void removeFromGroup() {
        click(By.name("remove"));
    }

    private void selectRemoveGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        returnToContactPage();
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactPage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("nickname"), contact.nickname());
        attach(By.name("photo"), contact.photo());
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
        dropdown.findElement(By.xpath(".//option[. = '" + text + "']")).click();
    }

    public void removeContact(ContactData contact) {
        returnToContactPage();
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
        click(By.xpath("//input[@value='Delete']"));
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

    public void initContactModification(ContactData contact) {
        click(By.xpath(".//td[8]/a[contains(@href,'" + contact.id() + "')]/img[@alt='Edit']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void removeAllContact() {
        returnToContactPage();
        selectAllContact();
        removeSelectedContacts();
        returnToContactPage();
    }

    private void selectAllContact() {
//        var checkboxes = manager.driver.findElements(By.name("selected[]"));
//
//        for (var checkbox : checkboxes) {
//            checkbox.click();
//        }
        manager.driver
                .findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

    public int getCount() {
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        returnToContactPage();
//        var contacts = new ArrayList<ContactData>();
        var main_locators = manager.driver.findElements(By.cssSelector("tr:not(:first-child)"));
return main_locators.stream()
        .map(locator -> {
            var lastname = locator.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var firstname = locator.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var checkbox_locator = locator.findElement(By.name("selected[]"));
            var id = checkbox_locator.getAttribute("value");
            return new ContactData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname);
        })
        .collect(Collectors.toList());
//        for (var locator : main_locators) {
//            var lastname = locator.findElement(By.cssSelector("td:nth-child(2)")).getText();
//            var firstname = locator.findElement(By.cssSelector("td:nth-child(3)")).getText();
//            var checkbox_locator = locator.findElement(By.name("selected[]"));
//            var id = checkbox_locator.getAttribute("value");
//
//            contacts.add(new ContactData()
//                    .withId(id)
//                    .withFirstname(firstname)
//                    .withLastname(lastname));
//            //       .withPhoto("src/test/resources/images/avatar.png"));
//        }
//        return contacts;
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public String getPhonesFromEdit() {
        var homeFromEdit = manager.driver.findElement(By.name("home")).getAttribute("value");
        var mobileFromEdit = manager.driver.findElement(By.name("mobile")).getAttribute("value");
        var workFromEdit = manager.driver.findElement(By.name("work")).getAttribute("value");
        return Stream.of(homeFromEdit, mobileFromEdit, workFromEdit)
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
    }

    public String getAddressFromEdit() {
        var address = manager.driver.findElement(By.name("address")).getAttribute("value");
        return address;
    }

    public String getEmailsFromEdit() {
        var emailFromEdit = manager.driver.findElement(By.name("email")).getAttribute("value");
        var email2FromEdit = manager.driver.findElement(By.name("email2")).getAttribute("value");
        var email3FromEdit = manager.driver.findElement(By.name("email3")).getAttribute("value");
        return Stream.of(emailFromEdit, email2FromEdit, email3FromEdit)
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
    }
}

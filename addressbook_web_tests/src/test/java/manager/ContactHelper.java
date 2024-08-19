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
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        manager.driver.findElement(By.name("title")).click();
        manager.driver.findElement(By.name("title")).sendKeys(contact.title());
        manager.driver.findElement(By.name("company")).click();
        manager.driver.findElement(By.name("company")).sendKeys(contact.company());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).click();
        manager.driver.findElement(By.name("home")).sendKeys(contact.home());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("homepage")).click();
        manager.driver.findElement(By.name("homepage")).sendKeys(contact.homepage());
        manager.driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.bday() + "']")).click();
        }
        manager.driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.bmonth() + "']")).click();
        }
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys(contact.byear());
        manager.driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.aday() + "']")).click();
        }
        manager.driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.amonth() + "']")).click();
        }
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys(contact.ayear());
        manager.driver.findElement(By.xpath("//div[@id=\'content\']/form/input[20]")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        manager.driver.findElement(By.linkText("home")).click();
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }
}

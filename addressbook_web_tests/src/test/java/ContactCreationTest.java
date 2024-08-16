import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreationTest {
  private static WebDriver driver;

  @BeforeEach
  public void setUp() {
    if (driver == null) {
      driver = new ChromeDriver();
      Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
      driver.get("http://localhost/addressbook/");
      driver.manage().window().setSize(new Dimension(974, 1032));
      driver.findElement(By.name("user")).sendKeys("admin");
      driver.findElement(By.name("pass")).sendKeys("secret");
      driver.findElement(By.xpath("//form[@id=\'LoginForm\']/input[3]")).click();
    }
  }

  @Test
  public void canCreateContact() {
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).sendKeys("first name");
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).sendKeys("middle name");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).sendKeys("last name");
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).sendKeys("nick");
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).sendKeys("title");
    driver.findElement(By.name("company")).click();
    driver.findElement(By.name("company")).sendKeys("company");
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).sendKeys("address");
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).sendKeys("89639070064");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).sendKeys("mail@m.ru");
    driver.findElement(By.name("homepage")).click();
    driver.findElement(By.name("homepage")).sendKeys("homepage");
    driver.findElement(By.name("bday")).click();
    {
      WebElement dropdown = driver.findElement(By.name("bday"));
      dropdown.findElement(By.xpath("//option[. = '19']")).click();
    }
    driver.findElement(By.name("bmonth")).click();
    {
      WebElement dropdown = driver.findElement(By.name("bmonth"));
      dropdown.findElement(By.xpath("//option[. = 'April']")).click();
    }
    driver.findElement(By.name("byear")).click();
    driver.findElement(By.name("byear")).sendKeys("1993");
    driver.findElement(By.name("aday")).click();
    {
      WebElement dropdown = driver.findElement(By.name("aday"));
      dropdown.findElement(By.xpath("//option[. = '16']")).click();
    }
    driver.findElement(By.name("amonth")).click();
    {
      WebElement dropdown = driver.findElement(By.name("amonth"));
      dropdown.findElement(By.xpath("//option[. = 'April']")).click();
    }
    driver.findElement(By.name("ayear")).click();
    driver.findElement(By.name("ayear")).sendKeys("1994");
    driver.findElement(By.xpath("//div[@id=\'content\']/form/input[20]")).click();
    driver.findElement(By.linkText("home page")).click();

  }

  @Test
  public void canCreateContactWithEmptyName() {
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).sendKeys("");
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).sendKeys("");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).sendKeys("");
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).sendKeys("");
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).sendKeys("");
    driver.findElement(By.name("company")).click();
    driver.findElement(By.name("company")).sendKeys("");
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).sendKeys("");
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).sendKeys("");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).sendKeys("");
    driver.findElement(By.name("homepage")).click();
    driver.findElement(By.name("homepage")).sendKeys("");
    driver.findElement(By.name("byear")).click();
    driver.findElement(By.name("byear")).sendKeys("");
    driver.findElement(By.name("ayear")).click();
    driver.findElement(By.name("ayear")).sendKeys("");
    driver.findElement(By.xpath("//div[@id=\'content\']/form/input[20]")).click();
    driver.findElement(By.linkText("home page")).click();

  }
}

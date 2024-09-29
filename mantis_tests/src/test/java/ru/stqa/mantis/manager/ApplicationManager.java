package ru.stqa.mantis.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {

    private WebDriver driver;

    private String string;

    private Properties properties;

    private SessionHelper sessionHelper;

    private HttpSessionHelper httpSessionHelper;

    private JamesCliHelper JamesCliHelper;


    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;

    }

    public WebDriver driver() {
        if (driver == null) {
            if ("Google Chrome".equals(string)) {
                driver = new ChromeDriver();
            } else if ("Firefox".equals(string)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", string));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
        }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }

        return sessionHelper;
    }

    public HttpSessionHelper http() {
        if (httpSessionHelper == null) {
            httpSessionHelper = new HttpSessionHelper(this);
        }
        return httpSessionHelper;
    }

    public String property (String name) {
        return properties.getProperty(name);
    }

    public JamesCliHelper jamesCli() {
        if (JamesCliHelper == null) {
            JamesCliHelper = new JamesCliHelper(this);
        }
        return JamesCliHelper;
    }
}

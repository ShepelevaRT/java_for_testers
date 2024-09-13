package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() throws IOException {
        if (app == null) {
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "Google Chrome"), properties);
        }

    }

    public static String randomIntDay() {
        var rnd = new Random();
        int number = (int) (rnd.nextInt(30) + 1);
        String result = String.valueOf(number);
        return result;
    }

    public static String randomIntMonth() {
        var rnd = new Random();
        int number = (int) (rnd.nextInt(11));
        var month = new String[]{"January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"};
        String result = month[number];
        return result;
    }

    public static String randomIntYear() {
        var rnd = new Random();
        int number = (int) (rnd.nextInt(1960) + 63);
        String result = String.valueOf(number);
        return result;
    }
}

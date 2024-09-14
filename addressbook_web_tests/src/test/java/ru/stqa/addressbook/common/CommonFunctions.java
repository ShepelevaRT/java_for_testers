package ru.stqa.addressbook.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char) ('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
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
        int number = (int) (rnd.nextInt(63) + 1960);
        String result = String.valueOf(number);
        return result;
    }
}

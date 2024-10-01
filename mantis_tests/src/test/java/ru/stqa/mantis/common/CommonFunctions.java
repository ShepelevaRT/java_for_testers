package ru.stqa.mantis.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random();
        Supplier<Integer> randomNumbers = () -> rnd.nextInt(26);
        var result = Stream.generate(randomNumbers)
                .limit(n)
                .map(i -> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());

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

    public static String extractUrl(String message) {
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(message);
        var url = "";
        if (matcher.find()) {
            url = message.substring(matcher.start(), matcher.end());
        }
        return url;
    }
}

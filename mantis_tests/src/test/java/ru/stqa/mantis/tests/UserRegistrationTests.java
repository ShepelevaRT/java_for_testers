package ru.stqa.mantis.tests;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;

public class UserRegistrationTests extends TestBase {

    @Test
    void canRegisterUser() {
        var email = String.format("%s@localhost", CommonFunctions.randomString(8));
        var password = "password";
        var username = CommonFunctions.randomString(5);
        app.jamesCli().addUser(email, password);
        app.http().signUp();
        app.user().signUp(username, email);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        System.out.println("messages " + messages);
        var url = app.mail().extractUrl(messages);
        System.out.println("url " + url);
        app.user().editAccount((String) url, username, password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());

        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        // заполняем форму создания и отправляем (браузер)
        // ждем почту (MailHelper)
        // извлечь ссылку
        // проходим по ссылке и завершаем регистрацию пользователя (браузер)
        // проверка, что пользователь может залогиниться (HttpSessionHelper)
    }

    @Test
    void deleteUser() {
        var users = app.jamesCli().getListUsers();
        var user = String.valueOf(users);
        var username = app.jamesCli().extractUser(user);
        var password = "password";
        app.mail().drain(username, password);
        app.jamesCli().removeUser(username);
    }
}

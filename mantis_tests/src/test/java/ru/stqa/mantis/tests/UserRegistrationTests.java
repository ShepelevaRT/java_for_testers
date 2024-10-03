package ru.stqa.mantis.tests;

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
        //Тест регистрирует новый адрес на почтовом сервере James.
        app.jamesCli().addUser(email, password);
        //Пользователь с главной страницы начинает регистрацию.
        app.http().loginPage();
        app.user().signUp(username, email);
        //Mantis отправляет письмо на указанный адрес, тест должен получить это письмо, извлечь из него ссылку для подтверждения, пройти по этой ссылке и завершить регистрацию.
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var url = app.mail().extractUrl(messages);
        app.user().editAccount((String) url, username, password);
        app.http().login(username, password);
        //Затем тест должен проверить, что пользователь может войти в систему с новым паролем. Этот шаг можно выполнить на уровне протокола HTTP
        Assertions.assertTrue(app.http().isLoggedIn());

        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        // заполняем форму создания и отправляем (браузер)
        // ждем почту (MailHelper)
        // извлечь ссылку
        // проходим по ссылке и завершаем регистрацию пользователя (браузер)
        // проверка, что пользователь может залогиниться (HttpSessionHelper)
    }

    //тест deleteUser нужен исключительно для отладки, что бы удалять нагенеренные адреса на почтовом сервере James
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

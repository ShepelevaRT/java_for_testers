package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.stream.Stream;

public class UserCreationTests extends TestBase {

    DeveloperMailUser user;

    @Test
    void canCreateUser() {
        //Тест регистрирует новый адрес на почтовом сервере James, используя REST API.
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());
        var password = "password";
        //Сценарий начинает регистрацию нового пользователя в Mantis, используя REST API.
        app.rest().createUser(new UserData()
                .withUsername(user.name())
                .withEmail(email));
   //     app.user().startCreation(user.name(), email);
        //Mantis отправляет письмо на указанный адрес, тест должен получить это письмо, извлечь из него ссылку для подтверждения, пройти по этой ссылке и завершить регистрацию.
        var message = app.developerMail().receive(user, Duration.ofSeconds(60));
        var url = CommonFunctions.extractUrl(message);
        app.user().editAccount(url, user.name(), password);
        app.http().login(user.name(), password);
        //Затем тест должен проверить, что пользователь может войти в систему с новым паролем. Этот шаг можно выполнить на уровне протокола HTTP
        Assertions.assertTrue(app.http().isLoggedIn());

    }

    @AfterEach
    void userDelete() {
        app.developerMail().deleteUser(user);
    }
}

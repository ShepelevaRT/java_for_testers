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
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());
        //здесь применяю метод по созданию пользователя
        app.rest().createUser(new UserData()
                .withUsername(user.name())
                .withEmail(email));
//        app.user().startCreation(user.name(), email);
        var message = app.developerMail().receive(user, Duration.ofSeconds(60));
        var url = CommonFunctions.extractUrl(message);
        app.user().editAccount(url, user.name(), password);
        app.http().login(user.name(), password);
        Assertions.assertTrue(app.http().isLoggedIn());

    }

    @AfterEach
    void userDelete() {
        app.developerMail().deleteUser(user);
    }
}

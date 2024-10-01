package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void signUp(String username, String email) {
        openSignUpPage();
        fillForm(username, email);
        submitClick();
    }

    private void submitClick() {
        click(By.cssSelector("input[type='submit']"));
    }

    private void fillForm(String username, String email) {
        type(By.name("username"), username);
        type(By.name("email"), email);
    }

    private void openSignUpPage() {
        click(By.xpath(".//a[contains(text(),'Signup for a new account')]"));
    }

    public void editAccount(String url, String username, String password) {
        clickLink(url);
        fillEditAccountForm(username, password);
        submitUpdate();
    }

    private void submitUpdate() {
        click(By.cssSelector("span.bigger-110"));
    }

    private void fillEditAccountForm(String username, String password) {
        type(By.name("realname"), username);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);

    }

    private void clickLink(String url) {
        manager.driver().get(url);
    }

    public void startCreation(String user, String email) {
        if (!manager.session().isLoggedIn()) {
            manager.session().login(manager.property("web.username"), manager.property("web.password"));
        }
        manager.driver().get(String.format("%s/manage_user_create_page.php", manager.property("web.baseUrl")));
        type(By.name("username"), user);
        type(By.name("realname"), user);
        type(By.name("email"), email);
        click(By.cssSelector("input[type='submit']"));

    }
}

package ru.stqa.mantis.model;
// рекорд для пользователя, которого создадим
public record UserData(String name, String email) {

    public UserData() {
        this("", "");
    }

    public UserData withUsername (String username) {
        return new UserData(username, this.email);
    }

    public UserData withEmail (String email) {
        return new UserData(this.name, email);
    }
}

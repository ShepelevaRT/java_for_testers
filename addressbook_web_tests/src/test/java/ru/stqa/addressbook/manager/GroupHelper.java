package ru.stqa.addressbook.manager;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupsPage(); // открыть страницу со списком групп
        selectGroup(group); // выбрать группу, отметить галочкой
        initGroupModification(); // нажать кнопку модификации
        fillGroupForm(modifiedGroup); // заполнить форму данными, которые содержатся в объекте, переданном в качестве параметра
        submitGroupModification(); // сохраняем форму
        returnToGroupsPage(); //возвращаемся на страницу со списком групп
    }

    @Step
    public void removeGroup(GroupData group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removeSelectedGroups() {
        click(By.name("delete"));
    }

    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup(GroupData group) {
        click(By.cssSelector(String.format("input[value='%s']", group.id())));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();

    }

    private void selectAllGroups() {
        //        for (var checkbox : checkboxes) {
//            checkbox.click();
//        }
//        checkboxes.forEach(checkbox -> checkbox.click());
        manager.driver.
                findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

    public List<GroupData> getList() {
        openGroupsPage();
//        var groups = new ArrayList<GroupData>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        return spans.stream()
                .map(span -> {
                    var name = span.getText();
                    var checkbox = span.findElement(By.name("selected[]"));
                    var id = checkbox.getAttribute("value");
                    return new GroupData()
                            .withId(id)
                            .withName(name);
                })
                .collect(Collectors.toList());
//        for (var span : spans) {
//            var name = span.getText();
//            var checkbox = span.findElement(By.name("selected[]"));
//            var id = checkbox.getAttribute("value");
//            groups.add(new GroupData()
//                    .withId(id)
//                    .withName(name));
//        }
//        return groups;
    }
}

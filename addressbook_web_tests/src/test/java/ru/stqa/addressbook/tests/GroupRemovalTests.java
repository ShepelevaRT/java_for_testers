package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "", "", ""));
        }
//получить количество групп. что бы сравнить с новым количеством
//        int groupCount = app.groups().getCount();
//--------------------------------------------------------------------
//получение списка групп с интерфейса
//        var oldGroups = app.groups().getList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldGroups.size());
//        app.groups().removeGroup(oldGroups.get(index));
//        var newGroups = app.groups().getList();
//--------------------------------------------------------------------
//получить количество групп. что бы сравнить со старым количеством
        // int newGroupCount = app.groups().getCount();
//--------------------------------------------------------------------
//получение списка групп с БД
//        var oldGroups = app.jdbc().getGroupList();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldGroups.size());
//        app.groups().removeGroup(oldGroups.get(index));
//        var newGroups = app.jdbc().getGroupList();
//Получение списков с использованием Hibernate
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups, expectedList);
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "", "", ""));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.hbm().getGroupCount());
    }
}

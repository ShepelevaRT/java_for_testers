package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.GroupData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCreationTests extends TestBase {

    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of("", "group name")) {
//            for (var header : List.of("", "group header")) {
//                for (var footer : List.of("", "group footer")) {
//                    result.add(new GroupData()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }
//-------------------------------------------------------------------------------------------------------------
//Чтение json построчно
// файлы бывают очень большими, если можно читать файл строчка за строчкой, тогда все остальные просто игнорируются
//        var json = "";
//        try (var reader = new FileReader("groups.json");
//        var breader = new BufferedReader(reader)) {
//            var line = breader.readLine();
//            while (line != null) {
//                json = json + line;
//                line = breader.readLine();
//            }
//        }
//-------------------------------------------------------------------------------------------------------------
//        Чтение json целым файлом
//        var json = Files.readString(Paths.get("groups.json"));
//-------------------------------------------------------------------------------------------------------------
//Чтение json
//        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
//
//        var value = mapper.readValue(json, new TypeReference<List<GroupData>>() {} );
//-------------------------------------------------------------------------------------------------------------
//        Чтение xml
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("groups.xml"), new TypeReference<List<GroupData>>() {
        });
//-------------------------------------------------------------------------------------------------------------
        result.addAll(value);
//        for (int i = 0; i < 5; i++) {
//            result.add(new GroupData()
//                    .withName(CommonFunctions.randomString(i * 10))
//                    .withHeader(CommonFunctions.randomString(i * 10))
//                    .withFooter(CommonFunctions.randomString(i * 10)));
//        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name'", "", "")
        ));
        return result;
    }

    public static Stream<GroupData> randomGroups() {
        Supplier<GroupData> randomGroup = () -> new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10));
        return Stream.generate(randomGroup).limit(3);
    }

    @ParameterizedTest
    @MethodSource("randomGroups")
    public void canCreateGroup(GroupData group) {

//получение списка групп с интерфейса
//        var oldGroups = app.groups().getList();
//        app.groups().createGroup(group);
//        var newGroups = app.groups().getList();
//--------------------------------------------------------------------
//получение списка групп с БД
//        var oldGroups = app.jdbc().getGroupList();
//        app.groups().createGroup(group);
//        var newGroups = app.jdbc().getGroupList();
//получение списка групп с БД через Hibernate
        var oldGroups = app.hbm().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();

        var extraGroups = newGroups.stream().filter(g -> !oldGroups.contains(g)).toList();
        var newId = extraGroups.get(0).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newId));
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group) {

//получение списка групп с интерфейса
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);

    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateMultipleGroups(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(oldGroups, newGroups);
    }


}

package ru.stqa.mantis.manager;

import org.openqa.selenium.io.CircularOutputStream;
import org.openqa.selenium.os.CommandLine;

import java.util.regex.Pattern;

public class JamesCliHelper extends HelperBase {

    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser (String email, String password) {
        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "AddUser", email, password);
        CircularOutputStream out = new CircularOutputStream();
        cmd.setWorkingDirectory(manager.property("james.workingDir"));
        cmd.copyOutputTo(out);
        cmd.execute();
        cmd.waitFor();
        System.out.println("out " + out);
    }

    public void removeUser (String email) {
        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "RemoveUser", email);
        CircularOutputStream out = new CircularOutputStream();
        cmd.setWorkingDirectory(manager.property("james.workingDir"));
        cmd.copyOutputTo(out);
        cmd.execute();
        cmd.waitFor();
        System.out.println("out " + out);
    }

    public CircularOutputStream getListUsers () {
        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "ListUsers");
        CircularOutputStream out = new CircularOutputStream();
        cmd.setWorkingDirectory(manager.property("james.workingDir"));
        cmd.copyOutputTo(out);
        cmd.execute();
        cmd.waitFor();
        return out;
    }

    public String extractUser(String user) {
        var messages = getListUsers();
        var text = String.valueOf(messages);
        var pattern = Pattern.compile("\\S*@localhost");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            user = text.substring(matcher.start(), matcher.end());
            System.out.println("user " + user);
        }
        return user;
    }
}

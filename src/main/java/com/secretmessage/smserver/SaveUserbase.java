package com.secretmessage.smserver;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class SaveUserbase {
    public void SaveUserbase(User user_to_save) throws IOException {
        Gson gson = new Gson();
        Path fileName = Path.of("Userbase.txt");
        String unparsed_userbase = Files.readString(fileName);

        Userlist users = gson.fromJson(unparsed_userbase, Userlist.class);
        System.out.println(user_to_save.username);
        users.userlist.add(user_to_save);
        String json = gson.toJson(users);
    }
}

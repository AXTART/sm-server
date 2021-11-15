package com.secretmessage.smserver;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;
import java.util.function.IntFunction;

public class ReadUserbase extends Vector<User> {
    public Vector<User> ReadUserbase(long id) throws IOException {
        Gson gson = new Gson();
        Path fileName = Path.of("Userbase.txt");
        String unparsed_userbase = Files.readString(fileName);

        Userlist users = gson.fromJson(unparsed_userbase, Userlist.class);
        return users.userlist;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }
}

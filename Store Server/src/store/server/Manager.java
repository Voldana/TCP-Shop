package store.server;

import java.util.List;
import java.util.LinkedList;

public class Manager {

    private String username, password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isItManager(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}

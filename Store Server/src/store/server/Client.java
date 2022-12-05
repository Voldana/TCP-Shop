package server;

import java.io.*;

public class Client {

    private String username, password;
    private int wallet = 0;

    public Client(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public boolean isItClient(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

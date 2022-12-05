package user;

import java.io.IOException;

public class User {

    public static void main(String[] args) throws IOException {
        String list = "\nCar\nBlue\n20000\n192\n4\nGloves\nBlack\n14.99\n168\n3";
        UserManager manager = new UserManager();
        manager.readList(list);
        manager.showProductList();
    }

}

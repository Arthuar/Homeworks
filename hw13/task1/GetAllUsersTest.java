package homeWork13.task1;

import homeWork13.Task1Methods;
import homeWork13.User;

import java.io.IOException;
import java.util.List;

public class GetAllUsersTest {
    public static void main(String[] args) {
        List<User> users = null;
        try {
            users = Task1Methods.getUsers();

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }


        if(users != null) {
            for (User user : users) {
                System.out.println(user + "\n");
            }
        }
    }
}


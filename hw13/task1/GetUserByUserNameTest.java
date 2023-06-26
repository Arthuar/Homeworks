package homeWork13.task1;

import homeWork13.Task1Methods;
import homeWork13.User;

import java.io.IOException;

public class GetUserByUserNameTest {
    public static void main(String[] args) {
        User userByUsername = null;

        try {
            userByUsername = Task1Methods.getUserByUsername("Karianne");
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(userByUsername);
    }
}

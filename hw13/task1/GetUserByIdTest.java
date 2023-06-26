package homeWork13.task1;

import homeWork13.Task1Methods;
import homeWork13.User;

import java.io.IOException;

public class GetUserByIdTest {
    public static void main(String[] args) {
        User userById = null;
        int id = 2;

        try {
            userById = Task1Methods.getUserById(id);
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(userById);
    }
}

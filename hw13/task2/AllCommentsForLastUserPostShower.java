package homeWork13.task2;

import homeWork13.Task1Methods;
import homeWork13.Task2CommentsShower;
import homeWork13.User;

import java.io.IOException;
import java.util.List;

public class AllCommentsForLastUserPostShower {
    public static void main(String[] args) {
        List<User> users;
        try {
            users = Task1Methods.getUsers();
            Task2CommentsShower.commentsToLastUserPost(users.get(5));
        }catch (IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }

    }
}
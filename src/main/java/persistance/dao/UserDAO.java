package persistance.dao;

import domain.User;
import exception.UserNotFoundException;
import persistance.FakeDB;

import java.util.List;

public class UserDAO {

    public static List<User> getUsers(){
        return FakeDB.getInstance().getUsers();
    }

    public static User getUser(User user) throws UserNotFoundException {
        return FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(user.getName()) &&
                        u.getPassword().equals((user.getPassword())))
                .findAny()
                .orElseThrow(UserNotFoundException::new);
    }
}

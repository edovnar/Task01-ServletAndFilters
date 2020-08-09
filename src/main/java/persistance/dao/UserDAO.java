package persistance.dao;

import domain.User;
import persistance.FakeDB;

import java.util.List;

public class UserDAO {

    public static List<User> getUsers(){
        return FakeDB.getInstance().getUsers();
    }

    public static User getUser(User user){
        return FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(user.getName()) &&
                        u.getPassword().equals((user.getPassword())))
                .findAny()
                .orElse(null);
    }

    //todo via threadLocal context
    public static User getUserByName(String name){
        return FakeDB.getInstance().getUsers().stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}

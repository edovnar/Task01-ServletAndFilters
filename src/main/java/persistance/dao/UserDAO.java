package persistance.dao;

import domain.User;
import exception.UserNotFoundException;
import persistance.FakeDB;

import java.util.List;

public class UserDAO {

    private UserDAO() { }

        private static class Singleton{
            public static final UserDAO INSTANCE = new UserDAO();
        }

    public static UserDAO getInstance(){ return UserDAO.Singleton.INSTANCE; }

    public List<User> getUsers(){
        return FakeDB.getInstance().getUsers();
    }

    public User getUser(User user) throws UserNotFoundException {
        return FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(user.getName()) &&
                        u.getPassword().equals((user.getPassword())))
                .findAny()
                .orElseThrow(UserNotFoundException::new);
    }
}

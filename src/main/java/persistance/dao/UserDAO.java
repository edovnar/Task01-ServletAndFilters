package persistance.dao;

import domain.User;
import exception.UserNotFoundException;
import persistance.FakeDB;

import java.util.List;
import java.util.Optional;

public class UserDAO {

    private UserDAO() { }

        private static class Singleton{
            public static final UserDAO INSTANCE = new UserDAO();
        }

    public static UserDAO getInstance(){ return UserDAO.Singleton.INSTANCE; }


    public List<User> getAll(){
        return FakeDB.getInstance().getUsers();
    }

    public Optional<User> getByName(String name) {
        return FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(name))
                .findAny();
    }
}

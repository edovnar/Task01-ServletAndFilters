package service;

import domain.User;
import exception.UserNotFoundException;
import persistance.dao.UserDAO;

import java.util.List;

public class UserService {

    public static List<User> getAllUsers(){
        return UserDAO.getUsers();
    }

    public static User getUser(User user) throws UserNotFoundException {
        return UserDAO.getUser(user);
    }
}

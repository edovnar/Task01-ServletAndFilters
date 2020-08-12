package service;

import domain.User;
import exception.UserNotFoundException;
import persistance.dao.UserDAO;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    private UserService(){
        this.userDAO = UserDAO.getInstance();
    }

        private static class Singleton{
            private  static final UserService INSTANCE = new UserService();
        }

    public static UserService getInstance(){ return Singleton.INSTANCE;}

    public List<User> getAllUsers(){
        return userDAO.getUsers();
    }

    public User getUser(User user) throws UserNotFoundException {
        return userDAO.getUser(user);
    }
}

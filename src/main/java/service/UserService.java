package service;

import domain.User;
import persistance.dao.UserDAO;

import java.util.List;

public class UserService {

    public static List<User> getAllUsers(){
        try{
            return UserDAO.getUsers();
        } catch (NullPointerException e){
            return null;
        }
    }

    public static User getUser(User user) {
        try {
            return UserDAO.getUser(user);
        } catch (NullPointerException e) {
            return null;
        }
    }
}

package ioc.service;

import ioc.domain.User;
import ioc.exception.UserNotFoundException;
import ioc.persistance.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    private UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers(){
        return userDAO.getAll();
    }

    public User getUser(String name){
        return userDAO.getByName(name)
                .orElseThrow(UserNotFoundException::new);
    }
}

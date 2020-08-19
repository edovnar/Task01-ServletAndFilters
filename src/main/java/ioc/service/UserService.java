package ioc.service;

import ioc.domain.User;
import ioc.exception.UserNotFoundException;
import ioc.persistance.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDAO userDAO;

    private UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User getUser(String name){
        return userDAO.getByName(name)
                .orElseThrow(UserNotFoundException::new);
    }
}

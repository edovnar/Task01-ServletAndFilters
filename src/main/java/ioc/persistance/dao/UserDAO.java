package ioc.persistance.dao;

import ioc.domain.User;
import ioc.persistance.FakeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {

    FakeDB db;

    @Autowired
    private UserDAO(FakeDB db) {
        this.db = db;
    }

    public List<User> getAll() {
        return db.getUsers();
    }

    public Optional<User> getByName(String name) {
        return  db.getUsers().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }
}

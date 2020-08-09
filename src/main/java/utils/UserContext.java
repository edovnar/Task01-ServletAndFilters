package utils;

import domain.User;

public class UserContext {
    private static final ThreadLocal<User> thUser = new ThreadLocal<>();

    public static User getCurrentUser() {
        return thUser.get();
    }

    public static void setCurrentUser(User user){
        thUser.set(user);
    }
}

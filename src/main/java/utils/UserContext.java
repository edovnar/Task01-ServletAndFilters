package utils;

import domain.User;

public class UserContext {
    private static final ThreadLocal<User> inheritableThreadLocal = new ThreadLocal<>();

    public static User getCurrentUser() {
        return inheritableThreadLocal.get();
    }

    public static void setCurrentUser(User user){
        inheritableThreadLocal.set(user);
    }
}

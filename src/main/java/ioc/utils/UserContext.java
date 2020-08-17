package ioc.utils;

import ioc.domain.User;

public class UserContext {
    private static final InheritableThreadLocal<User> THREAD_LOCAL = new InheritableThreadLocal<>();

    public static User getCurrentUser() {
        return THREAD_LOCAL.get();
    }

    public static void setCurrentUser(User user){
        THREAD_LOCAL.set(user);
    }
}

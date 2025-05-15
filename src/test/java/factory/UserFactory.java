package factory;

import config.EnvLoader;
import models.User;

public class UserFactory {
    public static User getInvalidUserFromEnv() {
        String email = EnvLoader.getProperty("user.email");
        String password = "Wrong" + EnvLoader.getProperty("user.password");
        return new User(email, password);
    }

    public static User getValidUserFromEnv() {
        String email = EnvLoader.getProperty("user.email");
        String password = EnvLoader.getProperty("user.password");
        return new User(email, password);
    }
    public static User getValidUserFromEnv(String name) {
        String email = EnvLoader.getProperty("user.email");
        String password = EnvLoader.getProperty("user.password");
        User user = new User(email, password);
        user.setName(name);
        return user;
    }
}

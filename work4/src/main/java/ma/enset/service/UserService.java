package ma.enset.service;
import jdk.jshell.spi.ExecutionControl;
import java.util.Collection;

import java.util.*;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public User editUser(User user) {
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return user;
        }
        return null;
    }

    public void deleteUser(String id) {
        users.remove(id);
    }

    public boolean userExist(String id) {
        return users.containsKey(id);
    }
}

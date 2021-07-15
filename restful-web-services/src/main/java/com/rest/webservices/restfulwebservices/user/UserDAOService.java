package com.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

    private static int usersCount = 3;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Usr1", new Date()));
        users.add(new User(2, "Usr2", new Date()));
        users.add(new User(3, "Usr3", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
    }

}

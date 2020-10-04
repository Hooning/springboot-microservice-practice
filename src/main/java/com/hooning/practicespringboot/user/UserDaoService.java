package com.hooning.practicespringboot.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    public static int usersCount = 3;

    static {
        users.add(new User(1, "David", new Date()));
        users.add(new User(2, "Noah", new Date()));
        users.add(new User(3, "Yoomin", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void delete(int id) {
        users.removeIf((u -> u.getId().equals(id)));
    }
}

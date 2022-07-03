package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.model.User;
import com.company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private List<User> user;

    @Override
    public void addUser(List<User> user) {
        this.user = user;
    }

    @Override
    public void findWithId(int id) {
        this.user.stream().filter(x -> x.getId() == id).forEach(System.out::println);
    }

    @Override
    public void removeWithId(int id) {
        this.user.removeIf(x -> x.getId() == id);


    }

    @Override
    public void getAllUsers() {
        for (User user1 : user) {
            System.out.println(user1);
        }

    }

}

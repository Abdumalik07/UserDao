package com.company.service;

import com.company.dao.UserDao;
import com.company.model.User;

import java.util.List;

public interface UserService {
     void addUser(List<User> user);
     void findWithId(int id);
     void removeWithId(int id);
     void getAllUsers();

}

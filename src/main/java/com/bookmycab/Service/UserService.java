package com.bookmycab.Service;

import java.util.List;

import com.bookmycab.Entities.User;
import com.bookmycab.Exceptions.UserException;

public interface UserService {
    User saveUser(User user) throws UserException;

    User updateUser(Integer id, User user) throws UserException;

    User deleteUser(Integer id) throws UserException;

    List<User> getAllUser();

    User getUserById(Integer id) throws UserException;

    User getUserByUsername(String username) throws UserException;

    boolean isLoggedIn(User user);

    boolean loginUser(User user);

    boolean logoutUser(User user);
}

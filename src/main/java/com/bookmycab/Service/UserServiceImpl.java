package com.bookmycab.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmycab.Entities.User;
import com.bookmycab.Exceptions.CabException;
import com.bookmycab.Exceptions.UserException;
import com.bookmycab.Repositories.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTrackerService userTrackerService;

    @Override
    public User saveUser(User user) throws UserException {
        return userDao.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) throws UserException {
        User curUser = userDao.getById(id);
        if (curUser == null) throw new UserException("User doesn't exist with this userId : " + id);
        curUser.setUsername(user.getUsername());
        curUser.setName(user.getName());
        curUser.setEmail(user.getEmail());
        curUser.setPassword(user.getPassword());
        curUser.setMobileNo(user.getMobileNo());
        final User finalUser = curUser;
        return userDao.save(finalUser);
    }

    @Override
    public User deleteUser(Integer id) throws UserException {
        User delUser = userDao.findById(id).orElseThrow(() -> new CabException("User doesn't exist with id : " + id));
        userDao.delete(delUser);
        return delUser;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) throws UserException {
        return userDao.findById(id).orElseThrow(() -> new CabException("User doesn't exist with id : " + id));
    }

    @Override
    public User getUserByUsername(String username) throws UserException {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean isLoggedIn(User user) {
        return userTrackerService.isLoggedIn(user);
    }

    public boolean loginUser(User user) {
        return userTrackerService.loginUser(user);
    }

    @Override
    public boolean logoutUser(User user) {
        return userTrackerService.logoutUser(user);
    }

}

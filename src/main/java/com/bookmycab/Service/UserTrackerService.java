package com.bookmycab.Service;

import com.bookmycab.Entities.User;
import com.bookmycab.Entities.UserTracker;
import com.bookmycab.Exceptions.UserException;
import com.bookmycab.Repositories.UserDao;
import com.bookmycab.Repositories.UserTrackerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserTrackerService {

    @Autowired
    UserTrackerRepository userTrackerRepository;

    @Autowired
    UserDao userRepository;

    public boolean isLoggedIn(User user) {
        Optional<UserTracker> userid = userTrackerRepository.findByUserId(user.getUserId());
        return userid.isPresent();
    }

    public boolean loginUser(User user) throws UserException {
        try {
            User userDB = userRepository.findByUsername(user.getUsername());
            if (userDB == null)
                throw new UserException("User not found");
            if (!Objects.equals(userDB.getPassword(), user.getPassword()))
                return false;

            UserTracker ut = new UserTracker();
            ut.setUserId(userDB.getUserId());
            userTrackerRepository.save(ut);
        } catch (ConstraintViolationException e) {
            return false;
        }

        return true;
    }

    public boolean logoutUser(User user) {
        Optional<UserTracker> ut = userTrackerRepository.findByUserId(user.getUserId());
        if (ut.isEmpty())
            return false;
        userTrackerRepository.delete(ut.get());
        return true;
    }
}

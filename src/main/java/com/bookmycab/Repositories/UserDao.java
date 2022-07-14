package com.bookmycab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmycab.Entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}

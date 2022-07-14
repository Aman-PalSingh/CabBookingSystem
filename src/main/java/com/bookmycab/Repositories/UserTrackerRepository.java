package com.bookmycab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmycab.Entities.UserTracker;

import java.util.Optional;

@Repository
public interface UserTrackerRepository extends JpaRepository<UserTracker, Integer> {
    Optional<UserTracker> findByUserId(Integer userId);
}

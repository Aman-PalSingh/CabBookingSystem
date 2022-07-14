package com.bookmycab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmycab.Entities.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver, Integer>{
}

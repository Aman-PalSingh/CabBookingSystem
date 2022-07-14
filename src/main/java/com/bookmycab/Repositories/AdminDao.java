package com.bookmycab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmycab.Entities.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
}

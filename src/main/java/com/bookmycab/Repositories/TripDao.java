package com.bookmycab.Repositories;

import com.bookmycab.Entities.Customer;
import com.bookmycab.Entities.Trip;
import com.bookmycab.Exceptions.TripException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip, Integer> {
}

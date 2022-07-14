package com.bookmycab.Service;

import com.bookmycab.Entities.Trip;
import com.bookmycab.Exceptions.TripException;

import java.util.List;

public interface TripService {
    Trip addTrip(Trip trip, Integer customerId, Integer driverId) throws TripException;

    Trip updateTrip(Integer id, Trip trip) throws TripException;

    Trip deleteTrip(Integer id) throws TripException;

    List<Trip> getAllTripsByCustomer(Integer customerId) throws TripException;

    Double calculateBill(Integer id) throws TripException;

    Trip getTripById(Integer id) throws TripException;
}

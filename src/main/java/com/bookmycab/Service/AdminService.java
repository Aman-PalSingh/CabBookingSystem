package com.bookmycab.Service;

import com.bookmycab.Entities.Admin;
import com.bookmycab.Exceptions.AdminException;

import java.util.List;

public interface AdminService {

    // CRUD on Admin table
    Admin getAdmin(Integer adminId) throws AdminException;

    Admin insertAdmin(Admin admin);

    Admin updateAdmin(Integer id, Admin admin) throws AdminException;

    Admin deleteAdmin(Integer adminId) throws AdminException;

    List<Admin> getAllAdmins();

    // TODO: implement these trip related CRUD

    /*

    List<TripBooking> getAllTrips(Integer customerId);
    List<TripBooking> getTripsCabWise(Integer cabId);
    List<TripBooking> getTripsCustomerWise(Integer customerId);
    List<TripBooking> getTripsDateWise(LocalDateTime date);
    List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime from, LocalDateTime to);

    */
}

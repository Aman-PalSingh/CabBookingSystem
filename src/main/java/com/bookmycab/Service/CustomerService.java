package com.bookmycab.Service;

import com.bookmycab.Entities.Customer;
import com.bookmycab.Entities.Trip;
import com.bookmycab.Exceptions.CustomerException;

import java.util.List;


public interface CustomerService {
    Customer insertCustomer(Customer customer);
    List<Trip> getList(Integer customerId) throws CustomerException;
    Customer updateCustomer(Customer customer, Integer customerId) throws CustomerException;

    Customer deleteCustomer(Integer customerId) throws CustomerException;

    List<Customer> viewCustomers();

    Customer viewCustomer(Integer customerId) throws CustomerException;

    Customer validateCustomer(String username, String password) throws CustomerException;

}

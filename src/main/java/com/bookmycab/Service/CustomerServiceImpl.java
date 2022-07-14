package com.bookmycab.Service;

import com.bookmycab.Entities.Customer;
import com.bookmycab.Entities.Trip;
import com.bookmycab.Exceptions.CustomerException;
import com.bookmycab.Repositories.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerRepositry;

    @Override
    public List<Trip> getList(Integer customerId) throws CustomerException{
        Customer customer = customerRepositry.findById(customerId).orElseThrow(() -> new CustomerException("Customer doesn't exist with this Id" + customerId));
        return  customer.getTrips();
    }

    @Override
    public Customer insertCustomer(Customer customer) throws CustomerException {
        return customerRepositry.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer id) throws CustomerException {
        Customer customerDb = customerRepositry.findById(id)
                .orElseThrow(() -> new CustomerException("Admin doesn't exist with id : " + customer.getUserId()));

        if (Objects.nonNull(customer.getUsername()) &&
                !"".equalsIgnoreCase(customer.getUsername()))
            customerDb.setUsername(customer.getUsername());

        if (Objects.nonNull(customer.getName()) &&
                !"".equalsIgnoreCase(customer.getName()))
            customerDb.setName(customer.getName());

        if (Objects.nonNull(customer.getPassword()) &&
                !"".equalsIgnoreCase(customer.getPassword()))
            customerDb.setPassword(customer.getPassword());

        if (Objects.nonNull(customer.getEmail()) &&
                !"".equalsIgnoreCase(customer.getEmail()))
            customerDb.setEmail(customer.getEmail());

        if (Objects.nonNull(customer.getMobileNo()) &&
                !"".equalsIgnoreCase(customer.getMobileNo()))
            customerDb.setMobileNo(customer.getMobileNo());


        return customerRepositry.save(customerDb);
    }

    @Override
    public Customer deleteCustomer(Integer customerId) throws CustomerException {
        Customer customer = customerRepositry.findById(customerId).orElseThrow(() -> new CustomerException("Customer doesn't exist with this Id" + customerId));
        customerRepositry.delete(customer);
        return customer;
    }

    @Override
    public List<Customer> viewCustomers() {
        return customerRepositry.findAll();
    }

    @Override
    public Customer viewCustomer(Integer customerId) throws CustomerException {
        Customer customer = customerRepositry.findById(customerId).orElseThrow(() -> new CustomerException("Customer doesn't exist with this ID " + customerId));
        return customer;
    }

    @Override
    public Customer validateCustomer(String username, String password) throws CustomerException {
        Customer customer = customerRepositry.validateCustomer(username, password);
        if (customer == null)
            throw new CustomerException("Customer doesn't Exist... Sorry!");
        else
            return customer;
    }
}

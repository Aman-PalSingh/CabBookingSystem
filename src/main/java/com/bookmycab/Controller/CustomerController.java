package com.bookmycab.Controller;

import com.bookmycab.Entities.Customer;
import com.bookmycab.Entities.Trip;
import com.bookmycab.Entities.TripStatus;
import com.bookmycab.Entities.UserRoles;
import com.bookmycab.Exceptions.CustomerException;
import com.bookmycab.Service.CustomerService;
import com.bookmycab.Service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private TripService tripService;

	@GetMapping("/customers")
	public List<Customer> viewCustomers() {
		return customerService.viewCustomers();
	}

	@GetMapping("/customers/{id}")
	public Customer viewCustomer(@PathVariable("id") Integer id) throws CustomerException {
		return customerService.viewCustomer(id);
	}

	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id)
			throws CustomerException {
		return customerService.updateCustomer(customer, id);
	}

	@PostMapping("/customers")
	public Customer insertCustomer(@RequestBody Customer customer) {
		customer.setRoles(List.of(UserRoles.CUSTOMER));
		return customerService.insertCustomer(customer);
	}

	@DeleteMapping("/customers/{id}")
	public Customer deleteCustomer(@PathVariable("id") Integer id) {
		return customerService.deleteCustomer(id);
	}

	@PatchMapping("/customers/{tripId}")
	public ResponseEntity<?> cancelBooking(@PathVariable("tripId") Integer tripId) {
		Trip trip = tripService.getTripById(tripId);
		trip.setStatus(TripStatus.CANCELED);
		tripService.updateTrip(tripId, trip);
		return new ResponseEntity<>("Booking cancelled", HttpStatus.ACCEPTED);
	}

}

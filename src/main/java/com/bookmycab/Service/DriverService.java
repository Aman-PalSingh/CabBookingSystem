package com.bookmycab.Service;

import com.bookmycab.Entities.Driver;
import com.bookmycab.Exceptions.DriverException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);

    String getDlByID(Integer id) throws DriverException;

    Driver updateDriver(Integer id, Driver driver) throws DriverException;

    Driver deleteDriver(Integer id) throws DriverException;

    Driver getDriverByID(Integer id) throws DriverException;

    List<Driver> getAllDrivers();


}

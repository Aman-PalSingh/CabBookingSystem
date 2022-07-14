package com.bookmycab.Service;

import com.bookmycab.Entities.Cab;
import com.bookmycab.Entities.CabType;
import com.bookmycab.Entities.Driver;
import com.bookmycab.Exceptions.CabException;
import com.bookmycab.Exceptions.DriverException;
import com.bookmycab.Repositories.DriverDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverDao driverDao;


    @Override
    public Driver addDriver(Driver driver) {
        Cab cab = driver.getCab();
        CabType cabType = cab.getCabType();
        cab.setSittingCapcity(cabType.sittingCapacity());
        cab.setPerKmRate(cabType.getPrice());
        driver.setCab(cab);
        return driverDao.save(driver);
    }

    @Override
    public String getDlByID(Integer id) throws DriverException {
        Driver driver = driverDao.findById(id).orElseThrow(() -> new DriverException("Driver doesn't exist with id : " + id));
        return driver.getDl();
    }

    @Override
    public Driver updateDriver(Integer id, Driver driver) throws DriverException {
        Driver driver1 = driverDao.findById(id).orElseThrow(() -> new DriverException("Driver doesn't exist with id : " + id));
        driver1.setCab(driver.getCab());
        driver1.setDl(driver.getDl());
        driver1.setRating(driver.getRating());
        driverDao.save(driver1);
        return driver1;
    }

    @Override
    public Driver deleteDriver(Integer id) throws DriverException {
        Driver driver1 = driverDao.findById(id).orElseThrow(() -> new DriverException("Driver doesn't exist with id : " + id));
        driverDao.delete(driver1);
        return driver1;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDao.findAll();
    }

    @Override
    public Driver getDriverByID(Integer id) throws DriverException {
        return driverDao.findById(id).orElseThrow(() -> new DriverException("Driver doesn't exist with id : " + id));
    }
}

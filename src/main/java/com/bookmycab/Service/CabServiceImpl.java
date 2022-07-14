package com.bookmycab.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmycab.Entities.Cab;
import com.bookmycab.Entities.CabType;
import com.bookmycab.Exceptions.CabException;
import com.bookmycab.Repositories.CabDao;

@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabDao cabDao;

    @Override
    public Cab addCab(Cab cab) {
        CabType type = cab.getCabType();
        cab.setPerKmRate(type.getPrice());
        cab.setSittingCapcity(type.sittingCapacity());
        return cabDao.save(cab);
    }

    @Override
    public Cab getCabById(Integer id) throws CabException {
        return cabDao.findById(id).orElseThrow(() -> new CabException("Cab doesn't exist with id : " + id));
    }

    @Override
    public List<Cab> getAllCabs() {
        return cabDao.findAll();
    }

    @Override
    public Cab updateCab(Integer id, Cab cab) throws CabException {
        Cab cab1 = cabDao.findById(id).orElseThrow(() -> new CabException("Cab with id : " + id + " does not exit.."));
        cab1.setPerKmRate(cab.getPerKmRate());
        cab1.setAvailable(cab.getAvailable());
        cab1.setCabType(cab.getCabType());
        cab1.setSittingCapcity(cab.getSittingCapcity());
        cabDao.save(cab1);
        return cab1;
    }

    @Override
    public List<Cab> getCabByType(String cabType) {
        return cabDao.findAllByCabType(cabType);
    }

    @Override
    public Integer countCabByType(String cabType) {
        return cabDao.findAllByCabType(cabType).size();
    }

    @Override
    public Boolean updateAvailiblityStatus(Integer id, Boolean status) {
        Cab cab1 = cabDao.findById(id).orElseThrow(() -> new CabException("Cab with id : " + id + " does not exit.."));
        cab1.setAvailable(status);
        cabDao.save(cab1);
        return cab1.getAvailable();
    }

    @Override
    public Cab deleteCabById(Integer id) throws CabException {
        Cab st = cabDao.findById(id).orElseThrow(() -> new CabException("Cab with id : " + id + " does not exit.."));
        cabDao.delete(st);
        return st;
    }

}

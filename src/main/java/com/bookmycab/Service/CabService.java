package com.bookmycab.Service;

import java.util.List;

import com.bookmycab.Entities.Cab;
import com.bookmycab.Exceptions.CabException;

public interface CabService {
    Cab addCab(Cab cab);

    Cab getCabById(Integer id) throws CabException;

    List<Cab> getAllCabs();

    Cab updateCab(Integer id, Cab cab) throws CabException;

    List<Cab> getCabByType(String cabType);

    Integer countCabByType(String cabType);

    Boolean updateAvailiblityStatus(Integer id, Boolean status);

    Cab deleteCabById(Integer id) throws CabException;
}

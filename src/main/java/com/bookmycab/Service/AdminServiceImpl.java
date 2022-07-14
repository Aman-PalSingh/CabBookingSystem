package com.bookmycab.Service;

import com.bookmycab.Entities.Admin;
import com.bookmycab.Exceptions.AdminException;
import com.bookmycab.Repositories.AdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminRepository;

    @Override
    public Admin getAdmin(Integer adminId) throws AdminException {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> new AdminException("Admin with id " + adminId + " not found"));
    }

    @Override
    public Admin insertAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Integer id, Admin admin) throws AdminException {
        Admin adminDB = adminRepository.findById(id)
                .orElseThrow(() -> new AdminException("Admin doesn't exist with id : " + admin.getUserId()));

        if (Objects.nonNull(admin.getUsername()) &&
                !"".equalsIgnoreCase(admin.getUsername()))
            adminDB.setUsername(admin.getUsername());

        if (Objects.nonNull(admin.getName()) &&
                !"".equalsIgnoreCase(admin.getName()))
            adminDB.setName(admin.getName());

        if (Objects.nonNull(admin.getPassword()) &&
                !"".equalsIgnoreCase(admin.getPassword()))
            adminDB.setPassword(admin.getPassword());

        if (Objects.nonNull(admin.getEmail()) &&
                !"".equalsIgnoreCase(admin.getEmail()))
            adminDB.setEmail(admin.getEmail());

        if (Objects.nonNull(admin.getMobileNo()) &&
                !"".equalsIgnoreCase(admin.getMobileNo()))
            adminDB.setMobileNo(admin.getMobileNo());


        return adminRepository.save(adminDB);
    }

    @Override
    public Admin deleteAdmin(Integer adminId) throws AdminException {
        Admin adminDB = adminRepository.findById(adminId)
                .orElseThrow(() -> new AdminException("Admin doesn't exist with id : " + adminId));
        adminRepository.delete(adminDB);
        return adminDB;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}

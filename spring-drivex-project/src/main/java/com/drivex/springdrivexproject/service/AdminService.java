// Package
package com.drivex.springdrivexproject.service;

// Imports
    // Spring.stereotype
import com.drivex.springdrivexproject.model.Admin;
import com.drivex.springdrivexproject.model.Car;
import com.drivex.springdrivexproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Annotations

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    // Methods

        // All Admin
    public List<Admin> getAll() {return adminRepository.findAll();}

        // Search an Admin


        // Save an Admin
    public Admin save(Admin admin) {return adminRepository.save(admin);}

        // Delete a Admin
    public boolean deleteAdmin(Integer idAdmin) {
        Optional<Admin> optionalAdmin = adminRepository.findById(idAdmin);

        if (optionalAdmin.isPresent())
        {
            Admin admin = optionalAdmin.get();
            adminRepository.deleteById(admin.getIdAdmin());
            return true;
        }else {
            return false;
        }
    }
}

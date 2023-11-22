package lk.ijse.gdse.UserService.service.impl;

import lk.ijse.gdse.UserService.entity.Admin;
import lk.ijse.gdse.UserService.repository.AdminRepo;
import lk.ijse.gdse.UserService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
   @Autowired
    private final AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepo.findAdminByEmail(email);
    }
}

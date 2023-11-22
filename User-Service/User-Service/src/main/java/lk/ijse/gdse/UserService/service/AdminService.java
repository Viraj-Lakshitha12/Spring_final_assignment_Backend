package lk.ijse.gdse.UserService.service;

import lk.ijse.gdse.UserService.entity.Admin;

public interface AdminService {
    Admin getAdminByEmail(String email);
}

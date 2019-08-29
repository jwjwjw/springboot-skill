package com.jw.service;

import com.jw.domain.UserRole;

public interface UserService {

    int add(UserRole userRole);
    int update(UserRole userRole);
    int deleteByType(String type);
    UserRole queryAdminUserRoleByType(String type);
}

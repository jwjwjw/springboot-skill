package com.jw.repository;


import com.jw.domain.UserRole;

public interface UserDao {

    int add(UserRole userRole);
    int update(UserRole userRole);
    int deleteByType(String type);
    UserRole queryAdminUserRoleByType(String type);
}

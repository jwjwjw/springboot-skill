package com.jw.service;

import com.jw.domain.UserRole;
import com.jw.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int add(UserRole userRole) {
        return this.userDao.add(userRole);
    }

    @Override
    public int update(UserRole userRole) {
        return userDao.update(userRole);
    }

    @Override
    public int deleteByType(String type) {
        return this.userDao.deleteByType(type);
    }

    @Override
    public UserRole queryAdminUserRoleByType(String type) {
        return this.userDao.queryAdminUserRoleByType(type);
    }
}

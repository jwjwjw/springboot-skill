package com.jw.repository;

import com.jw.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(UserRole userRole) {
        return jdbcTemplate.update("insert unto user_role (type, signing_limit) values (?,?)", userRole.getType(), userRole.getSigningLimit());
    }

    @Override
    public int update(UserRole userRole) {
        return jdbcTemplate.update("update user_role set signing_limit =? where type =?", userRole.getSigningLimit(), userRole.getType());
    }

    @Override
    public int deleteByType(String type) {
        return jdbcTemplate.update("delete from user_role where type =?",type);
    }

    @Override
    public UserRole queryAdminUserRoleByType(String type) {
        List<UserRole> list = jdbcTemplate.query("select * from user_role where type = ?",new Object[]{type},new BeanPropertyRowMapper(UserRole.class));
        if(null != list && list.size()>0){
            UserRole userRole = list.get(0);
            return userRole;
        }
        else {
            return null;
        }
    }
}

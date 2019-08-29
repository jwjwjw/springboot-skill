package com.jw.controller;


import com.jw.domain.UserRole;
import com.jw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dbTest")
public class DbController {

    @Autowired
    UserService userService;

    @GetMapping("/query/{type}")
    public ResponseEntity<UserRole> querybyType(
            @PathVariable(name="type") String type
    ){
        return new ResponseEntity(userService.queryAdminUserRoleByType(type),HttpStatus.OK);
    }

    @PutMapping("/update")
    public void update(
            @RequestParam(name="type") String type,
            @RequestParam(name="limit") String limit
    ){
        UserRole userRole = new UserRole();
        userRole.setType(type);
        userRole.setSigningLimit(Double.parseDouble(limit));
        userService.update(userRole);
    }

    @PostMapping("/add")
    public void add(@RequestParam(name="type") String type,
                    @RequestParam(name="limit") String limit
    ){
        UserRole userRole = new UserRole();
        userRole.setType(type);
        userRole.setSigningLimit(Double.parseDouble(limit));
        userService.add(userRole);
    }

    @DeleteMapping("/delete")
    public void add(@RequestParam(name="type") String type
    ){
        userService.deleteByType(type);
    }
}

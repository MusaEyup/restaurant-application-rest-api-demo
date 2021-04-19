package com.restaurant.Controller;

import com.restaurant.Entity.Employee;

import com.restaurant.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    public Employee login(@RequestBody Employee employee){
        return loginService.login(employee);
    }
}

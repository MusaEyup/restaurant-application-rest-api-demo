package com.restaurant.Service.Impl;

import com.restaurant.Entity.Employee;
import com.restaurant.Repository.EmployeeRepository;
import com.restaurant.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public Employee login(Employee employee) {

        Employee user = employeeRepo.findByEmployeeUserName(employee.getFirstName());
        if(user != null
                && employee.get_password()
                    .equals(user.get_password())){
            return user;
        }

        return null;
    }
}

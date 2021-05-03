package com.restaurant.Service;

import com.restaurant.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Long deleteEmployeeById(Long id);
    String AddNewEmployee(Employee employee);
    Long updateEmployee(Employee employee);
}

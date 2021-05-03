package com.restaurant.Controller;

import com.restaurant.Entity.Employee;
import com.restaurant.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAll(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteEmployeeById(@PathVariable("id") Long id){
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/add")
    public String addNewEmployee(@RequestBody Employee employee){
        return employeeService.AddNewEmployee(employee);
    }

    @PutMapping("/update")
    public Long updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
}

package com.restaurant.Service.Impl;

import com.restaurant.Entity.Employee;
import com.restaurant.Repository.EmployeeRepository;
import com.restaurant.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    @Transactional
    public Long deleteEmployeeById(Long id) {
        Employee employee = employeeRepo.findEmployeeById(id);
        employee.setDeleted(true);
        return employeeRepo.save(employee).getId();
    }

    @Override
    @Transactional
    public String AddNewEmployee(Employee employee) {
         if(employeeRepo.isEmailExist(employee.getEmail()))
             return "E-posta başka bir kişiye ait ";
         if(employeeRepo.isPhoneNumberExist(employee.getPhoneNum()))
             return "Telefon numarası başka bir kişiye ait";
         if(employeeRepo.isUserNameExist(employee.getUserName()))
             return "Kullanıcı adı başka bir kişiye ait";

         Employee employee1 = employeeRepo.save(employee);

         return employee1.getId() + " Başarılı bir şekilde kayıdedildi";

    }

    @Override
    @Transactional
    public Long updateEmployee(Employee employee) {
        return employeeRepo.save(employee).getId();
    }


}

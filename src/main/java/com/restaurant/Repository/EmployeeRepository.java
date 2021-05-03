package com.restaurant.Repository;

import com.restaurant.Entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query(value = "select e from Employee e WHERE e.deleted = false")
    List<Employee> findAll();

    @Query(value = "select e from Employee e where e.firstName = :name and e.deleted = false")
    Employee findByEmployeeName(@Param("name") String name);

    @Query(value = "select e from Employee e where e.userName = :userName and e.deleted = false")
    Employee findByEmployeeUserName(@Param("userName") String userName);

    @Query(value = "select e from Employee e where e.id = :id and e.deleted = false")
    Employee findEmployeeById(@Param("id") Long id);

    @Query(value = "SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM Employee e WHERE e.phoneNum = ?1")
    Boolean isPhoneNumberExist(String phoneNum);

    @Query(value = "SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END " +
                    "from Employee e where e.email=?1")
    Boolean isEmailExist(String email);

    @Query(value = "SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM Employee e WHERE e.userName = ?1")
    Boolean isUserNameExist(String userName);

}

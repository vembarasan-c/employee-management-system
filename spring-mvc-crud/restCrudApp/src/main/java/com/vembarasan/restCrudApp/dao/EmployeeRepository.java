package com.vembarasan.restCrudApp.dao;

import com.vembarasan.restCrudApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    // add a method -> this method name convert as a query, behind the scenes jpa will write query
    // and returns the employee data
    List<Employee> findAllByOrderByFirstName();

}

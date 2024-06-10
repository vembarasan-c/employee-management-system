package com.vembarasan.restCrudApp.service;

import com.vembarasan.restCrudApp.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id); // finding a single employee entity

    Employee save(Employee employee);

    int  deleteById(int id);

}


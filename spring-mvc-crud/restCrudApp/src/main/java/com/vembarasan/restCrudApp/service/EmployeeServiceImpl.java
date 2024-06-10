package com.vembarasan.restCrudApp.service;

import com.vembarasan.restCrudApp.dao.EmployeeRepository;
import com.vembarasan.restCrudApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Inside service class , you can use multiple dao files

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByFirstName();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> res = employeeRepository.findById(id);
        Employee employee = null;

        if (res.isPresent()){
            employee = res.get();
        }else{
            throw  new RuntimeException("did not find employee id - "+ id);
        }

        return employee;
    }


    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        employeeRepository.deleteById(id);
        return id;
    }


}

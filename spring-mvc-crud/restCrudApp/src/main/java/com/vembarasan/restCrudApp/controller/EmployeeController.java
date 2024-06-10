package com.vembarasan.restCrudApp.controller;

import com.vembarasan.restCrudApp.entity.Employee;
import com.vembarasan.restCrudApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private  EmployeeService employeeService;
    // Constructor injection
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model model){

        // Get the employee details from db
        List<Employee> employeeList = employeeService.findAll();

        // add the employee details in model
        model.addAttribute("employeesList", employeeList);

        return "/employees/list-employees";
    }

    @GetMapping("/showForm")
    public String createEmployee(Model model){

        Employee employee = new Employee();
        // add attribute
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){ // getting the form data

        // store the employee object to db
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id , Model model){

        // get the employee
        Employee employee = employeeService.findById(id);
        System.out.println(employee);

        // set the employee in the model
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String removeEmployee( @RequestParam("employeeId") int id, Model model ){
        // delete the employee
        employeeService.deleteById(id);

        // redirect to employee
        return "redirect:/employees/list";
    }

}



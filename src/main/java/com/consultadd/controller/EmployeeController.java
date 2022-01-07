package com.consultadd.controller;

import com.consultadd.model.Employee;
import com.consultadd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        List<Employee> employeeList = employeeService.getEmployees();
        return employeeList;
    }

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable String id){
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/employee/{id}")
    public  String delEmployee(@PathVariable String id){
        return employeeService.delEmployee(id);
    }

}

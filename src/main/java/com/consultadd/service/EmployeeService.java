package com.consultadd.service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public String saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())) {
            return "Couldn't save data. Id already Exists.";
        } else {
            employeeRepository.save(employee);
            return "Employee data saved successfully.";
        }
    }

}

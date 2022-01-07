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

    public String updateEmployee(Employee newEmployee, String Id){
        return employeeRepository.findById(Id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setAge(newEmployee.getAge());
                    employeeRepository.save(employee);
                    return "Employee data updated successfully.";
                })
                .orElse("Couldn't update data. Employee doesn't exists.");
    }

    public String delEmployee(String Id){
        if(employeeRepository.existsById(Id)){
            employeeRepository.deleteById(Id);
            return "Employee data deleted successfully.";
        } else {
            return "Couldn't delete data. Employee doesn't exists.";
        }
    }

}

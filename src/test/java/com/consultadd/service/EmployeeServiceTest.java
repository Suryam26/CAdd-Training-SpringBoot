package com.consultadd.service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void testGetEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee("1", "testUser1", 20, "Indore");
        Employee emp2 = new Employee("2", "testUser2", 20, "Pune");

        employeeList.add(emp1);
        employeeList.add(emp2);

        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);

        List<Employee> returnList = employeeService.getEmployees();
        Assert.assertEquals(employeeList, returnList);
        Mockito.verify(employeeRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testSaveEmployee(){
        Employee emp = new Employee("1", "testUser1", 20, "Indore");

        Mockito.when(employeeRepository.existsById(emp.getId())).thenReturn(false);

        employeeService.saveEmployee(emp);
        Mockito.verify(employeeRepository, Mockito.times(1)).existsById(emp.getId());
        Mockito.verify(employeeRepository, Mockito.times(1)).save(emp);
    }

    @Test
    public void testUpdateEmployee(){
        Employee emp = new Employee("1", "testUser1", 20, "Indore");
        Employee newEmp = new Employee(null, "testUser2", 22, "Indore");

        Mockito.when(employeeRepository.findById(emp.getId())).thenReturn(Optional.of(emp));

        employeeService.updateEmployee(newEmp, emp.getId());
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(emp.getId());
        Mockito.verify(employeeRepository, Mockito.times(1)).save(emp);
    }

    @Test
    public void testDelEmployee(){
        Employee emp = new Employee("1", "testUser1", 20, "Indore");

        Mockito.when(employeeRepository.existsById(emp.getId())).thenReturn(true);

        employeeService.delEmployee(emp.getId());
        Mockito.verify(employeeRepository, Mockito.times(1)).existsById(emp.getId());
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(emp.getId());
    }

}

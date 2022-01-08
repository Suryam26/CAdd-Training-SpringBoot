package com.consultadd.repository;

import com.consultadd.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    //Custom query using method name
    //List<Employee> findAllByCity(String city);

    //Custom query using @Query
    @Query("Select e from Employee e where e.city = :city")
    List<Employee> getByCity(String city);
}

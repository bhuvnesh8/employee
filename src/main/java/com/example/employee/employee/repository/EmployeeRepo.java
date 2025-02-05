package com.example.employee.employee.repository;

import com.example.employee.employee.entities.Department;
import com.example.employee.employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartment(Department department);
}

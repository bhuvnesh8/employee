package com.example.employee.employee.services;

import com.example.employee.employee.payload.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    //create employee
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO, Integer deptId);

    //delete employee
    void deleteEmployee(Integer empId);

    //get All employee
    List<EmployeeDTO> getAllEmployee();

    //getEmployeeId
    EmployeeDTO getEmployeeById(Integer empId);

    //get post by department
    List<EmployeeDTO> getEmployeeByDepartment(Integer departId);
}

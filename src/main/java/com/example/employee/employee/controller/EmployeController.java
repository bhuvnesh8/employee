package com.example.employee.employee.controller;

import com.example.employee.employee.payload.EmployeeDTO;
import com.example.employee.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO, @RequestParam Integer deptId) {
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO, deptId);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    // Delete Employee by empId
    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer empId) {
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get All Employees
    @GetMapping ("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get Employee by empId
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer empId) {
        EmployeeDTO employee = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Get Employees by Department ID
    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(@PathVariable Integer deptId) {
        List<EmployeeDTO> employees = employeeService.getEmployeeByDepartment(deptId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}

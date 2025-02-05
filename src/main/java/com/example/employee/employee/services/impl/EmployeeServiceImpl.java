package com.example.employee.employee.services.impl;

import com.example.employee.employee.entities.Department;
import com.example.employee.employee.entities.Employee;
import com.example.employee.employee.payload.EmployeeDTO;
import com.example.employee.employee.repository.DepartmentRepo;
import com.example.employee.employee.repository.EmployeeRepo;
import com.example.employee.employee.services.EmployeeService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, Integer deptId) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        Department department = departmentRepo.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepo.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        Employee employee = employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeRepo.delete(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();

        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer empId) {
        Employee employee = employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getEmployeeByDepartment(Integer deptId) {
        Department department = departmentRepo.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        List<Employee> employees = employeeRepo.findByDepartment(department);

        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }


}

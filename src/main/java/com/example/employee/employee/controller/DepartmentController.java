package com.example.employee.employee.controller;

import com.example.employee.employee.payload.DepartmentDTO;
import com.example.employee.employee.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO  departmentDTO){
        DepartmentDTO createDepartment = this.departmentService.createDepartment(departmentDTO);

        return new ResponseEntity<>(createDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> departmentList =this.departmentService.getAllDepartment();

        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }



}

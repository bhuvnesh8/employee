package com.example.employee.employee.services.impl;

import com.example.employee.employee.entities.Department;
import com.example.employee.employee.payload.DepartmentDTO;
import com.example.employee.employee.repository.DepartmentRepo;
import com.example.employee.employee.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO DepartmentDTO) {

        Department department = this.modelMapper.map(DepartmentDTO, Department.class);
        Department addedDepartment = this.departmentRepo.save(department);

        return this.modelMapper.map(addedDepartment, DepartmentDTO.class);

    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departmentList = this.departmentRepo.findAll();

        List<DepartmentDTO> departmentDTOList = departmentList.stream().map(d -> this.modelMapper.map(d, DepartmentDTO.class))
                .collect(Collectors.toList());
        return departmentDTOList;
    }
}

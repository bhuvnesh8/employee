package com.example.employee.employee.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    private String empName;

    private String email;

    private String position;

    private Double salary;

    private DepartmentDTO department;

}

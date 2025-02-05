package com.example.employee.employee.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "name")
    private String empName;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Double salary;

    // Many-to-one relationship with Department
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

}

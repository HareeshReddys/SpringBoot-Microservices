package com.project.emplotyee.service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponceDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}

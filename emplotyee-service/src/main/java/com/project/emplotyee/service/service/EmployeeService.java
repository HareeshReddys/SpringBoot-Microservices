package com.project.emplotyee.service.service;


import com.project.emplotyee.service.dto.EmployeeDto;
import com.project.emplotyee.service.entity.Employee;

public interface EmployeeService {

EmployeeDto saveemployeed(EmployeeDto employeeDto);
EmployeeDto GetEmployeeById(Long employeeById);


}

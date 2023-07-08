package com.project.emplotyee.service.mapper;

import com.project.emplotyee.service.dto.EmployeeDto;
import com.project.emplotyee.service.entity.Employee;

public class EmployeeMapper {

// convert the EmployeeJpa into EmployeeDto

    public static EmployeeDto maptoEmployeeDto(Employee employee) {
        EmployeeDto employeedto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
        return employeedto;
    }

        // converting the Employeedto into employee JPA

        public static Employee maptoEmployee(EmployeeDto employeedto){
        Employee employee = new Employee(
        employeedto.getId(),
            employeedto.getFirstName(),
            employeedto.getLastName(),
            employeedto.getEmail()
        );
            return employee;
        }
    }


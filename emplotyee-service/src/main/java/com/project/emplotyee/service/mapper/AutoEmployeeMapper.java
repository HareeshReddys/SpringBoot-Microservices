package com.project.emplotyee.service.mapper;

import com.project.emplotyee.service.dto.EmployeeDto;
import com.project.emplotyee.service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {



    AutoEmployeeMapper MAPPER= Mappers.getMapper(AutoEmployeeMapper.class);

    // converting teh Jpa into Employeedto

    Employee mapToEmployee(EmployeeDto employeeDto);


    // converting the Dto into Employee JPA

    EmployeeDto maptoEmployeeDto(Employee employee);

}

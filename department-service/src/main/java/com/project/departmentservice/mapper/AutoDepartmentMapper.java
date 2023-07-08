package com.project.departmentservice.mapper;

import com.project.departmentservice.dto.Departmentdto;
import com.project.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);


    // Converting the user into UserDto
    Department mapToDepartment(Departmentdto departmentdto);


    // converting the UserDto into user
//   @Mapping(source = "email",target = "emailAddress")    this is used to when their is different field name userdto and user
//     that time we use this @mapping feature
    Departmentdto mapToDepartmendto(Department department);

}

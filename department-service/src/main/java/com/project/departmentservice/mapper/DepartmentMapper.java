package com.project.departmentservice.mapper;

import com.project.departmentservice.dto.Departmentdto;
import com.project.departmentservice.entity.Department;

public class DepartmentMapper {

    // convert DepartmentJpa entity into DepartmentDto
    public static Departmentdto maptoDepartmentDto(Department department){
        Departmentdto departmentdto = new Departmentdto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentdto;
    }


    // converting the Userdto into userJpa

    public static Department mapToDepartment(Departmentdto departmentdto){

        Department department = new Department(
        departmentdto.getId(),
        departmentdto.getDepartmentName(),
        departmentdto.getDepartmentDescription(),
        departmentdto.getDepartmentCode()
        );
        return department;
    }

}

package com.project.departmentservice.service;

import com.project.departmentservice.DepartmentService;
import com.project.departmentservice.dto.Departmentdto;
import com.project.departmentservice.entity.Department;
import com.project.departmentservice.mapper.AutoDepartmentMapper;
import com.project.departmentservice.mapper.DepartmentMapper;
import com.project.departmentservice.repository.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceimpl implements DepartmentService {

    public ModelMapper modelMapper;

private DepartmentRepository departmentRepository;

    @Override
    public Departmentdto saveDepartment(Departmentdto departmentdto) {

        // converting department dto to department jpa
// Using Auto Mapper

        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentdto);

        // converting department dto to department jpa by using modelMapper
//        Department department = modelMapper.map(departmentdto,Department.class);

 // By Using Mapper class converting the values from department dto to jpa
          // Department department = DepartmentMapper.mapToDepartment(departmentdto);


//   Normal method for converting the department dto to department jpa

           //Department department = new Department(
//             departmentdto.getId(),
//             departmentdto.getDepartmentName(),
//             departmentdto.getDepartmentDescription(),
//             departmentdto.getDepartmentCode()
//     );
    Department savedDepartment= departmentRepository.save(department);

    // converting the department jpa into department dto

        Departmentdto savedDepartmentdto=AutoDepartmentMapper.MAPPER.mapToDepartmendto(department);

        //    converting the department jpa into department dto using modelmapper
//        Departmentdto savedDepartmentdto = modelMapper.map(department,Departmentdto.class);

     //    converting the department jpa into department dto using mapper method
//        Departmentdto savedDepartmentdto = DepartmentMapper.maptoDepartmentDto(department);


   //  Normal method for converting the department Jpa to department dto
//            Departmentdto  savedDepartmentdto= new Departmentdto(
//                    savedDepartment.getId(),
//                    savedDepartment.getDepartmentName(),
//                    savedDepartment.getDepartmentDescription(),
//                    savedDepartment.getDepartmentCode()
//            );
        return savedDepartmentdto;
    }

    @Override
    public Departmentdto getdepartmentByCode(String departmentCode) {

     Department department=departmentRepository.findByDepartmentCode(departmentCode);

     // converting the Jpa entity into departmentdto

        // using AutoMapper

        Departmentdto departmentdto = AutoDepartmentMapper.MAPPER.mapToDepartmendto(department);

//        Using model mapper
//        Departmentdto departmentdto = modelMapper.map(department,Departmentdto.class);


    // By using Mapper function the
//Departmentdto departmentdto = DepartmentMapper.maptoDepartmentDto(department);

// Normal method
//        Departmentdto departmentdto = new Departmentdto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

        return departmentdto;
    }
}

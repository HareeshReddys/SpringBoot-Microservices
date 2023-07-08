package com.project.departmentservice.controller;

import com.project.departmentservice.DepartmentService;
import com.project.departmentservice.dto.Departmentdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    // build save department RestApi
    @PostMapping
    private ResponseEntity<Departmentdto> saveDepartment(@RequestBody Departmentdto departmentdto){
      Departmentdto saveDepartment= departmentService.saveDepartment(departmentdto);
      return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

// Build Get Department RestAPI
    @GetMapping("{department-Code}")
    public ResponseEntity<Departmentdto> getdepartment(@PathVariable("department-Code") String departmentcode){
      Departmentdto getdepartment = departmentService.getdepartmentByCode(departmentcode);
      return new ResponseEntity<>(getdepartment,HttpStatus.OK);

    }

}

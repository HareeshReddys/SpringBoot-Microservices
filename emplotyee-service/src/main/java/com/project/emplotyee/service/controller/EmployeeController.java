package com.project.emplotyee.service.controller;

import com.project.emplotyee.service.dto.EmployeeDto;
import com.project.emplotyee.service.entity.Employee;
import com.project.emplotyee.service.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("abi/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping
    private ResponseEntity<EmployeeDto>saveemployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto saveemployee = employeeService.saveemployeed(employeeDto);
      return new ResponseEntity<>(saveemployee, HttpStatus.CREATED);

    }


//    @GetMapping("{id}")
//    private ResponseEntity<Employee>getemployeedetails(@PathVariable("id") Long Id){
//        EmployeeDto getemployeedetails = employeeService.GetEmployeedetails(Id);
//        return new ResponseEntity<>(getemployeedetails,HttpStatus.OK);
//
//    }


    @GetMapping("{id}")
    private ResponseEntity<EmployeeDto>getemployeedetails(@PathVariable("id") Long employeeById){
        EmployeeDto employeeDto = employeeService.GetEmployeeById(employeeById);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);

    }


}

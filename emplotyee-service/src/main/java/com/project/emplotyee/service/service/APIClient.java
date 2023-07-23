package com.project.emplotyee.service.service;

import com.project.emplotyee.service.dto.DepartmentDto;
import com.project.emplotyee.service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:9090", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

//    @GetMapping("api/organization/{code}")
//    OrganizationDto getOrganization(@PathVariable("code")String organizationCode);
}







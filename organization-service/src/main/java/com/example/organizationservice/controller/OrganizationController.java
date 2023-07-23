package com.example.organizationservice.controller;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto saveOrganization= organizationService.saveOrganization(organizationDto);
       return new ResponseEntity<>(saveOrganization, HttpStatus.CREATED);
    }
// Build Get Organization By code REST API

    @GetMapping("{code}")
        public ResponseEntity<OrganizationDto> getOrganization( @PathVariable("code") String organizationCode){
         OrganizationDto organizationDto = organizationService.GetOrganizationByCode(organizationCode);
         return  ResponseEntity.ok(organizationDto);
        }



}

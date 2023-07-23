package com.example.organizationservice.service;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.entity.Organization;
import org.aspectj.weaver.ast.Or;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto GetOrganizationByCode(String organizationCode);
}

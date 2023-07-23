package com.example.organizationservice.service.impl;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.mapper.OrganizationMapper;
import com.example.organizationservice.repository.OrganizationRepository;
import com.example.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationServiceimpl implements OrganizationService {



    @Autowired
    private OrganizationRepository organizationRepository;




    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto){

        // converting the OrganizationDto into Organizationjpa

        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);

       Organization saveOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(saveOrganization);
    }

    @Override
    public OrganizationDto GetOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}

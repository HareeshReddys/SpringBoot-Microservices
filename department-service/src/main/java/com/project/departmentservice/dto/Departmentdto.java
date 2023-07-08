package com.project.departmentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Departmentdto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}

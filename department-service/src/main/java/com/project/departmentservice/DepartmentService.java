package com.project.departmentservice;

import com.project.departmentservice.dto.Departmentdto;

public interface DepartmentService {

    Departmentdto saveDepartment (Departmentdto departmentdto);

    Departmentdto getdepartmentByCode(String code);


}

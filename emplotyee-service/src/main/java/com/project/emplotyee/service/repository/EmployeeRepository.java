package com.project.emplotyee.service.repository;

import com.project.emplotyee.service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee getEmployeeById(Long employeeId);
}

package com.project.emplotyee.service.service.impl;

import com.project.emplotyee.service.dto.APIResponceDto;
import com.project.emplotyee.service.dto.Departmentdto;
import com.project.emplotyee.service.dto.EmployeeDto;
import com.project.emplotyee.service.entity.Employee;
import com.project.emplotyee.service.mapper.AutoEmployeeMapper;
import com.project.emplotyee.service.mapper.EmployeeMapper;
import com.project.emplotyee.service.repository.EmployeeRepository;
import com.project.emplotyee.service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
   public ModelMapper modelMapper;


//    public RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;
    public EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto saveemployeed(EmployeeDto employeeDto) {

        // Converting the employeeDto in employee Jpa
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

         // Converting the employeeDto in employee Jpa by using model mapper
//        Employee employee = modelMapper.map(employeeDto, Employee.class);

        // Converting the employeeDto in employee Jpa by using mapper
//        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);

     // Normal method
//    Employee employee = new Employee(
//       employeeDto.getId(),
//        employeeDto.getFirstName(),
//        employeeDto.getLastName(),
//        employeeDto.getEmail()
//);


   Employee saveEmployeed = employeeRepository.save(employee);

        EmployeeDto employeeDto1 = AutoEmployeeMapper.MAPPER.maptoEmployeeDto(employee);

   // Converting the employee Jpa into employeedto by using modelmapper

//        EmployeeDto employeeDto1 = modelMapper.map(employee,EmployeeDto.class);

   // Converting the employee Jpa into employeedto by using model
//      EmployeeDto employeeDto1 =  EmployeeMapper.maptoEmployeeDto(employee);
   // Converting the employee Jpa into employeedto Normal method
//        EmployeeDto employeeDto1 = new EmployeeDto(
//               employee.getId(),
//               employee.getFirstName(),
//               employee.getLastName(),
//               employee.getEmail()
//        );
        return employeeDto1;
    }

    @Override
    public APIResponceDto GetEmployeeById(Long employeeById) {
        Employee employee = employeeRepository.findById(employeeById).get();


        // using Webclient calling the departmentmethod
       Departmentdto departmentdto = webClient.get()
                .uri("http://localhost:8083/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(Departmentdto.class)
                .block();

        // RestTemplate
//       ResponseEntity<Departmentdto>  responseEntity = restTemplate.getForEntity("http://localhost:8083/api/departments/"+ employee.getDepartmentCode(),
//                Departmentdto.class);
//       Departmentdto departmentdto= responseEntity.getBody();

// method 3
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class );

//  method 2       EmployeeDto employeeDto=EmployeeMapper.maptoEmployeeDto(employee);

//   method 1     EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

        APIResponceDto apiResponceDto = new APIResponceDto();
        apiResponceDto.setEmployee(employeeDto);
        apiResponceDto.setDepartment(departmentdto);
        return apiResponceDto;
    }
//
//    @Override
//    public EmployeeDto GetEmployeedetails(Long Id) {
//         Employee employee = employeeRepository.findBy(Id);
//         // converting the employeedto into employeejpa
//
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//        return employeeDto;
//    }


}

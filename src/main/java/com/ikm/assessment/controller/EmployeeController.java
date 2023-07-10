package com.ikm.assessment.controller;

import com.ikm.assessment.model.Employee;
import com.ikm.assessment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired

    EmployeeRepository employeeRepository;


    @PostMapping(value = "/_employee")
    public ResponseEntity<String> createCitizen(@Valid @RequestBody Employee employee) {
        if (employee.getName() == null){
            return new ResponseEntity("Name must not be Blank", HttpStatus.BAD_REQUEST);
        }
        if (employee.getAddress().getHousename()==null){
            return new ResponseEntity("House must not be Blank",HttpStatus.BAD_REQUEST);
        }

        else{
            Employee savedEmployee = employeeRepository.save(employee);
            int id = savedEmployee.getEmpid();
            return ResponseEntity.status(HttpStatus.CREATED)
//                    .header("Location", "/api/v1/employee/" + id)
                    .body(" New employee created");

        }
    }
}

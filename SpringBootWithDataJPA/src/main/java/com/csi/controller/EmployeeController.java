package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee) {
        log.info("Trying to signUp for Employee:"+employee.getEmpName());
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }

    @GetMapping("/signin/{")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmail, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmail, empPassword));
    }

    @GetMapping("/findall")

    public ResponseEntity<List<Employee>> findAll() {
        log.info("Employee List Size:"+employeeServiceImpl.findAll().size());
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

}

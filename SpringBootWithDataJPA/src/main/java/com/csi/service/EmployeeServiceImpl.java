package com.csi.service;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepositoryImpl;

    public Employee signUp(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public boolean signIn(String empEmail, String empPassword) {
        boolean flag = false;
        for (Employee employee : employeeRepositoryImpl.findAll()) {
            if (employee.getEmpEmail().equals(empEmail) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Employee> findAll() {
        return employeeRepositoryImpl.findAll();
    }

}

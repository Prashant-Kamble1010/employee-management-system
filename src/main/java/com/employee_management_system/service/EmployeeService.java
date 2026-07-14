package com.employee_management_system.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.entity.Employee;
import com.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee login(String email) {
        return repository.findByEmail(email);
    }
}
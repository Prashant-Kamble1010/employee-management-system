package com.employee_management_system.controller;
import com.employee_management_system.entity.Employee;
import com.employee_management_system.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,
                           @RequestBody Employee employee) {

        Employee existing = service.getEmployee(id);

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return service.saveEmployee(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
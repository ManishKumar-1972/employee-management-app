package com.employee.employee_management.controller;

import com.employee.employee_management.model.Employee;
import com.employee.employee_management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Enable frontend to access backend
@RestController
@RequestMapping("/api/employees")  // 🔄 Changed from "/api/employees" to match frontend
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}

package com.employee.employee_management.service.impl;

import com.employee.employee_management.exception.ResourceNotFoundException;
import com.employee.employee_management.model.Employee;
import com.employee.employee_management.repository.EmployeeRepository;
import com.employee.employee_management.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee newEmployee) {
        Employee emp = getEmployeeById(id);
        emp.setFirstName(newEmployee.getFirstName());
        emp.setLastName(newEmployee.getLastName());
        emp.setEmail(newEmployee.getEmail());
        return repo.save(emp);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}

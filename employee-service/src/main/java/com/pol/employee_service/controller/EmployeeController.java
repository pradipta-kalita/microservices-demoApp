package com.pol.employee_service.controller;

import com.pol.employee_service.model.Employee;
import com.pol.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}",employee);
        return repository.add(employee);
    }

    @GetMapping
    public List<Employee> getAll(){
        LOGGER.info("GET all employee");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("GET employee by id: {}",id);
        return repository.findById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id){
        LOGGER.info("GET employee list by department id : {}",id);
        return repository.findByDepartment(id);
    }
}

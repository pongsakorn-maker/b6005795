package se.g21.backend.employeesystem.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import se.g21.backend.employeesystem.entities.*;
import se.g21.backend.employeesystem.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private NametitleRepository nametitleRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private RoleRepository roleRepository;

    EmployeeController(EmployeeRepository employeeRepository, NametitleRepository nametitleRepository,
            GenderRepository genderRepository, RoleRepository roleRepository) {

        this.employeeRepository = employeeRepository;
        this.nametitleRepository = nametitleRepository;
        this.genderRepository = genderRepository;
        this.roleRepository = roleRepository;

    }

    @GetMapping("/employee")
    public Collection<Employee> Employees() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/employee/{nametitle_id}/{gender_id}/{role_id}/{name}")
    public Employee newEmployee(Employee newEmployee, @PathVariable long nametitle_id, @PathVariable long gender_id,
            @PathVariable long role_id, @PathVariable String name) {

        Nametitle nametitle = nametitleRepository.findById(nametitle_id);
        Gender gender = genderRepository.findById(gender_id);
        Role role = roleRepository.findById(role_id);

        newEmployee.setNametitle(nametitle);
        newEmployee.setGender(gender);
        newEmployee.setRole(role);
        newEmployee.setName(name);

        return employeeRepository.save(newEmployee);

    }
}
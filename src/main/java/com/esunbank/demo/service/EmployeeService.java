package com.esunbank.demo.service;

import com.esunbank.demo.dto.EmployeeDTO;
import com.esunbank.demo.entity.Employee;
import com.esunbank.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployeeDTOs() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeeDTO(emp.getEmpId(), emp.getName(), emp.getEmail()))
                .collect(Collectors.toList());
    }
}
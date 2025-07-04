package com.esunbank.demo.controller;

import com.esunbank.demo.dto.EmployeeDTO;
import com.esunbank.demo.dto.SeatWithEmployeeDTO;
import com.esunbank.demo.entity.Employee;
import com.esunbank.demo.service.EmployeeService;
import com.esunbank.demo.service.SeatingService;
import com.esunbank.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://192.168.1.127:8081")
@RestController
@RequestMapping("/api/seats")
public class SeatingController {

    @Autowired
    private EmployeeService employeeService;
    private final SeatingService seatingService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public SeatingController(SeatingService seatingService, EmployeeRepository employeeRepository) {
        this.seatingService = seatingService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<SeatWithEmployeeDTO> getAllSeats() {
        return seatingService.getAllSeatsWithEmployee();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable String empId) {
        return seatingService.getEmployee(empId);
    }

    @PostMapping("/assign")
    public void assignSeat(@RequestParam String empId, @RequestParam Integer seatSeq) {
        seatingService.assignSeat(empId, seatSeq);
    }

    @PostMapping("/release")
    public void releaseSeat(@RequestParam String empId) {
        seatingService.releaseSeat(empId);
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployeeDTOs();
    }
}

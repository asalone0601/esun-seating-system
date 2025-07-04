package com.esunbank.demo.service;

import com.esunbank.demo.dto.SeatWithEmployeeDTO;
import com.esunbank.demo.entity.Employee;
import java.util.List;

public interface SeatingService {
    List<SeatWithEmployeeDTO> getAllSeatsWithEmployee();
    void assignSeat(String empId, Integer seatSeq);
    void releaseSeat(String empId);
    Employee getEmployee(String empId);
}

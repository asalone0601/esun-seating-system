package com.esunbank.demo.service;

import com.esunbank.demo.dto.SeatWithEmployeeDTO;
import com.esunbank.demo.entity.Employee;
import com.esunbank.demo.entity.SeatingChart;
import com.esunbank.demo.repository.EmployeeRepository;
import com.esunbank.demo.repository.SeatingChartRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatingServiceImpl implements SeatingService {

    private final EmployeeRepository employeeRepository;
    private final SeatingChartRepository seatingChartRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public SeatingServiceImpl(EmployeeRepository employeeRepository, SeatingChartRepository seatingChartRepository) {
        this.employeeRepository = employeeRepository;
        this.seatingChartRepository = seatingChartRepository;
    }

    @Override
    public List<SeatWithEmployeeDTO> getAllSeatsWithEmployee() {
        List<SeatingChart> seats = seatingChartRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        List<SeatWithEmployeeDTO> result = new ArrayList<>();
        for (SeatingChart seat : seats) {
            SeatWithEmployeeDTO dto = new SeatWithEmployeeDTO();
            dto.setFloorSeatSeq(seat.getFloorSeatSeq());
            dto.setFloorNo(seat.getFloorNo());
            dto.setSeatNo(seat.getSeatNo());
            Employee emp = employees.stream()
                    .filter(e -> e.getSeatingChart() != null && e.getSeatingChart().getFloorSeatSeq().equals(seat.getFloorSeatSeq()))
                    .findFirst()
                    .orElse(null);
            if (emp != null) {
                dto.setEmpId(emp.getEmpId());
                dto.setEmpName(emp.getName());
            }
            result.add(dto);
        }
        return result;
    }

    @Override
    @Transactional
    public void assignSeat(String empId, Integer seatSeq) {
        entityManager.createNativeQuery("CALL assign_seat(:empId, :seatSeq)")
                .setParameter("empId", empId)
                .setParameter("seatSeq", seatSeq)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void releaseSeat(String empId) {
        entityManager.createNativeQuery("CALL release_seat(:empId)")
                .setParameter("empId", empId)
                .executeUpdate();
    }

    @Override
    public Employee getEmployee(String empId) {
        return employeeRepository.findById(empId).orElse(null);
    }
}

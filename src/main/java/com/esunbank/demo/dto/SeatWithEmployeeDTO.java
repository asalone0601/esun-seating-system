package com.esunbank.demo.dto;

public class SeatWithEmployeeDTO {
    private Integer floorSeatSeq;
    private Integer floorNo;
    private Integer seatNo;
    private String empId;
    private String empName;

    public Integer getFloorSeatSeq() { return floorSeatSeq; }
    public void setFloorSeatSeq(Integer floorSeatSeq) { this.floorSeatSeq = floorSeatSeq; }

    public Integer getFloorNo() { return floorNo; }
    public void setFloorNo(Integer floorNo) { this.floorNo = floorNo; }

    public Integer getSeatNo() { return seatNo; }
    public void setSeatNo(Integer seatNo) { this.seatNo = seatNo; }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
}

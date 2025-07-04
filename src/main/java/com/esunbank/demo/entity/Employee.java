package com.esunbank.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @Column(name = "emp_id", length = 5)
    private String empId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_seat_seq", referencedColumnName = "floor_seat_seq")
    private SeatingChart seatingChart;

    public Employee() {}

    public Employee(String empId, String name, String email, SeatingChart seatingChart) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.seatingChart = seatingChart;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SeatingChart getSeatingChart() {
        return seatingChart;
    }

    public void setSeatingChart(SeatingChart seatingChart) {
        this.seatingChart = seatingChart;
    }
}


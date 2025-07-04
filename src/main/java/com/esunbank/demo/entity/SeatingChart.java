package com.esunbank.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seatingchart")
public class SeatingChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_seat_seq")
    private Integer floorSeatSeq;

    @Column(name = "floor_no", nullable = false)
    private Integer floorNo;

    @Column(name = "seat_no", nullable = false)
    private Integer seatNo;

    public SeatingChart() {}

    public SeatingChart(Integer floorNo, Integer seatNo) {
        this.floorNo = floorNo;
        this.seatNo = seatNo;
    }

    public Integer getFloorSeatSeq() {
        return floorSeatSeq;
    }

    public void setFloorSeatSeq(Integer floorSeatSeq) {
        this.floorSeatSeq = floorSeatSeq;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }
}

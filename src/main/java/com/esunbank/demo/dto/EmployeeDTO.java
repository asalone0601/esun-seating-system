package com.esunbank.demo.dto;

public class EmployeeDTO {
    private String empId;
    private String name;
    private String email;

    public EmployeeDTO(String empId, String name, String email) {
        this.empId = empId;
        this.name = name;
        this.email = email;
    }

    public String getEmpId() { return empId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

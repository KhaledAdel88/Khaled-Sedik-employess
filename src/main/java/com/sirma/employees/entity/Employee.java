package com.sirma.employees.entity;

public class Employee {

    private String employeeId;

    private Long daysWorked;

    public Employee() {
    }

    public Employee(String employeeId, Long daysWorked) {
        this.employeeId = employeeId;
        this.daysWorked = daysWorked;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(Long daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", daysWorked=" + daysWorked +
                '}';
    }

}

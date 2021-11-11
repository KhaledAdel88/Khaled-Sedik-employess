package com.sirma.employees.entity;

public class OldestEmployees {

    private String employee1;

    private String employee2;

    private String projectId;

    private Long totalWorkingDays;

    public OldestEmployees() {
    }

    public String getEmployee1() {
        return employee1;
    }

    public void setEmployee1(String employee1) {
        this.employee1 = employee1;
    }

    public String getEmployee2() {
        return employee2;
    }

    public void setEmployee2(String employee2) {
        this.employee2 = employee2;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Long getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public void setTotalWorkingDays(Long totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }

    @Override
    public String toString() {
        return "OldestEmployees{" +
                "employee1='" + employee1 + '\'' +
                ", employee2='" + employee2 + '\'' +
                ", projectId='" + projectId + '\'' +
                ", totalWorkingDays='" + totalWorkingDays + '\'' +
                '}';
    }

}

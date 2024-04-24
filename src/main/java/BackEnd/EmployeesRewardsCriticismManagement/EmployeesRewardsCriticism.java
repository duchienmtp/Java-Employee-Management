package BackEnd.EmployeesRewardsCriticismManagement;

import java.time.LocalDate;

public class EmployeesRewardsCriticism {

    private String employeeId, rewardId, criticismId;
    private LocalDate createdAt;
    private int faultCount, rewardCount;

    public EmployeesRewardsCriticism(String employeeId, String rewardId, String criticismId,int faultCount,int rewardCount, LocalDate createdAt ) {
        this.employeeId = employeeId;
        this.rewardId = rewardId;
        this.criticismId = criticismId;
        this.createdAt = createdAt;
        this.faultCount = faultCount;
        this.rewardCount = rewardCount;

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getCriticismId() {
        return criticismId;
    }

    public void setCriticismId(String criticismId) {
        this.criticismId = criticismId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getFaultCount() {
        return faultCount;
    }

    public void setFaultCount(int faultCount) {
        this.faultCount = faultCount;
    }
     public int getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(int rewardCount) {
        this.rewardCount = rewardCount;
    }
}

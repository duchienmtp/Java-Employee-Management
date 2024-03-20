package BackEnd.EmployeesRewardsCriticismManagement;

public class EmployeesRewardsCriticism {

    private String employeeId, rewardId, criticismId, createdAt;
    private int faultCount;

    public EmployeesRewardsCriticism(String employeeId, String rewardId, String criticismId, String createdAt, int faultCount) {
        this.employeeId = employeeId;
        this.rewardId = rewardId;
        this.criticismId = criticismId;
        this.createdAt = createdAt;
        this.faultCount = faultCount;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getFaultCount() {
        return faultCount;
    }

    public void setFaultCount(int faultCount) {
        this.faultCount = faultCount;
    }
}

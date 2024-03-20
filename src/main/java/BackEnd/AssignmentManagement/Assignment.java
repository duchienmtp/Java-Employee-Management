package BackEnd.AssignmentManagement;

public class Assignment {

    private String employeeId, businessTravelId;

    public Assignment(String employeeId, String businessTravelId) {
        this.employeeId = employeeId;
        this.businessTravelId = businessTravelId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBusinessTravelId() {
        return businessTravelId;
    }

    public void setBusinessTravelId(String businessTravelId) {
        this.businessTravelId = businessTravelId;
    }
}

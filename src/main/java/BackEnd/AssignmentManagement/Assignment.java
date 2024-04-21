package BackEnd.AssignmentManagement;

public class Assignment {
    private String employeeId, projectId;
    private boolean deleteStatus;
    public Assignment(String employyeeId, String projectId, boolean deleteStatus) {
        this.employeeId = employyeeId;
        this.projectId = projectId;
        this.deleteStatus = deleteStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employyeeId) {
        this.employeeId = employyeeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    
}

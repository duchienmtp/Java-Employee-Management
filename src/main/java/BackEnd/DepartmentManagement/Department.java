package BackEnd.DepartmentManagement;

public class Department {
    private String departmentId;
    private String departmentName;
    private String departmentLeader;
    private boolean deleteStatus;

    public Department() {
    }

    public Department(String departmentId, String departmentName, String departmentLeader, boolean deleteStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLeader = departmentLeader;
        this.deleteStatus = false; // Assuming departments are initially active
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLeader() {
        return departmentLeader;
    }

    public void setDepartmentLeader(String departmentLeader) {
        this.departmentLeader = departmentLeader;
    }

    public boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}

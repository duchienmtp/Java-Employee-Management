package BackEnd.DepartmentManagement;

public class Department {

    private String departmentId, departmentName, departmentLeader;

    public Department(String departmentId, String departmentName, String departmentLeader) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLeader = departmentLeader;
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
}

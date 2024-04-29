package BackEnd.DepartmentManagement;

import BackEnd.EmployeeManagement.Employee;
import java.util.Arrays;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private String departmentLeaderName;
    private Employee departmentLeader;
    private int numberOfMembers;
    private boolean deleteStatus;

    public Department() {
        this.departmentId = "DP000";
        this.departmentName = "Không có phòng ban";
        this.departmentLeaderName = "ADM001";
        this.deleteStatus = false;
    }

    public Department(String departmentId, String departmentName, Employee departmentLeader, boolean deleteStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLeader = departmentLeader;
        this.deleteStatus = deleteStatus;
    }

    public Department(String departmentId, String departmentName, Employee departmentLeader, int numberOfMembers,
            boolean deleteStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLeader = departmentLeader;
        this.numberOfMembers = numberOfMembers;
        this.deleteStatus = deleteStatus;
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

    public String getDepartmentLeaderName() {
        return departmentLeaderName;
    }

    public void setDepartmentLeaderName(String departmentLeaderName) {
        this.departmentLeaderName = departmentLeaderName;
    }

    public Employee getDepartmentLeader() {
        return departmentLeader;
    }

    public void setDepartmentLeader(Employee departmentLeader) {
        this.departmentLeader = departmentLeader;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public List<Object> toList() {
        try {
            return Arrays.asList(departmentId, departmentName, departmentLeader.getId(), deleteStatus, numberOfMembers);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "{" +
                " departmentId='" + departmentId + "'" +
                ", departmentName='" + departmentName + "'" +
                ", departmentLeaderName='" + departmentLeaderName + "'" +
                ", deleteStatus='" + deleteStatus + "'" +
                "}";
    }
}

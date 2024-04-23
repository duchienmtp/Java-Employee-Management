package BackEnd.DepartmentManagement;

import BackEnd.EmployeeManagement.Employee;
import java.util.Arrays;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private String departmentLeaderName; 
    private boolean deleteStatus;

    public Department() {
    }

    public Department(String departmentId, String departmentName, Employee departmentLeader, boolean deleteStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLeaderName = (departmentLeader != null) ? departmentLeader.getFullName() : ""; // Sửa đổi ở đây
        this.deleteStatus = deleteStatus;
    }

    Department(String departmentId, String departmentName, String departmentLeader, boolean deleteStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public List<Object> toList() {
        try {
            return Arrays.asList(departmentId, departmentName, departmentLeaderName, deleteStatus);
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

    String getDepartmentLeader() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getDeleteStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

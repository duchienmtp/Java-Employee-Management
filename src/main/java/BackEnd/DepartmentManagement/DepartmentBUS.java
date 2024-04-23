package BackEnd.DepartmentManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class DepartmentBUS {
    private ArrayList<Department> departmentList;
    private DepartmentDAO departmentDAO;

    public DepartmentBUS() {
        departmentDAO = new DepartmentDAO();
        departmentList = departmentDAO.getAllDepartments();
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public String getNextID() {
        if (departmentList.isEmpty()) {
            return "DP001"; // Assuming the first ID is DP001
        } else {
            String lastID = departmentList.get(departmentList.size() - 1).getDepartmentId();
            String characterPart = lastID.substring(0, 2);
            int numberPart = Integer.parseInt(lastID.substring(2)) + 1;
            String nextID = characterPart + String.format("%03d", numberPart);
            return nextID;
        }
    }

    public Department getDepartmentById(String departmentId) {
        for (Department department : departmentList) {
            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    public boolean addDepartment(Department department) {
        boolean ok = departmentDAO.addNewDepartment(department);
        if (ok) {
            departmentList.add(department);
        }
        return ok;
    }

    public void updateDepartment(Department department) {
        boolean ok = departmentDAO.updateDepartment(department);
        if (ok) {
            for (int i = 0; i < departmentList.size(); i++) {
                if (departmentList.get(i).getDepartmentId().equals(department.getDepartmentId())) {
                    departmentList.set(i, department);
                    break;
                }
            }
        }
    }

    public void deleteDepartment(Department department) {
        if (department == null) {
            return;
        }
        boolean ok = departmentDAO.deleteDepartment(department);
        if (ok) {
            departmentList.removeIf(dep -> dep.getDepartmentId().equals(department.getDepartmentId()));
        }
    }
public ArrayList<String> getAllEmployeeIDs() {
        return departmentDAO.getAllEmployeeIDsAndNames();
        
    }

    public String getAllEmployeeIDs(String selectedEmployeeID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

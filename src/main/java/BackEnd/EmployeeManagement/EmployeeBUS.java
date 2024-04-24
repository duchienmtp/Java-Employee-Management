package BackEnd.EmployeeManagement;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmployeeBUS {

    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<Employee> employeeNotDepartmentLeaderIdList = new ArrayList<>();
    private ArrayList<Employee> employeeNotHaveAccountIdList = new ArrayList<>();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeBUS() {
        employeeList = employeeDAO.getAllEmployee();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<Employee> getEmployeeIdList() {
        getNotDepartmentLeaderEmployees();
        return employeeNotDepartmentLeaderIdList;
    }

    public void getNotDepartmentLeaderEmployees() {
        employeeNotDepartmentLeaderIdList = employeeDAO.getNotDepartmentLeaderEmployees();
    }

    public ArrayList<Employee> getEmployeeNotHaveAccountIdList() {
        getNotHaveAccount();
        return employeeNotHaveAccountIdList;
    }

    public void getNotHaveAccount() {
        employeeNotHaveAccountIdList = employeeDAO.getNotHaveAccount();
    }

    public void readDB() {
        employeeList = employeeDAO.getAllEmployee();
    }

    public String getNextID() {
        String lastID = employeeList.get(employeeList.size() - 1).getId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }

    public Employee getEmployeeById(String employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    public void addEmployee(Employee employee) {
        Boolean ok = employeeDAO.addNewEmployee(employee);

        if (ok) {
            employeeList.add(employee);
            JOptionPane.showMessageDialog(null, "Thêm mới thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateEmployee(Employee employee) {
        Boolean ok = employeeDAO.updateEmployee(employee);

        if (ok) {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getId().equals(employee.getId())) {
                    employeeList.set(i, employee);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteEmployee(Employee employee) {
        Boolean ok = employeeDAO.deleteEmployee(employee);

        if (ok) {
            this.readDB();
            JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

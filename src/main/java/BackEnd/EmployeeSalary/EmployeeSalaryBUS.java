package BackEnd.EmployeeSalary;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmployeeSalaryBUS {
    ArrayList<EmployeeSalary> employeeSalaryList = new ArrayList<>();
    EmployeeSalaryDAO employeeSalaryDAO = new EmployeeSalaryDAO();

    public EmployeeSalaryBUS() {
        employeeSalaryList = employeeSalaryDAO.getAllEmployeeSalary();
    }

    public ArrayList<EmployeeSalary> getAllEmployeeSalary() {
        return employeeSalaryList;
    }

    public void readDB() {
        employeeSalaryList = employeeSalaryDAO.getAllEmployeeSalary();
    }

    public void addEmployeeSalary(EmployeeSalary employeeSalary) {
        Boolean ok = employeeSalaryDAO.addEmployeeSalary(employeeSalary);
        if (ok) {
            employeeSalaryList.add(employeeSalary);
            JOptionPane.showMessageDialog(null, "Thêm mới thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateEmployeeSalary(EmployeeSalary employeeSalary) {
        Boolean ok = employeeSalaryDAO.updateEmployeeSalary(employeeSalary);
        if (ok) {
            for (int i = 0; i < employeeSalaryList.size(); i++) {
                if (employeeSalaryList.get(i).getEmployee().getId().equals(employeeSalary.getEmployee().getId())) {
                    employeeSalaryList.set(i, employeeSalary);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteEmployeeSalary(EmployeeSalary employeeSalary) {
        Boolean ok = employeeSalaryDAO.deleteEmployeeSalary(employeeSalary);
        if (ok) {
            this.readDB();
            JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public EmployeeSalary getEmployeeSalaryById(String id) {
        return employeeSalaryDAO.getEmployeeSalaryById(id);
    }
}

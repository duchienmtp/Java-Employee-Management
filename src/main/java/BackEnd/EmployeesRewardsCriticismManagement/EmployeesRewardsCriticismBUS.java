package BackEnd.EmployeesRewardsCriticismManagement;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmployeesRewardsCriticismBUS {
    private ArrayList<EmployeesRewardsCriticism> listEmployeeRC = new ArrayList<>();
    private ArrayList<EmployeesRewardsCriticism> listEmployeeReward = new ArrayList<>();
    private ArrayList<EmployeesRewardsCriticism> listEmployeeCriticism = new ArrayList<>();
    private EmployeesRewardsCriticismDAO employeeRCDAO = new EmployeesRewardsCriticismDAO();

    public EmployeesRewardsCriticismBUS() {
        listEmployeeRC = employeeRCDAO.getAllEmployeesRewardsCriticism();
    }

    public void readDB() {
        listEmployeeRC = employeeRCDAO.getAllEmployeesRewardsCriticism();
    }

    public String getNextID() {
        return "CR" + String.valueOf(this.listEmployeeRC.size() + 1);
    }

    public ArrayList<EmployeesRewardsCriticism> getlistEmployeeRC() {
        return this.listEmployeeRC;
    }

    public ArrayList<EmployeesRewardsCriticism> search(String type, String value) {
        ArrayList<EmployeesRewardsCriticism> result = new ArrayList<>();

        listEmployeeRC.forEach((id) -> {
            if (type.equals("Tất cả")) {
                if (id.getEmployee().getId().toLowerCase().contains(value.toLowerCase())
                        || id.getReward().getRewardId().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(id.getCriticism().getCriticismId()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(id.getCreatedAt()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(id);
                }
            } else {
                switch (type) {
                    case "Mã nhân viên":
                        if (id.getEmployee().getId().toLowerCase().contains(value.toLowerCase())) {
                            result.add(id);
                        }
                        break;
                    case "Mã khen thưởng":
                        if (id.getReward().getRewardId().toLowerCase().contains(value.toLowerCase())) {
                            result.add(id);
                        }
                        break;
                    case "Mã kỷ luật":
                        if (String.valueOf(id.getCriticism().getCriticismId()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(id);
                        }
                        break;
                }
            }

        });
        // Ngay lap, tong tien
        for (int i = result.size() - 1; i >= 0; i--) {
            EmployeesRewardsCriticism id = result.get(i);
            String createdAt = id.getCreatedAt();

        }

        return result;
    }

    public EmployeesRewardsCriticism getEmployeesRewardsCriticism(String employeeId, String rewardId,
            String criticismId,
            String createdAt) {
        for (EmployeesRewardsCriticism employeeRC : listEmployeeRC) {
            if (employeeRC.getEmployee().getId().equals(employeeId)
                    && employeeRC.getReward().getRewardId().equals(rewardId)
                    && employeeRC.getCriticism().getCriticismId().equals(criticismId)
                    && employeeRC.getCreatedAt().equals(createdAt)) {
                return employeeRC;
            }
        }
        return null;
    }

    public void addEmployeesRewardsCriticism(EmployeesRewardsCriticism employeesRewardsCriticism) {
        Boolean ok = employeeRCDAO.addEmployeesRewardsCriticism(employeesRewardsCriticism);

        if (ok) {
            listEmployeeRC.add(employeesRewardsCriticism);
            JOptionPane.showMessageDialog(null, "Thêm mới thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateEmployeesRewardsCriticism(EmployeesRewardsCriticism employeesRewardsCriticism) {
        Boolean ok = employeeRCDAO.updateEmployeesRewardsCriticism(employeesRewardsCriticism);

        if (ok) {
            for (int i = 0; i < listEmployeeRC.size(); i++) {
                if (listEmployeeRC.get(i).getEmployee().getId().equals(employeesRewardsCriticism.getEmployee().getId())
                        &&
                        listEmployeeRC.get(i).getReward().getRewardId()
                                .equals(employeesRewardsCriticism.getReward().getRewardId())
                        &&
                        listEmployeeRC.get(i).getCriticism().getCriticismId()
                                .equals(employeesRewardsCriticism.getCriticism().getCriticismId())
                        &&
                        listEmployeeRC.get(i).getCreatedAt().equals(employeesRewardsCriticism.getCreatedAt())) {
                    listEmployeeRC.set(i, employeesRewardsCriticism);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteEmployeesRewardsCriticism(EmployeesRewardsCriticism employeesRewardsCriticism) {
        Boolean ok = employeeRCDAO.deleteEmployeesRewardsCriticism(employeesRewardsCriticism);

        if (ok) {
            for (int i = 0; i < listEmployeeRC.size(); i++) {
                if (listEmployeeRC.get(i).getEmployee().getId().equals(employeesRewardsCriticism.getEmployee().getId())
                        &&
                        listEmployeeRC.get(i).getReward().getRewardId()
                                .equals(employeesRewardsCriticism.getReward().getRewardId())
                        &&
                        listEmployeeRC.get(i).getCriticism().getCriticismId()
                                .equals(employeesRewardsCriticism.getCriticism().getCriticismId())
                        &&
                        listEmployeeRC.get(i).getCreatedAt().equals(employeesRewardsCriticism.getCreatedAt())) {
                    listEmployeeRC.remove(i);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void getEmployeesRewardsByEmployeeId(String employeeId) {
        listEmployeeReward = employeeRCDAO.getEmployeesRewardsByEmployeeId(employeeId);
    }

    public ArrayList<EmployeesRewardsCriticism> getListEmployeeReward() {
        return this.listEmployeeReward;
    }

    public void getEmployeesCriticismByEmployeeId(String employeeId) {
        listEmployeeCriticism = employeeRCDAO.getEmployeesCriticismByEmployeeId(employeeId);
    }

    public ArrayList<EmployeesRewardsCriticism> getListEmployeeCriticism() {
        return this.listEmployeeCriticism;
    }
}

package BackEnd.AssignmentManagement;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AssignmentBUS {
    private AssignmentDAO asmD = new AssignmentDAO();
    private ArrayList<Assignment> list = new ArrayList<>();

    public AssignmentBUS() {
        list = asmD.getAllAssignments();
    }

    public ArrayList<Assignment> getAssignmentsList() {
        return list;
    }

    public String getNextEmployeeID() {
        String lastID = list.get(list.size() - 1).getEmployeeId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }

    public String getNextProjectID() {
        String lastID = list.get(list.size() - 1).getProjectId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }

    public Assignment getAssignmentByEmployeeId(String employeeId) {
        for (Assignment it : list) {
            if (it.getEmployeeId().equals(employeeId))
                return it;
        }
        return null;
    }

    public Assignment getAssignmentByProjectId(String projectId) {
        for (Assignment it : list) {
            if (it.getProjectId().equals(projectId))
                return it;
        }
        return null;
    }

    public void addNewAssignment(Assignment asm) {
        if (asmD.addNewAssignment(asm)) {
            list.add(asm);
            JOptionPane.showMessageDialog(null, "Thêm mới thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateAssignment(ArrayList<Object> prevState, Assignment newasm) {
        if (asmD.updateAssignment(prevState, newasm)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProject().getProjectId().equalsIgnoreCase((String) prevState.get(3))
                        && list.get(i).getEmployee().getId().equalsIgnoreCase((String) prevState.get(1))) {
                    list.set(i, newasm);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteAssignment(Assignment asm) {
        if (asmD.deleteAssignment(asm)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProject().getProjectId().equals(asm.getProject().getProjectId())
                        && list.get(i).getEmployee().getId().equals(asm.getEmployee().getId())) {
                    list.remove(i);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean checkInList(String employeeID, String projectId) {
        for (Assignment it : list) {
            if (it.getEmployee().getId().equalsIgnoreCase(employeeID)
                    && it.getProject().getProjectId().equalsIgnoreCase(projectId)) {
                return true;
            }
        }
        return false;
    }

    public Assignment findAssignmentByEmployeeIdAndProjectId(String employeeId, String projectId) {
        return asmD.findAssignmentByEmployeeIdAndProjectId(employeeId, projectId);
    }
}

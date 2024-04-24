package BackEnd.AssignmentManagement;
import BackEnd.AssignmentManagement.AssignmentDAO;
import java.util.ArrayList;
public class AssignmentBUS {
    private AssignmentDAO asmD = new AssignmentDAO();
    private ArrayList<Assignment> list = new ArrayList<>();
    public AssignmentBUS() {
        list = asmD.getAllAssignments();
    }
    public ArrayList<Assignment> getAssignmentsList(){
        return list;
    }
    public String getNextEmployeeID(){
        String lastID = list.get(list.size() - 1).getEmployeeId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    } 
    public String getNextProjectID(){
        String lastID = list.get(list.size() - 1).getProjectId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }
    public Assignment getAssignmentByEmployeeId(String employeeId){
        for(Assignment it : list){
            if(it.getEmployeeId().equals(employeeId))  return it;
        }
        return null;
    }
    public Assignment getAssignmentByProjectId(String projectId){
        for(Assignment it :  list){
            if(it.getProjectId().equals(projectId)) return it;
        }
        return null;
    }
    public void addNewAssignment(Assignment asm){
        if(asmD.addNewAssignment(asm)){
            list.add(asm);
        }
    }
    public void updateAssignmentWithEmpoyeeId(Assignment asm){
        if(asmD.updateAssignmentWithEmployeeId(asm)){
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).getEmployeeId().equals(asm.getEmployeeId()))   list.set(i, asm);
                break;
            }
        }
    }
    public void updateAssignmentWithProjectId(Assignment asm){
        if(asmD.updateAssignmentWithProjectId(asm)){
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).getProjectId().equals(asm.getProjectId()))     list.set(i, asm);
                break;
            }
        }
    }
    public void deleteAssignment(Assignment asm){
        if(asmD.deleteAssignment(asm)){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProjectId().equals(asm.getProjectId())&& list.get(i).getEmployeeId().equals(asm.getEmployeeId())) {
                    list.remove(i);
                    break;
                }
            }
        }
    }

    public boolean checkInList(String employeeID, String projectId){
        for(Assignment it : list){
            if(it.getEmployee().getId().equalsIgnoreCase(employeeID) && it.getProjectId().equalsIgnoreCase(projectId)){
                return true;
            }
        }
        return false;
    }
}

package BackEnd.ProjectsManagemennt;
import java.util.*;
public class ProjectBUS {
    private ArrayList<Project> list = new ArrayList<>();
    private ProjectDAO pjD = new ProjectDAO();
    public ProjectBUS(){
        list = pjD.getAllProject();
    }
    public void readProject(){
        list = pjD.getAllProject();
    }
    public ArrayList<Project> getProjectList(){
        return list;
    }
    public String getNextID(){
        String lastID = list.get(list.size() - 1).getProjectId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }
    public Project getProjectById(String projectId) {
        for (Project pj : list) {
            if (pj.getProjectId().equalsIgnoreCase(projectId)) {
                return pj;
            }
        }
        return null;
    }

    public void addProject(Project pj) {
        Boolean ok = pjD.addNewProject(pj);

        if (ok) {
            list.add(pj);
        }
    }

    public void updateProject(Project pj) {
        Boolean ok = pjD.updateProject(pj);

        if (ok) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProjectId().equals(pj.getProjectId())) {
                    list.set(i, pj);
                    break;
                }
            }
        }
    }

    public void deleteProject(String pj) {
        Boolean ok = pjD.deleteProject(pj);

        if (ok) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProjectId().equals(pj)) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
    public Project searchInProject(String pjId){
        if(pjD.searchInProject(pjId)!=null){
            return pjD.searchInProject(pjId);
        }
        return null;
    }
    
}

package BackEnd.ProjectsManagemennt;
import BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ProjectDAO {
    private ConnectDB con;
    public ProjectDAO(){
    }
    public ArrayList<Project> getAllProject(){
        ArrayList<Project> list = new ArrayList<>();
        con = new ConnectDB();
        try {
            String sql = "select * from Projects WHERE deleteStatus = 0";
            ResultSet rs = con.sqlQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    list.add(new Project(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu bảng đồ án");
        } finally {
            con.closeConnect();
        }
        return list;
    }
    
    public boolean updateProject(Project pj){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "update Projects set projectId = '" + pj.getProjectId() + "' and projectName = '" + pj.getProjectName() + "' and departmentId = '" + pj.getDepartmentId() + "' and beginAt = '" + pj.getBeginAt() + "' and completeAt = '" + pj.getCompleteAt() + "' and place = '" + pj.getPlace() + "' where projectId = '" + pj.getProjectId() + "'";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    public boolean deleteProject(String pjid){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "update Projects set deletestatus = 1 where projectId = '" + pjid  + "'";
            flag = con.sqlUpdate(sql);
        } finally {
            con.closeConnect();
        }
        return flag;
    }
    public Project searchInProject(String pjId){
        con = new ConnectDB();
        Project pj = null;
        try {
            String sql = "SELECT * FROM Projects WHERE projectId = '" + pjId + "'";
            ResultSet rs = con.sqlQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    pj = new Project(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        } 
        finally {
            con.closeConnect();
        }
        return pj;
    }
    public boolean addNewProject(Project pj){
        con = new ConnectDB();
        boolean flag = false;
        try {
            String sql = "INSERT INTO [QLNV].[dbo].[Projects] ([projectId], [projectName], [departmentId], [beginAt], [completedAt], [place], [deleteStatus]) VALUES ('" + pj.getProjectId() + "','" + pj.getProjectName() + "','" + pj.getDepartmentId() + "','" + pj.getBeginAt() + "','" + pj.getCompleteAt() + "','" + pj.getPlace() + "')";
            flag = con.sqlUpdate(sql);
        }finally {
            con.closeConnect();
        }
        return flag;
    }
}

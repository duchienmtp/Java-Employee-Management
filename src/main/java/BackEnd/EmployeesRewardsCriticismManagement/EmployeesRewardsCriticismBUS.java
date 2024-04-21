package BackEnd.EmployeesRewardsCriticismManagement;
import BackEnd.EmployeesRewardsCriticismManagement.EmployeesRewardsCriticismDAO;
import BackEnd.EmployeesRewardsCriticismManagement.EmployeesRewardsCriticism;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeesRewardsCriticismBUS {
 private ArrayList<EmployeesRewardsCriticism> listEmployeeRC = new ArrayList<>();
    private EmployeesRewardsCriticismDAO employeeRCDAO = new EmployeesRewardsCriticismDAO();

    public EmployeesRewardsCriticismBUS() {
         listEmployeeRC = employeeRCDAO.getAllEmployeesRewardsCriticism();
    }
    public void readDB(){
         listEmployeeRC = employeeRCDAO. getAllEmployeesRewardsCriticism();

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
                if (id.getEmployeeId().toLowerCase().contains(value.toLowerCase())
                        || id.getRewardId().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(id.getCriticismId()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(id.getCreatedAt()).toLowerCase().contains(value.toLowerCase())) {
                    result.add(id);
                }
            } else {
                switch (type) {
                    case "Mã nhân viên":
                        if (id.getEmployeeId().toLowerCase().contains(value.toLowerCase())) {
                            result.add(id);
                        }
                        break;
                    case "Mã khen thưởng":
                        if (id.getRewardId().toLowerCase().contains(value.toLowerCase())) {
                            result.add(id);
                        }
                        break;
                    case "Mã kỷ luật":
                        if (String.valueOf(id.getCriticismId()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(id);
                        }
                        break;               
              }
            }

        });
        //Ngay lap, tong tien
        for (int i = result.size() - 1; i >= 0; i--) {
            EmployeesRewardsCriticism id = result.get(i);
            LocalDate createdAt = id.getCreatedAt();
          
        }

        return result;
    }



}

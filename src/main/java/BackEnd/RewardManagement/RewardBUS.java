package BackEnd.RewardManagement;
import BackEnd.CriticismManagement.Criticism;
import BackEnd.RewardManagement.RewardDAO;
import BackEnd.RewardManagement.Reward;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class RewardBUS {
    private ArrayList<Reward> listreward = new ArrayList<>();
    private RewardDAO rewardDAO = new RewardDAO();
    public RewardBUS() {
        listreward = rewardDAO. getAllReward();
    }  public void readDB() {
        listreward = rewardDAO. getAllReward();
    }
    
    public String getNextID() {
        String lastID = listreward.get(listreward.size() - 1).getRewardId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;  
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }
      public ArrayList<Reward> getListReward() {
        return this.listreward;
    }
      public Reward getRewardById(String rewardId) {
        for (Reward rw : listreward) {
            if (rw.getRewardId().equals(rewardId)) {
                return rw;
            }
        }
        return null;
    }
      public void addReward(Reward rw) {
        Boolean ok = rewardDAO.addNewReward(rw);

        if (ok) {
            listreward.add(rw);
        }
    }


   public void updateReward(Reward rw) {
        Boolean ok =rewardDAO.updateReward(rw);

        if (ok) {
            for (int i = 0; i < listreward.size(); i++) {
                if (listreward.get(i).getRewardId().equals(rw.getRewardId())) {
                    listreward.set(i, rw);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }


//    public void updateReward(Reward rw) {
//        Boolean ok = rewardDAO.updateReward(rw);
//
//        if (ok) {
//            for (int i = 0; i < listreward.size(); i++) {
//                if (listreward.get(i).getRewardId().equals(rw.getRewardId())) {
//                   listreward.set(i, rw);
//                    break;
//                }
//            }
//        }
//    }
     public boolean deleteReward(Reward rw) {
        boolean ok = rewardDAO.deleteReward(rw);

    if (ok) {
        // Duyệt qua danh sách từ cuối lên đầu
        for (int i = listreward.size() - 1; i >= 0; i--) {
            // Điều kiện đã sửa để so sánh các ID
            if (listreward.get(i).getRewardId().equals(rw.getRewardId())) {
                listreward.remove(i);
            }
        }
    }

    return ok;
    }

}

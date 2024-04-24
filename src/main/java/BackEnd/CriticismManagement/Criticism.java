
package BackEnd.CriticismManagement;

public class Criticism {

    private String criticismId, criticismName;
    private int judgement;
    private boolean deleteStatus;

    public Criticism(String criticismId, String criticismName, int judgement) {
        this.criticismId = criticismId;
        this.criticismName = criticismName;
        this.judgement = judgement;
        this.deleteStatus = false;

    }

    public Criticism() {
        this.criticismId = "CR001";
        this.criticismName = "Không có lỗi";
        this.judgement = 0;
        this.deleteStatus = false;
    }

    public String getCriticismId() {
        return criticismId;
    }

    public void setCriticismId(String criticismId) {
        this.criticismId = criticismId;
    }

    public String getCriticismName() {
        return criticismName;
    }

    public void setCriticismName(String criticismName) {
        this.criticismName = criticismName;
    }

    public int getJudgement() {
        return judgement;
    }

    public void setJudgement(int judgement) {
        this.judgement = judgement;
    }

    public boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}

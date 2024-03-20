package BackEnd.CriticismManagement;

public class Criticism {

    private String criticismId, criticismName;
    private int judgement;

    public Criticism(String criticismId, String criticismName, int judgement) {
        this.criticismId = criticismId;
        this.criticismName = criticismName;
        this.judgement = judgement;
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
}

package BackEnd.SpecialtyManagement;

public class Specialty {

    private String specialtyId, specialtyName;

    public Specialty(String specialtyId, String specialtyName) {
        this.specialtyId = specialtyId;
        this.specialtyName = specialtyName;
    }

    public String getPositionId() {
        return specialtyId;
    }

    public void setPositionId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getPositionName() {
        return specialtyName;
    }

    public void setPositionName(String specialtyName) {
        this.specialtyName = specialtyName;
    }
}

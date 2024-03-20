package BackEnd.RelativesManagement;

public class Relatives {

    private String employeeId, fullname,
            gender, birthDate;

    public Relatives(String employeeId, String fullname, String gender, String birthDate) {
        this.employeeId = employeeId;
        this.fullname = fullname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

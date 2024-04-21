package BackEnd.EmployeeManagement;

public class Employee {

    private String id, fullName, gender, birthDate, phoneNumber, ethnicGroup, typeId, religion, degreenId, nation, positionId, departmentId, specialtyId;
    private boolean employeeStatus, deleteStatus;
    public Employee(String id, String fullName, String gender, String birthDate, String phoneNumber, String ethnicGroup, String typeId, String religion, String degreenId, String nation, String positionId, String departmentId, String specialtyId, boolean employeeStatus, boolean deleteStatus) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.ethnicGroup = ethnicGroup;
        this.typeId = typeId;
        this.religion = religion;
        this.degreenId = degreenId;
        this.nation = nation;
        this.positionId = positionId;
        this.departmentId = departmentId;
        this.specialtyId = specialtyId;
        this.employeeStatus = employeeStatus;
        this.deleteStatus = deleteStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDegreenId() {
        return degreenId;
    }

    public void setDegreenId(String degreenId) {
        this.degreenId = degreenId;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    
}

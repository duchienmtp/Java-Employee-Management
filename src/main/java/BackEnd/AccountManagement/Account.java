package BackEnd.AccountManagement;

import BackEnd.EmployeeManagement.Employee;

public class Account {

    private Employee employee;
    private String userId, username, password, email, avatar, authorization;
    private boolean deleteStatus;

    public Account() {
    }

    public Account(String userId, String username, String password, String email, String avatar, String authorization) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.authorization = authorization;
        this.deleteStatus = false;
    }

    public Account(Employee employee, String username, String password, String email, String avatar,
            String authorization) {
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.authorization = authorization;
        this.deleteStatus = false;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}

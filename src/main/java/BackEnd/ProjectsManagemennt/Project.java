package BackEnd.ProjectsManagemennt;

public class Project {
    private String businessTravelId, beginAt, completedAt, place, purpose;

    public String getBusinessTravelId() {
        return businessTravelId;
    }

    public void setBusinessTravelId(String businessTravelId) {
        this.businessTravelId = businessTravelId;
    }

    public String getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(String beginAt) {
        this.beginAt = beginAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Project(String businessTravelId, String beginAt, String completedAt, String place, String purpose) {
        this.businessTravelId = businessTravelId;
        this.beginAt = beginAt;
        this.completedAt = completedAt;
        this.place = place;
        this.purpose = purpose;
    }
    
}

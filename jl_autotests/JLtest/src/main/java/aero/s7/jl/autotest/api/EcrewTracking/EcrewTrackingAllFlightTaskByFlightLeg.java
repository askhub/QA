package aero.s7.jl.autotest.api.EcrewTracking;

public class EcrewTrackingAllFlightTaskByFlightLeg {
    private String authorFullName;
    private Integer authorId;
    private Integer createDate;
    private String crewType;
    private Integer id;

    public EcrewTrackingAllFlightTaskByFlightLeg() {
    }

    public String getAuthorFullName() {
        return authorFullName;
    }
    public Integer getAuthorId() {
        return authorId;
    }
    public Integer getCreateDate() {
        return createDate;
    }
    public String getCrewType() {
        return crewType;
    }
    public Integer getId() {
        return id;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }
    public void setCrewType(String crewType) {
        this.crewType = crewType;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}

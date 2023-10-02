package aero.s7.jl.autotest.api.SeatRules;

import java.util.Date;

public class SeatRuleData {

    private Integer id;
    private Integer carrierId;
    private Integer actypeId;
    private Integer boardId;
    private Boolean isActive;
    private Boolean isTemplate;
    private Integer crewMemberType;
    private String capCY;
    private Date validityStart;
    private Date validityEnd;
    private Integer authorId;
    private String authorFullName;
    private Date createDate;
    private Date modifyDate;
    private Integer modifyAuthorId;
    private String modifyAuthorFullName;
    private Object[] taskToSeatRuleIDs;

    public SeatRuleData() {

    }

    public Integer getId() {
        return id;
    }
    public Integer getCarrierId() {
        return carrierId;
    }
    public Integer getActypeId() {
        return actypeId;
    }
    public Integer getBoardId() {
        return boardId;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public Boolean getTemplate() {
        return isTemplate;
    }
    public Integer getCrewMemberType() {
        return crewMemberType;
    }
    public String getCapCY() {
        return capCY;
    }
    public Date getValidityStart() {
        return validityStart;
    }
    public Date getValidityEnd() {
        return validityEnd;
    }
    public Integer getAuthorId() {
        return authorId;
    }
    public String getAuthorFullName() {
        return authorFullName;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public Integer getModifyAuthorId() {
        return modifyAuthorId;
    }
    public String getModifyAuthorFullName() {
        return modifyAuthorFullName;
    }
    public Object[] getTaskToSeatRuleIDs() {
        return taskToSeatRuleIDs;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }
    public void setActypeId(Integer actypeId) {
        this.actypeId = actypeId;
    }
    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }
    public void setCrewMemberType(Integer crewMemberType) {
        this.crewMemberType = crewMemberType;
    }
    public void setCapCY(String capCY) {
        this.capCY = capCY;
    }
    public void setValidityStart(Date validityStart) {
        this.validityStart = validityStart;
    }
    public void setValidityEnd(Date validityEnd) {
        this.validityEnd = validityEnd;
    }
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    public void setModifyAuthorId(Integer modifyAuthorId) {
        this.modifyAuthorId = modifyAuthorId;
    }
    public void setModifyAuthorFullName(String modifyAuthorFullName) {
        this.modifyAuthorFullName = modifyAuthorFullName;
    }
    public void setTaskToSeatRuleIDs(Object[] taskToSeatRuleIDs) {
        this.taskToSeatRuleIDs = taskToSeatRuleIDs;
    }
}

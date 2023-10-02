package aero.s7.jl.autotest.api.SeatRules;

import java.util.List;

public class SeatRule {
    private int id;
    private int crewMemberType;
    private int carrierId;
    private int actypeId;
    private String capCY;
    private boolean isActive;
    private boolean isTemplate;
    private String validityStart;
    private String validityEnd;
    private List<Integer> taskToSeatRuleIDs;
    private String authorFullName;
    private int authorId;
    private int boardId;
    private String createDate;
    private String modifyAuthorFullName;
    private int modifyAuthorId;
    private String modifyDate;


    public SeatRule() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrewMemberType() {
        return crewMemberType;
    }

    public void setCrewMemberType(int crewMemberType) {
        this.crewMemberType = crewMemberType;
    }

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public int getActypeId() {
        return actypeId;
    }

    public void setActypeId(int acTypeId) {
        this.actypeId = acTypeId;
    }

    public String getCapCY() {
        return capCY;
    }

    public void setCapCY(String capCY) {
        this.capCY = capCY;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(boolean template) {
        isTemplate = template;
    }

    public String getValidityStart() {
        return validityStart;
    }

    public void setValidityStart(String validityStart) {
        this.validityStart = validityStart;
    }

    public String getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(String validityEnd) {
        this.validityEnd = validityEnd;
    }

    public List<Integer> getTaskToSeatRuleIDs() {
        return taskToSeatRuleIDs;
    }

    public void setTaskToSeatRuleIDs(List<Integer> taskToSeatRuleIDs) {
        this.taskToSeatRuleIDs = taskToSeatRuleIDs;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyAuthorFullName() {
        return modifyAuthorFullName;
    }

    public void setModifyAuthorFullName(String modifyAuthorFullName) {
        this.modifyAuthorFullName = modifyAuthorFullName;
    }

    public int getModifyAuthorId() {
        return modifyAuthorId;
    }

    public void setModifyAuthorId(int modifyAuthorId) {
        this.modifyAuthorId = modifyAuthorId;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

}
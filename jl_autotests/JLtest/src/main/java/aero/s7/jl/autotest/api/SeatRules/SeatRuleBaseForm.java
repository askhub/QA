package aero.s7.jl.autotest.api.SeatRules;

import java.util.List;

public class SeatRuleBaseForm {
    
    public Integer carrierId;
    public Integer actypeId;
    public Boolean isActive;
    public Boolean isTemplate;
    public Integer crewMemberType;
    public String capCY;
    public String validityStart;
    public String validityEnd;
    public Integer authorId;
    public String authorFullName;
    public String createDate;
    public Object[] taskToSeatRuleIDs;
    public String code;
    public List<Integer> crewCategoryIds;
    public int crewPosId;
    public boolean isAdditional;
    public List<Integer> qualificationIds;
    public Integer role;
    public Integer subTask;
    public String taskId;
    public int type;

    public SeatRuleBaseForm() {
    }


    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public void setActypeId(Integer actypeId) {
        this.actypeId = actypeId;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public void setIsTemplate(Boolean template) {
        isTemplate = template;
    }

    public void setCrewMemberType(Integer crewMemberType) {
        this.crewMemberType = crewMemberType;
    }

    public void setCapCY(String capCY) {
        this.capCY = capCY;
    }

    public void setValidityStart(String validityStart) {
        this.validityStart = validityStart;
    }

    public void setValidityEnd(String validityEnd) {
        this.validityEnd = validityEnd;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public void setCreateDate(String createDate) { this.createDate = createDate; }

    public void setTaskToSeatRuleIDs(Object[] taskToSeatRuleIDs) { this.taskToSeatRuleIDs = taskToSeatRuleIDs; }



    public Integer getCarrierId() {
        return carrierId;
    }

    public Integer getActypeId() {
        return actypeId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public Integer getCrewMemberType() {
        return crewMemberType;
    }

    public String getCapCY() {
        return capCY;
    }

    public String getValidityStart() {
        return validityStart;
    }

    public String getValidityEnd() {
        return validityEnd;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Object[] getTaskToSeatRuleIDs() {
        return taskToSeatRuleIDs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Integer> getCrewCategoryIds() {
        return crewCategoryIds;
    }

    public void setCrewCategoryIds(List<Integer> crewCategoryIds) {
        this.crewCategoryIds = crewCategoryIds;
    }

    public int getCrewPosId() {
        return crewPosId;
    }

    public void setCrewPosId(int crewPosId) {
        this.crewPosId = crewPosId;
    }

    public boolean getIsAdditional() {
        return isAdditional;
    }

    public void setIsAdditional(boolean additional) {
        this.isAdditional = isAdditional;
    }

    public List<Integer> getQualificationIds() {
        return qualificationIds;
    }

    public void setQualificationIds(List<Integer> qualificationIds) {
        this.qualificationIds = qualificationIds;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getSubTask() {
        return subTask;
    }

    public void setSubTask(Integer subTask) {
        this.subTask = subTask;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

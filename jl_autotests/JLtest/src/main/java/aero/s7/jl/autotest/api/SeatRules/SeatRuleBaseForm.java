package aero.s7.jl.autotest.api.SeatRules;

import java.util.List;

public class SeatRuleBaseForm {
    
    public Integer carrierId;
    public int actypeId;
    public boolean isActive;
    public boolean isTemplate;
    public int crewMemberType;
    public String capCY;
    public String validityStart;
    public String validityEnd;
    public int authorId;
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

    public Integer getCarrierId() {
        return carrierId;
    }

    public int getActypeId() {
        return actypeId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean getIsTemplate() {
        return isTemplate;
    }

    public int getCrewMemberType() {
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

    public int getAuthorId() {
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

    public List<Integer> getCrewCategoryIds() {
        return crewCategoryIds;
    }

    public int getCrewPosId() {
        return crewPosId;
    }

    public boolean getIsAdditional() {
        return isAdditional;
    }

    public List<Integer> getQualificationIds() {
        return qualificationIds;
    }

    public Integer getRole() {
        return role;
    }

    public Integer getSubTask() {
        return subTask;
    }

    public String getTaskId() {
        return taskId;
    }

    public int getType() {
        return type;
    }


    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public void setActypeId(int actypeId) {
        this.actypeId = actypeId;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsTemplate(boolean IsTemplate) {
        this.isTemplate = isTemplate;
    }

    public void setCrewMemberType(int crewMemberType) {
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

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setTaskToSeatRuleIDs(Object[] taskToSeatRuleIDs) {
        this.taskToSeatRuleIDs = taskToSeatRuleIDs;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCrewCategoryIds(List<Integer> crewCategoryIds) {
        this.crewCategoryIds = crewCategoryIds;
    }

    public void setCrewPosId(int crewPosId) {
        this.crewPosId = crewPosId;
    }

    public void setIsAdditional(boolean isAdditional) {
        this.isAdditional = isAdditional;
    }

    public void setQualificationIds(List<Integer> qualificationIds) {
        this.qualificationIds = qualificationIds;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setSubTask(Integer subTask) {
        this.subTask = subTask;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setType(int type) {
        this.type = type;
    }
}

package aero.s7.jl.autotest.api.SeatRules;

import java.util.List;

public class TaskToSeatRule {
    private int id;
    private String taskId;
    private String code;
    private int crewPosId;
    private List<Integer> qualificationIds;
    private int seatRuleId;
    private List<Integer> crewCategoryIds;
    private int subTask;
    private int type;
    private int role;
    private boolean isAdditional;
    private int authorId;
    private String authorFullName;
    private String createDate;
    private String modifyAuthorFullName;
    private int modifyAuthorId;
    private String modifyDate;

    public TaskToSeatRule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCrewPosId() {
        return crewPosId;
    }

    public void setCrewPosId(int crewPosId) {
        this.crewPosId = crewPosId;
    }

    public List<Integer> getQualificationIds() {
        return qualificationIds;
    }

    public void setQualificationIds(List<Integer> qualificationIds) {
        this.qualificationIds = qualificationIds;
    }

    public int getSeatRuleId() {
        return seatRuleId;
    }

    public void setSeatRuleId(int seatRuleId) {
        this.seatRuleId = seatRuleId;
    }

    public List<Integer> getCrewCategoryIds() {
        return crewCategoryIds;
    }

    public void setCrewCategoryIds(List<Integer> crewCategoryIds) {
        this.crewCategoryIds = crewCategoryIds;
    }

    public int getSubTask() {
        return subTask;
    }

    public void setSubTask(int subTask) {
        this.subTask = subTask;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean getIsAdditional() {
        return isAdditional;
    }

    public void setIsAdditional(boolean additional) {
        isAdditional = additional;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
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

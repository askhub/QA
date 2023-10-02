package aero.s7.jl.autotest.api.EcrewTracking;

public class EcrewTrackingFlightTaskPage {
    private Integer copies;
    private Integer docTemplateId;
    private Boolean dynamic;
    private Integer fileId;
    private Integer flightTaskId;
    private Integer flightTaskPageId;
    private Integer sortIndex;
    private Boolean whitePage;

    public EcrewTrackingFlightTaskPage() {
    }

    public Integer getCopies() {
        return copies;
    }
    public Integer getDocTemplateId() {
        return docTemplateId;
    }
    public Boolean getDynamic() {
        return dynamic;
    }
    public Integer getFileId() {
        return fileId;
    }
    public Integer getFlightTaskId() {
        return flightTaskId;
    }
    public Integer getFlightTaskPageId() {
        return flightTaskPageId;
    }
    public Integer getSortIndex() {
        return sortIndex;
    }
    public Boolean getWhitePage() {
        return whitePage;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }
    public void setDocTemplateId(Integer docTemplateId) {
        this.docTemplateId = docTemplateId;
    }
    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    public void setFlightTaskId(Integer flightTaskId) {
        this.flightTaskId = flightTaskId;
    }
    public void setFlightTaskPageId(Integer flightTaskPageId) {
        this.flightTaskPageId = flightTaskPageId;
    }
    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
    public void setWhitePage(Boolean whitePage) {
        this.whitePage = whitePage;
    }
}

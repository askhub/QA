package aero.s7.jl.autotest.api.FlightTaskDataBuilder;
import org.junit.Assert;

public class EcrewTrackingFlightTaskDtos {
    private final int flightTaskId;
    private final int docTemplateId;
    private boolean dynamic;
    private int copies;
    private Integer fileId;
    private Boolean whitePage;
    private Integer sortIndex;

    public EcrewTrackingFlightTaskDtos(int flightTaskId, int docTemplateId, boolean dynamic, int copies) {
        // добавить ассерты, чтобы обеспечить не нулевые значения ( != 0) flightTaskId docTemplateId
        Assert.assertNotEquals(0, flightTaskId);
        Assert.assertNotEquals(0, docTemplateId);
        Assert.assertTrue(String.valueOf(dynamic), true);
        Assert.assertNotEquals(0, copies);

        this.flightTaskId = flightTaskId;
        this.docTemplateId = docTemplateId;
        this.dynamic = dynamic;
        this.copies = copies;

    }

    public int getFlightTaskId() {
        return flightTaskId;
    }
    public int getDocTemplateId() {
        return docTemplateId;
    }
    public boolean getDynamic() {
        return dynamic;
    }
    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }
    public Integer getFileId() {
        return fileId;
    }
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    public Boolean getWhitePage() {
        return whitePage;
    }
    public void setWhitePage(Boolean whitePage) {
        this.whitePage = whitePage;
    }
    public Integer getSortIndex() {
        return sortIndex;
    }
    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
}

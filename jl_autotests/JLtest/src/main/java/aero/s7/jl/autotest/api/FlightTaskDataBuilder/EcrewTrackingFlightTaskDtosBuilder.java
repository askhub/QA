package aero.s7.jl.autotest.api.FlightTaskDataBuilder;

public class EcrewTrackingFlightTaskDtosBuilder {
    private final int flightTaskId;
    private final int docTemplateId;
    private final boolean dynamic;
    private final int copies;
    private Integer fileId;
    private Boolean whitePage;
    private Integer sortIndex;

    public EcrewTrackingFlightTaskDtosBuilder(int flightTaskId, int docTemplateId, boolean dynamic, int copies) {
        this.flightTaskId = flightTaskId;
        this.docTemplateId = docTemplateId;
        this.dynamic = dynamic;
        this.copies = copies;
    }

    public EcrewTrackingFlightTaskDtosBuilder setFileId(Integer fileId) {
        this.fileId = fileId;
        return this;
    }
    public EcrewTrackingFlightTaskDtosBuilder setWhitePage(Boolean whitePage) {
        this.whitePage = whitePage;
        return this;
    }
    public EcrewTrackingFlightTaskDtosBuilder setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
        return this;
    }


    public EcrewTrackingFlightTaskDtos build() {
        EcrewTrackingFlightTaskDtos result = new EcrewTrackingFlightTaskDtos(flightTaskId, docTemplateId, dynamic, copies);
        result.setFileId(this.fileId);
        result.setWhitePage(this.whitePage);
        result.setSortIndex(this.sortIndex);
        return result;
    }


}

package aero.s7.jl.autotest.api.FlightTaskDataBuilder;

public class EcrewTrackingFlightTaskJourneyLogDataBuilder {
    private String jlno; // "15-05-23-5863-5863"
    private String pic;
    private String sp;
    private String jlMinima;
    private String jlDatePrint; // "2023-08-03T03:25:58.400459"
    private String signatureBase64;
    private EcrewTrackingFlightTaskJourneyLogTableData journeyLogTableData;
    private EcrewTrackingFlightTaskJourneyLogTableDataSecond journeyLogTableDataSecond;
    private String jlTs;

    public EcrewTrackingFlightTaskJourneyLogDataBuilder() {
    }

    public EcrewTrackingFlightTaskJourneyLogDataBuilder setJlno(String jlno) {
        this.jlno = jlno;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setPic(String pic) {
        this.pic = pic;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setSp(String sp) {
        this.sp = sp;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setJlMinima(String jlMinima) {
        this.jlMinima = jlMinima;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setJlDatePrint(String jlDatePrint) {
        this.jlDatePrint = jlDatePrint;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setSignatureBase64(String signatureBase64) {
        this.signatureBase64 = signatureBase64;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setJourneyLogTableData(EcrewTrackingFlightTaskJourneyLogTableData journeyLogTableData) {
        this.journeyLogTableData = journeyLogTableData;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setJourneyLogTableDataSecond(EcrewTrackingFlightTaskJourneyLogTableDataSecond journeyLogTableDataSecond) {
        this.journeyLogTableDataSecond = journeyLogTableDataSecond;
        return this;
    }
    public EcrewTrackingFlightTaskJourneyLogDataBuilder setJlTs(String jlTs) {
        this.jlTs = jlTs;
        return this;
    }

    public EcrewTrackingFlightTaskJourneyLogData build() {
        EcrewTrackingFlightTaskJourneyLogData result = new EcrewTrackingFlightTaskJourneyLogData();
        result.setJlno(this.jlno);
        result.setPic(this.pic);
        result.setSp(this.sp);
        result.setJlMinima(this.jlMinima);
        result.setJlDatePrint(this.jlDatePrint);
        result.setSignatureBase64(this.signatureBase64);
        result.setJourneyLogTableData(this.journeyLogTableData);
        result.setJourneyLogTableDataSecond(this.journeyLogTableDataSecond);
        return result;
    }
}

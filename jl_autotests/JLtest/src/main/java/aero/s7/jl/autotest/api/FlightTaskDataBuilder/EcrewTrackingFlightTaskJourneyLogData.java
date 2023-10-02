package aero.s7.jl.autotest.api.FlightTaskDataBuilder;

public class EcrewTrackingFlightTaskJourneyLogData {

    private String jlno; // "15-05-23-5863-5863"
    private String pic;
    private String sp;
    private String jlMinima;
    private String jlDatePrint; // "2023-08-03T03:25:58.400459"
    private String signatureBase64;
    private EcrewTrackingFlightTaskJourneyLogTableData journeyLogTableData;
    private EcrewTrackingFlightTaskJourneyLogTableDataSecond journeyLogTableDataSecond;
    private String jlTs;

    public EcrewTrackingFlightTaskJourneyLogData() {
    }

    public String getJlno() {
        return jlno;
    }
    public String getPic() {
        return pic;
    }
    public String getSp() {
        return sp;
    }
    public String getJlMinima() {
        return jlMinima;
    }
    public String getJlDatePrint() {
        return jlDatePrint;
    }
    public String getSignatureBase64() {
        return signatureBase64;
    }
    public EcrewTrackingFlightTaskJourneyLogTableData getJourneyLogTableData() {
        return journeyLogTableData;
    }
    public EcrewTrackingFlightTaskJourneyLogTableDataSecond getJourneyLogTableDataSecond() {
        return journeyLogTableDataSecond;
    }
    public String getJlTs() {
        return jlTs;
    }

    public void setJlno(String jlno) {
        this.jlno = jlno;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public void setSp(String sp) {
        this.sp = sp;
    }
    public void setJlMinima(String jlMinima) {
        this.jlMinima = jlMinima;
    }
    public void setJlDatePrint(String jlDatePrint) {
        this.jlDatePrint = jlDatePrint;
    }
    public void setSignatureBase64(String signatureBase64) {
        this.signatureBase64 = signatureBase64;
    }
    public void setJourneyLogTableData(EcrewTrackingFlightTaskJourneyLogTableData journeyLogTableData) {
        this.journeyLogTableData = journeyLogTableData;
    }
    public void setJourneyLogTableDataSecond(EcrewTrackingFlightTaskJourneyLogTableDataSecond journeyLogTableDataSecond) {
        this.journeyLogTableDataSecond = journeyLogTableDataSecond;
    }
    public void setJlTs(String jlTs) {
        this.jlTs = jlTs;
    }
}

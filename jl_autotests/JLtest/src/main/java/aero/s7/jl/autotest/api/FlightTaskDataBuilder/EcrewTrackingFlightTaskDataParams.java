package aero.s7.jl.autotest.api.FlightTaskDataBuilder;
import org.junit.Assert;


public class EcrewTrackingFlightTaskDataParams {

    private final EcrewTrackingFlightTaskJourneyLogData journeyLogData;

    // добавить по мере масштабирования тестов
    //private EcrewTrackingFlightTaskAttachmentData attachmentData;
    //private EcrewTrackingFlightTaskEntryDepartureData entryDepartureData;
    //private EcrewTrackingFlightTaskGeneralDeclarationArDepData generalDeclarationArDepData;
    //private EcrewTrackingFlightTaskGeneralDeclarationData generalDeclarationData;
    //private EcrewTrackingFlightTaskMedicalCheckData medicalCheckData;
    //private EcrewTrackingFlightTaskSupernumaryData supernumaryData;
    //private EcrewTrackingFlightTaskTamDeclareData tamDeclareData;
    //private EcrewTrackingFlightTaskTripReportData tripReportData;
    //private EcrewTrackingFlightTaskBortmealData bortmealData;
    //private EcrewTrackingFlightTaskFueldeclare fueldeclarationDocument" - уточнить точное наименование после доработки бэка


    public EcrewTrackingFlightTaskDataParams(EcrewTrackingFlightTaskJourneyLogData journeyLogData) {
        Assert.assertNotNull(journeyLogData);
        this.journeyLogData = journeyLogData;
    }

    public EcrewTrackingFlightTaskJourneyLogData getJourneyLogData() {
        return journeyLogData;
    }
}

package aero.s7.jl.autotest.api.FlightTaskDataBuilder;

public class EcrewTrackingFlightTaskDataUpdate {
    private final EcrewTrackingFlightTaskDtos flightTaskDtos;
    private final EcrewTrackingFlightTaskDataParams reportData;

    public EcrewTrackingFlightTaskDataUpdate(final EcrewTrackingFlightTaskDtos flightTaskDtos,
                                             final EcrewTrackingFlightTaskDataParams reportData) {

        this.flightTaskDtos = flightTaskDtos;
        this.reportData = reportData;
    }

    public EcrewTrackingFlightTaskDtos getFlightTaskDtos() {
        return flightTaskDtos;
    }

    public EcrewTrackingFlightTaskDataParams getReportData() {
        return reportData;
    }


}

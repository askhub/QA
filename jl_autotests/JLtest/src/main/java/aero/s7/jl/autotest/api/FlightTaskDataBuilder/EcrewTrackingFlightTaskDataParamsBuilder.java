package aero.s7.jl.autotest.api.FlightTaskDataBuilder;

public class EcrewTrackingFlightTaskDataParamsBuilder {
    private EcrewTrackingFlightTaskJourneyLogData journeyLogData;

    public EcrewTrackingFlightTaskDataParamsBuilder (EcrewTrackingFlightTaskJourneyLogData journeyLogData) {
        this.journeyLogData = journeyLogData;
    }

    public EcrewTrackingFlightTaskDataParamsBuilder setJourneyLogData(EcrewTrackingFlightTaskJourneyLogData journeyLogData) {
        this.journeyLogData = journeyLogData;
        return this;
    }


    public EcrewTrackingFlightTaskDataParams build() {

        return new EcrewTrackingFlightTaskDataParams(journeyLogData);
    }
}

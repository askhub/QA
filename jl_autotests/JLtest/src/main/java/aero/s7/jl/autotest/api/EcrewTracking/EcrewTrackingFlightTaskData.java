package aero.s7.jl.autotest.api.EcrewTracking;

import aero.s7.jl.autotest.api.FlightTaskDataBuilder.EcrewTrackingFlightTaskDataParams;

public class EcrewTrackingFlightTaskData {

	private Integer flightTaskDataId;
	private Integer flightTaskId;
	private EcrewTrackingFlightTaskDataParams params;

    public EcrewTrackingFlightTaskData() {
    }

    public Integer getFlightTaskDataId() {
        return flightTaskDataId;
    }
    public Integer getFlightTaskId() {
        return flightTaskId;
    }
    public EcrewTrackingFlightTaskDataParams getParams() {
        return params;
    }

    public void setFlightTaskDataId(Integer flightTaskDataId) {
        this.flightTaskDataId = flightTaskDataId;
    }
    public void setFlightTaskId(Integer flightTaskId) {
        this.flightTaskId = flightTaskId;
    }
    public void setParams(EcrewTrackingFlightTaskDataParams params) {
        this.params = params;
    }
}

package aero.s7.jl.autotest.api.EcrewTracking;
import aero.s7.jl.autotest.api.FlightTaskDataBuilder.EcrewTrackingFlightTaskDataUpdate;
import aero.s7.jl.autotest.api.Filter.EcrewTrackingSearch;

import java.util.List;

public interface EcrewTrackingService {

    List<EcrewTrackingFlightLegInfo> searchFlightLeg (EcrewTrackingSearch ecrewTrackingSearch);
    Boolean email (long flightLegId, String email);
    Boolean generateFlightTask (long flightLegId);
    Boolean getGeneratedFlightTask (long flightLegId);
    List<EcrewTrackingAllFlightTaskByFlightLeg> getAllFlightTaskByFlightLeg (long flightLegId);
    EcrewTrackingFlightTaskData getFlightTaskData (long flightTaskId);
    boolean updateFlightTask (long flightLegId, EcrewTrackingFlightTaskDataUpdate ecrewTrackingFlightTaskDataUpdate);

}

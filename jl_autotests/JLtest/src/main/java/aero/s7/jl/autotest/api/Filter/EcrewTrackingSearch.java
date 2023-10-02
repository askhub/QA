package aero.s7.jl.autotest.api.Filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EcrewTrackingSearch {
    private final Integer crewMemberType;

    @JsonProperty("flight_number")
    private final Integer flightNumber;

    @JsonProperty("airline_id")
    private final Integer airlineId;

    @JsonProperty("airport_id_arr")
    private final Integer airportIdArr;

    @JsonProperty("airport_id_dep")
    private final Integer airportIdDep;

    private final String startDate;
    private final String endDate;

    EcrewTrackingSearch (EcrewTrackingSearchBuilder ecrewTrackingSearchBuilder) {
        crewMemberType = ecrewTrackingSearchBuilder.crewMemberType;
        flightNumber = ecrewTrackingSearchBuilder.flightNumber;
        airlineId = ecrewTrackingSearchBuilder.airlineId;
        airportIdArr = ecrewTrackingSearchBuilder.airportIdArr;
        airportIdDep = ecrewTrackingSearchBuilder.airportIdDep;
        startDate = ecrewTrackingSearchBuilder.startDate;
        endDate = ecrewTrackingSearchBuilder.endDate;
    }

    public Integer getCrewMemberType() {
        return crewMemberType;
    }
    public Integer getFlightNumber() {
        return flightNumber;
    }
    public Integer getAirlineId() {
        return airlineId;
    }
    public Integer getAirportIdArr() {
        return airportIdArr;
    }
    public Integer getAirportIdDep() {
        return airportIdDep;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
}

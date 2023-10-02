package aero.s7.jl.autotest.api.Filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EcrewTrackingSearchBuilder {

    Integer crewMemberType;
    @JsonProperty("flight_number")
    Integer flightNumber;

    @JsonProperty("airline_id")
    Integer airlineId;

    @JsonProperty("airport_id_arr")
    Integer airportIdArr;

    @JsonProperty("airport_id_dep")
    Integer airportIdDep;

    String startDate;
    String endDate;

    public EcrewTrackingSearchBuilder(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EcrewTrackingSearchBuilder setCrewMemberType(Integer crewMemberType) {
        this.crewMemberType = crewMemberType;
        return this;
    }
    public EcrewTrackingSearchBuilder setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
        return this;
    }
    public EcrewTrackingSearchBuilder setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
        return this;
    }
    public EcrewTrackingSearchBuilder setAirportIdArr(Integer airportIdArr) {
        this.airportIdArr = airportIdArr;
        return this;
    }
    public EcrewTrackingSearchBuilder setAirportIdDep(Integer airportIdDep) {
        this.airportIdDep = airportIdDep;
        return this;
    }

    public EcrewTrackingSearch build() {
        return new EcrewTrackingSearch(this);
    }
}

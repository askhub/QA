package aero.s7.jl.autotest.api.DictionaryAndData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airlines {
    @JsonProperty("airline_id")
    private int airlineId;
    @JsonProperty("country_id")
    private int countryId;

    private String code;
    private String code2;
    private String code3;
    private String name;

    public Airlines() {
    }

    public int getAirlineId() {
        return airlineId;
    }
    public int getCountryId() {
        return countryId;
    }
    public String getCode() {
        return code;
    }
    public String getCode2() {
        return code2;
    }
    public String getCode3() {
        return code3;
    }
    public String getName() {
        return name;
    }
}

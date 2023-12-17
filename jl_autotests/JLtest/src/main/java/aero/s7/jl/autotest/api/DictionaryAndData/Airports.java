package aero.s7.jl.autotest.api.DictionaryAndData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airports {

    @JsonProperty("airport_id")
    private int airportId;

    @JsonProperty("city_id")
    private int cityId;

    @JsonProperty("is_base")
    private boolean isBase;

    @JsonProperty("name_en")
    private String nameEn;

    @JsonProperty("name_ru")
    private String nameRu;

    private boolean base;
    private String iata;
    private String icao;

    public Airports() {
    }

    public int getAirportId() {
        return airportId;
    }
    public int getCityId() {
        return cityId;
    }
    public boolean getIsBase() {
        return isBase;
    }
    public String getIata() {
        return iata;
    }
    public String getIcao() {
        return icao;
    }
    public String getNameEn() {
        return nameEn;
    }
    public String getNameRu() {
        return nameRu;
    }

    public boolean getBase() {
        return base;
    }
}

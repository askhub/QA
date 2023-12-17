package aero.s7.jl.autotest.api.DictionaryAndData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aircrafts {
    @JsonProperty("aircraft_id")
    private  int aircraftId;

    @JsonProperty("name_en")
    private String nameEn;

    @JsonProperty("name_ru")
    private String nameRu;

    private String code;
    private String family;
    private String iata;
    private String icao;

    public Aircrafts() {
    }

    public int getAircraftId() {
        return aircraftId;
    }
    public String getNameEn() {
        return nameEn;
    }
    public String getNameRu() {
        return nameRu;
    }
    public String getCode() {
        return code;
    }
    public String getFamily() {
        return family;
    }
    public String getIata() {
        return iata;
    }
    public String getIcao() {
        return icao;
    }
}

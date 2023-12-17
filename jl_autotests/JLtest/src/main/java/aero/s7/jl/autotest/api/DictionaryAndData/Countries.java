package aero.s7.jl.autotest.api.DictionaryAndData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Countries {

    private String code2;
    private String code3;
    @JsonProperty("country_id")
    private int countryId;

    @JsonProperty("name_en")
    private String nameEn;

    @JsonProperty("name_ru")
    private String nameRu;

    public Countries() {
    }

    public String getCode2() {
        return code2;
    }
    public String getCode3() {
        return code3;
    }
    public int getCountryId() {
        return countryId;
    }
    public String getNameEn() {
        return nameEn;
    }
    public String getNameRu() {
        return nameRu;
    }
}

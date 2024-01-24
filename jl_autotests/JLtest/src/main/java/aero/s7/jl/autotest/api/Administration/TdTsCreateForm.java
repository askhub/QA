package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TdTsCreateForm {
    @JsonProperty("catering_number")
    private final String cateringNumber;

    @JsonProperty("end_date")
    private final String dateEnd;

    @JsonProperty("start_date")
    private final String dateStart;

    @JsonProperty("fuel_number")
    private final String fuelNumber;

    public TdTsCreateForm(TdTsCreateFormBuilder tdTsCreateFormBuilder) {
        cateringNumber = tdTsCreateFormBuilder.cateringNumber;
        dateEnd = tdTsCreateFormBuilder.dateEnd;
        dateStart = tdTsCreateFormBuilder.dateStart;
        fuelNumber = tdTsCreateFormBuilder.fuelNumber;
    }

    public String getCateringNumber() {
        return cateringNumber;
    }
    public String getDateEnd() {
        return dateEnd;
    }
    public String getDateStart() {
        return dateStart;
    }
    public String getFuelNumber() {
        return fuelNumber;
    }
}

package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TdTsCreateForm {
    @JsonProperty("catering_number")
    private final String cateringDeclNumber;

    @JsonProperty("end_date")
    private final String dateEnd;

    @JsonProperty("start_date")
    private final String dateStart;

    @JsonProperty("fuel_number")
    private final String fuelDeclNumber;

    public TdTsCreateForm(TdTsCreateFormBuilder tdTsCreateFormBuilder) {
        cateringDeclNumber = tdTsCreateFormBuilder.cateringDeclNumber;
        dateEnd = tdTsCreateFormBuilder.dateEnd;
        dateStart = tdTsCreateFormBuilder.dateStart;
        fuelDeclNumber = tdTsCreateFormBuilder.fuelDeclNumber;
    }

    public String getCateringDeclNumber() {
        return cateringDeclNumber;
    }
    public String getDateEnd() {
        return dateEnd;
    }
    public String getDateStart() {
        return dateStart;
    }
    public String getFuelDeclNumber() {
        return fuelDeclNumber;
    }
}

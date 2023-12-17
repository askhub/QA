package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TdTsUpdateForm {
    @JsonProperty("catering_number")
    private final String cateringDeclNumber;

    @JsonProperty("end_date")
    private final String dateEnd;

    @JsonProperty("start_date")
    private final String dateStart;

    @JsonProperty("fuel_number")
    private final String fuelDeclNumber;

    @JsonProperty("is_active")
    private final boolean isActive;

    TdTsUpdateForm(TdTsUpdateFormBuilder tdTsUpdateFormBuilder) {
        cateringDeclNumber = tdTsUpdateFormBuilder.cateringDeclNumber;
        dateEnd = tdTsUpdateFormBuilder.dateEnd;
        dateStart = tdTsUpdateFormBuilder.dateStart;
        fuelDeclNumber = tdTsUpdateFormBuilder.fuelDeclNumber;
        isActive = tdTsUpdateFormBuilder.isActive;
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

    public boolean isActive() {
        return isActive;
    }
}

package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TdTsUpdateForm {
    @JsonProperty("catering_number")
    private final String cateringNumber;

    @JsonProperty("end_date")
    private final String dateEnd;

    @JsonProperty("start_date")
    private final String dateStart;

    @JsonProperty("fuel_number")
    private final String fuelNumber;

    @JsonProperty("is_active")
    private final boolean isActive;

    TdTsUpdateForm(TdTsUpdateFormBuilder tdTsUpdateFormBuilder) {
        cateringNumber = tdTsUpdateFormBuilder.cateringNumber;
        dateEnd = tdTsUpdateFormBuilder.dateEnd;
        dateStart = tdTsUpdateFormBuilder.dateStart;
        fuelNumber = tdTsUpdateFormBuilder.fuelNumber;
        isActive = tdTsUpdateFormBuilder.isActive;
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

    public boolean getIsActive() {
        return isActive;
    }
}

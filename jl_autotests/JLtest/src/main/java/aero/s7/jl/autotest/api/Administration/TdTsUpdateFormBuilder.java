package aero.s7.jl.autotest.api.Administration;

public class TdTsUpdateFormBuilder {
    String cateringNumber;
    String dateEnd;
    String dateStart;
    String fuelNumber;
    boolean isActive;

    public TdTsUpdateFormBuilder () {
    }

    public TdTsUpdateFormBuilder setCateringNumber(String cateringNumber) {
        this.cateringNumber = cateringNumber;
        return this;
    }

    public TdTsUpdateFormBuilder setIsActive (boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public TdTsUpdateFormBuilder setDateStart (String dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public TdTsUpdateFormBuilder setDateEnd (String dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public TdTsUpdateFormBuilder setFuelNumber(String fuelNumber) {
        this.fuelNumber = fuelNumber;
        return this;
    }

    public TdTsUpdateForm build () {
        return new TdTsUpdateForm(this);
    }
}

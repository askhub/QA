package aero.s7.jl.autotest.api.Administration;

public class TdTsUpdateFormBuilder {
    String cateringDeclNumber;
    String dateEnd;
    String dateStart;
    String fuelDeclNumber;
    boolean isActive;

    public TdTsUpdateFormBuilder () {
    }

    public TdTsUpdateFormBuilder setCateringDeclNumber (String cateringDeclNumber) {
        this.cateringDeclNumber = cateringDeclNumber;
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

    public TdTsUpdateFormBuilder setFuelDeclNumber (String fuelDeclNumber) {
        this.fuelDeclNumber = fuelDeclNumber;
        return this;
    }

    public TdTsUpdateForm build () {
        return new TdTsUpdateForm(this);
    }
}

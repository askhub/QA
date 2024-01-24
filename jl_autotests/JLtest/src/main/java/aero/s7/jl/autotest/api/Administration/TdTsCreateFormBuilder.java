package aero.s7.jl.autotest.api.Administration;

public class TdTsCreateFormBuilder {

    String cateringNumber;
    String dateEnd;
    String dateStart;
    String fuelNumber;

    public TdTsCreateFormBuilder (String dateStart, String dateEnd, String fuelNumber) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.fuelNumber = fuelNumber;
    }

    public TdTsCreateFormBuilder setCateringNumber (String cateringNumber) {
        this.cateringNumber = cateringNumber;
        return this;
    }

    public TdTsCreateForm build () {
        return new TdTsCreateForm(this);  }
}

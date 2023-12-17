package aero.s7.jl.autotest.api.Administration;

public class TdTsCreateFormBuilder {

    String cateringDeclNumber;
    String dateEnd;
    String dateStart;
    String fuelDeclNumber;

    public TdTsCreateFormBuilder (String dateStart, String dateEnd, String fuelDeclNumber) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.fuelDeclNumber = fuelDeclNumber;
    }

    public TdTsCreateFormBuilder setCateringDeclNumber (String cateringDeclNumber) {
        this.cateringDeclNumber = cateringDeclNumber;
        return this;
    }

    public TdTsCreateForm build () {
        return new TdTsCreateForm(this);  }
}

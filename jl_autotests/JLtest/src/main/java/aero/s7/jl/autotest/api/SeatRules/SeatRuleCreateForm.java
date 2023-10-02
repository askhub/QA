package aero.s7.jl.autotest.api.SeatRules;

public class SeatRuleCreateForm extends SeatRuleBaseForm {



    public static SeatRuleCreateForm newSeatRule () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(1094);
        result.setActypeId(201);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setCapCY(null);
        result.setValidityStart("2023-04-01T00:00:00.001Z");
        result.setValidityEnd("2023-08-31T23:59:59.999Z");

        return result;
    }

    public static SeatRuleCreateForm newSeatRuleWithTask () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(1094);
        result.setActypeId(197);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setCapCY(null);
        result.setValidityStart("2023-03-01T00:00:00.001Z");
        result.setValidityEnd("2023-10-31T23:59:59.999Z");

        return result;
    }

    public static SeatRuleCreateForm newSeatRuleWithEmptyField () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(null);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setCapCY(null);
        result.setValidityStart(null);
        result.setValidityEnd(null);

        return result;
    }

    public static SeatRuleCreateForm newSeatRuleRequiredFields () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(1094);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setValidityStart("2023-03-01T00:00:00.001Z");
        result.setValidityEnd("2023-10-31T23:59:59.999Z");

        return result;
    }

    public static SeatRuleCreateForm newSeatRuleWithTaskNegative () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(1094);
        result.setActypeId(197);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setCapCY(null);
        result.setValidityStart("2023-03-01T00:00:00.001Z");
        result.setValidityEnd("2023-10-31T23:59:59.999Z");

        return result;
    }

    public static SeatRuleCreateForm newSeatRuleWithTaskForDelete () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(1094);
        result.setActypeId(203);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setCapCY(null);
        result.setValidityStart("2023-03-01T00:00:00.001Z");
        result.setValidityEnd("2023-10-31T23:59:59.999Z");

        return result;
    }

    public static SeatRuleCreateForm newSeatRuleWrongDate () {

        SeatRuleCreateForm result = new SeatRuleCreateForm();
        result.setCarrierId(1094);
        result.setActypeId(201);
        result.setCrewMemberType(1);
        result.setIsActive(true);
        result.setIsTemplate(false);
        result.setCapCY(null);
        result.setValidityStart("2023-04-01T00:00:00.001Z");
        result.setValidityEnd("2023-05-31T23:59:59.999Z");

        return result;
    }
}

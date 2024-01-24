package aero.s7.jl.autotest.api.Documents;

public class DocRuleCreateForm extends DocumentsPackingBaseForm {
    public static DocRuleCreateForm newDocRule () {
        DocRuleCreateForm docRule = new DocRuleCreateForm();

        docRule.setRule("INCLUDE");
        docRule.setCrewRouteCategoryId(1);
        docRule.setFlightType("VVL");
        docRule.setCountryDepId(86);
        docRule.setCountryArrId(86);
        docRule.setDepAirports("DME");
        docRule.setArrAirports("LED");
        docRule.setFlightNumbers("5226");
        docRule.setAircraftId(207);
        docRule.setCapCY("78/78");
        docRule.setBoard(5);
        docRule.setCrewType("FD");
        docRule.setAirlineId(1094);
        docRule.setCopies(1);
        docRule.setDateStart("2023-08-01T00:00:00.001");
        docRule.setDateEnd("2023-11-30T23:59:59.999");
        docRule.setIsTechnicalStop(false);
        docRule.setIsActive(true);

        return docRule;
    }

    public static DocRuleCreateForm newDocRuleForFilterTest () {
        DocRuleCreateForm docRule = new DocRuleCreateForm();

        docRule.setRule("INCLUDE");
        docRule.setCrewRouteCategoryId(3);
        docRule.setFlightType("MVL");
        docRule.setCountryDepId(86);
        docRule.setCountryArrId(38);
        docRule.setDepAirports("DME");
        docRule.setArrAirports("AYT");
        docRule.setFlightNumbers("5863");
        docRule.setAircraftId(207);
        docRule.setCapCY(null);
        docRule.setBoard(3);
        docRule.setCrewType("FD");
        docRule.setAirlineId(1094);
        docRule.setCopies(1);
        docRule.setDateStart("2023-08-01T00:00:00.001");
        docRule.setDateEnd("2023-12-31T23:59:59.999");
        docRule.setIsTechnicalStop(false);
        docRule.setIsActive(true);

        return docRule;
    }

    public static DocRuleCreateForm newDocRuleWithRequiredFieldsOnly () {
        DocRuleCreateForm docRule = new DocRuleCreateForm();

        docRule.setRule("INCLUDE");
        docRule.setCrewRouteCategoryId(2);
        docRule.setFlightType("VVL");
        docRule.setCrewType("FD");
        docRule.setAirlineId(1094);
        docRule.setCopies(2);
        docRule.setIsActive(true);

        return docRule;
    }

    public static DocRuleCreateForm emptyDocRuleTemplate () {
        DocRuleCreateForm docRule = new DocRuleCreateForm();
        return docRule;
    }
}

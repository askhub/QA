package aero.s7.jl.autotest.api.DocumentsPacking;

public class DocRuleUpdateForm extends DocRule{
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static DocRuleUpdateForm updateDocRule (int id) {
        DocRuleUpdateForm ruleForm = new DocRuleUpdateForm();

        ruleForm.setId(id);
        ruleForm.setRule("EXCLUDE");
        ruleForm.setCrewRouteCategoryId(2);
        ruleForm.setFlightType("MVL");
        ruleForm.setCountryDepId(38);
        ruleForm.setCountryArrId(38);
        ruleForm.setDepAirports("IST");
        ruleForm.setArrAirports("AYT");
        ruleForm.setFlightNumbers("5863");
        ruleForm.setAircraftId(342);
        ruleForm.setBoard(6);
        ruleForm.setAirlineId(890);
        ruleForm.setCopies(2);
        ruleForm.setDateStart("2023-09-01T00:00:01.001");
        ruleForm.setDateEnd("2023-11-30T00:00:01.001");
        ruleForm.setTechnicalStop(true);

        return ruleForm;
    }
}

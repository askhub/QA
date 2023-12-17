package aero.s7.jl.autotest.api.Documents;

public class DocTemplateUpdateForm extends DocumentsPackingBaseForm {
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public static DocTemplateUpdateForm updateDocument (int id) {

        DocTemplateUpdateForm form = new DocTemplateUpdateForm();
        form.setId(id);
        form.setName("обновленный документ");
        form.setDescription("описание документа после обновления");
        form.setWhitePage(true);
        form.setReplaceWhitePage(false);
        form.setValidityPeriodStart("2023-10-12T05:01:55.135Z");

        return form;
    }

    public static DocTemplateUpdateForm updateDocumentForSearch (int id) {

        DocTemplateUpdateForm form = new DocTemplateUpdateForm();
        form.setId(id);
        form.setName("update doc");
        form.setDescription("документа после обновления");
        form.setWhitePage(true);
        form.setReplaceWhitePage(false);
        form.setValidityPeriodStart("2023-10-10T05:01:55.135Z");

        return form;
    }

/*    public static DocTemplateUpdateForm updateDocRule (int id) {
        DocTemplateUpdateForm ruleForm = new DocTemplateUpdateForm();

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
    }*/
}

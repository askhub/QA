package aero.s7.jl.autotest.api.Documents;

import java.util.ArrayList;
import java.util.List;

public class DocTemplateWithRulesCreateForm extends DocumentsPackingBaseForm {

    private DocTemplateCreateForm docTemplateCreateForm;
    private List<DocRuleCreateForm> docRuleCreateForms;

    public DocTemplateWithRulesCreateForm(DocTemplateCreateForm docTemplateCreateForm, List<DocRuleCreateForm> docRuleCreateForms) {
        this.docTemplateCreateForm = docTemplateCreateForm;
        this.docRuleCreateForms = docRuleCreateForms;
    }


    public static DocTemplateWithRulesCreateForm newDocWithRule () {
        List<DocRuleCreateForm> docRuleCreateForms = new ArrayList<>();
        docRuleCreateForms.add(DocRuleCreateForm.newDocRule());

        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocWithRule(), docRuleCreateForms);
    }

    public static DocTemplateWithRulesCreateForm newDocForFilterTest () {
        List<DocRuleCreateForm> docRuleCreateForm1 = new ArrayList<>();
        docRuleCreateForm1.add(DocRuleCreateForm.newDocRuleForFilterTest());

        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocFilter(), docRuleCreateForm1);
    }

    public static DocTemplateWithRulesCreateForm newDocForNegativeFilterTest () {
        List<DocRuleCreateForm> docRuleCreateForm1 = new ArrayList<>();
        docRuleCreateForm1.add(DocRuleCreateForm.newDocRuleForFilterTest());

        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocForNegativeFilterTest(), docRuleCreateForm1);
    }

    public static DocTemplateWithRulesCreateForm newDocWithRequiredFieldsOnly () {
        List<DocRuleCreateForm> docRuleCreateForms = new ArrayList<>();
        docRuleCreateForms.add(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly());

        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocWithRequiredFieldsOnly(), docRuleCreateForms);
    }

    public static DocTemplateWithRulesCreateForm emptyDocumentForm() {
        List<DocRuleCreateForm> docRuleCreateForms2 = new ArrayList<>();
        docRuleCreateForms2.add(DocRuleCreateForm.emptyDocRuleTemplate());
        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocWithEmptyForm(), docRuleCreateForms2);
    }

    public static DocTemplateWithRulesCreateForm emptyDocTemplate () {
        List<DocRuleCreateForm> docRuleCreateForms3 = new ArrayList<>();
        docRuleCreateForms3.add(DocRuleCreateForm.newDocRule());
        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocWithEmptyForm(), docRuleCreateForms3);
    }

    public static DocTemplateWithRulesCreateForm emptyDocRule () {
        List<DocRuleCreateForm> docRuleCreateForms4 = new ArrayList<>();
        docRuleCreateForms4.add(DocRuleCreateForm.emptyDocRuleTemplate());
        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocWithRule(), docRuleCreateForms4);
    }

    public static DocTemplateWithRulesCreateForm docForSettingsTest (int docCategoryId) {
        List<DocRuleCreateForm> docRuleCreateForms = new ArrayList<>();
        docRuleCreateForms.add(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly());
        return new DocTemplateWithRulesCreateForm(DocTemplateCreateForm.newDocForSettingsTest(docCategoryId),
                docRuleCreateForms);
    }

    public DocTemplateCreateForm getDocTemplateCreateForm() {
        return docTemplateCreateForm;
    }

    public void setDocTemplateCreateForm(DocTemplateCreateForm docTemplateCreateForm) {
        this.docTemplateCreateForm = docTemplateCreateForm;
    }

    public List<DocRuleCreateForm> getDocRuleCreateForms () {
        return docRuleCreateForms;
    }
    public void setDocRuleCreateForms (List<DocRuleCreateForm> docRuleCreateForms) {
        this.docRuleCreateForms = docRuleCreateForms;
    }
}

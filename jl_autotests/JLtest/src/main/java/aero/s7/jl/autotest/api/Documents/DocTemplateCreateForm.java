package aero.s7.jl.autotest.api.Documents;

import java.util.Collections;

public class DocTemplateCreateForm extends DocumentsPackingBaseForm {

    public static DocTemplateCreateForm newDocFilter () {
        DocTemplateCreateForm doc = new DocTemplateCreateForm();

        doc.setDescription("api filter test documents packing chapter");
        doc.setDocCategoryId(10);
        doc.setDocType("STATIC");
        doc.setName("filter test");
        doc.setDocFile("A+a=");
        doc.setIsActive(true);
        doc.setDocOwnerIds(Collections.singletonList(6));
        doc.setValidityPeriodStart("2023-07-01T00:00:01.001Z");
        doc.setValidityPeriodEnd("2023-10-31T23:59:59.999Z");
        doc.setIsWhitePage(false);
        doc.setIsReplaceWhitePage(false);

        return doc;
    }

    public static DocTemplateCreateForm newDocForNegativeFilterTest () {
        DocTemplateCreateForm doc = new DocTemplateCreateForm();

        doc.setDescription("api filter negative test");
        doc.setDocCategoryId(11);
        doc.setDocType("STATIC");
        doc.setName("negative filter test");
        doc.setDocFile("A+a=");
        doc.setIsActive(true);
        doc.setDocOwnerIds(Collections.singletonList(5));
        doc.setValidityPeriodStart("2023-07-01T00:00:01.001Z");
        doc.setValidityPeriodEnd("2023-08-31T23:59:59.999Z");
        doc.setIsWhitePage(false);
        doc.setIsReplaceWhitePage(false);

        return doc;
    }

    public static DocTemplateCreateForm newDocWithRule () {
        DocTemplateCreateForm doc = new DocTemplateCreateForm();

        doc.setDocOwnerIds(Collections.singletonList(2));
        doc.setDocType("STATIC");
        doc.setName("api test doc 3");
        doc.setDocCategoryId(11);
        doc.setDocFile("A+a=");
        doc.setDescription("api test document 3 with rule");
        doc.setValidityPeriodStart("2023-07-01T00:00:01.001Z");
        doc.setValidityPeriodEnd("2023-12-31T23:59:59.999Z");
        doc.setIsWhitePage(false);
        doc.setIsReplaceWhitePage(false);
        doc.setIsActive(true);
        doc.setPrevDocId(null);

        return doc;
    }

    public static DocTemplateCreateForm newDocWithRequiredFieldsOnly () {
        DocTemplateCreateForm doc = new DocTemplateCreateForm();

        doc.setDocOwnerIds(Collections.singletonList(3));
        doc.setDocType("STATIC");
        doc.setName("api test doc 4");
        doc.setDocCategoryId(10);
        doc.setDocFile("Jh+gqdZH9Wvw77V5npj363+tfLu+W5ndGggNDkvTiAxL1R5cGUvT2KJSVFT0YNCg");
        doc.setValidityPeriodStart("2023-07-01T00:00:01.001Z");
        doc.setIsWhitePage(false);
        doc.setIsReplaceWhitePage(false);
        doc.setIsActive(true);
        doc.setPrevDocId(null);

        return doc;
    }

    public static DocTemplateCreateForm newDocWithEmptyForm () {
        DocTemplateCreateForm doc = new DocTemplateCreateForm();

        return doc;
    }

    public static DocTemplateCreateForm newDocForSettingsTest (int docCategoryId) {
        DocTemplateCreateForm doc = new DocTemplateCreateForm();

        doc.setDocOwnerIds(Collections.singletonList(3));
        doc.setDocType("STATIC");
        doc.setName("api settings test doc 4");
        doc.setDocCategoryId(docCategoryId);
        doc.setDocFile("A+a=");
        doc.setValidityPeriodStart("2023-09-01T00:00:01.001Z");
        doc.setIsWhitePage(false);
        doc.setIsReplaceWhitePage(false);
        doc.setIsActive(true);
        doc.setPrevDocId(null);

        return doc;
    }

}

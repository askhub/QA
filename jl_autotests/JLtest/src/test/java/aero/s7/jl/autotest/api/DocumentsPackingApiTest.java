package aero.s7.jl.autotest.api;

import aero.s7.jl.autotest.api.DocumentsPacking.*;
import aero.s7.jl.autotest.api.Filter.DocumentsPackingSearchBuilder;
import aero.s7.jl.autotest.api.Filter.DocumentsPackingSearch;
import aero.s7.jl.autotest.common.TestBase;
import aero.s7.jl.autotest.common.Constant;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class DocumentsPackingApiTest extends TestBase {
    DocumentsPackingService documentsPackingService = new DocumentsPackingServiceImpl();

    @Test
    public void testGetDocumentById () {
        DocumentsPacking docPacking = documentsPackingService.getDocument(Constant.Api.DOCUMENT_ID);
        Assert.assertEquals(Constant.Api.DOCUMENT_ID, docPacking.getId());
    }

    @Test
    public void testCreateEmptyDocument () {
        int statusCode = documentsPackingService.createEmptyDocument(DocTemplateWithRulesCreateForm.emptyDocumentForm());

        Assert.assertEquals(400, statusCode);
    }

    @Test
    public void testCreateEmptyDocTemplateWithRule () {
        int statusCode = documentsPackingService.createEmptyDocument(DocTemplateWithRulesCreateForm.emptyDocTemplate());
        Assert.assertEquals(400, statusCode);
    }

    @Test
    public void testCreateDocTemplateWithEmptyRule () {
        int statusCode = documentsPackingService.createEmptyDocument(DocTemplateWithRulesCreateForm.emptyDocRule());
        Assert.assertEquals(400, statusCode);
    }

    @Test
    public void testCreateDocumentWithRule () {
        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocWithRule());
        Assert.assertNotNull(documentsPacking);
        Assert.assertNotNull(documentsPacking.getDocRulesIds());
        Assert.assertTrue(documentsPacking.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(documentsPacking.getDocRulesIds().get(0));

        Assert.assertNotNull(rule);

        Assert.assertEquals(Optional.ofNullable(DocTemplateCreateForm.newDocWithRule().getName()),
                Optional.of(documentsPacking.getName()));
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getDocOwnerIds(),
                documentsPacking.getDocOwnerIds());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getDocType(),
                documentsPacking.getDocType());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getDocCategoryId(),
                documentsPacking.getDocCategoryId());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getDescription(),
                documentsPacking.getDescription());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getDocOwnerIds(),
                documentsPacking.getDocOwnerIds());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getValidityPeriodStart(),
                documentsPacking.getValidityPeriodStart());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getValidityPeriodEnd(),
                documentsPacking.getValidityPeriodEnd());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getWhitePage(),
                documentsPacking.getWhitePage());
        Assert.assertEquals(DocTemplateCreateForm.newDocWithRule().getIsActive(),
                documentsPacking.getIsActive());

        Assert.assertEquals(DocRuleCreateForm.newDocRule().getRule(), rule.getRule());
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRule().getCrewRouteCategoryId()), Optional.of(rule.getCrewRouteCategoryId()));
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getFlightType(), rule.getFlightType());
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRule().getCountryDepId()), Optional.of(rule.getCountryDepId()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRule().getCountryArrId()), Optional.of(rule.getCountryArrId()));
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getDepAirports(), rule.getDepAirports());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getArrAirports(), rule.getArrAirports());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getFlightNumbers(), rule.getFlightNumbers());
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRule().getAircraftId()), Optional.of(rule.getAircraftId()));
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getCapCY(), rule.getCapCY());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getBoard(), rule.getBoard());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getCrewType(), rule.getCrewType());
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRule().getAirlineId()), Optional.of(rule.getAirlineId()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRule().getCopies()), Optional.of(rule.getCopies()));
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getDateStart(), rule.getDateStart());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getDateEnd(), rule.getDateEnd());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getTechnicalStop(), rule.getTechnicalStop());
        Assert.assertEquals(DocRuleCreateForm.newDocRule().getIsActive(), rule.getIsActive());
    }

    @Test
    public void testCreateDocumentWithRequiredFields () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocWithRequiredFieldsOnly());
        Assert.assertNotNull(document);
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        Assert.assertEquals(Optional.ofNullable(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getName()),
                Optional.of(document.getName()));
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getDocType()),
                Optional.of(document.getDocType()));
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getDocOwnerIds()),
                Optional.of(document.getDocOwnerIds()));
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getDocCategoryId()),
                Optional.of(document.getDocCategoryId()));
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getValidityPeriodStart()),
                Optional.of(document.getValidityPeriodStart()));
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getDocType()),
                Optional.of(document.getDocType()));
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRequiredFieldsOnly().getWhitePage()),
                Optional.of(document.getWhitePage()));

        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly().getRule()),
                Optional.of(rule.getRule()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly().getCrewRouteCategoryId()),
                Optional.of(rule.getCrewRouteCategoryId()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly().getFlightType()),
                Optional.of(rule.getFlightType()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly().getCrewType()),
                Optional.of(rule.getCrewType()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly().getAirlineId()),
                Optional.of(rule.getAirlineId()));
        Assert.assertEquals(Optional.of(DocRuleCreateForm.newDocRuleWithRequiredFieldsOnly().getCopies()),
                Optional.of(rule.getCopies()));

        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testUpdateDocTemplate () {
        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocWithRule());
        DocumentsPacking documentUpdate = documentsPackingService.updateDocument(DocTemplateUpdateForm.updateDocument(documentsPacking.getId()));

        Assert.assertEquals(DocTemplateUpdateForm.updateDocument(documentsPacking.getId()).getName(), documentUpdate.getName());
        Assert.assertEquals(DocTemplateUpdateForm.updateDocument(documentsPacking.getId()).getWhitePage(), documentUpdate.getWhitePage());
        Assert.assertEquals(DocTemplateUpdateForm.updateDocument(documentsPacking.getId()).getValidityPeriodStart(), documentUpdate.getValidityPeriodStart());

    }

    @Test
    public void testUpdateDocRule () {
        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocWithRule());
        Assert.assertNotNull(documentsPacking);
        Assert.assertNotNull(documentsPacking.getDocRulesIds());
        Assert.assertTrue(documentsPacking.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(documentsPacking.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocRule docRuleUpdate = documentsPackingService.updateDocRule(DocRuleUpdateForm.updateDocRule(rule.getId()));

        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getRule(), docRuleUpdate.getRule());
        Assert.assertEquals(Optional.of(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getCrewRouteCategoryId()),
                Optional.of(docRuleUpdate.getCrewRouteCategoryId()));
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getFlightType(), docRuleUpdate.getFlightType());
        Assert.assertEquals(Optional.of(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getCountryDepId()),
                Optional.of(docRuleUpdate.getCountryDepId()));
        Assert.assertEquals(Optional.of(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getCountryArrId()),
                Optional.of(docRuleUpdate.getCountryArrId()));
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getDepAirports(), docRuleUpdate.getDepAirports());
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getArrAirports(), docRuleUpdate.getArrAirports());
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getFlightNumbers(), docRuleUpdate.getFlightNumbers());
        Assert.assertEquals(Optional.of(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getAircraftId()),
                Optional.of(docRuleUpdate.getAircraftId()));
        Assert.assertEquals(Optional.of(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getAirlineId()),
                Optional.of(docRuleUpdate.getAirlineId()));
        Assert.assertEquals(Optional.of(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getCopies()),
                Optional.of(docRuleUpdate.getCopies()));
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getDateStart(), docRuleUpdate.getDateStart());
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getDateEnd(), docRuleUpdate.getDateEnd());
        Assert.assertEquals(DocRuleUpdateForm.updateDocRule(documentsPacking.getDocRulesIds().get(0)).getTechnicalStop(), docRuleUpdate.getTechnicalStop());
    }

    @Test
    public void testDeleteDocument () {
        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocWithRule());
        Assert.assertNotNull(documentsPacking);
        Assert.assertTrue(documentsPackingService.deleteDocument(documentsPacking.getId()));
    }

    @Test
    public void testSearchDocumentsByCategory () {
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setDocCategoryId(1).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);

        docList.forEach(x -> Assert.assertEquals(Optional.ofNullable(searchRequest.getDocCategoryId()), Optional.of(x.getDocCategoryId())));
    }

    @Test
    public void testSearchDocumentsByName () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setName(document.getName()).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        docList.forEach(x -> Assert.assertEquals(searchRequest.getName(), x.getName()));
        System.out.println("delete doc");
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByType () {
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setDocType("DYNAMIC").build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);

        docList.forEach(x -> Assert.assertEquals(searchRequest.getDocType(), x.getDocType()));
    }

    @Test
    public void testSearchDocumentsByOwner () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setDocOwnerIds(document.getDocOwnerIds()).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        docList.forEach(x -> Assert.assertEquals(searchRequest.getDocOwnerIds(), x.getDocOwnerIds()));
/*
        docList.forEach(x -> Assert.assertTrue(checkArray(searchRequest.getDocOwnerIds(), x.getDocOwnerIds())));
        [6] - [6]
        [6] - [6]
        [6, 7] - [1, 2, 6, 7]*/
        // булева-функция для определения значений массива. На входе массив из запроса, + массив ответа. в функции проверяю по элементно значения массива, которые содержатся в ответе
        // если нахожу, то ретерн тру если нашли хоть одно совпадение
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
        //доработать, если находит документ с массивом Owner то бракует такой документ. Надо проверять, что содержится в том числе
    }

    @Test
    public void testSearchDocumentsByAuthor () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setAuthor(document.getAuthorName()).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        docList.forEach(x -> Assert.assertEquals(searchRequest.getAuthor(), x.getAuthorName()));

        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByModifier () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());

        DocumentsPacking documentUpdate = documentsPackingService.updateDocument(DocTemplateUpdateForm.updateDocument(document.getId()));

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setModifier(documentUpdate.getModifyAuthorFullName()).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        docList.forEach(x -> Assert.assertEquals(searchRequest.getModifier(), x.getModifyAuthorFullName()));

        Assert.assertTrue(documentsPackingService.deleteDocument(documentUpdate.getId()));
    }

    @Test
    public void testSearchDocumentsByInactive () {
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(false).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        docList.forEach(x -> Assert.assertEquals(searchRequest.getIsActive(), x.getIsActive()));
    }
}

/*
        @Test
        public void testSearchDocument () {
            DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
            Assert.assertNotNull(documentsPacking);
            Assert.assertNotNull(documentsPacking.getDocRulesIds());
            Assert.assertTrue(documentsPacking.getDocRulesIds().size() > 0);
            DocumentsPacking getNewDocument = documentsPackingService.getDocument(documentsPacking.getId());

            List<DocTemplateData> docList = documentsPackingService.searchDocument();
            Assert.assertNotNull(docList);
            Assert.assertTrue(docList.size() > 0);
            docList.forEach(x -> Assert.assertEquals(getNewDocument.getName(), x.getName()));
            docList.forEach(x -> Assert.assertEquals(getNewDocument.getAuthorName(), x.getAuthorName()));

            for (int i = 0; i < docList.size(); i++) {
                Assert.assertTrue(documentsPackingService.deleteDocument(docList.get(i).getId()));
            }
        }
    */

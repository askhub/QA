// Автотесты API раздела Documents. Korotchenko AS. 2023
package aero.s7.jl.autotest.api;

import aero.s7.jl.autotest.api.DictionaryAndData.*;
import aero.s7.jl.autotest.api.Documents.*;
import aero.s7.jl.autotest.api.Filter.DocumentsPackingSearchBuilder;
import aero.s7.jl.autotest.api.Filter.DocumentsPackingSearch;
import aero.s7.jl.autotest.common.TestBase;
import aero.s7.jl.autotest.common.Constant;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DocumentsApiTest extends TestBase {
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
        Assert.assertEquals(Optional.of(DocTemplateCreateForm.newDocWithRule().getDocCategoryId()),
                Optional.of(documentsPacking.getDocCategoryId()));
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
    public void testSearchDocumentsByPeriodOfCreationFrom () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());

        System.out.println(document.getCreateDate());
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setCreateDateStart(document.getCreateDate())   //.setCreateDateStart("2023-10-04T00:00:00.000Z")
                .build();

        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        LocalDate expectedDate = LocalDate.parse(searchRequest.getCreateDateStart(), formatter);

        for (DocTemplateData docTemplateData : docList) {
            LocalDate actualDate = LocalDate.parse(docTemplateData.getCreateDate(), formatter);
            Assert.assertTrue((actualDate.isEqual(expectedDate)) || (actualDate.isAfter(expectedDate)));
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByPeriodOfCreationTo () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());

        System.out.println(document.getCreateDate());
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setCreateDateEnd(document.getCreateDate())   //.setCreateDateStart("2023-10-04T00:00:00.000000Z")
                .build();

        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        LocalDate expectedDate = LocalDate.parse(searchRequest.getCreateDateEnd(), formatter);

        for (DocTemplateData docTemplateData : docList) {
            LocalDate actualDate = LocalDate.parse(docTemplateData.getCreateDate(), formatter);
            Assert.assertTrue((actualDate.isBefore(expectedDate)) || (actualDate.isEqual(expectedDate)));
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
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
    public void testSearchDocumentsByPeriodOfValidityFrom () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setValidityPeriodStart(document.getValidityPeriodStart())   //.setCreateDateStart("2023-10-04T00:00:00.000Z")
                .build();

        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String expectedString = searchRequest.getValidityPeriodStart().substring(0,19);
        LocalDate expectedDate = LocalDate.parse(expectedString, formatter);

        for (DocTemplateData docTemplateData : docList) {
            String actualString = docTemplateData.getValidityPeriodStart().substring(0,19);
            LocalDate actualDate = LocalDate.parse(actualString, formatter);
            Assert.assertTrue((actualDate.isEqual(expectedDate)) || (actualDate.isAfter(expectedDate)));
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByPeriodOfValidityTo () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setValidityPeriodEnd(document.getValidityPeriodEnd())
                .build();

        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String expectedString = searchRequest.getValidityPeriodEnd().substring(0,19);
        LocalDate expectedDate = LocalDate.parse(expectedString, formatter);

        for (DocTemplateData docTemplateData : docList) {
            String actualString = docTemplateData.getValidityPeriodEnd().substring(0,19);
            LocalDate actualDate = LocalDate.parse(actualString, formatter);
            Assert.assertTrue((actualDate.isBefore(expectedDate)) || (actualDate.isEqual((expectedDate))));
        }
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
    public void testSearchDocumentsByPeriodOfModificationFrom () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        DocumentsPacking updatedDoc = documentsPackingService.updateDocument(DocTemplateUpdateForm.updateDocumentForSearch(document.getId()));

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setModifyPeriodStart(updatedDoc.getModifyDate())
                .build();

        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String expectedString = searchRequest.getModifyPeriodStart().substring(0,19);
        LocalDate expectedDate = LocalDate.parse(expectedString, formatter);

        for (DocTemplateData docTemplateData : docList) {
            String actualString = docTemplateData.getModifyDate().substring(0,19);
            LocalDate actualDate = LocalDate.parse(actualString, formatter);
            Assert.assertTrue((actualDate.isEqual(expectedDate)) || (actualDate.isAfter(expectedDate)));
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByPeriodOfModificationTo () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        DocumentsPacking updatedDoc = documentsPackingService.updateDocument(DocTemplateUpdateForm.updateDocumentForSearch(document.getId()));

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setModifyPeriodEnd(updatedDoc.getModifyDate())
                .build();

        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String expectedString = searchRequest.getModifyPeriodEnd().substring(0,19);
        LocalDate expectedDate = LocalDate.parse(expectedString, formatter);

        for (DocTemplateData docTemplateData : docList) {
            String actualString = docTemplateData.getModifyDate().substring(0,19);
            LocalDate actualDate = LocalDate.parse(actualString, formatter);
            Assert.assertTrue((actualDate.isBefore(expectedDate)) || (actualDate.isEqual(expectedDate)));
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByInactive () {
        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(false).build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        docList.forEach(x -> Assert.assertEquals(searchRequest.getIsActive(), x.getIsActive()));
    }

    @Test
    public void testSearchDocumentsByFlightType () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setFlightType(rule.getFlightType())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);
        int count = 0;
        for (DocTemplateData docTemplateData : docList) {
            for (int i = 0; i < docTemplateData.getDocRulesIds().size(); i++) {
                DocRule docRule = documentsPackingService.getDocRule(docTemplateData.getDocRulesIds().get(i));
                if (docRule.getFlightType().equals(searchRequest.getFlightType())) {
                    count++;
                    break;
                }
            }
            Assert.assertNotEquals(0, count);
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByCountry () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setCountry(rule.getCountryArrId()) // или вариант два: .setCountry(rule.getCountryDepId())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);
        int count = 0;
        for (DocTemplateData docTemplateData : docList) {
            for (int i = 0; i < docTemplateData.getDocRulesIds().size(); i++) {
                DocRule docRule = documentsPackingService.getDocRule(docTemplateData.getDocRulesIds().get(i));
                if ((docRule.getCountryArrId().equals(searchRequest.getCountry())) ||
                        (docRule.getCountryDepId().equals(searchRequest.getCountry()))) {
                    count++;
                    break;
                }
            }
            Assert.assertNotEquals(0, count);
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByAirport () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setAirport(rule.getDepAirports()) // или вариант два: .setAirport(rule.getArrAirports())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);
        int count = 0;
        for (DocTemplateData docTemplateData : docList) {
            for (int i = 0; i < docTemplateData.getDocRulesIds().size(); i++) {
                DocRule docRule = documentsPackingService.getDocRule(docTemplateData.getDocRulesIds().get(i));
                if (docRule.getArrAirports() != null) {
                    if (docRule.getArrAirports().equals(searchRequest.getAirport())) {
                        count++;
                        break;
                    }
                }
                if (docRule.getDepAirports() != null) {
                    if (docRule.getDepAirports().equals(searchRequest.getAirport())) {
                        count++;
                        break;
                    }
                }
            }
            Assert.assertNotEquals(0, count);
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));

    }

    @Test
    public void testSearchDocumentsByFlightNumber () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setFlightNumbers(rule.getFlightNumbers())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);
        int count = 0;
        for (DocTemplateData docTemplateData : docList) {
            for (int i = 0; i < docTemplateData.getDocRulesIds().size(); i++) {
                DocRule docRule = documentsPackingService.getDocRule(docTemplateData.getDocRulesIds().get(i));
                if (docRule.getFlightNumbers() != null) {
                    if (docRule.getFlightNumbers().equals(searchRequest.getFlightNumbers())) {
                        count++;
                        break;
                    }
                }
            }
            Assert.assertNotEquals(0, count);
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByRouteCategory () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setCrewRouteCategoryId(rule.getCrewRouteCategoryId())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);
        int count = 0;
        for (DocTemplateData docTemplateData : docList) {
            for (int i = 0; i < docTemplateData.getDocRulesIds().size(); i++) {
                DocRule docRule = documentsPackingService.getDocRule(docTemplateData.getDocRulesIds().get(i));
                if (docRule.getCrewRouteCategoryId().equals(searchRequest.getCrewRouteCategoryId())) {
                    count++;
                    break;
                }
            }
            Assert.assertNotEquals(0, count);
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testSearchDocumentsByTechStop () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setTechnicalStop(rule.getTechnicalStop())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertTrue(docList.size() > 0);
        int count = 0;
        for (DocTemplateData docTemplateData : docList) {
            for (int i = 0; i < docTemplateData.getDocRulesIds().size(); i++) {
                DocRule docRule = documentsPackingService.getDocRule(docTemplateData.getDocRulesIds().get(i));
                if (docRule.getTechnicalStop() != null) {
                    if (docRule.getTechnicalStop().equals(searchRequest.getIsTechnicalStop())) {
                        count++;
                        break;
                    }
                }
            }
            Assert.assertNotEquals(0, count);
        }
        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Ignore("need validation between createDateStart and validityDateEnd")
    @Test
    public void testSearchDocumentsByPeriodOfCreationAndValidity () {
        DocumentsPacking document = documentsPackingService.createDocumentWithRule(DocTemplateWithRulesCreateForm.newDocForNegativeFilterTest());
        Assert.assertNotNull(document);
        Assert.assertTrue(document.getIsActive());
        Assert.assertNotNull(document.getDocRulesIds());
        Assert.assertTrue(document.getDocRulesIds().size() > 0);
        DocRule rule = documentsPackingService.getDocRule(document.getDocRulesIds().get(0));
        Assert.assertNotNull(rule);

        DocumentsPackingSearch searchRequest = new DocumentsPackingSearchBuilder(true)
                .setCreateDateStart(document.getCreateDate())
                .setValidityPeriodEnd(document.getValidityPeriodEnd())
                .build();
        List<DocTemplateData> docList = documentsPackingService.searchDocument(searchRequest);
        Assert.assertFalse(docList.size() > 0);

        Assert.assertTrue(documentsPackingService.deleteDocument(document.getId()));
    }

    @Test
    public void testGetDataAsAirlines () {
        List<Airlines> airlineData = documentsPackingService.getAirlines();
        Assert.assertNotNull(airlineData);
        Assert.assertTrue(airlineData.size() > 0);

        List<String> airlineCodeList = airlineData.stream().map(Airlines::getCode).toList();

        Assert.assertEquals(new HashSet<Object>(airlineCodeList), new HashSet<Object>(Constant.Dictionary.AIRLINES));
    }

    @Test
    public void testGetDataAsAircrafts () {
        List<Aircrafts> aircraftData = documentsPackingService.getAircrafts();
        Assert.assertNotNull(aircraftData);
        Assert.assertTrue(aircraftData.size() > 0);

        List<String> aircraftNameList = aircraftData.stream().map(Aircrafts::getNameEn).toList();

        Assert.assertEquals(new HashSet<Object>(aircraftNameList), new HashSet<Object>(Constant.Dictionary.AIRCRAFTS));
    }

    @Test
    public void testGetDataAsBoards () {
        List<Boards> boardData = documentsPackingService.getBoards();
        Assert.assertNotNull(boardData);
        Assert.assertTrue(boardData.size() > 0);

        List<String> boardsRegNumberList = boardData.stream().map(Boards::getReg).toList();
        //System.out.println(boardsRegNumberList);
        Assert.assertEquals(new HashSet<Object>(boardsRegNumberList), new HashSet<Object>(Constant.Dictionary.BOARDS));
    }

    @Test
    public void testGetDataAsCountries () {
        List<Countries> countryData = documentsPackingService.getCountries();
        Assert.assertNotNull(countryData);
        Assert.assertTrue(countryData.size() > 0);

        List<String> countriesList = countryData.stream().map(Countries::getNameEn).toList();
        //System.out.println(countriesList);
        Assert.assertEquals(new HashSet<Object>(countriesList), new HashSet<Object>(Constant.Dictionary.COUNTRIES));
    }

    @Test
    public void testGetDataAsAirports () {
        List<Airports> airportsData = documentsPackingService.getAirports();
        Assert.assertNotNull(airportsData);
        Assert.assertTrue(airportsData.size() > 0);

        List<String> airportsList = airportsData.stream().map(Airports::getIata).toList();
        System.out.println(airportsList);
        Assert.assertEquals(new HashSet<Object>(airportsList), new HashSet<Object>(Constant.Dictionary.AIRPORTS));
    }


    @Test
    public void testGetDataDocCategory () {
        List<DocCategories> categoriesData = documentsPackingService.getCategories();
        Assert.assertNotNull(categoriesData);
        Assert.assertTrue(categoriesData.size() > 0);

        List<String> categoriesList = categoriesData.stream().map(DocCategories::getName).toList();
        System.out.println(categoriesList);
        Assert.assertEquals(new HashSet<Object>(categoriesList), new HashSet<Object>(Constant.Dictionary.DOC_CATEGORIES));
    }

    @Test
    public void testGetDataDocOwner () {
        List<DocOwners> ownersData = documentsPackingService.getOwners();
        Assert.assertNotNull(ownersData);
        Assert.assertTrue(ownersData.size() > 0);

        List<String> ownersList = ownersData.stream().map(DocOwners::getName).toList();
        System.out.println(ownersList);
        Assert.assertEquals(new HashSet<Object>(ownersList), new HashSet<Object>(Constant.Dictionary.DOC_OWNERS));
    }

    @Test
    public void testGetDataRouteCategory () {
        List<CrewRouteCategories> routeCategoryData = documentsPackingService.getCrewRouteCategories();
        Assert.assertNotNull(routeCategoryData);
        Assert.assertTrue(routeCategoryData.size() > 0);

        List<String> routeCategoryList = routeCategoryData.stream().map(CrewRouteCategories::getName).toList();
        System.out.println(routeCategoryList);
        Assert.assertEquals(new HashSet<Object>(routeCategoryList), new HashSet<Object>(Constant.Dictionary.ROUTE_CATEGORIES));
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

package aero.s7.jl.autotest.api.DocumentsPacking;

import aero.s7.jl.autotest.api.Filter.DocumentsPackingSearch;
import aero.s7.jl.autotest.api.Specifications;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.util.List;

public class DocumentsPackingServiceImpl implements DocumentsPackingService {

    @Override
    public DocumentsPacking getDocument(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .pathParam("id", id)
                    .get("/api/configuration/doc-template/{id}")
                .then()
                    .log().body()
                    .extract().as(DocumentsPacking.class);
    }

    @Override
    public DocumentsPacking createDocumentWithRule (DocTemplateWithRulesCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .body(form)
                    .post("/api/configuration/doc-template/with-rules")
                .then()
                    .log().all()
                    //.statusCode(201)
                    .extract().as(DocumentsPacking.class);
    }

    @Override
    public int createEmptyDocument (DocTemplateWithRulesCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        final Response response = RestAssured.given()
                .when()
                .body(form)
                .post("/api/configuration/doc-template/with-rules");
        return response.statusCode();
    }

    @Override
    public DocumentsPacking updateDocument(DocTemplateUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .put("/api/configuration/doc-template")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(DocumentsPacking.class);
    }

    @Override
    public DocRule updateDocRule (DocRuleUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .put("/api/configuration/doc-rule")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(DocRule.class);
    }

    @Override
    public boolean deleteDocument(int id) {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("isActive", "false");

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .body(json.toString())
                .put("/api/configuration/doc-template");
        return response.statusCode() == 200;
    }

    @Override
    public DocRule getDocRule(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .pathParam("id", id)
                    .get("/api/configuration/doc-rule/{id}")
                .then()
                    .log().body()
                    .extract().as(DocRule.class);
    }

    @Override
    public List<DocTemplateData> searchDocument(DocumentsPackingSearch documentsPackingSearch) {
        JSONObject json = new JSONObject();
        if (documentsPackingSearch.getName()!=null) {
            json.put("name", documentsPackingSearch.getName());
        }
        if (documentsPackingSearch.getDocCategoryId()!=null) {
            json.put("docCategoryId", documentsPackingSearch.getDocCategoryId());
        }
        if (documentsPackingSearch.getDocType()!=null) {
            json.put("docType", documentsPackingSearch.getDocType());
        }
        json.put("docOwnerIds", documentsPackingSearch.getDocOwnerIds());
        if (documentsPackingSearch.getCreateDateStart()!=null) {
            json.put("createDateStart", documentsPackingSearch.getCreateDateStart());
        }
        if (documentsPackingSearch.getCreateDateEnd()!=null) {
            json.put("createDateEnd", documentsPackingSearch.getCreateDateEnd());
        }
        if (documentsPackingSearch.getIsActive()!=null) {
            json.put("isActive", documentsPackingSearch.getIsActive());
        }
        if( documentsPackingSearch.getAuthor()!=null) {
            json.put("author", documentsPackingSearch.getAuthor());
        }
        if (documentsPackingSearch.getValidityPeriodStart()!=null) {
            json.put("validityPeriodStart", documentsPackingSearch.getValidityPeriodStart());
        }
        if (documentsPackingSearch.getValidityPeriodEnd()!=null) {
            json.put("validityPeriodEnd", documentsPackingSearch.getValidityPeriodEnd());
        }
        if (documentsPackingSearch.getModifier()!=null) {
            json.put("modifier", documentsPackingSearch.getModifier());
        }
        if (documentsPackingSearch.getModifyPeriodStart()!=null) {
            json.put("modifyPeriodStart", documentsPackingSearch.getModifyPeriodStart());
        }
        if (documentsPackingSearch.getModifyPeriodEnd()!=null) {
            json.put("modifyPeriodEnd", documentsPackingSearch.getCreateDateEnd());
        }
        if (documentsPackingSearch.getFlightType()!=null) {
            json.put("flightType", documentsPackingSearch.getFlightType());
        }
        if (documentsPackingSearch.getCrewType()!=null) {
            json.put("crewType", documentsPackingSearch.getCrewType());
        }
        if (documentsPackingSearch.getCountry()!=null) {
            json.put("country",documentsPackingSearch.getCountry());
        }
        if (documentsPackingSearch.getAirport()!=null) {
            json.put("airport", documentsPackingSearch.getAirport());
        }
        if (documentsPackingSearch.getFlightNumbers()!=null) {
            json.put("flightNumbers", documentsPackingSearch.getFlightNumbers());
        }
        if (documentsPackingSearch.getCrewRouteCategoryId()!=null) {
            json.put("crewRouteCategoryId", documentsPackingSearch.getCrewRouteCategoryId());
        }
        if (documentsPackingSearch.getIsTechnicalStop()!=null) {
            json.put("isTechnicalStop", documentsPackingSearch.getIsTechnicalStop());
        }

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(json.toString())
                .post("/api/configuration/doc-template/filter")
            .then()
                .log().all()
                .statusCode(200)
                //.extract().as("content", DocTemplateData.class);
                .extract().body().jsonPath().getList("content", DocTemplateData.class);
    }

}

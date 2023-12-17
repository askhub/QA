package aero.s7.jl.autotest.api.Documents;

import aero.s7.jl.autotest.api.DictionaryAndData.*;
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
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .pathParam("id", id)
                    .get("/api/configuration/documents/{id}")
                .then()
                    .log().body()
                    .extract().as(DocumentsPacking.class);
    }

    @Override
    public DocumentsPacking createDocumentWithRule (DocTemplateWithRulesCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .body(form)
                    .post("/api/configuration/documents/with-rules")
                .then()
                    .log().all()
                    //.statusCode(201)
                    .extract().as(DocumentsPacking.class);
    }

    @Override
    public int createEmptyDocument (DocTemplateWithRulesCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
                .when()
                .body(form)
                .post("/api/configuration/documents/with-rules");
        return response.statusCode();
    }

    @Override
    public DocumentsPacking updateDocument(DocTemplateUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .put("/api/configuration/documents")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(DocumentsPacking.class);
    }

    @Override
    public DocRule updateDocRule (DocRuleUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .put("/api/configuration/document-rules")
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

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .body(json.toString())
                .put("/api/configuration/documents");
        return response.statusCode() == 200;
    }

    @Override
    public DocRule getDocRule(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .pathParam("id", id)
                    .get("/api/configuration/document-rules/{id}")
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

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(json.toString())
                .post("/api/configuration/documents/filter")
            .then()
                .log().all()
                .statusCode(200)
                //.extract().as("content", DocTemplateData.class);
                .extract().body().jsonPath().getList("content", DocTemplateData.class);
    }

    @Override
    public List<DocTemplateData> sortDocuments(DocumentsPackingSearch documentsPackingSearch,
                                               String sortField, String sortDirection) {
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

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(json.toString())
                .post(String.format("/api/configuration/documents/filter?page=0&sort=%s&order=%s", sortField, sortDirection))
            .then()
                .log().all()
                .extract().body().jsonPath().getList("content", DocTemplateData.class);
    }

    @Override
    public List<Airlines> getAirlines() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/data/airlines")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Airlines.class);
    }

    @Override
    public List<Aircrafts> getAircrafts() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/data/aircraft")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Aircrafts.class);
    }

    @Override
    public List<Boards> getBoards() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/data/boards")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Boards.class);
    }

    @Override
    public List<Countries> getCountries() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/data/countries")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Countries.class);
    }

    @Override
    public List<Airports> getAirports() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/data/airports")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Airports.class);
    }

    @Override
    public List<DocCategories> getCategories() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/document-categories")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", DocCategories.class);
    }

    @Override
    public List<DocOwners> getOwners() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/document-owners")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", DocOwners.class);
    }

    @Override
    public List<CrewRouteCategories> getCrewRouteCategories() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/crew-route-categories")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", CrewRouteCategories.class);
    }
}

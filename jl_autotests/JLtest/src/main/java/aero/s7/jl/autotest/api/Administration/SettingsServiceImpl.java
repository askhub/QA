package aero.s7.jl.autotest.api.Administration;

import aero.s7.jl.autotest.api.Specifications;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class SettingsServiceImpl implements SettingsService {

    @Override
    public List<Category> getAllCategory() {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/document-categories")
            .then()
                //.log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Category.class);
    }

    @Override
    public Category getCategory(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("id", id)
                .get("/api/configuration/document-categories/{id}")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(Category.class);
    }

    @Override
    public Category createCategory(CategoryCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .post("/api/configuration/document-categories")
            .then()
                .log().body()
                .statusCode(201)
                .extract().as(Category.class);
    }

    @Override
    public Boolean createNewCategoryNegative(CategoryCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
                .body(form)
                .post("/api/configuration/document-categories");
        return response.statusCode() == 409;
    }

    @Override
    public Category updateCategory(int id, CategoryUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("id", id)
                .body(form)
                .put("/api/configuration/document-categories/{id}")
            .then()
                .statusCode(200)
                .extract().as(Category.class);
    }

    @Override
    public Category deleteCategory(int documentCategoryId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("documentCategoryId", documentCategoryId)
                .post("/api/configuration/document-categories/{documentCategoryId}/deactivate")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(Category.class);
    }

    @Override
    public Category recoverCategory(int documentCategoryId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("documentCategoryId", documentCategoryId)
                .post("/api/configuration/document-categories/{documentCategoryId}/activate")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(Category.class);
    }

    @Override
    public boolean deleteCategoryNegative(int documentCategoryId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
                .pathParam("documentCategoryId", documentCategoryId)
                .post("/api/configuration/document-categories/{documentCategoryId}/deactivate");
        return response.statusCode() == 409;
    }



    @Override
    public List<TdTs> getAllDeclarations() {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/transport-declarations")
            .then()
                .statusCode(200)
                .log().all()
                .extract().body().jsonPath().getList("",TdTs.class);
    }

    @Override
    public TdTs getDeclaration(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("id", id)
                .get("/api/configuration/transport-declarations/{id}")
            .then()
                .statusCode(200)
                .log().all()
                .extract().as(TdTs.class);
    }

    @Override
    public TdTs createDeclaration(TdTsCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .post("/api/configuration/transport-declarations")
            .then()
                .statusCode(201)
                .log().all()
                .extract().as(TdTs.class);
    }

    @Override
    public boolean createDeclarationNegative(TdTsCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .body(form)
                .post("/api/configuration/transport-declarations");
        return response.statusCode() == 409;
    }

    @Override
    public TdTs updateDeclaration(int id, TdTsUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("transportDeclarationId", id)
                .body(form)
                .put("/api/configuration/transport-declarations/{transportDeclarationId}")
            .then()
                .statusCode(200)
                .log().all()
                .extract().as(TdTs.class);
    }

    @Override
    public boolean updateDeclarationNegative(int id, TdTsUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .pathParam("transportDeclarationId", id)
                .body(form)
                .put("/api/configuration/transport-declarations/{transportDeclarationId}");
        return response.statusCode() == 409;
    }

    @Override
    public TdTs deleteDeclaration (int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("transportDeclarationId", id)
                .post("/api/configuration/transport-declarations/{transportDeclarationId}/deactivate")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(TdTs.class);
    }

    @Override
    public TdTs recoveryDeclaration(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("transportDeclarationId", id)
                .post("/api/configuration/transport-declarations/{transportDeclarationId}/activate")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(TdTs.class);

    }
}

//Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
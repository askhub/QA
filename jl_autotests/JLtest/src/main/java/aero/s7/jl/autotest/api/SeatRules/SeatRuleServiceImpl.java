package aero.s7.jl.autotest.api.SeatRules;

import aero.s7.jl.autotest.api.DictionaryAndData.*;
import aero.s7.jl.autotest.api.Filter.SeatRuleSearch;
import aero.s7.jl.autotest.api.Specifications;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import java.util.List;

public class SeatRuleServiceImpl implements SeatRuleService {

    @Override
    public SeatRule getSeatRule(int id) {

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("id", id)
                .get("/api/configuration/seat-rules/{id}")
            .then()
                .log().body()
                .extract().as(SeatRule.class);
    }

    @Override
    public TaskToSeatRule getTaskToSeatRule(int id) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .pathParam("id", id)
                .get("/api/configuration/seat-rule-tasks/{id}")
            .then()
                .log().body()
                .extract().as(TaskToSeatRule.class);
    }

    @Override
    public SeatRule createSeatRule(SeatRuleCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .post("/api/configuration/seat-rules")
            .then()
                .log().body()
                .statusCode(201)
                .extract().as(SeatRule.class);
    }

    @Override
    public boolean createSeatRuleNegative(SeatRuleCreateForm form) {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .body(form)
                .post("/api/configuration/seat-rules");
        return response.statusCode() == 400;
    }

    @Override
    public SeatRule createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .post("/api/configuration/seat-rules/with-task-to-seat-rules")
            .then()
                .log().body()
                .statusCode(201)
                .extract().as(SeatRule.class);
    }

    @Override
    public boolean createSeatRuleWithTaskNegative(SeatRuleWithTaskToSeatRuleCreateForm form) {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
                .body(form)
                .post("/api/configuration/seat-rules/with-task-to-seat-rules");
        return response.statusCode() == 400;
    }

    @Override
    public SeatRule updateSeatRule(SeatRuleUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .put("/api/configuration/seat-rules")
            .then()
                .statusCode(200)
                //.log().body()
                .extract().as(SeatRule.class);
    }

    @Override
    public TaskToSeatRule updateTaskToSeatRule(SeatRuleUpdateForm form) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .body(form)
                .put("/api/configuration/seat-rule-tasks")
            .then()
                .statusCode(200)
                .log().body()
                .extract().as(TaskToSeatRule.class);
    }

    @Override
    public boolean deleteSeatRule(int id) {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("isActive", "false");

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .body(json.toString())
                .put("/api/configuration/seat-rules");

        return response.statusCode() == 200;
    }

    @Override
    public boolean deleteTaskToSeatRule(int taskId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        final ValidatableResponse response = RestAssured.given()
            .when()
                .pathParam("id", taskId)
                .delete("/api/configuration/seat-rule-tasks/{id}")
            .then()
                .log().all()
                .assertThat().statusCode(204);

        return true;
    }

    @Override
    public List<SeatRuleData> searchSeatRule(SeatRuleSearch seatRuleSearch) {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        JSONObject json = new JSONObject();
        if (seatRuleSearch.getCrewMemberType() != null) {
            json.put("crewMemberType", seatRuleSearch.getCrewMemberType());
        }
        if (seatRuleSearch.getCapCY() != null) {
            json.put("CapCY", seatRuleSearch.getCapCY());
        }
        if (seatRuleSearch.getCarrierId() != null) {
            json.put("carrierId", seatRuleSearch.getCarrierId());
        }
        if (seatRuleSearch.getCode() != null) {
            json.put("code", seatRuleSearch.getCode());
        }
        if (seatRuleSearch.getAcTypeId() != null) {
            json.put("acTypeId", seatRuleSearch.getAcTypeId());
        }
        if (seatRuleSearch.getIsActive() != null) {
            json.put("isActive", seatRuleSearch.getIsActive());
        }
        if (seatRuleSearch.getIsTemplate() != null) {
            json.put("isTemplate", seatRuleSearch.getIsTemplate());
        }

        return RestAssured.given()
            .when()
                .body(json.toString())
                .post("/api/configuration/seat-rules/filter")
            .then()
                .log().body()
                .statusCode(200)
                .extract().body().jsonPath().getList("content", SeatRuleData.class);
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<CrewMemberType> getCrewMemberType() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/CREW_MEMBER_TYPE")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", CrewMemberType.class);
    }

    @Override
    public List<CrewCategories> getCrewCategory() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/CREW_CATEGORY")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", CrewCategories.class);
    }

    @Override
    public List<Positions> getPosition() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/POSITION")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Positions.class);
    }

    @Override
    public List<Qualifications> getQualification() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/QUALIFICATION")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Qualifications.class);
    }

    @Override
    public List<SubTasks> getSubtask() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/SUB_TASK")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", SubTasks.class);
    }

    @Override
    public List<Types> getMemberType() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/TYPE")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Types.class);
    }

    @Override
    public List<Roles> getRole() {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_URL, TestBase.token));
        return RestAssured.given()
            .when()
                .get("/api/configuration/dictionary/ROLE")
            .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Roles.class);
    }
}

package aero.s7.jl.autotest.api.EcrewTracking;

import aero.s7.jl.autotest.api.FlightTaskDataBuilder.EcrewTrackingFlightTaskDataUpdate;
import aero.s7.jl.autotest.api.Filter.EcrewTrackingSearch;
import aero.s7.jl.autotest.api.Specifications;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

public class EcrewTrackingServiceImpl implements EcrewTrackingService {
    @Override
    public List<EcrewTrackingFlightLegInfo> searchFlightLeg(EcrewTrackingSearch ecrewTrackingSearch) {
        String crewMemberType = "";
        String flightNumber = "";
        String arrivalAirportId = "";
        String departureAirportId = "";
        String carrierId = "";

        JSONObject json = new JSONObject();
        if (ecrewTrackingSearch.getCrewMemberType()!=null) {
            json.put("crewMemberType", ecrewTrackingSearch.getCrewMemberType());
            crewMemberType = String.valueOf(ecrewTrackingSearch.getCrewMemberType());
        }
        if (ecrewTrackingSearch.getFlightNumber()!= null) {
            json.put("flight_number", ecrewTrackingSearch.getFlightNumber());
            flightNumber = String.valueOf(ecrewTrackingSearch.getFlightNumber());
        }
        if (ecrewTrackingSearch.getAirlineId()!=null) {
            json.put("airline_id", ecrewTrackingSearch.getAirlineId());
            carrierId = String.valueOf(ecrewTrackingSearch.getAirlineId());
        }
        if (ecrewTrackingSearch.getAirportIdDep()!= null) {
            json.put("airport_id_dep", ecrewTrackingSearch.getAirportIdDep());
            departureAirportId = String.valueOf(ecrewTrackingSearch.getAirportIdDep());
        }
        if (ecrewTrackingSearch.getAirportIdArr()!= null) {
            json.put("airport_id_arr", ecrewTrackingSearch.getAirportIdArr());
            arrivalAirportId = String.valueOf(ecrewTrackingSearch.getAirportIdArr());
        }
        if (ecrewTrackingSearch.getStartDate()!=null) {
            json.put("startDate", ecrewTrackingSearch.getStartDate());
        }
        if (ecrewTrackingSearch.getEndDate()!= null) {
            json.put("endDate", ecrewTrackingSearch.getEndDate());
        }
        System.out.println(json);

        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .body(json.toString())
                    .pathParam("startDate", ecrewTrackingSearch.getStartDate())
                    .pathParam("endDate", ecrewTrackingSearch.getEndDate())
                    .get("/api/data/flight-legs/search/from/{startDate}/to/{endDate}?&page=0&pageSize=300&flightNumber={flightNumber}&departureAirportId={departureAirportId}&arrivalAirportId={arrivalAirportId}&carrierId={carrierId}&crewMemberType={crewMemberType}", flightNumber, departureAirportId,arrivalAirportId, carrierId, crewMemberType)
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().body().jsonPath().getList("content", EcrewTrackingFlightLegInfo.class);
    }

    @Override
    public Boolean email(long flightLegId, String email) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        final Response response = RestAssured.given()
            .when()
                .pathParam("flight_id", flightLegId)
                .pathParam("to", email)
                .get("/api/document-packing/email/send/flight-task/{flight_id}/{to}");
        return response.statusCode() == 200;
    }

    @Override
    public Boolean generateFlightTask (long flightLegId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        final Response response = RestAssured.given()
                .when()
                .pathParam("flightLegId", flightLegId)
                .get("/api/document-packing/flight-task/{flightLegId}");
        return response.statusCode() == 200;
    }

    @Override
    public Boolean getGeneratedFlightTask(long flightLegId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        final Response response = RestAssured.given()
                .when()
                .pathParam("flight-id", flightLegId)
                .get("/api/archive/flight-task-file/{flight-id}");
        return response.statusCode() == 200;
    }

    @Override
    public List<EcrewTrackingAllFlightTaskByFlightLeg> getAllFlightTaskByFlightLeg(long flightLegId) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return Collections.singletonList(RestAssured.given()
                .when()
                .pathParam("flight_Leg_Id", flightLegId)
                .get("/api/document-packing/flight-task/all-by-flight-leg/{flight_Leg_Id}")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(EcrewTrackingAllFlightTaskByFlightLeg.class));
    }

    @Override
    public EcrewTrackingFlightTaskData getFlightTaskData(long flightTaskId) {
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        return RestAssured.given()
                .when()
                    .pathParam("flight_Task_Id", flightTaskId)
                    .get("/api/document-packing/flight-task/flight-task-data/{flight_Task_Id}")
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().as(EcrewTrackingFlightTaskData.class);
    }

    @Override
    public boolean updateFlightTask(long flightLegId, EcrewTrackingFlightTaskDataUpdate ecrewTrackingFlightTaskDataUpdate) {
        JSONObject json = new JSONObject();
        // сюда поля для изменения ПЗ
        Specifications.setupRequestSpecification(Specifications.requestSpecification(Constant.BASE_DEV_URL, TestBase.token));
        Response response = RestAssured.given()
                .when()
                .pathParam("flightLegId", flightLegId)
                .body(json.toString())
                .post("/api/document-packing/flight-task/from-template/{flightLegId}");
        return response.statusCode() == 200;
    }
}

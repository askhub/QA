package aero.s7.jl.autotest.api;

import aero.s7.jl.autotest.api.EcrewTracking.*;
import aero.s7.jl.autotest.api.Filter.EcrewTrackingSearchBuilder;
import aero.s7.jl.autotest.api.Filter.EcrewTrackingSearch;
import aero.s7.jl.autotest.api.FlightTaskDataBuilder.*;
import aero.s7.jl.autotest.common.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class EcrewTrackingApiTest extends TestBase {

    EcrewTrackingService ecrewTrackingService = new EcrewTrackingServiceImpl();

    @Test
    public void testGetFlightLegByDate () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-24", "2023-08-24").build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);
        legList.forEach(x -> Assert.assertEquals(searchRequest.getStartDate(), x.getStd().substring(0,10)));
    }

    @Test
    public void testSearchFlightLegByFlightNumber () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-03", "2023-08-10")
                .setFlightNumber(5226).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);
        legList.forEach(x-> Assert.assertEquals(searchRequest.getFlightNumber(), x.getFlightNumber()));
    }

    @Test
    public void testSearchFlightLegByCarrier () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-03", "2023-08-16")
                .setAirlineId(1094).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);
        legList.forEach(x -> Assert.assertEquals(searchRequest.getAirlineId(), x.getAirlineId()));
    }

    @Test
    public void testSearchFlightLegByDepartureAirport () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-03", "2023-08-31")
                .setAirportIdDep(1132).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);
        legList.forEach(x -> Assert.assertEquals(searchRequest.getAirportIdDep(), x.getAirportIdDep()));
    }

    @Test
    public void testSearchFlightLegByArrivalAirport () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-03", "2023-08-31")
                .setAirportIdArr(4199).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);
        legList.forEach(x -> Assert.assertEquals(searchRequest.getAirportIdArr(), x.getAirportIdArr()));
    }

    @Test
    public void testAllFlightLegByDateHavePic () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-20", "2023-08-20")
                .setAirportIdArr(5891).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);
        legList.forEach(x -> Assert.assertNotNull(x.getGeneralCrewMemberFullName()));
    }

    @Test
    public void testGenerateNewFlightTask () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-09-13", "2023-09-13")
                .setFlightNumber(Integer.valueOf(Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER)).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);

        long legId = legList.get(0).getFlightLegId();

        Assert.assertTrue(ecrewTrackingService.generateFlightTask(legId));
    }

    @Test
    public void testGetGeneratedFlightTask () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-09-01", "2023-09-01")
                .setFlightNumber(Integer.valueOf(Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER)).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);

        long legId = legList.get(0).getFlightLegId();

        Assert.assertTrue(ecrewTrackingService.getGeneratedFlightTask(legId));
    }

    @Test
    public void testSendingEmail () {
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-08-28", "2023-08-28")
                .setFlightNumber(Integer.valueOf(Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER)).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);

        long legId = legList.get(0).getFlightLegId();
        Assert.assertTrue(ecrewTrackingService.email(legId, Constant.Ui.E_MAIL));
    }

    @Test
    public void testUpdateFlightTask () {
        // на примере изменения имени второго пилота в документе Journey log

        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-09-09", "2023-09-09")
                .setFlightNumber(Integer.valueOf(Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER)).build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);

        long legId = legList.get(0).getFlightLegId();
        Assert.assertTrue(ecrewTrackingService.generateFlightTask(legId));

        List<EcrewTrackingAllFlightTaskByFlightLeg> allFlightTask = ecrewTrackingService.getAllFlightTaskByFlightLeg(legId);
        EcrewTrackingAllFlightTaskByFlightLeg newestFlightTask = allFlightTask.get(allFlightTask.size() - 1);
        int newTaskId = newestFlightTask.getId();

        EcrewTrackingFlightTaskData flightTaskData = ecrewTrackingService.getFlightTaskData(newTaskId);

        EcrewTrackingFlightTaskDtos flightTaskDtos = new EcrewTrackingFlightTaskDtosBuilder(newTaskId, 3, true, 1)
                .setSortIndex(0)
                .setWhitePage(true)
                .build();

        EcrewTrackingFlightTaskJourneyLogData journeyLogData = new EcrewTrackingFlightTaskJourneyLogDataBuilder()
                .setSp("Ivanov Ivan")
                .build();

        EcrewTrackingFlightTaskDataParams reportData = new EcrewTrackingFlightTaskDataParamsBuilder(journeyLogData).build();

        Assert.assertTrue(ecrewTrackingService.updateFlightTask(
                legId,
                new EcrewTrackingFlightTaskDataUpdate(
                        flightTaskDtos,
                        reportData
                )
        ));

        List<EcrewTrackingAllFlightTaskByFlightLeg> allFlightTaskAfterUpdate = ecrewTrackingService.getAllFlightTaskByFlightLeg(legId);
        EcrewTrackingAllFlightTaskByFlightLeg newestFlightTaskAfterUpdate = allFlightTaskAfterUpdate.get(allFlightTask.size() - 1);
        int newTaskIdAfterUpdate = newestFlightTaskAfterUpdate.getId();

        EcrewTrackingFlightTaskData flightTaskDataAfterUpdate = ecrewTrackingService.getFlightTaskData(newTaskIdAfterUpdate);

        Assert.assertNotEquals(flightTaskData.getParams().getJourneyLogData().getSp(),
                flightTaskDataAfterUpdate.getParams().getJourneyLogData().getSp());
    }

    @Test
    public void testSortByOrigStd () {
        //проверка формирования списка легов в порядке возрастания времени вылета (сортировка по умолчанию)
        EcrewTrackingSearch searchRequest = new EcrewTrackingSearchBuilder("2023-09-10", "2023-09-10").build();
        List<EcrewTrackingFlightLegInfo> legList = ecrewTrackingService.searchFlightLeg(searchRequest);
        Assert.assertNotNull(legList);
        Assert.assertTrue(legList.size()>0);

        List<String> origStd = legList.stream().map(EcrewTrackingFlightLegInfo::getOrigstd).toList();
        List<String> sortedOrigStd = origStd.stream().sorted().toList();

        Assert.assertEquals(sortedOrigStd, origStd);
    }

}

//ObjectMapper mapper = new ObjectMapper();
//JsonNode jsonNode = mapper.readTree((JsonParser) legList);
//int legId = jsonNode.get("flight_leg_id").asInt();

//EcrewTrackingFlightTaskDtos flightTaskDtos = new EcrewTrackingFlightTaskDtos(newTaskId, 0);
//flightTaskDtos.setDynamic(true);
//flightTaskDtos.setCopies(1);

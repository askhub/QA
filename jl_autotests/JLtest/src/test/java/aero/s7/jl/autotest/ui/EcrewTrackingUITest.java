// Автотесты UI раздела EcrewTracking. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EcrewTrackingUITest extends TestBase {

    @Before
    public void choiceChapter () {
        headerLink("ECrew Tracking");
    }
    @After
    public void goToMainChapter () {
        headerLink("ECrew Tracking");
    }

    @Test
    public void searchByFlightNumberField () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.textForm("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        ecrewTrackingManager.pushButton("Search");


        int actualQty = ecrewTrackingManager.searchDocByOneField(Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        int expectQty = ecrewTrackingManager.searchDocResult();
        Assert.assertEquals(expectQty, actualQty);
        /*
        boolean isDocumentPresent = ecrewTrackingManager.findDocument (Constant.SEARCH_LEG_FLIGHT_NUMBER);
        Assert.assertTrue(isDocumentPresent);*/
    }

    @Test
    public void searchByDateField () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.dateSearch("Date to", Constant.Ui.SEARCH_LEG_DATE);
        ecrewTrackingManager.dateSearch("Date from", Constant.Ui.SEARCH_LEG_DATE);
        ecrewTrackingManager.pushButton("Search");

        int actualQty = ecrewTrackingManager.searchDocByOneField(ecrewTrackingManager.dateFormatConverter(Constant.Ui.SEARCH_LEG_DATE));
        int expectedQty = ecrewTrackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchByCarrierField () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.listBox("Airline", Constant.Ui.SEARCH_LEG_CARRIER);
        int actualQty = ecrewTrackingManager.searchDocByOneField(Constant.Ui.SEARCH_LEG_CARRIER);
        int expectQty = ecrewTrackingManager.searchDocResult();
        Assert.assertEquals(expectQty, actualQty);
    }

    @Ignore ("UI search by crew doesn't work ")
    @Test
    public void searchByCrewField () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.listBox("Crew", Constant.Ui.SEARCH_LEG_CREW);
        int actualQty = ecrewTrackingManager.searchDocByOneField(Constant.Ui.SEARCH_LEG_CREW);
        int expectQty = ecrewTrackingManager.searchDocResult();
        Assert.assertEquals(expectQty, actualQty);
    }

    @Test
    public void searchByAirportField () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.airportField("Departure", Constant.Ui.SEARCH_LEG_DEP_AIRPORT);
        ecrewTrackingManager.airportField("Arrival", Constant.Ui.SEARCH_LEG_ARR_AIRPORT);
        ecrewTrackingManager.pushButton("Search");
        Helper.wait(1000);

        int expectedQty = ecrewTrackingManager.searchDocByTwoFields(Constant.Ui.SEARCH_LEG_DEP_AIRPORT, Constant.Ui.SEARCH_LEG_ARR_AIRPORT);
        int actualQty = ecrewTrackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Ignore ("UI send mail doesn't work ")
    @Test
    public void sendTaskToEmail () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.textForm("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        ecrewTrackingManager.pushButton("Search");
        Helper.wait(3000);
        ecrewTrackingManager.sendEmail(Constant.Ui.E_MAIL);
        // дождаться сообщения об отправке
    }

    @Ignore ("UI download flight deck doesn't work ")
    @Test
    public void downloadExistTask () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.textForm("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        ecrewTrackingManager.pushButton("Search");
        ecrewTrackingManager.downloadFlightTask("Get existing");
        //оттолкнуться от реализации при итоговой проверке
    }

    @Ignore ("UI download flight deck doesn't work ")
    @Test
    public void generateNewTask () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        ecrewTrackingManager.textForm("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        ecrewTrackingManager.pushButton("Search");
        ecrewTrackingManager.downloadFlightTask("Create new");
        //оттолкнуться от реализации при итоговой проверке
    }

    @Test
    public void allFlightTaskTodayWithPic() {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        List<String> picNames = ecrewTrackingManager.picCheck();
        String noPic = "";
        for (String pic : picNames) {
            //Assert.assertNotSame(noPic, pic);
            Assert.assertNotEquals(noPic,pic);
        }
    }

    @Test
    public void testSortFlightLegByDepartureAirport () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("ECrew Tracking"));

        ecrewTrackingManager.sortButton("DEP");
        List<String> depAirportList = ecrewTrackingManager.airportCollect("DEP");
        List<String> depAirportSorted = depAirportList.stream().sorted().toList();

        Assert.assertEquals(depAirportSorted, depAirportList);
    }

    @Test
    public void testSortFlightLegByArrivalAirport () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("ECrew Tracking"));

        ecrewTrackingManager.sortButton("ARR");
        List<String> arrAirportList = ecrewTrackingManager.airportCollect("ARR");
        List<String> arrAirportSorted = arrAirportList.stream().sorted().toList();

        Assert.assertEquals(arrAirportSorted, arrAirportList);
    }

    @Test
    public void testDateFromDateLimitControl () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("ECrew Tracking"));
        String searchDate = "15011985";
        ecrewTrackingManager.dateSearch("Date from", searchDate);
        String getDate = ecrewTrackingManager.getCalendarValue("Date from");

        Assert.assertTrue(
                ecrewTrackingManager.parserDate(getDate)
                        .isAfter(ecrewTrackingManager.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        ecrewTrackingManager.parserDate(getDate)
                                .isEqual(ecrewTrackingManager.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testDateToDateLimitControl () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("ECrew Tracking"));
        String searchDate = "15012185";
        ecrewTrackingManager.dateSearch("Date to", searchDate);
        String getDate = ecrewTrackingManager.getCalendarValue("Date to");

        Assert.assertTrue(
                ecrewTrackingManager.parserDate(getDate)
                        .isBefore(ecrewTrackingManager.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        ecrewTrackingManager.parserDate(getDate)
                                .isEqual(ecrewTrackingManager.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }
}


/*
@Test
    public void allFlightTaskWithPic () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());

        List<String> picNames = ecrewTrackingManager.picCheck();
        String noPic = "";
        for (String pic : picNames) {
            //Assert.assertNotSame(noPic, pic);
            Assert.assertNotEquals(noPic,pic);
        }
    }

    public void allFlightTaskWithPic () {
        EcrewTrackingManager ecrewTrackingManager = new EcrewTrackingManager(driver.getDriver());
        //проверять до первого лега без pic,
        // если хотя бы у одного лега нет капитана, то леги формируются некорректно

        List<String> picNames = ecrewTrackingManager.picCheck();
        String noPic = "";
        int index = 0;
        do {
            Assert.assertNotEquals(noPic,picNames.get(index));
            index = index+1;
        } while (!noPic.equals(picNames.get(index - 1)));
    }

 */
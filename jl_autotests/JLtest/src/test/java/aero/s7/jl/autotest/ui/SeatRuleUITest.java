// Автотесты UI раздела Seat rules. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeatRuleUITest extends TestBase {

    @Before
    public void choiceChapter () {
        headerLink("Seat rules");
    }
    @After
    public void goToMainChapter () {
        headerLink("eCrew tracking"); }

    @Test
    public void newSeatRuleWithTwoMembers() {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30092024");
        seatRuleManager.listBox("Carrier", "S7");
        seatRuleManager.listBox("Aircraft", "Airbus A321");
        seatRuleManager.textForm("Task", "T4.2");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "Z");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "JS2");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "q");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh", "CFI"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 3", "cat 2", "cat 5"});
        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
    }

    @Test
    public void newSeatRuleWithRequiredFieldsOnly() {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T4.4");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "Z");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE", "CP"});
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "q");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
    }

    @Test
    public void newSeatRuleWithThreeMembers () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01062023");
        seatRuleManager.dateForm("To", "30062024");
        seatRuleManager.listBox("Carrier", "S7");
        seatRuleManager.listBox("Aircraft", "Airbus A321");
        seatRuleManager.textForm("Task", "T4.4");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "X");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"FO"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "n");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("additional");
        seatRuleManager.textForm("Task", "4.4");
        seatRuleManager.listBox("Type", "Member");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "TRE"});
        seatRuleManager.listBox("Position", "S3");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 5", "cat 4", "cat 1"});
        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
    }

    @Test
    public void newSeatRuleWithAllMembers () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30112024");
        seatRuleManager.listBox("Carrier", "S7");
        seatRuleManager.listBox("Aircraft", "Airbus A321neo");
        seatRuleManager.textForm("Task", "T1.1");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "P");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"FO", "TRE"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "j");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "g");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh", "FO"});
        seatRuleManager.listBox("Position", "JS1");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4", "cat 3", "cat 6"});

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "i");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CP"});
        seatRuleManager.listBox("Position", "JS2");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "g");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE"});
        seatRuleManager.listBox("Position", "S1");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "j");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh", "CP"});
        seatRuleManager.listBox("Position", "S2");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("additional");
        seatRuleManager.textForm("Task", "T4.5");
        seatRuleManager.listBox("Type", "Member");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP", "TRE", "CPrh"});
        seatRuleManager.listBox("Position", "S3");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 5", "cat 4", "cat 1"});

        seatRuleManager.addMember("additional");
        seatRuleManager.listBox("Type", "Member");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "TRE"});
        seatRuleManager.listBox("Position", "S4");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 3", "cat 4", "cat 5"});

        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
    }
    @Ignore("disabled after calendar window rebuilded")
    @Test
    public void newSeatRuleWithInvalidDateTo () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30052023");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T6.5.4");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "Z");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE", "CP"});
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "q");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
    }

    @Test
    public void newSeatRuleWithTwoTrainerCrew () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T6.5.6");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "Z");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE", "CP"});
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "Q");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CP"});
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_MEMBER_TYPE_CONTROL);
    }

    @Test
    public void newSeatRuleWithTwoTraineeCrew () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T6.5.6");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "x");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE", "CPrh"});
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "r");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_MEMBER_TYPE_CONTROL);
    }
    @Ignore("disabled, position listbox was rebuilded")
    @Test
    public void newSeatRuleWithSameCrewPosition () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "31102023");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T6.5.7");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "J");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE", "CP"});
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "r");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.pushButton("Save");
    }

    @Test
    public void updateSeatRuleGeneralInfo () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T7.6.5");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "K");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE", "CP"});
        seatRuleManager.listBox("Position", "RLS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "j");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LRS");

        seatRuleManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        seatRuleManager.resetIndex();

        seatRuleManager.dateForm("From", "01102023");
        seatRuleManager.dateForm("To", "31112023");
        seatRuleManager.listBox("Carrier", "GH");
        seatRuleManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_UPDATED);
    }

    @Test
    public void updateSeatRuleTaskInfo () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Carrier", "S7");

        seatRuleManager.textForm("Task", "T8.7.6");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "U");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP"});
        seatRuleManager.listBox("Position", "RLS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "f");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LRS");

        seatRuleManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        seatRuleManager.resetIndex();
        Helper.wait(2000);
        //seatRuleManager.textFormUpdate("Task", "T.9.9", 1);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"FO"});
        seatRuleManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_UPDATED);
    }

    @Test
    public void deleteSeatRule () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30112024");
        seatRuleManager.listBox("Carrier", Constant.Ui.CREATE_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.SEARCH_RULE_AIRCRAFT);

        seatRuleManager.textForm("Task", "T9.8.9");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP"});
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINEE_CODE);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CP", "TRE"});
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        String newSeatRuleId = seatRuleManager.getNewSeatRuleId();
        seatRuleManager.resetIndex();
        seatRuleManager.pushButton("Back");

        seatRuleManager.listBox("Airline", Constant.Ui.CREATE_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.SEARCH_RULE_AIRCRAFT);
        seatRuleManager.textSearchForm("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.pushButton("Search");
        Helper.wait(2000);

        seatRuleManager.clickDeleteButton(newSeatRuleId,
                                        Constant.Ui.CREATE_RULE_CARRIER,
                                        Constant.Ui.SEARCH_RULE_AIRCRAFT,
                                        Constant.Ui.CREATE_RULE_TRAINER_CODE);

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_DELETED);
    }

    @Test
    public void testRecoverInactiveSeatRuleWithActualDateFromForm () {

        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30112024");
        seatRuleManager.listBox("Carrier", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);

        seatRuleManager.textForm("Task", "T1.2.3");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", Constant.Ui.TYPE_2);
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINEE_CODE);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        String newSeatRuleId = seatRuleManager.getNewSeatRuleId ();
        seatRuleManager.resetIndex();
        seatRuleManager.pushButton("Back");
        Helper.wait(2000);

        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Airline", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.textSearchForm ("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);
        seatRuleManager.pushButton("Search");

        seatRuleManager.clickDeleteButton(newSeatRuleId,
                                        Constant.Ui.SEARCH_RULE_CARRIER,
                                        Constant.Ui.CREATE_RULE_AIRCRAFT,
                                        Constant.Ui.CREATE_RULE_TRAINER_CODE);
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_DELETED);
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);

        seatRuleManager.clickViewButton(newSeatRuleId,
                                        Constant.Ui.SEARCH_RULE_CARRIER,
                                        Constant.Ui.CREATE_RULE_AIRCRAFT,
                                        Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.pushButton("Recover");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_RECOVERED);
    }

    @Test
    public void testRecoverInactiveSeatRuleWithOverdueDate () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        seatRuleManager.dateForm("From", "01022023");
        seatRuleManager.dateForm("To", "31072023");
        seatRuleManager.listBox("Carrier", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);

        seatRuleManager.textForm("Task", "T3.2.1");
        seatRuleManager.listBox("Type", Constant.Ui.TYPE_1);
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", Constant.Ui.TYPE_2);
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINEE_CODE);
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");

        seatRuleManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);

        seatRuleManager.resetIndex();
        String newSeatRuleId = seatRuleManager.getNewSeatRuleId();
        seatRuleManager.pushButton("Back");
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);

        seatRuleManager.listBox("Airline", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.textSearchForm("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);
        seatRuleManager.pushButton("Search");

        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        seatRuleManager.clickDeleteButton(newSeatRuleId, Constant.Ui.SEARCH_RULE_CARRIER,
                        Constant.Ui.CREATE_RULE_AIRCRAFT, Constant.Ui.CREATE_RULE_TRAINER_CODE);
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_DELETED);

        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        seatRuleManager.clickRecoverButton(newSeatRuleId,
                                            Constant.Ui.SEARCH_RULE_CARRIER,
                                            Constant.Ui.CREATE_RULE_AIRCRAFT,
                                            Constant.Ui.CREATE_RULE_TRAINER_CODE);
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CANNOT_RECOVERED);

        seatRuleManager.clickViewButton(newSeatRuleId,
                                        Constant.Ui.SEARCH_RULE_CARRIER,
                                        Constant.Ui.CREATE_RULE_AIRCRAFT,
                                        Constant.Ui.CREATE_RULE_TRAINER_CODE);

        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        seatRuleManager.dateForm("To", "31122024");
        seatRuleManager.pushButton("Recover");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_RECOVERED);
    }

    @Test
    public void generalMembersLimit () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Ui.MAX_GENERAL_CREW_MEMBER, seatRuleManager.generalMemberCounter());
    }

    @Test
    public void additionalMembersLimit () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Ui.MAX_ADDITIONAL_CREW_MEMBER, seatRuleManager.additionalMemberCounter());
    }

    @Test
    public void minimumRequiredFieldSeatRuleCreateForm () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Helper.wait(1000);
        seatRuleManager.addMember("general");
        seatRuleManager.pushButton("Save");
        Helper.wait(500);
        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[text()=' Required field ']"));
        Assert.assertEquals(9, message.size());
    }

    @Test
    public void maximumRequiredFieldSeatRuleCreateForm () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Helper.wait(2000);
        for (int i = 1; i < 7; i++) {
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            seatRuleManager.addMember("general");
        }
        for (int j = 1; j < 3; j++) {
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            seatRuleManager.addMember("additional");
        }
        seatRuleManager.pushButton("Save");
        Helper.wait(3000);
        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[text()=' Required field ']"));
        Assert.assertEquals(29, message.size());
    }

    @Test
    public void aircraftPositionsFilling () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        for(int i = 0; i < 5; i++) {
            seatRuleManager.textForm("Code", Integer.toString(i));
            seatRuleManager.listBox("Position", Constant.Ui.POSITION_TEST_LIST.get(i));
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            seatRuleManager.addMember("general");

            String expected = Integer.toString(i);
            String actual = seatRuleManager.positionXpathFinder(Constant.Ui.POSITION_TEST_LIST.get(i));
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testCodeFieldGeneralTrainerValidation () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));
        seatRuleManager.addRule();
        Assert.assertEquals(23, seatRuleManager.codeControl("Trainer"));
    }

    @Test
    public void testCodeFieldGeneralTraineeValidation () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));
        seatRuleManager.addRule();
        Assert.assertEquals(23, seatRuleManager.codeControl("Trainee"));
    }

    @Test
    public void searchSeatRuleByAircraft () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.pageSizeSwitcher(Constant.Ui.PAGINATION_PAGE_SIZE);

        seatRuleManager.listBox("Aircraft", Constant.Ui.SEARCH_RULE_AIRCRAFT);
        seatRuleManager.pushButton("Search");
        Helper.wait(2000);

        int expectedQty = seatRuleManager.searchRulesResult();
        System.out.println("searchRulesResult: " + expectedQty);
        int actualQty = seatRuleManager.searchRulesByAircraft(Constant.Ui.SEARCH_RULE_AIRCRAFT,
                                                                Constant.Ui.PAGINATION_PAGE_SIZE,
                                                                expectedQty);
        System.out.println("searchRulesByAircraft: " + actualQty);
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchSeatRulesByCode () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.pageSizeSwitcher(Constant.Ui.PAGINATION_PAGE_SIZE);

        seatRuleManager.textSearchForm("Code", "A");
        seatRuleManager.pushButton("Search");
        Helper.wait(2000);

        int expectedQty = seatRuleManager.searchRulesResult();
        seatRuleManager.pushButton("Search");
        Helper.wait(2000);
        int actualQty = seatRuleManager.searchRulesByCode("A", Constant.Ui.PAGINATION_PAGE_SIZE, expectedQty);
        Assert.assertEquals(expectedQty, actualQty);

    }

    @Test
    public void searchSeatRulesByAirline () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.pageSizeSwitcher(Constant.Ui.PAGINATION_PAGE_SIZE);

        seatRuleManager.listBox("Airline", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.pushButton("Search");
        Helper.wait(2000);

        int expectedQty = seatRuleManager.searchRulesResult();

        seatRuleManager.pushButton("Search");
        Helper.wait(2000);
        int actualQty = seatRuleManager.searchRulesByAirline(Constant.Ui.SEARCH_RULE_CARRIER,
                                                            Constant.Ui.PAGINATION_PAGE_SIZE,
                                                            expectedQty);
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Ignore("function disabled")
    @Test
    public void checkGetCrewTypeData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.CREW_MEMBER_TYPE, seatRuleManager.getListBoxValues("Crew"));
    }

    @Ignore("function disabled")
    @Test
    public void checkGetSubtaskData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.SUB_TASK, seatRuleManager.getListBoxValues("Subtask"));
    }

    @Test
    public void checkGetTypeData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.TYPE_GENERAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.TYPE_GENERAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.TYPE_GENERAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.TYPE_GENERAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.TYPE_GENERAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.TYPE_GENERAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.TYPE_ADDITIONAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.TYPE_ADDITIONAL, seatRuleManager.getListBoxValues("Type"));
        seatRuleManager.resetIndex();
    }

    @Test
    public void checkGetQualificationData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.QUALIFICATION, seatRuleManager.getListBoxValues("Qualification"));
        seatRuleManager.resetIndex();
    }

    @Test
    public void checkGetRoleData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.ROLE, seatRuleManager.getListBoxValues("Role"));
        seatRuleManager.resetIndex();
    }

    @Test
    public void checkGetPositionData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("general");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.addMember("additional");
        Assert.assertEquals(Constant.Dictionary.POSITION, seatRuleManager.getListBoxValues("Position"));
        seatRuleManager.resetIndex();
    }

    @Test
    public void checkGetAircraftData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));

        seatRuleManager.addRule();
        Assert.assertEquals(Constant.Dictionary.AIRCRAFTS, seatRuleManager.getListBoxValues("Aircraft"));
    }

    @Test
    public void testPeriodOfValidityFromControlDateLimit () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));
        String searchDate = "15011985";
        seatRuleManager.addRule();
        seatRuleManager.dateForm("From", searchDate);
        String getDate = seatRuleManager.getCalendarValue("Period of validity", "From");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isAfter(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodOfValidityToControlDateLimit () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat rules"));
        String searchDate = "15122185";
        seatRuleManager.addRule();
        seatRuleManager.dateForm("To", searchDate);
        String getDate = seatRuleManager.getCalendarValue("Period of validity", "To");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isBefore(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }
}

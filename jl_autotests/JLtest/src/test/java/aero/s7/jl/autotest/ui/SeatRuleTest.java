package aero.s7.jl.autotest.ui;// Автотесты раздела Seat rules

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeatRuleTest extends TestBase {

    @Before
    public void choiceChapter () {
        headerLink("Seat Rules");
    }

    @Test
    public void newSeatRuleWithTwoMembers() {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30092023");
        seatRuleManager.listBox("Carrier", "S7");
        seatRuleManager.listBox("Aircraft", "Airbus A321");
        seatRuleManager.textForm("Task", "T4.2");
        seatRuleManager.listBox("Subtask", "LE");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "Z+");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE"});
        seatRuleManager.listBox("Role", "RP");
        seatRuleManager.listBox("Position", "JS2");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "PICUS");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "qw");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh", "CFI"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 3", "cat 2", "cat 5"});

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Seat rule')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Seat rule created";
        Helper.wait(5000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newSeatRuleWithRequiredFieldsOnly() {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30092023");
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

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Seat rule')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Seat rule created";
        Helper.wait(1000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newSeatRuleWithThreeMembers () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01062023");
        seatRuleManager.dateForm("To", "30062023");
        seatRuleManager.listBox("Carrier", "S7");
        seatRuleManager.listBox("Aircraft", "Airbus A321");
        seatRuleManager.textForm("Task", "T4.4");
        seatRuleManager.listBox("Subtask", "LE");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "X");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"FO"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "PICUS");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "n");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("additional");
        seatRuleManager.textForm("Task", "4.5");
        seatRuleManager.listBox("Subtask", "LTC");
        seatRuleManager.listBox("Type", "Member");
        seatRuleManager.textForm("Code", "l+");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP", "TRE", "CPrh"});
        seatRuleManager.listBox("Role", "RP");
        seatRuleManager.listBox("Position", "S3");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 5", "cat 4", "cat 1"});

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Seat rule')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Seat rule created";
        Helper.wait(5000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newSeatRuleWithAllMembers () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30112023");
        seatRuleManager.listBox("Carrier", "S7");
        seatRuleManager.listBox("Aircraft", "Airbus A321neo");
        seatRuleManager.textForm("Task", "T1.1");
        seatRuleManager.listBox("Subtask", "LE");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "P");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"FO", "TRE"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "RS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "PICUS");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "j");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Role", "PIC");
        seatRuleManager.listBox("Position", "LS");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "PICUS");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "g");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh", "FO"});
        seatRuleManager.listBox("Role", "RP");
        seatRuleManager.listBox("Position", "JS1");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4", "cat 3", "cat 6"});

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "LE");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "W");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CP"});
        seatRuleManager.listBox("Role", "RP");
        seatRuleManager.listBox("Position", "JS2");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "LE");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "c");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"TRE"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "S1");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Subtask", "LE");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "d");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh", "CP"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "S2");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 4"});

        seatRuleManager.addMember("additional");
        seatRuleManager.textForm("Task", "T4.5");
        seatRuleManager.listBox("Subtask", "LTC");
        seatRuleManager.listBox("Type", "Member");
        seatRuleManager.textForm("Code", "+");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP", "TRE", "CPrh"});
        seatRuleManager.listBox("Role", "RP");
        seatRuleManager.listBox("Position", "S3");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 5", "cat 4", "cat 1"});

        seatRuleManager.addMember("additional");
        seatRuleManager.listBox("Subtask", "LTC");
        seatRuleManager.listBox("Type", "Member");
        seatRuleManager.textForm("Code", "m");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "TRE"});
        seatRuleManager.listBox("Role", "SP");
        seatRuleManager.listBox("Position", "S4");
        seatRuleManager.listBoxMulti("Category", new String[]{"cat 1", "cat 4", "cat 5"});

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(15));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Seat rule')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Seat rule created";
        //Helper.wait(1000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newSeatRuleWithInvalidDateTo () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30092023");
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

        seatRuleManager.button("Save");

        /*
        дописать, когда сделают реализацию - тип и текст уведомления о некорректной дате
        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Seat rule created')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Seat rule created";
        Helper.wait(1000);
        Assert.assertEquals(expectedMessage, actualMessage);
        */
    }

    @Test
    public void newSeatRuleWithTwoTrainerCrew () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "31102023");
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

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Task') and contains(text(), 'Trainer') and contains(text(), 'Trainee')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Task must contain one Trainee and one Trainer";
        Helper.wait(1000);

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newSeatRuleWithTwoTraineeCrew () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "31102023");
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

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Task') and contains(text(), 'Trainer') and contains(text(), 'Trainee')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Task must contain one Trainee and one Trainer";
        Helper.wait(1000);

        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Ignore("disabled")
    @Test
    public void newSeatRuleWithSameCrewPosition () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
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

        seatRuleManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'invalid')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Value is invalid";
        Helper.wait(1000);

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void updateSeatRuleGeneralInfo () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "31102023");
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

        seatRuleManager.button("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        seatRuleManager.resetIndex();

        seatRuleManager.dateForm("From", "01102023");
        seatRuleManager.dateForm("To", "31112023");
        seatRuleManager.listBox("Carrier", "GH");
        seatRuleManager.button("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_UPDATED);
    }

    @Test
    public void updateSeatRuleTaskInfo () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01082023");
        seatRuleManager.dateForm("To", "30112023");
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

        seatRuleManager.button("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);

        seatRuleManager.textFormUpdate("Task", "T.9.9", 1);

        seatRuleManager.button("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_UPDATED);
    }

    @Test
    public void deleteSeatRule () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30112023");
        seatRuleManager.listBox("Carrier", Constant.Ui.CREATE_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.SEARCH_RULE_AIRCRAFT);

        seatRuleManager.textForm("Task", "T9.8.7");
        seatRuleManager.listBox("Type", "Trainer");
        seatRuleManager.textForm("Code", "G");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CFI", "CP"});
        seatRuleManager.listBox("Position", "RLS");

        seatRuleManager.addMember("general");
        seatRuleManager.listBox("Type", "Trainee");
        seatRuleManager.textForm("Code", "f");
        seatRuleManager.listBoxMulti("Qualification", new String[]{"CPrh"});
        seatRuleManager.listBox("Position", "LRS");

        seatRuleManager.button("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        seatRuleManager.resetIndex();
        seatRuleManager.button("Back");


        seatRuleManager.listBox("Carrier", Constant.Ui.CREATE_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.SEARCH_RULE_AIRCRAFT);
        seatRuleManager.button("Search");
        Helper.wait(2000);

        String deleteButtonXpath = String.format("//div[@class='field carrier']//span[contains(text(), '%s')]/../../" +
                "following-sibling::div//span[contains(text(), ' %s ')]/../../../../" +
                "following-sibling::div[@class='actions']//button[@icon='tuiIconTrash']//span[@class='t-content']",
                Constant.Ui.CREATE_RULE_CARRIER, Constant.Ui.SEARCH_RULE_AIRCRAFT);
        driver.getDriver().findElement(By.xpath(deleteButtonXpath)).click();
        String confirmationXpath = "//span[contains(text(), 'Confirm')]";
        driver.getDriver().findElement(By.xpath(confirmationXpath)).click();

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_DELETED);

    }

    @Test
    public void testRecoverInactiveSeatRuleWithActualDate () {

        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        //seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.dateForm("From", "01092023");
        seatRuleManager.dateForm("To", "30112023");
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

        seatRuleManager.button("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);

        seatRuleManager.button("Back");
        Helper.wait(2000);
        seatRuleManager.listBox("Crew", "FD");
        seatRuleManager.listBox("Carrier", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINEE_CODE);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);
        seatRuleManager.button("Search");

        String deleteXpath = String.format("//div[@class='general-info']//div//span[text()='%s']/../../" +
                "following-sibling::div//span[contains(text(), '%s')]/../../../../" +
                "following-sibling::div[@class='members-block']//div[@class='field type']//span[text()='%s']/../../" +
                "following-sibling::div[@class='field code']//span[text()='%s']/../../../../../" +
                "following-sibling::div[@class='actions']/button[@icon='tuiIconTrash']//span[@class='t-content']",
                Constant.Ui.SEARCH_RULE_CARRIER, Constant.Ui.CREATE_RULE_AIRCRAFT,
                Constant.Ui.TYPE_2, Constant.Ui.CREATE_RULE_TRAINEE_CODE);

        driver.getDriver().findElement(By.xpath(deleteXpath)).click();
        seatRuleManager.button("Confirm");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_DELETED);
        Helper.wait(2000);

        driver.getDriver().findElement(By.xpath("//button[@icon='tuiIconEye']//span")).click();
        seatRuleManager.button("Recover");
        seatRuleManager.button("Confirm");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_RECOVERED);

    }

    @Test
    public void testRecoverInactiveSeatRuleWithOverdueDate () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        seatRuleManager.dateForm("From", "01022023");
        seatRuleManager.dateForm("To", "31072023");
        seatRuleManager.listBox("Carrier", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);

        seatRuleManager.textForm("Task", "T3.2.1");
        seatRuleManager.listBox("Type", Constant.Ui.TYPE_1);
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

        //seatRuleManager.button("Save");

        //Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_CREATED);
        seatRuleManager.resetIndex();
        seatRuleManager.button("Back");

        Helper.wait(3000);

        seatRuleManager.listBox("Carrier", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.textForm("Code", Constant.Ui.CREATE_RULE_TRAINER_CODE);
        seatRuleManager.listBox("Aircraft", Constant.Ui.CREATE_RULE_AIRCRAFT);
        seatRuleManager.button("Search");

        String deleteXpath = String.format("//div[@class='general-info']//div//span[text()='%s']/../../" +
                        "following-sibling::div//span[contains(text(), '%s')]/../../../../" +
                        "following-sibling::div[@class='members-block']//div[@class='field type']//span[text()='%s']/../../" +
                        "following-sibling::div[@class='field code']//span[text()='%s']/../../../../../" +
                        "following-sibling::div[@class='actions']/button[@icon='tuiIconTrash']//span[@class='t-content']",
                Constant.Ui.SEARCH_RULE_CARRIER, Constant.Ui.CREATE_RULE_AIRCRAFT,
                Constant.Ui.TYPE_1, Constant.Ui.CREATE_RULE_TRAINER_CODE);

        driver.getDriver().findElement(By.xpath(deleteXpath)).click();
        seatRuleManager.button("Confirm");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_DELETED);
        Helper.wait(2000);

        driver.getDriver().findElement(By.xpath("//button[@icon='tuiIconRotateCcw']//span")).click();
        seatRuleManager.button("Confirm");
        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_OUT_OF_DATE_RECOVERED);

        driver.getDriver().findElement(By.xpath("//button[@icon='tuiIconEye']//span")).click();
        seatRuleManager.dateForm("To", "31122023");
        seatRuleManager.button("Recover");

        Helper.notificationControl(Constant.Ui.TOAST_SEAT_RULE_RECOVERED);

    }

    @Test
    public void generalMembersLimit () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        int count = 0;
        final String memberXpath = "//label[@tuilabel='Subtask']//input[@automation-id='tui-primitive-textfield__native-input']";
        for (int i = 1; i < 10; i++) {
            count = driver.getDriver().findElements(By.xpath(memberXpath)).size();
            seatRuleManager.addMember("general");
        }
        Assert.assertEquals(count, 6);
    }

    @Test
    public void additionalMembersLimit () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        int count = 0;
        final String memberXpath = "//label[@tuilabel='Subtask']//input[@automation-id='tui-primitive-textfield__native-input']";
        for (int i = 1; i < 6; i++) {
            count = driver.getDriver().findElements(By.xpath(memberXpath)).size();
            seatRuleManager.addMember("additional");
        }
        Assert.assertEquals(count-1, 2);
    }

    @Test
    public void minimumRequiredFieldSeatRuleCreateForm () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        Helper.wait(2000);
        seatRuleManager.addMember("general");
        seatRuleManager.button("Save");

        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[text()=' Required field ']"));
        Assert.assertEquals(12, message.size());
    }

    @Test
    public void maximumRequiredFieldSeatRuleCreateForm () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        Helper.wait(2000);
        for (int i = 1; i < 7; i++) {
            seatRuleManager.addMember("general");
        }
        for (int j = 1; j < 3; j++) {
            seatRuleManager.addMember("additional");
        }

        seatRuleManager.button("Save");

        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[text()=' Required field ']"));
        Assert.assertEquals(37, message.size());
    }

    @Test
    public void aircraftPositionsFilling () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        for(int i = 0; i < 8; i++) {
            seatRuleManager.textForm("Code", Integer.toString(i));
            seatRuleManager.listBox("Position", Constant.Ui.POSITION_TEST_LIST.get(i));
            if (i < 5) {
                seatRuleManager.addMember("general");
            } else {
                seatRuleManager.addMember("additional");
            }
            String expected = Integer.toString(i);
            String actual = seatRuleManager.positionXpathFinder(Constant.Ui.POSITION_TEST_LIST.get(i));
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void testCodeFieldGeneralTrainerValidation () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        Assert.assertEquals(23, seatRuleManager.trainerCodeControl("Trainer"));
    }

    @Test
    public void testCodeFieldGeneralTraineeValidation () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        Assert.assertEquals(23, seatRuleManager.trainerCodeControl("Trainee"));
    }

    @Test
    public void searchSeatRuleByAircraft () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.listBox("Aircraft", Constant.Ui.SEARCH_RULE_AIRCRAFT);
        seatRuleManager.button("Search");
        Helper.wait(2000);

        int expectedQty = seatRuleManager.searchRulesResult();
        seatRuleManager.allFoundRulesOnOnePage(expectedQty);
        seatRuleManager.button("Search");
        Helper.wait(2000);
        int actualQty = seatRuleManager.searchRulesByAircraft();

        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchSeatRulesByCode () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.textForm("Code", Constant.Ui.SEARCH_RULE_CODE);
        seatRuleManager.button("Search");
        Helper.wait(2000);

        int expectedQty = seatRuleManager.searchRulesResult();
        seatRuleManager.allFoundRulesOnOnePage(expectedQty);
        seatRuleManager.button("Search");
        Helper.wait(2000);
        int actualQty = seatRuleManager.searchRulesByCode();
        Assert.assertEquals(expectedQty, actualQty);

    }

    @Test
    public void searchSeatRulesByCarrier () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.listBox("Carrier", Constant.Ui.SEARCH_RULE_CARRIER);
        seatRuleManager.button("Search");
        Helper.wait(2000);

        int expectedQty = seatRuleManager.searchRulesResult();
        seatRuleManager.allFoundRulesOnOnePage(expectedQty);
        seatRuleManager.button("Search");
        Helper.wait(2000);
        int actualQty = seatRuleManager.searchRulesByCarrier();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Ignore("function disabled")
    @Test
    public void checkGetCrewTypeData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        driver.getDriver().findElement(By.xpath("//label[@tuilabel='Crew']//input[@automation-id='tui-primitive-textfield__native-input']")).click();
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            WebElement crewData = driver.getDriver().findElement(By.xpath(String.format("(//tui-data-list//button//tui-select-option)[%d]", i)));
            data.add(crewData.getText());
        }
        String[] expectedData = {"FD", "CC"};
        List<String> expected = Arrays.asList(expectedData);

        Assert.assertEquals(expected, data);
    }

    @Test
    public void checkGetSubtaskData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        driver.getDriver().findElement(By.xpath("//label[@tuilabel='Subtask']//input[@automation-id='tui-primitive-textfield__native-input']")).click();
        List<String> data = new ArrayList<>();
        Helper.wait(1000);
        for (int i = 1; i <= 3; i++) {
            WebElement crewData = driver.getDriver().findElement(By.xpath(String.format("(//tui-data-list//button//tui-select-option)[%d]", i)));
            data.add(crewData.getText());
        }
        List<String> expected = Constant.Dictionary.SUB_TASK;

        Assert.assertEquals(expected, data);
    }

    @Test
    public void checkGetTypeData () {

        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        driver.getDriver().findElement(By.xpath("//label[@tuilabel='Type']//input[@automation-id='tui-primitive-textfield__native-input']")).click();
        List<String> data = new ArrayList<>();
        Helper.wait(1000);
        for (int i = 1; i <= 2; i++) {
            WebElement crewData = driver.getDriver().findElement(By.xpath(String.format("(//tui-data-list//button//tui-select-option)[%d]", i)));
            data.add(crewData.getText());
        }
        String[] expectedData = {"Trainer", "Trainee"};
        List<String> expected = Arrays.asList(expectedData);

        Assert.assertEquals(expected, data);

    }

    @Test
    public void checkGetQualificationData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        driver.getDriver().findElement(By.xpath("//label[@tuilabel='Qualification']//div[@class='t-icons t-icons_right ng-star-inserted']")).click();
        List<String> data = new ArrayList<>();
        Helper.wait(1000);
        for (int i = 1; i <= 5; i++) {
            WebElement crewData = driver.getDriver().findElement(By.xpath(String.format("(//tui-data-list//button//tui-multi-select-option)[%d]", i)));
            data.add(crewData.getText());
        }
        List<String> expected = Constant.Dictionary.QUALIFICATION;

        Assert.assertEquals(expected, data);
    }

    @Test
    public void checkGetRoleData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        driver.getDriver().findElement(By.xpath("//label[@tuilabel='Role']//input[@automation-id='tui-primitive-textfield__native-input']")).click();
        List<String> data = new ArrayList<>();

        Helper.wait(1000);
        for (int i = 1; i <= 3; i++) {
            WebElement crewData = driver.getDriver().findElement(By.xpath(String.format("(//tui-data-list//button//tui-select-option)[%d]", i)));
            data.add(crewData.getText());
        }
        List<String> expected = Constant.Dictionary.ROLE;

        Assert.assertEquals(expected, data);
    }

    @Test
    public void checkGetPositionData () {
        SeatRuleManager seatRuleManager = new SeatRuleManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Seat Rules"));

        seatRuleManager.button("ADD RULE");
        driver.getDriver().findElement(By.xpath("//label[@tuilabel='Position']//input[@automation-id='tui-primitive-textfield__native-input']")).click();
        List<String> data = new ArrayList<>();
        Helper.wait(1000);
        String crewDataPosition;
        String crewDataSubPosition;
        for (int i = 1; i <= 16; i++) {
            WebElement crewDataString = driver.getDriver().findElement(By.xpath(String.format("(//tui-data-list//button//tui-select-option[@class='ng-star-inserted'])[%d]", i)));
            WebElement crewDataSubstring = driver.getDriver().findElement(By.xpath(String.format("(//small)[%d]", i)));
            crewDataPosition = crewDataString.getText().replaceAll("\n", "");
            if (crewDataSubstring.getText().equals("LS") || crewDataSubstring.getText().equals("RS")) {
                crewDataSubPosition = String.format("(%s)$", crewDataSubstring.getText());
            } else {
                crewDataSubPosition = crewDataSubstring.getText();
            }
            data.add(crewDataPosition.replaceAll(crewDataSubPosition,""));
        }

        List<String> expected = Constant.Dictionary.POSITION;

        Assert.assertEquals(expected, data);
    }

}

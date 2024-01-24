// Автотесты UI раздела Administration. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministrationDeclarationUITest extends TestBase {

    @Before
    public void choiceChapter () {
        headerLink("Administration");
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());
        administrationManager.pushButton("Transport declarations");
        driver.getDriver().navigate().refresh();
    }
    @After
    public void goToMainChapter () {
        headerLink("eCrew tracking");
    }

    @Test
    public void testCreateFuelDeclaration() {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Document categories");
        Helper.wait(2000);
        administrationManager.dateForm("From", "02122023");
        administrationManager.dateForm("To", "31012024");
        administrationManager.fuelNumberForm("02122023/122023/4112024");
        administrationManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CREATE_TD);
    }

    @Test
    public void testCreateFuelNumberNegative() {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01072023");
        administrationManager.dateForm("To", "22022024");
        administrationManager.fuelNumberForm(Constant.Ui.CDV_NUMBER_WRONG);
        Helper.notificationControl(Constant.Ui.INVALID_VALUE);
        administrationManager.pushButton("Close");
    }

    @Test
    public void testUpdateFuelDeclarationNumber () {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01102023");
        administrationManager.dateForm("To", "31122023");
        administrationManager.fuelNumberForm("01122023/122023/3112111");
        administrationManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CREATE_TD);
        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("01102023"),
                                                                        administrationManager.modifyDate("31122023"),
                                                                            "01122023/122023/3112111"));

        administrationManager.viewFuelDeclaration(administrationManager.modifyDate("01102023"),
                                                administrationManager.modifyDate("31122023"),
                                            "01122023/122023/3112111");
        administrationManager.fuelNumberForm("01122023/122023/3112789");
        administrationManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_UPDATE_TD);
        driver.getDriver().navigate().refresh();
        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("01102023"),
                                                                            administrationManager.modifyDate("31122023"),
                                                                             "01122023/122023/3112789"));
    }

    @Test
    public void testUpdateFuelDeclarationDate () {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01082023");
        administrationManager.dateForm("To", "31012024");
        administrationManager.fuelNumberForm("01082023/012024/3112124");
        administrationManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CREATE_TD);
        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("01082023"),
                                                                    administrationManager.modifyDate("31012024"),
                                                                    "01082023/012024/3112124"));

        administrationManager.viewFuelDeclaration(administrationManager.modifyDate("01082023"),
                                                    administrationManager.modifyDate("31012024"),
                                                    "01082023/012024/3112124");
        administrationManager.dateForm("To", "23022024");
        administrationManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_UPDATE_TD);
        driver.getDriver().navigate().refresh();
        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("01082023"),
                                                                    administrationManager.modifyDate("23022024"),
                                                                    "01082023/012024/3112124"));
    }

    @Test
    public void testUpdateFuelDeclarationWrongNumberNegative() {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01112023");
        administrationManager.dateForm("To", "31012024");
        administrationManager.fuelNumberForm("29262728/293031/3233348");
        administrationManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CREATE_TD);

        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("01112023"),
                                                                    administrationManager.modifyDate("31012024"),
                                                                    "29262728/293031/3233348"));
        administrationManager.viewFuelDeclaration(administrationManager.modifyDate("01112023"),
                                                    administrationManager.modifyDate("31012024"),
                                                   "29262728/293031/3233348");
        administrationManager.fuelNumberForm(Constant.Ui.DATE_TO_CDV_WRONG);

        Helper.notificationControl(Constant.Ui.INVALID_VALUE);
        administrationManager.pushButton("Close");
    }

    @Test
    public void testControlDuplicateFuelNumber () {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01092023");
        administrationManager.dateForm("To", "31072024");
        administrationManager.fuelNumberForm("11111111/222222/4333335");
        administrationManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CREATE_TD);

        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("01092023"),
                                                                    administrationManager.modifyDate("31072024"),
                                                                    "11111111/222222/4333335"));
        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01092023");
        administrationManager.dateForm("To", "31072024");
        administrationManager.fuelNumberForm("11111111/222222/4333335");
        administrationManager.pushButton("Save");

        Helper.modalWindowMessageControl(Constant.Ui.MODAL_DUPLICATE_TD);
        administrationManager.pushButton("Ok");
        administrationManager.pushButton("Close");
    }

    @Test
    public void testFuelNumberMixedDatedControl () {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "01102023");
        administrationManager.dateForm("To", "30062023");
        administrationManager.fuelNumberForm("11111111/222222/3333336");
        administrationManager.pushButton("Save");

        Helper.modalWindowMessageControl(Constant.Ui.MODAL_MIXED_DATE);
        administrationManager.pushButton("Ok");
        administrationManager.pushButton("Close");
    }

    @Test
    public void testUpdateFuelDeclarationMixedDateNegative () {
        Assert.assertTrue(TestBase.isChapterPresent("Administration"));
        AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

        administrationManager.add("Transport declaration");
        Helper.wait(2000);
        administrationManager.dateForm("From", "30082023");
        administrationManager.dateForm("To", "25122023");
        administrationManager.fuelNumberForm("11223344/556677/8899004");
        administrationManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CREATE_TD);

        Assert.assertTrue(administrationManager.findFuelDeclaration(administrationManager.modifyDate("30082023"),
                                                                    administrationManager.modifyDate("25122023"),
                                                                    "11223344/556677/8899004"));
        administrationManager.viewFuelDeclaration(administrationManager.modifyDate("30082023"),
                                                    administrationManager.modifyDate("25122023"),
                                                    "11223344/556677/8899004");
        administrationManager.dateForm("To", "30062023");
        administrationManager.pushButton("Save");

        Helper.modalWindowMessageControl(Constant.Ui.MODAL_MIXED_DATE);
        administrationManager.pushButton("Ok");
        administrationManager.pushButton("Close");
    }
}

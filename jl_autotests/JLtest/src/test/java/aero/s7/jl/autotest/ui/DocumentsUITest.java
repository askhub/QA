// Автотесты UI раздела Documents. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentsUITest extends TestBase {

    @Before
    public void choiceChapter () {
        headerLink("Documents");
    }
    @After
    public void goToMainChapter () {
        headerLink("eCrew tracking");
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    @Test
    public void newDocumentsWithAllField () {

        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        docpackingManager.addDocument();
        docpackingManager.listDocTypeForm("STATIC");
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.markCategoryPasteAfter("Документы по ВС");
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.docNameField("Информация по Сабетте");
        docpackingManager.description("информация экипажу по прибытию");
        docpackingManager.dateValid("Valid from", "01042023");
        docpackingManager.dateValid("Valid to", "31122023");
        docpackingManager.checkBoxWhitePage();
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listBox("Dep country", "Russian Federation");
        docpackingManager.listBox("Arr country", "Russian Federation");
        docpackingManager.listBox("Dep airport", "DME");
        docpackingManager.listBox("Arr airport", "BKK");
        docpackingManager.textForm("Flight numbers", "3668");
        docpackingManager.listBox("Aircraft", "Airbus A320neo");
        docpackingManager.listBox("Board", "VP-BPO");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.dateSearch("Period", "From", "01042023");
        docpackingManager.dateSearch("Period", "To", "31122023");
        docpackingManager.clickCheckBox("Technical stop");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
    }

    @Test
    public void newDocumentsWithRequiredField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.markCategoryPasteAfter("Основные документы");
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
    }

    @Test
    public void updateDocumentForm() {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.fileLoad("GD_new86.pdf");
        docpackingManager.docNameField("Gen_declaration_8");
        docpackingManager.markCategoryPasteAfter("Чек-листы, анкеты, бланки");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "CIS");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        docpackingManager.pushButton("Back");

        docpackingManager.textForm("Name", "Gen_declaration_8");
        docpackingManager.pushButton("Search");

        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(Constant.Ui.LONG_PAUSE);

        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.dateValid("Valid to", "31122023");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_UPDATED);
        docpackingManager.pushButton("Back");
    }

    @Test
    public void updateDocRule () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДЛС"});
        docpackingManager.markCategoryPasteAfter("Прочая информация");
        docpackingManager.fileLoad("TD_TC_ARR_IKT.pdf");
        docpackingManager.docNameField("TD_TC_ARR_PORT_IKT_MVL");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(5000);
        docpackingManager.pushButton("Back");

        docpackingManager.textForm("Name", "TD_TC_ARR_PORT_IKT_MVL");
        docpackingManager.pushButton("Search");

        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(Constant.Ui.LONG_PAUSE);

        docpackingManager.pushButton("Edit");
        docpackingManager.listBox("Route category", "SPLITDUTY");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.pushSaveRuleButton();
        Helper.notificationControl(Constant.Ui.TOAST_DOC_RULE_UPDATED);
        docpackingManager.pushButton("Back");
    }

    @Test
    public void deleteDocument () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДОПП"});
        docpackingManager.fileLoad("GD_new86.pdf");
        docpackingManager.markCategoryPasteAfter("Особенности выполнения полётов");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "SCHENGEN VISA IS REQUIRED");
        docpackingManager.listBox("Flight type", "ALL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        docpackingManager.pushButton("Back");

        docpackingManager.textForm("Name", "GD_new86");
        docpackingManager.pushButton("Search");

        docpackingManager.deleteFirstDocumentsOfList();
        docpackingManager.pushButton("Yes");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_DELETED);
    }

    @Test
    public void createDocumentWithoutRequiredDocRuleFieldNegative () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.markCategoryPasteAfter("Документы по типу ВС");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_RULE_CONTROL);
        Helper.wait(Constant.Ui.SHORT_PAUSE);
        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[@automation-id='tui-error__text']"));
        Assert.assertEquals(6, message.size());
    }

    @Test
    public void createDocumentWithoutRequiredDocumentFieldNegative () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");

        docpackingManager.pushButton("Save");

        Helper.wait(1000);
        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[@automation-id='tui-error__text']"));
        Assert.assertEquals(4, message.size());
    }

    @Test
    public void checkRequiredFieldDocCreateForm() {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.pushButton("Save");
        Helper.wait(Constant.Ui.SHORT_PAUSE);
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_RULE_CONTROL);
        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[@automation-id='tui-error__text']"));
        Assert.assertEquals(10, message.size());
    }

    @Test
    public void searchDocumentsByCategory () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.markCategoryPasteAfter("Документы по центровке");
        docpackingManager.fileLoad("5226-IKT-OVB.pdf");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        docpackingManager.pushButton("Back");
        docpackingManager.showSidePanel();
        docpackingManager.markCategoryOnSidePanel("Документы по центровке");
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByOneField("Документы по центровке");
        int expectQty = docpackingManager.searchDocResult();
        Assert.assertTrue(actualQty >= 1);
        Assert.assertEquals(expectQty, actualQty);
    }

    @Test
    public void searchDocNameField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.markCategoryPasteAfter("Документы по ВС");
        docpackingManager.fileLoad("RA73434 MEL.pdf");
        docpackingManager.docNameField("MEL for 73434 board");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "INT");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("3");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        docpackingManager.pushButton("Back");

        docpackingManager.textForm("Name", "MEL for 73434 board");
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByOneField("MEL for 73434 board");
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertTrue(actualQty >= 1);
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocTypeField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.pushButton("Reset");
        docpackingManager.listBox("Type", "STATIC");
        //docpackingManager.textForm("Name", " GARR_Irkut");
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByType("STATIC");
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocOwnerField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДОПП"});
        docpackingManager.markCategoryPasteAfter("Документы по ВС");
        docpackingManager.fileLoad("Памятка экипажам в IKT.pdf");
        docpackingManager.docNameField("памятка для порта IKT");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "DOM");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        docpackingManager.pushButton("Back");
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        docpackingManager.listOwnerSearch(new String[]{"ДОПП"});
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByOwner();
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertTrue(actualQty >= 1);
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchByDeletedDoc () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДЛС"});
        docpackingManager.markCategoryPasteAfter("Документы по типу ВС");
        docpackingManager.fileLoad("Памятка AER.pdf");
        docpackingManager.docNameField("памятка для порта AER");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "CIS");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        docpackingManager.pushButton("Back");
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);

        docpackingManager.clickCheckBox("Deleted");
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByInactiveCheckbox();
        Assert.assertTrue(actualQty >= 1);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchAuthorDoc () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listDocTypeForm("STATIC");
        docpackingManager.listOwnerForm(new String[]{"ТХ"});
        docpackingManager.markCategoryPasteAfter("Чек-листы, анкеты, бланки");
        docpackingManager.fileLoad("ЧЕК - ЛИСТ досмотра ВС.pdf");
        docpackingManager.docNameField("тех-осмотр");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        String author = docpackingManager.getDocumentCreator();
        docpackingManager.pushButton("Back");
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.textForm("Author", author);
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByOneField(author);
        Assert.assertTrue(actualQty >= 1);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Ignore("Rewrite after develop history-service. Read request on history bookmark (value 'modify')")
    @Test
    public void searchModifierDoc () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listDocTypeForm("STATIC");
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.markCategoryPasteAfter("Документы по типу ВС");
        docpackingManager.fileLoad("5541-OVB-FRU.pdf");
        docpackingManager.docNameField("тех-осмотр-ovb-fru");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        String author = docpackingManager.getDocumentCreator();
        docpackingManager.pushButton("Back");

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.textForm("Modifier", author);
        docpackingManager.pushButton("Search");


        int actualQty = docpackingManager.searchDocByOneField(Constant.Ui.SEARCH_DOC_MODIFIER);
        Assert.assertTrue(actualQty >= 1);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocByTwoFields () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"СБП"});
        docpackingManager.markCategoryPasteAfter("Прочее");
        docpackingManager.fileLoad("test_file.pdf");
        docpackingManager.docNameField("сбп-ovb");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "CIS");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        String author = docpackingManager.getDocumentCreator();
        docpackingManager.pushButton("Back");

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.textForm("Name", "сбп-ovb");
        docpackingManager.textForm("Author", author);
        docpackingManager.pushButton("Search");

        int actualQty = docpackingManager.searchDocByTwoFields("сбп-ovb", author);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertTrue(actualQty >= 1);
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocByPeriodOfCreationFrom () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String dateFrom = "23012024";
/*
        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ТХ"});
        docpackingManager.markCategoryPasteAfter("Документы по центровке");
        docpackingManager.fileLoad("ЧЕК - ЛИСТ досмотра ВС.pdf");
        docpackingManager.dateValid("Valid from", dateFrom);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "CIS");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("10");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        docpackingManager.pushButton("Back");
*/
        docpackingManager.dateSearch("Period of creation", "From", dateFrom);
        docpackingManager.pushButton("Search");
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу period of creation " + dateFrom +
                    " документов не найдено.");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }

        int result = docpackingManager.checkSearchResult (dateFrom, docpackingManager.searchDocResult());
        Assert.assertNotEquals(0, result);
        Assert.assertEquals(docpackingManager.searchDocResult(), result);
    }

    @Test
    public void testPeriodOfCreationFromControlDateLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15011985";
        docpackingManager.dateSearch("Period of creation", "From", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period of creation", "From");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isAfter(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                        .isEqual(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodOfCreationToControlDateLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15012190";
        docpackingManager.dateSearch("Period of creation", "To", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period of creation", "To");
        System.out.println(getDate);
        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isBefore(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodOfValidityFromControlDateLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15011985";
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.dateSearch("Period of validity", "From", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period of validity", "From");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isAfter(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodOfValidityToControlDateLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15012985";
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.dateSearch("Period of validity", "To", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period of validity", "To");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isBefore(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                        .isEqual(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodOfModificationFromControlDateLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15031988";
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.dateSearch("Period of modification", "From", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period of modification", "From");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isAfter(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodOfModificationToControlDateLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15012985";
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.dateSearch("Period of modification", "To", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period of modification", "To");

        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isBefore(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                        .isEqual(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }

    @Test
    public void testValidFromControlDateLimitCreateForm () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15031988";
        docpackingManager.addDocument();
        docpackingManager.dateValid("Valid from", searchDate);

        String getDate = docpackingManager.getCalendarValue("Valid", "From");
        System.out.println(getDate);
        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isAfter(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testValidToControlDateLimitCreateForm () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "18032988";
        docpackingManager.addDocument();
        docpackingManager.dateValid("Valid to", searchDate);

        String getDate = docpackingManager.getCalendarValue("Valid", "To");
        System.out.println(getDate);
        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isBefore(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodFromControlDateLimitDocRuleForm () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "15031988";
        docpackingManager.addDocument();
        docpackingManager.dateSearch("Period", "From", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period", "From");
        System.out.println(getDate);
        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isAfter(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.LOWER_DATE_LIMIT)));
    }

    @Test
    public void testPeriodToControlDateLimitDocRuleForm () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "25053988";
        docpackingManager.addDocument();
        docpackingManager.dateSearch("Period", "To", searchDate);

        String getDate = docpackingManager.getCalendarValue("Period", "To");
        System.out.println(getDate);
        Assert.assertTrue(
                Helper.parserDate(getDate)
                        .isBefore(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)) ||
                        Helper.parserDate(getDate)
                                .isEqual(Helper.parserDate(Constant.Ui.UPPER_DATE_LIMIT)));
    }

    @Ignore("Rewrite after develop history-service. Read request on history bookmark (value 'modify')")
    @Test
    public void searchDocByPeriodOfModificationFrom () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "25092023";
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.dateSearch("Period of modification", "From", searchDate);
        docpackingManager.pushButton("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу period of modification " + searchDate +
                    " документов не найдено.");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }

        Helper.wait(1000);
        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(3000);
        driver.getDriver().findElement(By.xpath("//span[text()='History']")).click();
        String modifyXpath = "//label[@tuilabel='Action']/span[text()=' MODIFY ']" +
                "/../preceding-sibling::label[@tuilabel='Date']//span[text()='Date']" +
                "/../following-sibling::span[@class='t-content']";
        List<LocalDate> dates = new ArrayList<>();

        for (int i = 1; i <= driver.getDriver().findElements(By.xpath(modifyXpath)).size(); i++ ) {
            String xPath = "(" + modifyXpath + ")[" + i +"]";
            String d = driver.getDriver().findElement(By.xpath(xPath)).getText().substring(0,9);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
            LocalDate date = LocalDate.parse(d, formatter);
            dates.add(date);
        }

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate date2 = LocalDate.parse(searchDate, formatter2);
        int count = 0;
        for (LocalDate date : dates) {
            if (date.isAfter(date2)) {
                count++;
                break;
            }
        }
        Assert.assertNotEquals(0, count);
    }

    @Test
    public void searchDocByFlightType () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДОПП"});
        docpackingManager.markCategoryPasteAfter("Документы по ВС");
        docpackingManager.fileLoad("test_file.pdf");
        docpackingManager.docNameField("flight_type_search");
        docpackingManager.dateValid("Valid from", "01022024");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "DOM");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listBox("Dep country", "Russian Federation");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        docpackingManager.pushButton("Back");

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.pushButton("Search");

        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу flight type документов не найдено. Поиск не функционирует");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        } else {
            Assert.assertNotEquals(0, docpackingManager.searchDocResult());
            int actualQty = docpackingManager.searchDocByDocRuleField("Flight type", "MVL");
            Assert.assertTrue(actualQty > 0);
            Assert.assertEquals(docpackingManager.searchDocResult(), actualQty);
        }
    }

    @Test
    public void searchDocByCountry () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ТХ"});
        docpackingManager.markCategoryPasteAfter("Документы по ВС");
        docpackingManager.fileLoad("test_file.pdf");
        docpackingManager.docNameField("MVL_to_Belarus");
        docpackingManager.dateValid("Valid from", "01012024");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "INT");
        docpackingManager.listBox("Flight type", "MVL FROM RUSSIA");
        docpackingManager.listBox("Arr country", "Belarus");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        docpackingManager.pushButton("Back");

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.listBox("Country", "Belarus");
        docpackingManager.pushButton("Search");

        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу country документов не найдено. Поиск не функционирует");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        } else {
            Assert.assertNotEquals(0, docpackingManager.searchDocResult());
            int actualQty = docpackingManager.searchDocByDocRuleField("Country", "Belarus");
            Assert.assertTrue(actualQty > 0);
            Assert.assertEquals(docpackingManager.searchDocResult(), actualQty);
        }
    }

    @Test
    public void searchDocByAirport () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.markCategoryPasteAfter("Документы по АП прибытия");
        docpackingManager.fileLoad("test_file.pdf");
        docpackingManager.docNameField("arrive_to_Pewek");
        docpackingManager.description("сходить посмотреть на плавучую АЭС");
        docpackingManager.dateValid("Valid from", "01012024");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "DOM");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listBox("Arr airport", "PWE");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        docpackingManager.pushButton("Back");

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.listBox("Airport", "PWE");
        docpackingManager.pushButton("Search");

        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу country документов не найдено. Поиск не функционирует");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        } else {
            Assert.assertNotEquals(0, docpackingManager.searchDocResult());
            int actualQty = docpackingManager.searchDocByDocRuleField("Airport", "PWE");
            Assert.assertTrue(actualQty > 0);
            Assert.assertEquals(docpackingManager.searchDocResult(), actualQty);
        }
    }

    @Test
    public void searchDocByFlightNumber () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.textForm("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        docpackingManager.pushButton("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println(
                    "по запросу flight number документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField(
                "Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByCrew () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.listBox("Crew", Constant.Ui.SEARCH_LEG_CREW);
        docpackingManager.pushButton("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (!docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу crew документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Crew", Constant.Ui.SEARCH_LEG_CREW);
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByRouteCategory () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.listBox("Route category", "SPLITDUTY");
        docpackingManager.pushButton("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (!docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу crew документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Route category", "SPLITDUTY");
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByTechStop () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.pushButton("Show additional filters");
        docpackingManager.clickCheckBox("Tech stop");
        docpackingManager.pushButton("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (!docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу tech stop документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Tech stop", "Yes");
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void testFileSizeEqualLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.fileLoad("file50000.pdf");
    }

    @Test
    public void testFileSizeOverLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.fileLoad("file50001.pdf");

        String actualMessage = driver.getDriver()
                .findElement(By.xpath("//div[@automation-id='tui-file__content']")).getText();
        String expectMessage = Constant.Ui.TOAST_DOCUMENT_ATTACHMENT_LIMIT;
        Assert.assertEquals(expectMessage,actualMessage);
    }

    @Test
    public void testDeleteFileAttachmentOfDocTemplate () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
/*
        docpackingManager.addDocument();

        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.markCategoryPasteAfter("Документы по центровке");
        docpackingManager.docNameField("testdoc");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);

        Helper.wait(3000);
        docpackingManager.pushButton("Back");
        Helper.wait(3000);
*/
        docpackingManager.listOwnerSearch(new String[]{"ДНО"});
        docpackingManager.textForm("Name","testdoc");
        docpackingManager.pushButton("Search");
        Helper.wait(3000);
        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(15000);
        docpackingManager.clickHiddenButtonCloseFromDocTemplateForm();
        Helper.notificationControl("Delete file?");
        docpackingManager.pushButton("Cancel");
        docpackingManager.pushButton("Back");
    }

    @Test
    public void testGetDataCategory () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.showSidePanel();
        Helper.wait(1000);
        docpackingManager.showChildCategoryOnCategoryPanel();
        Helper.wait(1000);
        List<WebElement> categoryList = driver.getDriver().findElements(By.xpath("//div[@class='mdc-form-field']"));
        int count = 0;
        for (int i = 0; i <= Constant.Dictionary.DOC_CATEGORIES.size(); i++) {
            String actualName = categoryList.get(i).getText();
            System.out.println(actualName);
            for (String expectedName : Constant.Dictionary.DOC_CATEGORIES) {
                if (actualName.equals(expectedName)){
                    System.out.println(expectedName);
                    count++;
                    break;
                }
            }
        }
        Assert.assertEquals(14, count);
    }

    @Test
    public void testGetDataOwner () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.showListboxData("Owner");
        //driver.getDriver().findElement(By.xpath("//label[@tuilabel='Owner']//div[@class='t-icon t-textfield-icon ng-star-inserted']")).click();

        List<String> data = new ArrayList<>();
        Helper.wait(1000);
        for (int i = 1; i <= Constant.Dictionary.DOC_OWNERS.size(); i++) {
            WebElement ownerData = driver.getDriver().findElement(By.xpath(
                    String.format("(//tui-multi-select-option[@class='ng-star-inserted'])[%d]", i)));
            data.add(ownerData.getText());
            System.out.println(ownerData.getText());
        }
        Assert.assertEquals(data, Constant.Dictionary.DOC_OWNERS);
    }

    @Test
    public void testGetDataCountry () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.showListboxData("Country");

        Assert.assertEquals(docpackingManager.getUICountry(), Constant.Dictionary.COUNTRIES);
    }

    @Test
    public void testGetDataAirport () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.showListboxData("Airport");

        Assert.assertEquals(new HashSet<>(docpackingManager.getUIAirports()), new HashSet<>(Constant.Dictionary.AIRPORTS));
    }

    @Test
    public void testGetDataRouteCategory () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.showListboxData("Route category");
        List<String> data = new ArrayList<>();
        List<WebElement> routeCategory = driver.getDriver().findElements(By.xpath("//button[@type='button']/tui-select-option"));
        for (WebElement s : routeCategory) {
            data.add(s.getText());
        }
        Assert.assertEquals(new HashSet<>(data), new HashSet<>(Constant.Dictionary.ROUTE_CATEGORIES));
    }

    @Test
    public void testForbiddenDocNameWithSymbol () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.markCategoryPasteAfter("Основные документы");
        docpackingManager.fileLoad("AIR_IKT.pdf");
        docpackingManager.docNameField(Constant.Ui.WRONG_DOC_NAME_SYMBOLS);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.INVALID_VALUE);
    }

    @Test
    public void testForbiddenDocNameWithPunctuationMark () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДОПП"});
        docpackingManager.markCategoryPasteAfter("Основные документы");
        docpackingManager.fileLoad("AIR_IKT.pdf");
        docpackingManager.docNameField(Constant.Ui.WRONG_DOC_NAME_PUNCTUATION);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.INVALID_VALUE);
    }

    @Test
    public void testCreateDocRuleDuplicate () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.markCategoryPasteAfter("Документы по стране прибытия");
        docpackingManager.fileLoad("AIRPORT CREW INFO.pdf");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);

        docpackingManager.pushButton("Add rule");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOC_RULE_DUPLICATE);
    }

    @Test
    public void testCreateDocumentWithLimitDocNameLength () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.markCategoryPasteAfter("Документы по стране прибытия");
        docpackingManager.fileLoad("AIRPORT CREW INFO.pdf");
        docpackingManager.docNameField(Constant.Ui.DOC_NAME_255);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "FOR TRAININGS");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("10");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
    }

    @Test
    public void testCreateDocumentWithOversizeDocNameLength () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДОПП"});
        docpackingManager.markCategoryPasteAfter("Документы по стране прибытия");
        docpackingManager.fileLoad("wrongFiletype.jpg");
        docpackingManager.docNameField("wrong filetype");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "FOR TRAININGS");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("10");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_WRONG_FILE_ATTACHMENT);
    }

    @Test
    public void testCreateDocRuleWithLetterFlightNumber () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДЛС"});
        docpackingManager.markCategoryPasteAfter("Прочая информация");
        docpackingManager.fileLoad("Памятка AER.pdf");
        docpackingManager.docNameField("wrongFlightNumber");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NOT FOR CAT 166");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.textForm("Flight numbers", "ABCD");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("3");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.INVALID_VALUE);
    }

    @Test
    public void testCreateDocRuleWithIncorrectFlightNumber () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ВРАЧ"});
        docpackingManager.markCategoryPasteAfter("Сертификаты дезинсекции");
        docpackingManager.fileLoad("Сертификат дезинсекции 473.pdf");
        docpackingManager.docNameField("certificate 473");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.textForm("Flight numbers", "222");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.INVALID_VALUE);
    }

    @Test
    public void testCreateDocumentWithLimitDescriptionLength () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДЛС"});
        docpackingManager.markCategoryPasteAfter("Документы по центровке");
        docpackingManager.fileLoad("AIRPORT CREW INFO.pdf");
        docpackingManager.docNameField("test description length");
        docpackingManager.description(Constant.Ui.TEXT_FOR_DESCRIPTION_100);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "HOTAC INT");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("3");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
    }

    @Test
    public void testCreateDocumentWithOversizeDescriptionLength () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.markCategoryPasteAfter("Документы по центровке");
        docpackingManager.fileLoad("TD_TC_ARR_IKT.pdf");
        docpackingManager.docNameField("test oversize description length");
        docpackingManager.description(Constant.Ui.TEXT_FOR_DESCRIPTION_101);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "INT");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("4");
        docpackingManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_DESCRIPTION_LENGTH);
    }

    @Test
    public void testUnsaveControlFormQuitWithoutSaveDocTemplate () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.fileLoad("GD_new85.pdf");
        docpackingManager.docNameField("test quit unsave doc template");
        docpackingManager.markCategoryPasteAfter("Прочее");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "CIS");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(3000);
        docpackingManager.pushButton("Back");

        docpackingManager.textForm("Name", "unsave doc template");
        docpackingManager.pushButton("Search");

        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(5000);

        docpackingManager.description("update doc template");
        docpackingManager.pushButton("Back");
        Helper.notificationControl("Do you want to save your changes?");
    }

    @Test
    public void testUnsaveControlFormQuitWithoutSaveDocRule () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));

        docpackingManager.addDocument();
        docpackingManager.listOwnerForm(new String[]{"ЛД"});
        docpackingManager.fileLoad("GD_new86.pdf");
        docpackingManager.docNameField("test quit unsave doc rule");
        docpackingManager.markCategoryPasteAfter("Прочее");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "CIS");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listCrewForm("FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        Helper.wait(3000);
        docpackingManager.pushButton("Back");

        docpackingManager.textForm("Name", "unsave doc rule");
        docpackingManager.pushButton("Search");

        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(5000);

        docpackingManager.description("update doc rule");
        docpackingManager.pushButton("Back");
        Helper.notificationControl("Do you want to save your changes?");
    }

}


/*
@Test
    public void searchDocByPeriodOfModificationFrom () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        String searchDate = "25092023";
        docpackingManager.pushButton("Show additional filters");
        docpackingManager.dateSearch("Period of modification", "From", searchDate);
        docpackingManager.pushButton("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу period of modification " + searchDate +
                    " документов не найдено.");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }

        Helper.wait(1000);
        docpackingManager.viewFirstDocumentsOfList();
        Helper.wait(3000);
        driver.getDriver().findElement(By.xpath("//span[text()='History']")).click();
        String modifyXpath = "//label[@tuilabel='Action']/span[text()=' MODIFY ']" +
                "/../preceding-sibling::label[@tuilabel='Date']//span[text()='Date']" +
                "/../following-sibling::span[@class='t-content']";
        List<LocalDate> dates = new ArrayList<>();

        for (int i = 1; i <= driver.getDriver().findElements(By.xpath(modifyXpath)).size(); i++ ) {
            String xPath = "(" + modifyXpath + ")[" + i +"]";
            String d = driver.getDriver().findElement(By.xpath(xPath)).getText().substring(0,9);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
            formatter = formatter.withLocale(Locale.ENGLISH);
            LocalDate date = LocalDate.parse(d, formatter);
            dates.add(date);
        }

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
        formatter2 = formatter2.withLocale(Locale.ENGLISH);
        LocalDate date2 = LocalDate.parse(searchDate, formatter2);
        int count = 0;
        for (LocalDate date : dates) {
            if (date.isAfter(date2)) {

                System.out.println("найдены записи о изменении документа");
                count++;
                break;
            }
        }
        Assert.assertNotEquals(0, count);
    }
 */
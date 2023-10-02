package aero.s7.jl.autotest.ui;// Автотесты раздела Documents packing

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentsPackingTest extends TestBase {

    @Before
    public void choiceChapter () {
        headerLink("Documents Packing");
    }

    @Test
    public void newDocumentsWithAllField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("ADD DOC");
        docpackingManager.selector("Static");
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.listCatForm("Документы по стране прибытия");
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.docNameField("Инфо по Сабетте");
        docpackingManager.description("информация экипажу по прибытию");
        docpackingManager.dateValid("Valid from", "01042023");
        docpackingManager.dateValid("Valid to", "31122023");
        docpackingManager.checkBoxWhitePage();
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listBox("Dep country", "Russian Federation");
        docpackingManager.listBox("Arr country", "Russian Federation");
        docpackingManager.textForm("Dep airport", "DME");
        docpackingManager.textForm("Arr airport", "SBT");
        docpackingManager.textForm("Flight number", "3668");
        docpackingManager.listBox("Aircraft", "Airbus A320neo");
        docpackingManager.listBox("Board", "VP-BPO");
        docpackingManager.listBox("Crew", "FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.dateSearch("Period", "From", "01042023");
        docpackingManager.dateSearch("Period", "To", "31122023");
        docpackingManager.checkBox("Technical stop");
        docpackingManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Document created')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = Constant.Ui.TOAST_DOCUMENT_CREATED;
        Helper.wait(1000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newDocumentsWithRequiredField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("ADD DOC");
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.listCatForm("Документы по стране прибытия");
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listBox("Crew", "FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Document created')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = Constant.Ui.TOAST_DOCUMENT_CREATED;
        Helper.wait(1000);
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void saveEmptyDocument () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("ADD DOC");
        docpackingManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Doc need to have at least 1 rule')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = Constant.Ui.TOAST_DOCUMENT_RULE_CONTROL;
        Helper.wait(5000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void requiredFieldDocCreateForm () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("ADD DOC");
        docpackingManager.button("Save");
        Helper.wait(1000);

        List<WebElement> message = driver.getDriver().findElements(By.xpath("//div[@automation-id='tui-error__text']"));
        Assert.assertEquals(10, message.size());
    }

    @Test
    public void searchDocNameField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.textForm("Doc name", Constant.Ui.SEARCH_DOC_NAME);
        docpackingManager.button("Search");

        int actualQty = docpackingManager.searchDocByOneField(Constant.Ui.SEARCH_DOC_NAME);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocTypeField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.selector(Constant.Ui.SEARCH_DOC_TYPE);
        docpackingManager.button("Search");

        int actualQty = docpackingManager.searchDocByOneField(Constant.Ui.SEARCH_DOC_TYPE);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocOwnerField () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.listOwnerSearch(Constant.Ui.SEARCH_DOC_OWNER);
        docpackingManager.button("Search");

        int actualQty = docpackingManager.searchDocByOwner();
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchInActiveDoc () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.checkBox("Inactive");
        docpackingManager.button("Search");

        int actualQty = docpackingManager.searchDocByInactiveCheckbox();
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchCategoryDoc () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        driver.getDriver().findElement(By.xpath("//button[@title='Categroy panel']")).click();
        driver.getDriver().findElement(By.xpath(String.format("//label[text()='%s']/../div[@class='mdc-radio']", Constant.Ui.SEARCH_DOC_CATEGORY))).click();

        int actualQty = docpackingManager.searchDocByOneField(Constant.Ui.SEARCH_DOC_CATEGORY);
        int expectQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectQty, actualQty);
    }

    @Test
    public void searchAuthorDoc () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.textForm("Author", Constant.Ui.SEARCH_DOC_AUTHOR);
        docpackingManager.button("Search");

        int actualQty = docpackingManager.searchDocByOneField(Constant.Ui.SEARCH_DOC_AUTHOR);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocByTwoFields () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.textForm("Doc name", Constant.Ui.SEARCH_DOC_NAME);
        docpackingManager.selector(Constant.Ui.SEARCH_DOC_TYPE);
        docpackingManager.button("Search");

        int actualQty = docpackingManager.searchDocByTwoFields(Constant.Ui.SEARCH_DOC_NAME, Constant.Ui.SEARCH_DOC_TYPE);
        int expectedQty = docpackingManager.searchDocResult();
        Assert.assertEquals(expectedQty, actualQty);
    }

    @Test
    public void searchDocByPeriodModificationFrom () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));
        String searchDate = "25092023";
        docpackingManager.button("Show additional filters");
        docpackingManager.dateSearch("Period of modification", "From", searchDate);
        docpackingManager.button("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу period of modification" + searchDate + "документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }

        Helper.wait(1000);
        driver.getDriver().findElement(By.xpath("//button[@title='View']//span[@class='t-content']")).click();
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

    @Test
    public void searchDocByFlightType () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.button("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Flight type", "MVL");
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByCountry () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.listBox("Country", "Thailand");
        docpackingManager.button("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу country документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Country", "Thailand");
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByAirport () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.listBox("Airport", "AER");
        docpackingManager.button("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу airport документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Airport", "AER");
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByFlightNumber () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.listBox("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        docpackingManager.button("Search");

        Assert.assertNotEquals(0, docpackingManager.searchDocResult());
        if (! docpackingManager.isDocumentPresent()) {
            System.out.println("по запросу flight number документов не найдено. Сообщение о результатах поиска не корректное");
            Assert.assertTrue(docpackingManager.isDocumentPresent());
        }
        int actualCount = docpackingManager.searchDocByDocRuleField("Flight number", Constant.Ui.SEARCH_LEG_FLIGHT_NUMBER);
        Assert.assertNotEquals(0, actualCount);
        Assert.assertEquals(docpackingManager.searchDocResult(), actualCount);
    }

    @Test
    public void searchDocByCrew () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.listBox("Crew", Constant.Ui.SEARCH_LEG_CREW);
        docpackingManager.button("Search");

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
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.listBox("Crew", Constant.Ui.SEARCH_LEG_CREW);
        docpackingManager.button("Search");

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
    public void searchDocByTechStop () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("Show additional filters");
        docpackingManager.checkBox("Tech stop");
        docpackingManager.button("Search");

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
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("ADD DOC");
        docpackingManager.fileLoad("file50000.pdf");
    }

    @Test
    public void testFileSizeOverLimit () {
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents Packing"));

        docpackingManager.button("ADD DOC");
        docpackingManager.fileLoad("file50001.pdf");

        String actualMessage = driver.getDriver().findElement(By.xpath("//div[@automation-id='tui-file__content']")).getText();
        String expectMessage = Constant.Ui.TOAST_DOCUMENT_ATTACHMENT_LIMIT;
        Assert.assertEquals(expectMessage,actualMessage);
    }
}

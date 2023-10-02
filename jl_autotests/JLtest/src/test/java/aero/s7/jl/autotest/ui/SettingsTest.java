package aero.s7.jl.autotest.ui;// Автотесты раздела Settings

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SettingsTest extends TestBase {

    @Test
    public void newParentCategory () {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Catalogue Management']")).click();
        Helper.wait(5000);
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.button("ADD NEW");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category created')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Category created";
        Helper.wait(3000);
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void newParentCategorySearch () {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Catalogue Management']")).click();
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.button("ADD NEW");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.button("Save");
        settingsManager.button("Back");

        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME);
        Assert.assertTrue(isCategoryPresent);
    }

    @Test
    public void newUnderParentCategory() {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Catalogue Management']")).click();
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.button("ADD NEW");
        Helper.wait(2000);
        settingsManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME);
        settingsManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME);
        settingsManager.sortIndexForm(sortIndex);
        Helper.wait(2000);
        settingsManager.button("Save");

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath("//div[contains(text(),'Category created')]")));
        String expectedMessage = toast.getText();
        final String actualMessage = "Category created";
        Helper.wait(3000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void newUnderParentCategorySearch () {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Catalogue Management']")).click();
        settingsManager.showAllCategories();
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_NAME);
        Assert.assertTrue(isCategoryPresent);
    }

    @Test
    public void TestTdTsDeclaration() {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Add CDV Number']")).click();
        settingsManager.button("ADD NEW");
        Helper.wait(2000);
        settingsManager.dateForm("From", Constant.Ui.DATE_FROM_TD_TS);
        settingsManager.dateForm("To", Constant.Ui.DATE_TO_TD_TS);
        settingsManager.cdvForm(Constant.Ui.CDV_NUMBER);

        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30));
        String messageXpath = "//span[contains(text(),'Action successful')]";

        settingsManager.button("Save");

        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath(messageXpath)));
        String expectedMessage = toast.getText();
        final String actualMessage = "Action successful";
        Helper.wait(3000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void TestTdTsDeclarationNegative() {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Add CDV Number']")).click();
        settingsManager.button("ADD NEW");
        settingsManager.dateForm("From", Constant.Ui.DATE_FROM_TD_TS);
        settingsManager.dateForm("To", Constant.Ui.DATE_TO_TD_TS);
        settingsManager.cdvForm(Constant.Ui.CDV_NUMBER_WRONG);
        settingsManager.button("Save");
        Helper.wait(3000);
        WebElement message = driver.getDriver().findElement(By.xpath("//div[contains(text(),'Value is invalid')]"));
        String expectedMessage = message.getText();
        final String actualMessage = " Value is invalid ";

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void TestTdTsDeclarationSearch () {
        TestBase.headerLink("Settings");
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Add CDV Number']")).click();
        Helper.wait(3000);
        boolean isDocumentPresent = settingsManager.findTdTsDocument(Constant.Ui.CDV_NUMBER);
        Assert.assertTrue(isDocumentPresent);
    }

}

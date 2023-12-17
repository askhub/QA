package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SettingsManager {
    private final WebDriver driver;

    public SettingsManager (WebDriver driver) {
        this.driver = driver;
    }

    public void pushButton(final String buttonTitle) {
        String buttonXpath;
        if (buttonTitle.equals("Close")) {
            buttonXpath = "//button[@type='button']//span[contains(text(), 'Close')]" + "|" + "//button[@title='Close']";
        } else if (List.of("Document categories", "Transport declarations").contains(buttonTitle)) {
            buttonXpath = String.format("//button[contains(text(), '%s')]", buttonTitle);
        } else {
            buttonXpath = String.format("//button//span[contains(text(), '%s')]", buttonTitle);
        }
        //buttonXpath = String.format("//button[@type='button']//span[contains(text(), '%s')]", buttonTitle);
        //buttonXpath = String.format("//div[@class='create-cdv tui-space_top-3'] | //button[@type='button']//span[contains(text(), '%s')]" ,buttonTitle);
        this.driver.findElement(By.xpath(buttonXpath)).click();
        Helper.wait(500);
    }

    public void add(final String title) {
        String buttonXpath = null;
        if (title.equals("Document categories")) {
            buttonXpath = "//div[contains(text(), 'Document categories')]/../button";
        } else if (title.equals("Transport declaration")) {
            buttonXpath = "//div[contains(text(), 'Transport declarations')]/../button";
        }
        this.driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void clickCheckBox(final String chkBoxTitle) {
        String chkXpath = String.format("//div[contains(text(), '%s')]", chkBoxTitle);
        this.driver.findElement(By.xpath(chkXpath)).click();
    }

    public void parentCategoryListBox (final String parentCategory) {
        String parentListboxXpath = "//div[text()='Parent category']/../following-sibling::div//input";
        this.driver.findElement(By.xpath(parentListboxXpath)).click();
        String parentXpath = String.format("//button[@type='button']//tui-select-option[contains(text(), '%s')]", parentCategory);
        this.driver.findElement(By.xpath(parentXpath)).click();
    }

    public void categoryNaming (final String newCategoryName) {
        String nameFieldXpath = "//div[text()='Category name']/../following-sibling::div//input";
        this.driver.findElement(By.xpath(nameFieldXpath)).clear();
        this.driver.findElement(By.xpath(nameFieldXpath)).click();
        this.driver.findElement(By.xpath(nameFieldXpath)).sendKeys(newCategoryName);

    }

    public void sortIndexForm (final String index) {
        String indexFieldXpath = "//div[text()='Sort index']/../following-sibling::div//input";
        this.driver.findElement(By.xpath(indexFieldXpath)).clear();
        this.driver.findElement(By.xpath(indexFieldXpath)).click();
        this.driver.findElement(By.xpath(indexFieldXpath)).sendKeys(index);
    }

    public void viewCategory (final String categoryName) {
        String viewButtonXpath = String.format(
                "//span[text()='%s']/../following-sibling::div//button[@title='View']//span[@class='t-content']",
                categoryName);
        this.driver.findElement(By.xpath(viewButtonXpath)).click();

    }

    public void viewFuelDeclaration(final String dateFrom, final String dateTo, final String number) {
        String viewButtonXpath = String.format("//tr[@class='ng-star-inserted' and" +
                " td[contains(text(),'%s')] and" +
                " td[contains(text(),'%s')] and" +
                " td[contains(text(),'%s')]]//button[@title='View']", dateFrom, dateTo, number);
        this.driver.findElement(By.xpath(viewButtonXpath)).click();
    }

    public void dateForm (final String dateSeq, final String date) {
        String dateXpath = null;
        if (dateSeq.equals("From")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[1]";
        } else if (dateSeq.equals("To")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
        }

        WebElement dateFrm = this.driver.findElement(By.xpath(dateXpath));
        dateFrm.click();
        dateFrm.sendKeys(Keys.CLEAR);
        dateFrm.sendKeys(date);
        Helper.wait(1000);
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]",
                date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
    }

    public void fuelNumberForm(final String fuelNumber) {
        String fuelFormXpath = "//input[@type='text']";
        WebElement fuelNumberForm = this.driver.findElement(By.xpath(fuelFormXpath));
        fuelNumberForm.click();
        fuelNumberForm.sendKeys(Keys.CLEAR);
        fuelNumberForm.sendKeys(fuelNumber);
    }

    public boolean findNewCategoryInList (final String categoryName) {
        String catXpath = String.format("//span[contains(text(), '%s')]/../following-sibling::div//button", categoryName);
        if (this.driver.findElements(By.xpath(catXpath)).size()>0) {
            return true;
        } else {
            return false;
        }
    }

    public String lastSortIndexFromCategories () {

        String sortIndexXpath = "//div[@class='row ng-star-inserted' or @class='row inactive ng-star-inserted']/div[2]";
        List<WebElement> listSortIndices = this.driver.findElements(By.xpath(sortIndexXpath));

        ArrayList<Integer> sortIndexList = new ArrayList<>();
        for (WebElement index : listSortIndices) {
            int actualIndex = Integer.parseInt(index.getText());
            sortIndexList.add(actualIndex);
        }
        int value = Collections.max(sortIndexList) + 1;
        return Integer.toString(value);
    }

    public void showAllCategories () {
        Helper.wait(2000);
        String openButtonXpath = "//button[@icon='tuiIconChevronDown']";
        List<WebElement> chevronButton = this.driver.findElements(By.xpath(openButtonXpath));
        if (chevronButton.size()>0) {
            for (WebElement chevron : chevronButton) {
                chevron.click();
            }
        }
    }

    public void deleteCategoryAfterTest (final String categoryName) {
        //showAllCategories();
        String deleteXpath = String.format("//span[text()='%s']/../following-sibling::div//button[@title='Delete']" +
                "//span[@class='t-content']", categoryName);
        this.driver.findElement(By.xpath(deleteXpath)).click();
        pushButton("Yes");
        //Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_DELETED);
    }

    public boolean findCDVDocument(final String dateFrom, final String dateTo, final String number) {
        String requestXpath = String.format("//tr[@class='ng-star-inserted' and" +
                " td[contains(text(),'%s')] and" +
                " td[contains(text(),'%s')] and" +
                " td[contains(text(),'%s')]]//button[@title='View']", dateFrom, dateTo, number);
        if (this.driver.findElements(By.xpath(requestXpath)).size()>0) {
            return true;
        } else {
            return false;
        }
    }
}

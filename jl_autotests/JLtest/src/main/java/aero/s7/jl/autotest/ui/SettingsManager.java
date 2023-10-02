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

    public void button(final String buttonTitle) {
        String buttonXpath;
        if (buttonTitle.equals("Close")) {
            buttonXpath = "//button[@type='button']//span[contains(text(), 'Close')]" + "|" + "//button[@title='Close']";
        } else {
            buttonXpath = String.format("//button[@type='button']//span[contains(text(), '%s')]", buttonTitle);
            buttonXpath = String.format("//div[@class='create-cdv tui-space_top-3'] | //button[@type='button']//span[contains(text(), '%s')]" ,buttonTitle);
        }
        this.driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void checkBox (final String chkBoxTitle) {
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

    public void sortIndexForm (String index) {
        String indexFieldXpath = "//div[text()='Sort index']/../following-sibling::div//input";
        this.driver.findElement(By.xpath(indexFieldXpath)).clear();
        this.driver.findElement(By.xpath(indexFieldXpath)).click();
        this.driver.findElement(By.xpath(indexFieldXpath)).sendKeys(index);
    }

    public void viewCategory (final String categoryName) {
        String viewButtonXpath = String.format("//span[contains(text(), '%s')]/../following-sibling::div//button", categoryName);
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
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]", date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
    }

    public void cdvForm (final String cdvNumber) {
        String cdvFormXpath = "//input[@type='text']";
        WebElement cdvNumberForm = this.driver.findElement(By.xpath(cdvFormXpath));
        cdvNumberForm.click();
        cdvNumberForm.sendKeys(Keys.CLEAR);
        cdvNumberForm.sendKeys(cdvNumber);
    }

    public void viewCdvDocument (final String cdvNumber) {
        String viewButtonXpath = String.format("//td[text()='%s']/following-sibling::td//span[@class='t-content']", cdvNumber);
        this.driver.findElement(By.xpath(viewButtonXpath)).click();
    }

    public boolean findNewCategoryInList (String categoryName) {
        String catXpath = String.format("//span[contains(text(), '%s')]/../following-sibling::div//button", categoryName);
        if (this.driver.findElements(By.xpath(catXpath)).size()>0) {
            return true;
        } else {
            return false;
        }
    }

    public String lastSortIndexFromCategories () {
        showAllCategories();
        Helper.wait(1000);
        String sortIndexXpath = "//div[@class='row ng-star-inserted']/div[2]";
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

    public boolean findTdTsDocument (String name) {
        String requestXpath = String.format("//tr/td[contains(text(), '%s')]/following-sibling::td//span[@class='t-content']", name);
        //tr/td[contains(text(), '01052023/052023/3122021')]/following-sibling::td/button
        if (this.driver.findElements(By.xpath(requestXpath)).size()>0) {
            return true;
        } else {
            return false;
        }
    }
}

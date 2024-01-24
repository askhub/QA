package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.api.Administration.Category;
import aero.s7.jl.autotest.api.Specifications;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class AdministrationManager {
    private final WebDriver driver;

    public AdministrationManager(WebDriver driver) {
        this.driver = driver;
    }

    public void pushButton(final String buttonTitle) {
        Helper.wait(500);
        String buttonXpath;
        if (buttonTitle.equals("Close")) {
            buttonXpath = "//button[@type='button']//span[contains(text(), 'Close')]" + "|" + "//button[@title='Close']";
        } else if (List.of("Document categories", "Transport declarations").contains(buttonTitle)) {
            buttonXpath = String.format("//button[contains(text(), '%s')]", buttonTitle);
        } else {
            buttonXpath = String.format("//button//span[contains(text(), '%s')]", buttonTitle);
        }
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

    public void deleteCheckbox() {
        String chkXpath = "//div[@class='checkbox-center']";
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
                "//span[text()='%s']/../../following-sibling::td//button[@title='View']//span[@class='t-content']",
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
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
        } else if (dateSeq.equals("To")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[3]";
        }

        WebElement dateFrm = this.driver.findElement(By.xpath(dateXpath));
        dateFrm.clear();
        dateFrm.click();
        dateFrm.sendKeys(Keys.CLEAR);
        dateFrm.sendKeys(date);
        Helper.wait(500);
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]",
                date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
    }

    public void fuelNumberForm(final String fuelNumber) {
        String fuelFormXpath = "//input[@type='text']";
        WebElement fuelNumberForm = this.driver.findElement(By.xpath(fuelFormXpath));
        fuelNumberForm.clear();
        fuelNumberForm.click();
        fuelNumberForm.sendKeys(fuelNumber);
        fuelNumberForm.sendKeys(Keys.TAB);
    }

    public boolean findNewCategoryInList (final String categoryName) {
        String catXpath = String.format("//span[text()='%s']/../../following-sibling::td//button[@icon='tuiIconSearch']",
                categoryName);
        return this.driver.findElements(By.xpath(catXpath)).size() > 0;
    }

    public int lastSortIndexFromCategories (final String token) {
        Specifications.setupRequestSpecification (Specifications.requestSpecification(Constant.BASE_URL, token));
        List<Category> categoryData = RestAssured.given()
                .when()
                .get("/api/configuration/document-categories")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("", Category.class);
        List<Integer> sortIndexList = categoryData.stream().map(Category::getSortIndex).toList();
        return Collections.max(sortIndexList);
    }

    public void showAllCategories () {
        String openButtonXpath = "//button[@class='tui-space_right-3 tui-space_bottom-3 ng-star-inserted']";
        List<WebElement> chevronButton = this.driver.findElements(By.xpath(openButtonXpath));
        if (chevronButton.size()>0) {
            for (WebElement chevron : chevronButton) {
                chevron.click();
            }
        }
    }

    public void deleteCategory (final String categoryName) {
        String deleteXpath = String.format(
                "//span[text()='%s']/../../following-sibling::td//button[@icon='tuiIconTrash']", categoryName);
        this.driver.findElement(By.xpath(deleteXpath)).click();
        Helper.modalWindowMessageControl(Constant.Ui.MODAL_ACCEPT_DELETE);
        pushButton("Yes");
    }

    public boolean findFuelDeclaration(final String dateFrom, final String dateTo, final String number) {
        int count = 1;
        int tdFound = 0;
        boolean isNextPagePresent = false;
        String requestXpath = String.format("//tr[td[text()='%s'] and td[text()='%s'] and td[text()='%s']]" +
                "//button[@title='View']", number, dateFrom, dateTo);
        this.driver.navigate().refresh();
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent) {
                boolean found = this.driver.findElements(By.xpath(requestXpath)).size() > 0;
                if (found) {
                    tdFound++;
                    break;
                }
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (isNextPagePresent);
        return tdFound > 0;
    }

    public String modifyDate(final String date) {
        StringBuilder sb = new StringBuilder(date);
        sb.insert(2, ".");
        return String.valueOf(sb.insert(5, "."));
    }
}

package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EcrewTrackingManager {

    private final WebDriver driver;

    public EcrewTrackingManager (WebDriver driver) {
        this.driver = driver;
    }

    public void textForm (String nameForm, String searchText) {
        String formXpath = String.format("//label[@tuilabel='%s']//input[@type='text']", nameForm);
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(searchText);
        Helper.wait(500);
    }

    public void button (String buttonTitle) {
        String buttonXpath = String.format("//button[@type='button']//span[contains(text(), '%s')]", buttonTitle);
        this.driver.findElement(By.xpath(buttonXpath)).click();
        //Helper.wait(300);
    }

    public void sortButton (String buttonTitle) {
        String buttonXpath = String.format("//button[text()='%s']", buttonTitle);
        this.driver.findElement(By.xpath(buttonXpath)).click();
        Helper.wait(300);
    }

    public void listBox (String listTitle, String listValue) {
        String listTitleXpath = null;
        if (Objects.equals("Carrier", listTitle)) {
            listTitleXpath = String.format("//label[@tuilabel='%s']" +
                    "//input[@automation-id='tui-primitive-textfield__native-input']", listTitle);
        } else if (Objects.equals("Crew", listTitle)){
            listTitleXpath = String.format("//label[@tuilabel='%s']//input[@type='text']", listTitle);
        }
        this.driver.findElement(By.xpath(listTitleXpath)).click();
        Helper.wait(500);
        String listValueXpath;
        listValueXpath = String.format("//button[@type='button']//*[contains(text(), '%s')]", listValue);

        this.driver.findElement(By.xpath(listValueXpath)).click();
        Helper.wait(500);

    }

    public void dateSearch (String dateTitle, String date) {
        String dateXpath = String.format("//label[@tuilabel='%s']" +
                "//input[@automation-id='tui-primitive-textfield__native-input']", dateTitle);
        WebElement dateFrm = this.driver.findElement(By.xpath(dateXpath));
        dateFrm.clear();
        dateFrm.click();
        dateFrm.sendKeys(date);
        Helper.wait(500);
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]", date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
        Helper.wait(500);
    }

    public boolean findDocument (String request) {
        String requestXpath = String.format("//tr/td[contains(text(), '%s')]" +
                "/following-sibling::td/button[@title='View']//fa-icon", request);
        return this.driver.findElements(By.xpath(requestXpath)).size() > 0;
    }

    public int searchDocResult() {
        int result = 0;
        try {
            final String messageXpath = "//div[@class='search-result']";
            String qty = this.driver.findElement(By.xpath(messageXpath)).getText();
            String[] array = qty.split(" ");
            result = Integer.parseInt(array[array.length -1]);
        } catch (NumberFormatException e) {
            System.out.println("в сообщении о результатах поиска не число");
        }
        return result;
    }

    public int searchDocByOneField (String request) {
        List<WebElement> docList;
        int docFound = 0;
        int count = 1;
        boolean isNextPagePresent = false;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent) {
                final String searchXpath = String.format("//tr/td[contains(text(), '%s')]" +
                                "/following-sibling::td/button[@title='View']//span[@class='t-content']", request);
                Helper.wait(500);
                docList = this.driver.findElements(By.xpath(searchXpath));
                docFound = docFound + docList.size();
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (isNextPagePresent);
        return docFound;
    }

    public int searchDocByTwoFields(String first, String second) {
        List<WebElement> docList;
        int docFound = 0;
        int count = 1;
        boolean isNextPagePresent = false;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent) {
                final String searchXpath = String.format("//tr[td[contains(text(),'%s')] and td[contains(text(),'%s')]]//button[@title='View']//span[@class='t-content']", first, second);
                Helper.wait(500);
                docList = this.driver.findElements(By.xpath(searchXpath));
                docFound = docFound + docList.size();
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (isNextPagePresent);
        return docFound;
    }

    public String dateFormatConverter(String date) {
        String oldFormat = "ddmmyyyy";
        String newFormat = "dd.mm.yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
        Date d;
        try {
            d = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        dateFormat.applyPattern(newFormat);
        return dateFormat.format(d);
    }

    public void airportField (String title, String iata) {
        String fieldXpath = String.format("//label[@tuilabel='%s']//input[@type='text']", title);
        String valueXpath = String.format("//ng-dropdown-panel//span[contains(text(), '%s')]", iata);
        WebElement field = this.driver.findElement(By.xpath(fieldXpath));
        field.click();
        field.sendKeys(iata);
        this.driver.findElement(By.xpath(valueXpath)).click();
    }

    public void sendEmail (String email) {
        this.driver.findElement(By.xpath("//button[@title='Send mail']//span[@class='t-left ng-star-inserted']")).click();
        this.driver.findElement(By.xpath("//input[@type='email']")).click();
        this.driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        Helper.wait(3000);
        this.driver.findElement(By.xpath("//button[@icon='tuiIconMailLarge']")).click();
    }

    public void downloadFlightTask (String value) {
        String downloadXpath = "//button[@title='Download']//span";
        boolean isPresent = this.driver.findElements(By.xpath(downloadXpath)).size()>0;
        try {
            if (isPresent) {
                this.driver.findElement(By.xpath(downloadXpath)).click();
            }
        } catch (NoSuchElementException n) {
            System.out.println("Элемент ("+ downloadXpath + ") не найден");
        }
        if (value.equals("Get existing")) {
            this.driver.findElement(By.xpath("//button[@type='button']//span[text()=' Get existing ']")).click();
        } else if (value.equals("Create new")) {
            this.driver.findElement(By.xpath("//button[@type='button']//span[text()=' Create new ']")).click();
        }
    }

    public List<String> picCheck() {
        List<String> picList = new ArrayList<>();
        String emptyPic = null;
        int count = 1;
        Boolean isNextPagePresent = null;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            Boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent.equals(true)) {
                Helper.wait(300);
                for (int i = 1; i<=20; i++) {
                    Boolean isVisible = this.driver.findElements(By.xpath(String.format("(//tr//td[5])[%s]", i))).size() > 0;
                    if (isVisible.equals(true)) {
                        picList.add(this.driver.findElement(By.xpath(String.format("(//tr//td[5])[%s]", i))).getText());
                        if (Objects.equals(picList.get(i - 1), "")) {
                            emptyPic = picList.get(i - 1);
                            break;
                        }
                    }
                }
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent.equals(true)) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while ((!Objects.equals(emptyPic, "")) && Objects.equals(isNextPagePresent, true));
        return picList;
    }

    public List<String> airportCollect(String columnTitle) {
        List<String> airportList = new ArrayList<>();
        String emptyAirportField = null;
        int count = 1;
        Boolean isNextPagePresent = null;
        String airportXpath = null;
        if (columnTitle.equals("DEP")) {
            airportXpath = "//tr//td[3]";
        } else if (columnTitle.equals("ARR")) {
            airportXpath = "//tr//td[4]";
        }
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            Boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent.equals(true)) {
                Helper.wait(300);
                for (int i = 1; i<=20; i++) {
                    Boolean isVisible = this.driver.findElements(By.xpath(String.format("(%s)[%s]", airportXpath, i))).size() > 0;
                    if (isVisible.equals(true)) {
                        airportList.add(this.driver.findElement(By.xpath(String.format("(%s)[%s]", airportXpath, i))).getText());
                        if (Objects.equals(airportList.get(i - 1), "")) {
                            emptyAirportField = airportList.get(i - 1);
                            break;
                        }
                    }
                }
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent.equals(true)) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while ((!Objects.equals(emptyAirportField, "")) && Objects.equals(isNextPagePresent, true));
        return airportList;
    }
}

/*
public List<String> picCheck() {
        List<String> picList = new ArrayList<>();
        int count = 1;
        Boolean isNextPagePresent = null;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            Boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent.equals(true)) {
                Helper.wait(500);
                for (int i = 1; i<=20; i++) {
                    Boolean isVisible = this.driver.findElements(By.xpath(String.format("(//tr//td[5])[%s]", i))).size() > 0;
                    if (isVisible.equals(true)) {
                        picList.add(this.driver.findElement(By.xpath(String.format("(//tr//td[5])[%s]", i))).getText());
                    }
                }
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent.equals(true)) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (Objects.equals(isNextPagePresent, true));
        return picList;
    }
 */

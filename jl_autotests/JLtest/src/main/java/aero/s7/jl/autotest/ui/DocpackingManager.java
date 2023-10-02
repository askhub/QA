package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class DocpackingManager {
    private final WebDriver driver;

    public DocpackingManager (WebDriver driver) {
        this.driver = driver;
    }

    public void textForm (String nameForm, String searchText) {
        String formXpath = String.format("//label[@tuilabel='%s']//input[@id='uniqueId']", nameForm);
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(searchText);
        Helper.wait(1000);
    }

    public void button (String buttonTitle) {
        String buttonXpath = String.format("//button//span[contains(text(), '%s')]", buttonTitle);
        this.driver.findElement(By.xpath(buttonXpath)).click();
        //Helper.wait(5000);
    }

    public void selector (String selectTitle) {
        String selectXpath = String.format("//tui-radio-block[@item='%s']", selectTitle);
        Helper.wait(1000);
        this.driver.findElement(By.xpath(selectXpath)).click();
    }

    public void dateSearch (String dateTitle, String dateSeq, String date) {
        String dateXpath;
        if (dateSeq.equals("From")) {
            dateXpath = String.format("(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[1]", dateTitle);
        }
        else {
            dateXpath = String.format("(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[2]", dateTitle);
        }
        WebElement dateFrm = this.driver.findElement(By.xpath(dateXpath));
        dateFrm.click();
        dateFrm.sendKeys(date);
        Helper.wait(1000);
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]", date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
        Helper.wait(1000);
    }

    public void checkBox (String chkBoxTitle) {
        String chkXpath = String.format("//label[@tuilabel='%s']//input[@class='t-native']", chkBoxTitle);
        this.driver.findElement(By.xpath(chkXpath)).click();
    }

    public void listBox (String listTitle, String listValue) {
        String listTitleXpath;
        if (List.of("Country", "Route category", "Aircraft", "Airport", "Board", "Carrier", "Dep country", "Arr country").contains(listTitle)) {
            listTitleXpath = String.format("//label[@tuilabel='%s']" +
                    "//input[@automation-id='tui-primitive-textfield__native-input']", listTitle);
        }
        else {
            listTitleXpath = String.format("//label[@tuilabel='%s']//input[@type='text']", listTitle);
        }
        this.driver.findElement(By.xpath(listTitleXpath)).click();
        Helper.wait(1000);
        String listValueXpath;
        listValueXpath = String.format("//button[@type='button']//*[text()= ' %s ']", listValue);

        WebElement value = this.driver.findElement(By.xpath(listValueXpath));
        if (listTitle.equals("Aircraft")) {
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(value);
            Actions action = new Actions(driver);
            action.scrollFromOrigin(scrollOrigin, 0, 100);
            action.perform();
        }
        value.click();
        Helper.wait(1000);
    }

    public void listOwnerSearch (final String[] department) {
        String ownerXpath = "//label[@tuilabel='Owner']//input[@automation-id='tui-input-tag__native']";
        this.driver.findElement(By.xpath(ownerXpath)).click();
        Helper.wait(1000);
        for (String s : department) {
            String ownerListXpath = switch (s) {
                case "ЛД" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ЛД')]";
                case "ДНО" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДНО')]";
                case "ДЛС" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДЛС')]";
                case "ВРАЧ" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ВРАЧ')]";
                case "ТХ" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ТХ')]";
                case "ДОПП" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДОПП')]";
                case "СБП" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'СБП')]";
                default -> "//button[@type='button']//tui-multi-select-option[@class='ng-star-inserted']";
            };
            this.driver.findElement(By.xpath(ownerListXpath)).click();
        }
        String closeListXpath = "//label[@tuilabel='Owner']//*[@automation-id='tui-multi-select__arrow']";
        this.driver.findElement(By.xpath(closeListXpath)).click();
        Helper.wait(1000);
    }

    public void listOwnerForm (final String[] department) {
        String ownerXpath = "//tui-multi-select[@formcontrolname='docOwnerIds']";
        this.driver.findElement(By.xpath(ownerXpath)).click();
        Helper.wait(1000);
        for (String s : department) {
            String ownerListXpath = switch (s) {
                case "ЛД" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ЛД')]";
                case "ДНО" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДНО')]";
                case "ДЛС" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДЛС')]";
                case "ВРАЧ" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ВРАЧ')]";
                case "ТХ" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ТХ')]";
                case "ДОПП" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДОПП')]";
                case "СБП" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'СБП')]";
                default -> "//tui-multi-select-option[@class='ng-star-inserted']";

            };
        this.driver.findElement(By.xpath(ownerListXpath)).click();
        }
        String closeListXpath = "//div[text()='Owner']/../following-sibling::div" +
                "//*[@automation-id='tui-multi-select__arrow']";
        this.driver.findElement(By.xpath(closeListXpath)).click();
        Helper.wait(1000);
    }

    public void listCatForm (String docCategory) {
        String listCatXpath = "//tui-select[@formcontrolname='docCategoryId']//input";
        String docCatXpath;
        docCatXpath = String.format("//button[@type='button']//tui-select-option[contains(text(),' %s ')]", docCategory);
        this.driver.findElement(By.xpath(listCatXpath)).click();
        this.driver.findElement(By.xpath(docCatXpath)).click();
        Helper.wait(1000);
    }

    public void fileLoad (String fileName) {
        File file = new File("src/main/resources/static_docs/" + fileName);
        String absolutePath = file.getAbsolutePath();
        this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absolutePath);
        Helper.wait(2000);
    }

    // если нужно изменить DOC NAME, подставленный по имени файла
    public void docNameField (String docName) {
        WebElement docFld = this.driver.findElement(By.xpath("(//input[@id='uniqueId'])[1]"));
        docFld.clear();
        docFld.click();
        docFld.sendKeys(docName);

    }

    public void description (String docDescription) {
        WebElement descFld = this.driver.findElement(By.xpath("//textarea[@automation-id='tui-text-area__native']"));
        descFld.click();
        descFld.sendKeys(docDescription);
        Helper.wait(1000);
    }

    public void dateValid (String valid, String date) {
        String dateXpath;
        if (valid.equals("Valid from")) {
            dateXpath = "//tui-input-date[@formcontrolname='validityPeriodStart']" +
                    "//*[@automation-id='tui-primitive-textfield__native-input']";
            //WebElement validFrom;
            this.driver.findElement(By.xpath(dateXpath)).clear();
            Helper.wait(500);
            this.driver.findElement(By.xpath(dateXpath)).click();
            Helper.wait(500);
            this.driver.findElement(By.xpath(dateXpath)).sendKeys(date);
        }
        else if (valid.equals("Valid to")){
            dateXpath = "//tui-input-date[@formcontrolname='validityPeriodEnd']" +
                    "//input[@automation-id='tui-primitive-textfield__native-input']";
            WebElement validTo = this.driver.findElement(By.xpath(dateXpath));
            validTo.click();
            Helper.wait(500);
            validTo.sendKeys(date);
        }
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']" +
                "//div[@class='t-item'])[%s]", date.substring(0, 2));
        Helper.wait(500);
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
        Helper.wait(1000);
    }

    public void checkBoxWhitePage () {
        this.driver.findElement(By.xpath("//div[@class='form-input']//input[@type='checkbox']")).click();
        Helper.wait(1000);
    }

    public void copiesDocRule (String quantity) {
        String formXpath = "//label[@tuilabel='Copies']//input[@type='text']";
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(quantity);
        Helper.wait(1000);
    }

    public void markPasteAfter (String nameCat,String nameDoc) {
        String parentXpath = String.format("//label[text()='%s']/../../following-sibling::button", nameCat);
        Boolean isPresent = driver.findElements(By.xpath(parentXpath)).size() > 0;
        String pasteDocXpath;
        if (isPresent.equals(true)) {
            // есть дочерние элементы
            this.driver.findElement(By.xpath(parentXpath)).click();
            pasteDocXpath = String.format("//div[contains(text(),' %s ')]", nameDoc);
        } else {
            // нет дочерних элементов
            pasteDocXpath = String.format("//div[contains(text(),' %s ')]", nameCat);
        }
        this.driver.findElement(By.xpath(pasteDocXpath)).click();
        Helper.wait(1000);
    }

    public int searchDocResult() {
        int result = 0;
        Helper.wait(2000);
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
                final String searchXpath = String.format("//td[contains(text(),'%s')]/following-sibling::" +
                        "td[@class='ng-star-inserted']//fa-icon", request);
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

    public int searchDocByOwner() {
        List<WebElement> docList;
        int docFound = 0;
        int count = 1;
        Boolean isNextPagePresent = null;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']" +
                    "//span[text()=' " + count + " ']";
            Boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent.equals(true)) {
                final String searchXpath = searchRequestXpath(Constant.Ui.SEARCH_DOC_OWNER);
                Helper.wait(500);
                docList = this.driver.findElements(By.xpath(searchXpath));
                docFound = docFound + docList.size();
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent.equals(true)) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (Objects.equals(isNextPagePresent, true));
        return docFound;
    }

    public String searchRequestXpath (String[] arr) {
        int elements = arr.length;
        String xpath = switch (elements) {
            case 1 -> String.format("//td[contains(text(), '%s')]", arr[0]);
            case 2-> String.format("//td[contains(text(), '%s') " +
                    "or contains(text(), '%s')]", arr[0], arr[1]);
            case 3 -> String.format("//td[contains(text(), '%s') " +
                    "or contains(text(), '%s') " +
                    "or contains(text(), '%s')]", arr[0], arr[1], arr[2]);
            case 4 -> String.format("//td[contains(text(), '%s') " +
                    "or contains(text(), '%s') " +
                    "or contains(text(), '%s') " +
                    "or contains(text(), '%s')]", arr[0], arr[1], arr[2], arr[3]);
            case 5 -> String.format("//td[contains(text(), '%s') " +
                    "or contains(text(), '%s') " +
                    "or contains(text(), '%s') " +
                    "or contains(text(), '%s') " +
                    "or contains(text(), '%s')]", arr[0], arr[1], arr[2], arr[3], arr[4]);
            case 6 -> String.format("//td[contains(text(), '%s') " +
                    "or contains(text(),'%s') " +
                    "or contains(text(),'%s') " +
                    "or contains(text(),'%s') " +
                    "or contains(text(),'%s') " +
                    "or contains(text(),'%s')]", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
            default -> "//td[contains(text(),'ЛД')";
        };
        return xpath;
    }

    public int searchDocByInactiveCheckbox() {
        List<WebElement> docList;
        int docFound = 0;
        int count = 1;
        Boolean isNextPagePresent = null;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            Boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent.equals(true)) {
                Helper.wait(500);
                docList = this.driver.findElements(By.cssSelector("tr[class='not-active ng-star-inserted']"));
                docFound = docFound + docList.size();
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent.equals(true)) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (Objects.equals(isNextPagePresent, true));
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

    public int searchDocByDocRuleField (String field, String value) {

        int page = 1;
        int count = 0;
        boolean isNextPagePresent = false;
        do {
            Helper.wait(1000);
            String viewIcon = "//button[@title='View']//span[@class='t-content']";
            for (int i = 1; i <= this.driver.findElements(By.xpath(viewIcon)).size(); i++) {
                this.driver.findElement(By.xpath("(" + viewIcon + ")[" + i + "]")).click();
                Helper.wait(3000);

                final String xPath = switch (field) {
                    case "Flight type" -> "//label[@tuilabel='Flight type']//span[@class='t-content']";
                    case "Country" ->
                            "//label[@tuilabel='Dep country' or @tuilabel='Arr country']//span[@class='t-content']";
                    case "Airport" ->
                            "//label[@tuilabel='Dep airport' or @tuilabel='Arr airport']//span[@class='t-content']";
                    case "Flight number" -> " //label[@tuilabel='Flight number']//span[@class='t-content']";
                    case "Crew" -> "//label[@tuilabel='Crew']//span[@class='t-content']";
                    case "Route category" -> "//label[@tuilabel='Route category']//span[@class='t-content']";
                    case "Tech stop" -> "//label[@tuilabel='Technical stop']//*[@class='t-content']";
                    default -> throw new IllegalArgumentException("oops, data wrong!");
                };

                for (int j = 1; j <= this.driver.findElements(By.xpath(xPath)).size(); j++) {
                    String ruleXpath = "(" + xPath + ")[" + j + "]";
                    String actualValue = this.driver.findElement(By.xpath(ruleXpath)).getText();
                    if (actualValue.equals(value)) {
                        count++;
                        break;
                    }
                }
                button("Back");
            }
            String nextPage = "//button[@automation-id='tui-pagination__element']" +
                    "//span[text()=' " + (page + 1) + " ']";
            isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
            if (isNextPagePresent) {
                this.driver.findElement(By.xpath(nextPage)).click();
                page++;
            }
        } while (isNextPagePresent);

        return count;
    }

    public boolean isDocumentPresent () {
        return this.driver.findElements(By.xpath("//button[@title='View']//span[@class='t-content']")).size() > 0;
    }
}

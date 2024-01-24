package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DocpackingManager {
    private final WebDriver driver;

    public DocpackingManager (WebDriver driver) {
        this.driver = driver;
    }

    public void textForm (final String nameForm, final String enterText) {
        String formXpath = String.format("//label[@tuilabel='%s']//input[@id='uniqueId']", nameForm);
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(enterText);
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void pushButton(final String buttonTitle) {
        String buttonXpath = null;
        if (List.of("Document categories", "Transport declarations").contains(buttonTitle)) {
            buttonXpath = String.format("//button[contains(text(), '%s')]", buttonTitle);
        } else {
            buttonXpath = String.format("//button//span[contains(text(), '%s')]", buttonTitle);
        }
        this.driver.findElement(By.xpath(buttonXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void pushSaveRuleButton () {
        String buttonXpath = "//h2[text()='Edit rule']/..//button//span[contains(text(), 'Save')]";
        this.driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void addDocument() {
        String buttonXpath = "//div[contains(text(), 'Documents')]/../button";
        this.driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void dateSearch (final String dateTitle, final String dateSeq, final String date) {
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
        Helper.wait(Constant.Ui.SHORT_PAUSE);
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]", date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
        //Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void clickCheckBox(final String chkBoxTitle) {
        String chkXpath = String.format("//label[@tuilabel='%s']//input[@class='t-native']", chkBoxTitle);
        this.driver.findElement(By.xpath(chkXpath)).click();
    }

    public void markCategoryOnSidePanel(final String category) {
        String chkXpath = String.format("//div[@class='mdc-form-field']//label[text()='%s']", category);
        this.driver.findElement(By.xpath(chkXpath)).click();
    }

    public void listBox (final String listTitle, final String listValue) {
        String listTitleXpath;
        if (List.of("Country", "Route category", "Aircraft", "Board", "Carrier", "Dep country", "Arr country").contains(listTitle)) {
            listTitleXpath = String.format("//label[@tuilabel='%s']" +
                    "//input[@automation-id='tui-primitive-textfield__native-input']", listTitle);
        }
        else {
            listTitleXpath = String.format("//label[@tuilabel='%s']//input[@type='text']", listTitle);
        }
        WebElement field = this.driver.findElement(By.xpath(listTitleXpath));
        field.click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
        String listValueXpath;
        if (List.of("Dep airport", "Arr airport", "Airport").contains(listTitle)) {
            field.sendKeys(listValue);
            listValueXpath = String.format("//span[text()='%s']", listValue);
        } else {
            listValueXpath = String.format("//button[@type='button']//*[text()= ' %s ']", listValue);
        }

        WebElement value = this.driver.findElement(By.xpath(listValueXpath));
        if (listTitle.equals("Aircraft")) {
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(value);
            Actions action = new Actions(driver);
            action.scrollFromOrigin(scrollOrigin, 0, 100);
            action.perform();
        }
        value.click();
        //Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void listOwnerSearch (final String[] department) {
        //String ownerXpath = "//label[@tuilabel='Owner']//input[@automation-id='tui-input-tag__native']";
        String ownerXpath = "//label[@tuilabel='Owner']//div[@class='t-icons t-icon-wrapper ng-star-inserted']";
        this.driver.findElement(By.xpath(ownerXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
        for (String s : department) {
            String ownerListXpath = switch (s) {
                /*case "ЛД" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ЛД')]";
                case "ДНО" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДНО')]";
                case "ДЛС" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДЛС')]";
                case "ВРАЧ" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ВРАЧ')]";
                case "ТХ" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ТХ')]";
                case "ДОПП" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'ДОПП')]";
                case "СБП" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'СБП')]";*/
                case "ЛД" -> "//button[@type='button']//span[contains(text(), 'ЛД')]/preceding-sibling::tui-primitive-checkbox";
                case "ДНО" -> "//button[@type='button']//span[contains(text(), 'ДНО')]/preceding-sibling::tui-primitive-checkbox";
                case "ДЛС" -> "//button[@type='button']//span[contains(text(), 'ДЛС')]/preceding-sibling::tui-primitive-checkbox";
                case "ВРАЧ" -> "//button[@type='button']//span[contains(text(), 'ВРАЧ')]/preceding-sibling::tui-primitive-checkbox";
                case "ТХ" -> "//button[@type='button']//span[contains(text(), 'ТХ')]/preceding-sibling::tui-primitive-checkbox";
                case "ДОПП" -> "//button[@type='button']//span[contains(text(), 'ДОПП')]/preceding-sibling::tui-primitive-checkbox";
                case "СБП" -> "//button[@type='button']//span[contains(text(), 'СБП')]/preceding-sibling::tui-primitive-checkbox";
                default -> "//button[@type='button']//tui-multi-select-option[@class='ng-star-inserted']";
            };
            this.driver.findElement(By.xpath(ownerListXpath)).click();
        }
        String closeListXpath = "//label[@tuilabel='Owner']//*[@automation-id='tui-multi-select__arrow']";
        this.driver.findElement(By.xpath(closeListXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void listOwnerForm (final String[] department) {
        String ownerXpath = "//tui-multi-select[@formcontrolname='docOwnerIds']";
        this.driver.findElement(By.xpath(ownerXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
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
        String closeListXpath = "//div[text()='Owner']/..//div[@class='t-icon t-textfield-icon ng-star-inserted']";
        this.driver.findElement(By.xpath(closeListXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void listDocTypeForm (final String docType) {
        String listDocTypeXpath = "//div[text()='Type']/..//div[@automation-id='tui-primitive-textfield__wrapper']/input";
        String docTypeValueXpath = String.format(
                "//span[@class='t-content ng-star-inserted'][text()=' %s ']", docType);
        this.driver.findElement(By.xpath(listDocTypeXpath)).click();
        this.driver.findElement(By.xpath(docTypeValueXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void listCrewForm (final String crewType) {
        String listCrewXpath = "//label[@tuilabel='Crew']//input[@type='text']";
        String docCrewXpath;
        docCrewXpath = String.format("//button[@type='button']//span[text()=' %s ']", crewType);
        this.driver.findElement(By.xpath(listCrewXpath)).click();
        this.driver.findElement(By.xpath(docCrewXpath)).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void fileLoad (final String fileName) {
        File file = new File("src/main/resources/static_docs/" + fileName);
        String absolutePath = file.getAbsolutePath();
        this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absolutePath);
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
    }

    // если нужно изменить DOC NAME, подставленный по имени файла
    public void docNameField (final String docName) {
        WebElement docFld = this.driver.findElement(By.xpath("(//input[@id='uniqueId'])[1]"));
        docFld.clear();
        docFld.click();
        docFld.sendKeys(docName);
    }

    public void description (final String docDescription) {
        WebElement descFld = this.driver.findElement(By.xpath("//textarea[@automation-id='tui-text-area__native']"));
        descFld.click();
        descFld.sendKeys(docDescription);
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void dateValid (final String valid, final String date) {
        String dateXpath;
        if (valid.equals("Valid from")) {
            dateXpath = "//tui-input-date[@formcontrolname='validityPeriodStart']" +
                    "//*[@automation-id='tui-primitive-textfield__native-input']";
            //WebElement validFrom;
            this.driver.findElement(By.xpath(dateXpath)).clear();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            this.driver.findElement(By.xpath(dateXpath)).click();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            this.driver.findElement(By.xpath(dateXpath)).sendKeys(date);
        }
        else if (valid.equals("Valid to")){
            dateXpath = "//tui-input-date[@formcontrolname='validityPeriodEnd']" +
                    "//input[@automation-id='tui-primitive-textfield__native-input']";
            WebElement validTo = this.driver.findElement(By.xpath(dateXpath));
            validTo.click();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            validTo.sendKeys(date);
        }
        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']" +
                "//div[@class='t-item'])[%s]", date.substring(0, 2));
        Helper.wait(Constant.Ui.SHORT_PAUSE);
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
        //Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void checkBoxWhitePage () {
        this.driver.findElement(By.xpath("//div[@class='form-input']//input[@type='checkbox']")).click();
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void copiesDocRule (final String quantity) {
        String formXpath = "//label[@tuilabel='Copies']//input[@type='text']";
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(quantity);
        Helper.wait(Constant.Ui.SHORT_PAUSE);
    }

    public void markCategoryPasteAfter (final String categoryName) {
        showAllPasteAfterTree();
        String catXpath = String.format("//label[text()='%s']/preceding-sibling::div[@class='mdc-radio']", categoryName);
        Boolean isPresent = driver.findElements(By.xpath(catXpath)).size() > 0;

        if (isPresent.equals(true)) {
            this.driver.findElement(By.xpath(catXpath)).click();
        } else {
            System.out.println("doc-category" + categoryName + "not found");
        }
    }

    public void showAllPasteAfterTree() {
        String xPath = "//div[@class='tui-island__content']//button[@type='button']";
        List<WebElement> arrowButtons = this.driver.findElements(By.xpath(xPath));
        for (WebElement arrow : arrowButtons) {
            arrow.click();
        }
    }

    public int searchDocResult() {
        int result = 0;
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        try {
            final String messageXpath = "//div[@class='tui-space_left-5 search-result ng-star-inserted']";
            String qty = this.driver.findElement(By.xpath(messageXpath)).getText();
            String[] array = qty.split(" ");
            result = Integer.parseInt(array[array.length -1]);
        } catch (NumberFormatException e) {
            System.out.println("в сообщении о результатах поиска не число");
        }
        return result;
    }

    public int searchDocByOneField (final String request) {
        Helper.wait(Constant.Ui.MIDDLE_PAUSE);
        List<WebElement> docList;
        int docFound = 0;
        int count = 1;
        boolean isNextPagePresent = false;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent) {
                final String searchXpath = String.format("//td[contains(text(),'%s')]/following-sibling::" +
                        "td[@class='ng-star-inserted']//button[@title='View']", request);
                Helper.wait(Constant.Ui.SHORT_PAUSE);
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
                Helper.wait(Constant.Ui.SHORT_PAUSE);
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

    public int searchDocByType (final String searchRequest) {
        final String staticTypeIconTagName = "tuiIconFile";
        final String dynamicTypeIconTagName = "tuiIconFileText";
        int staticDocFound = 0;
        int dynamicDocFound = 0;
        int docFound = 0;
        int count = 1;
        Boolean isNextPagePresent = false;
        int pageSize = Integer.parseInt(this.driver.findElement(By.xpath(
                "//div[@class='pagination-actions']//input[@automation-id='tui-primitive-textfield__native-input']"))
                .getAttribute("value"));
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']" +
                    "//span[text()=' " + count + " ']";
            Boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent.equals(true)) {
                for(int i = 1; i <= pageSize; i++) {
                     final String iconTypeXpath = String.format("(//tr/td[1]//*[name()='use'])[%d]", i);
                     Boolean isExist = this.driver.findElements(By.xpath(iconTypeXpath)).size() > 0;
                     if(isExist.equals(true)) {
                         final String iconNameXpath = this.driver.findElement(By.xpath(iconTypeXpath))
                                 .getAttribute("xlink:href");
                         String[] tagName = iconNameXpath.split("#");
                         final String iconName = tagName[tagName.length - 1];
                         if (searchRequest.equals("STATIC")) {
                             if (iconName.equals(staticTypeIconTagName))
                                 staticDocFound = staticDocFound + 1;
                         } else if (searchRequest.equals("DYNAMIC")) {
                             if (iconName.equals(dynamicTypeIconTagName))
                                 dynamicDocFound = dynamicDocFound + 1;
                         }
                     } else {
                         break;
                     }
                 }
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                                 "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent.equals(true)) {
                     this.driver.findElement(By.xpath(nextPage)).click();
                     count++;
                } else {
                    break;
                }
            }
        } while (Objects.equals(isNextPagePresent, true));
        if(searchRequest.equals("STATIC")) {
            docFound = staticDocFound;
        } else if (searchRequest.equals("DYNAMIC")) {
            docFound = dynamicDocFound;
        }
        return docFound;
    }

    public String searchRequestXpath (final String[] arr) {
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
            default -> "//td[contains(text(),'ЛД')"; // выбор произвольного
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
                Helper.wait(Constant.Ui.SHORT_PAUSE);
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

    public int searchDocByTwoFields(final String first, final String second) {
        List<WebElement> docList;
        int docFound = 0;
        int count = 1;
        boolean isNextPagePresent = false;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent) {
                final String searchXpath = String.format("//tr[td[contains(text(),'%s')] and td[contains(text(),'%s')]]//button[@title='View']//span[@class='t-content']", first, second);
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

    public int searchDocByDocRuleField (final String searchField, final String searchRequest) {

        int page = 1;
        int count = 0;
        boolean isNextPagePresent = false;
        do {
            String viewIcon = "//button[@title='View']//span[@class='t-content']";
            for (int i = 1; i <= this.driver.findElements(By.xpath(viewIcon)).size(); i++) {
                this.driver.findElement(By.xpath("(" + viewIcon + ")[" + i + "]")).click();
                Helper.wait(Constant.Ui.MIDDLE_PAUSE);

                final String xPath = switch (searchField) {
                    case "Flight type" -> "//label[@tuilabel='Flight type']//span[@class='t-content']";
                    case "Country" ->
                            "//label[@tuilabel='Dep country' or @tuilabel='Arr country']//span[@class='t-content']";
                    case "Airport" ->
                            "//label[@tuilabel='Dep airport' or @tuilabel='Arr airport']//span[@class='t-content']";
                    case "Flight number" -> "//label[@tuilabel='Flight number']//span[@class='t-content']";
                    case "Crew" -> "//label[@tuilabel='Crew']//span[@class='t-content']";
                    case "Route category" -> "//label[@tuilabel='Route category']//span[@class='t-content']";
                    case "Tech stop" -> "//label[@tuilabel='Technical stop']//*[@class='t-content']";
                    default -> throw new IllegalArgumentException("oops, data wrong!");
                };

                for (int j = 1; j <= this.driver.findElements(By.xpath(xPath)).size(); j++) {
                    String ruleXpath = "(" + xPath + ")[" + j + "]";
                    String actualValue = this.driver.findElement(By.xpath(ruleXpath)).getText();
                    if (actualValue.equals(searchRequest)) {
                        count++;
                        break;
                    }
                }
                pushButton("Back");
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

    public void viewFirstDocumentsOfList (){
        this.driver.findElement(By.xpath("//button[@title='View']//span[@class='t-content']")).click();
    }

    public void deleteFirstDocumentsOfList (){
        this.driver.findElement(By.xpath("//button[@icon='tuiIconTrash']//span[@class='t-content']")).click();
    }

    public void clickHiddenButtonCloseFromDocTemplateForm () {
        Actions action = new Actions(this.driver);
        WebElement fileAttachmentField = this.driver.findElement(By.xpath("//section"));
        action.moveToElement(fileAttachmentField).moveToElement(this.driver.findElement(By.xpath("//section//span[@class='t-content']"))).click().build().perform();
    }

    public void showSidePanel() {
        this.driver.findElement(By.xpath("//div[@class='category-block']//span[@class='t-content']")).click();
    }

    public void showChildCategoryOnCategoryPanel() {
        //this.driver.findElement(By.xpath("//button[@class='_focused']//span[@class='t-content']")).click();
        this.driver.findElement(By.xpath("//mat-tree//button/div[@class='t-wrapper']/span[@class='t-content']")).click();
    }

    public void showListboxData (final String listTitle) {
        String listTitleXpath;
        if (List.of("Country", "Route category", "Aircraft", "Board", "Carrier", "Dep country", "Arr country").contains(listTitle)) {
            listTitleXpath = String.format("//label[@tuilabel='%s']" +
                    "//input[@automation-id='tui-primitive-textfield__native-input']", listTitle);
        }
        else {
            listTitleXpath = String.format("//label[@tuilabel='%s']//input[@type='text']", listTitle);
        }
        this.driver.findElement(By.xpath(listTitleXpath)).click();
    }

    public List<String> getUICountry () {
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= Constant.Dictionary.COUNTRIES.size(); i++) {
            WebElement countryData = this.driver.findElement(By.xpath(String.format("(//tui-select-option)[%d]", i)));
            data.add(countryData.getText());
        }
        pushButton("Hide additional filters");
        return data;
    }

    public List<String> getUIAirports () {
        List<String> data = new ArrayList<>();
        int dynamicId = 0;
        boolean isNextPresent = false;
        do {
            String dataXpath = String.format("//div[@class='scrollable-content']/div[contains(@id, '-%d')]", dynamicId);
            boolean isPresent = this.driver.findElements(By.xpath(dataXpath)).size() > 0;
            if (isPresent) {
                WebElement airportData = this.driver.findElement(By.xpath(dataXpath));
                data.add(airportData.getText());

                String nextElementXpath = String.format("//div[@class='scrollable-content']/div[contains(@id, '-%d')]", dynamicId+1);
                isNextPresent = this.driver.findElements(By.xpath(nextElementXpath)).size() > 0;
                if (!isNextPresent) {
                    WebElement footer = this.driver.findElement(By.xpath("//div[@class='scrollable-content']"));
                    WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(footer);
                    Actions action = new Actions(this.driver);
                    action.scrollFromOrigin(scrollOrigin, 0, 565);
                    action.perform();
                }
                dynamicId++;
                isNextPresent = this.driver.findElements(By.xpath(nextElementXpath)).size() > 0;
            }
        } while (isNextPresent);
        return data;
    }

    public int checkSearchResult (final String dateFrom, final int quantity) {

        List<LocalDate> documentsList = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            this.driver.findElement(By.xpath(
                    String.format("(//button[@title='View']//span[@class='t-content'])[%s]", i))).click();
            Helper.wait(Constant.Ui.LONG_PAUSE);
            String createDateXpath = "//div[text()='Modify at']/following-sibling::div[@class='form-input']";
            String dateText = this.driver.findElement(By.xpath(createDateXpath)).getText();
            String[] array = dateText.split(" ");
            String createDate = array[0];
            System.out.println(createDate);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
            LocalDate date = LocalDate.parse(createDate, formatter);
            documentsList.add(date);
            pushButton("Back");
        }
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate date2 = LocalDate.parse(dateFrom, formatter2);
        int count = 0;
        for (LocalDate date : documentsList) {
            if (date.isEqual(date2) || date.isAfter(date2)) {
                count++;
                System.out.println(count);;
            }
        }
        return count;
    }

    public String getCalendarValue (String dateTitle, String dateSeq) {
        String dateXpath = null;
        if (List.of(
                "Period of creation", "Period of validity", "Period of modification", "Period").contains(dateTitle)
                & dateSeq.equals("From")) {
            dateXpath = String.format(
                    "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[1]",
                    dateTitle);
        } else if (List.of(
                "Period of creation", "Period of validity", "Period of modification", "Period").contains(dateTitle)
                & dateSeq.equals("To")) {
            dateXpath = String.format(
                    "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[2]",
                    dateTitle);
        } else if (dateTitle.equals("Valid") & dateSeq.equals("From")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[3]";
        } else if (dateTitle.equals("Valid") & dateSeq.equals("To")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[4]";
        }
        return this.driver.findElement(By.xpath(dateXpath)).getAttribute("value");
    }

    public String getDocumentCreator () {
        String authorXpath = "//div[text()='Modify by']/../div[@class='form-input']";
        WebElement author = this.driver.findElement(By.xpath(authorXpath));
        return author.getText();
    }
}

/*
 public String getCalendarValue (String dateTitle, String dateSeq) {
        String title = dateTitle + " " + dateSeq;
        String dateXpath =
        switch (title) {
            case "Period of creation From" -> "(//label[@tuilabel='Period of creation']//input[@automation-id='tui-primitive-textfield__native-input'])[1]";
            case "Period of creation To" -> "(//label[@tuilabel='Period of creation']//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
            case "Period of validity From" -> "(//label[@tuilabel='Period of validity']//input[@automation-id='tui-primitive-textfield__native-input'])[1]";
            case "Period of validity To" -> "(//label[@tuilabel='Period of validity']//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
            case "Period of modification From" -> "(//label[@tuilabel='Period of modification']//input[@automation-id='tui-primitive-textfield__native-input'])[1]";
            case "Period of modification To" -> "(//label[@tuilabel='Period of modification']//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
            case "Valid From" -> "(//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
            case "Valid To" -> "(//input[@automation-id='tui-primitive-textfield__native-input'])[3]";
            case "Period From" -> "(//label[@tuilabel='Period']//input[@automation-id='tui-primitive-textfield__native-input'])[1]";
            case "Period To" -> "(//label[@tuilabel='Period']//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
            default -> throw new IllegalArgumentException("oops, data wrong!");
        };
        return this.driver.findElement(By.xpath(dateXpath)).getAttribute("value");
    }
 */

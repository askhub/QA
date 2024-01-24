package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.util.ArrayList;
import java.util.List;

public class SeatRuleManager {

    private final WebDriver driver;
    private int index = 1;

    public SeatRuleManager(WebDriver driver) {
        this.driver = driver;
    }

    public void addMember(final String typeMember) {
        Helper.wait(500);
        String addMemberButtonXpath = "//button[@type='button']//span[contains(text(), 'Add member')]";
        String addMemberXpath = null;
        if (typeMember.equals("general")) {
            addMemberXpath = "(//div[@class='form-section'][1])" + addMemberButtonXpath;
        } else if (typeMember.equals("additional")) {
            addMemberXpath = "(//div[@class='form-section'][2])" + addMemberButtonXpath;
        }
        this.driver.findElement(By.xpath(addMemberXpath)).click();

        this.index++;
        Helper.wait(500);
    }

    public int resetIndex () {
        return this.index = 1;
    }

    public void listBox (final String listTitle, final String listValue) {
        String listTitleXpath;
        if (List.of("Crew", "Type", "Carrier", "Aircraft", "Role", "Position", "Airline").contains(listTitle)) {
            listTitleXpath = String.format("(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%s]", listTitle, this.index);
        }
        else {
            listTitleXpath = String.format("(//label[@tuilabel='%s']//input[@type='text'])[%s]", listTitle, this.index);
        }
        this.driver.findElement(By.xpath(listTitleXpath)).click();
        Helper.wait(500);
        String listValueXpath;
        if (listTitle.equals("Position")) {
            listValueXpath = switch (listValue) {
                case "LS" -> "//tui-data-list[@role='listbox']/button[@type='button'][1]";
                case "RS" -> "//tui-data-list[@role='listbox']/button[@type='button'][2]";
                case "JS1" -> "//tui-data-list[@role='listbox']/button[@type='button'][3]";
                case "JS2" -> "//tui-data-list[@role='listbox']/button[@type='button'][4]";
                case "S1" -> "//tui-data-list[@role='listbox']/button[@type='button'][5]";
                case "S2" -> "//tui-data-list[@role='listbox']/button[@type='button'][6]";
                case "S3" -> "//tui-data-list[@role='listbox']/button[@type='button'][7]";
                case "S4" -> "//tui-data-list[@role='listbox']/button[@type='button'][8]";
                case "RLS" -> "//tui-data-list[@role='listbox']/button[@type='button'][9]";
                case "LRS" -> "//tui-data-list[@role='listbox']/button[@type='button'][10]";
                case "JLS2" -> "//tui-data-list[@role='listbox']/button[@type='button'][11]";
                case "JLS1" -> "//tui-data-list[@role='listbox']/button[@type='button'][12]";
                case "JRS2" -> "//tui-data-list[@role='listbox']/button[@type='button'][13]";
                case "JRS1" -> "//tui-data-list[@role='listbox']/button[@type='button'][14]";
                case "RJS" -> "//tui-data-list[@role='listbox']/button[@type='button'][15]";
                case "LJS" -> "//tui-data-list[@role='listbox']/button[@type='button'][16]";
                default -> throw new IllegalArgumentException("ups, data wrong!");
            };
        } else {
            listValueXpath = String.format("//tui-select-option[@class='ng-star-inserted'][contains(text(), '%s')]", listValue);
        }

        WebElement value = this.driver.findElement(By.xpath(listValueXpath));

        if (listTitle.equals("Aircraft")) {
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(value);
            Actions action = new Actions(this.driver);
            action.scrollFromOrigin(scrollOrigin, 0, 100).perform();
        }
        value.click();
        Helper.wait(500);
    }

    public void textForm(final String nameForm, final String searchText) {
        String formXpath = String.format("(//label[@tuilabel='%s']//input[@id='uniqueId'])[%s]", nameForm, this.index);
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(searchText);
        Helper.wait(500);
    }

    public void textSearchForm (final String fieldTitle, final String searchText) {
        String formXpath = String.format("(//label[@tuilabel='%s']//input[@type='text'])[%d]", fieldTitle, this.index);
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.click();
        txtFrm.sendKeys(searchText);
        Helper.wait(500);
    }

    public void textFormUpdate(final String nameForm, final String searchText, final int taskIndex) {
        String formXpath = String.format("(//label[@tuilabel='%s']//input[@id='uniqueId'])[%s]", nameForm, taskIndex);
        WebElement txtFrm = this.driver.findElement(By.xpath(formXpath));
        txtFrm.clear();
        txtFrm.click();
        txtFrm.sendKeys(searchText);
        Helper.wait(1000);
    }

    public void listBoxMulti(final String listTitle, final String[] listValue) {
        if (listTitle.equals("Qualification")) {
            String qualifyFieldXpath = String.format("(//label[@tuilabel='Qualification']//div[@automation-id='tui-multi-select__arrow'])[%s]", this.index);
            this.driver.findElement(By.xpath(qualifyFieldXpath)).click();
        } else if (listTitle.equals("Category")) {
            String qualifyFieldXpath = String.format("(//label[@tuilabel='Category']//div[@class='t-tags'])[%s]", this.index);
            this.driver.findElement(By.xpath(qualifyFieldXpath)).click();
        }

        String qualifyXpath = null;
        for (String s : listValue) {
            if (listTitle.equals("Qualification")) {
                qualifyXpath = switch (s) {
                    case "CFI" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'CFI')]";
                    case "CP" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'CP')]";
                    case "CPrh" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'CPrh')]";
                    case "TRE" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'TRE')]";
                    case "FO" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'FO')]";
                    //default -> throw new IllegalArgumentException("ups, data wrong!");
                    default -> "//button[@type='button']//tui-multi-select-option[@class='ng-star-inserted']";
                };
            } else if (listTitle.equals("Category")) {
                qualifyXpath = switch (s) {
                    case "cat 1" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'cat 1')]";
                    case "cat 2" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'cat 2')]";
                    case "cat 3" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'cat 3')]";
                    case "cat 4" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'cat 4')]";
                    case "cat 5" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'cat 5')]";
                    case "cat 6" -> "//button[@type='button']//tui-multi-select-option[contains(text(), 'cat 6')]";
                    //default -> throw new IllegalArgumentException("ups, data wrong!");
                    default -> "//button[@type='button']//tui-multi-select-option[@class='ng-star-inserted']";
                };
            }
            Helper.wait(100);
            this.driver.findElement(By.xpath(qualifyXpath)).click();
        }
        //Helper.wait(1000);
    }

    public void pushButton(final String buttonTitle) {
        Helper.wait(1000);
        String buttonXpath = String.format("//button//span[contains(text(), '%s')]", buttonTitle);
        this.driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void addRule() {
        String buttonXpath = "//div[contains(text(), 'Seat rules')]/../button";
        this.driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void clickCheckBox(final String chkBoxTitle) {
        String chkXpath = String.format("//label[@tuilabel='%s']//input[@class='t-native']", chkBoxTitle);
        this.driver.findElement(By.xpath(chkXpath)).click();
        Helper.wait(1000);
    }

    public void dateForm(final String dateSeq, final String date) {
        String dateXpath;
        if (dateSeq.equals("From")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
        }
        else {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[3]";
        }
        WebElement dateFrm = this.driver.findElement(By.xpath(dateXpath));
        dateFrm.clear();
        dateFrm.click();
        dateFrm.sendKeys(date);

        String dataCaldrXpath;
        dataCaldrXpath = String.format("(//div[@class='ng-star-inserted']//div[@class='t-item'])[%s]", date.substring(0, 2));
        this.driver.findElement(By.xpath(dataCaldrXpath)).click();
        Helper.wait(1000);
    }

    public void pageSizeSwitcher(final String pageSize) {
        String pageXpath = "//div[@class='pagination-actions']" +
                "//input[@automation-id='tui-primitive-textfield__native-input']";
        this.driver.findElement(By.xpath(pageXpath)).click();
        Helper.wait(1000);
        String pageSizeXpath = String.format("//button//span[text()=' %s ']", pageSize);
        this.driver.findElement(By.xpath(pageSizeXpath)).click();
    }

    public int searchRulesResult() {
        int result = 0;
        String messageXpath = "//div[@class='tui-space_left-5 search-result ng-star-inserted']";
        if (this.driver.findElements(By.xpath(messageXpath)).size() == 0) {
            System.out.println("Search result: 0");
            return result;
        }
        try {
            Helper.wait(500);
            final String qty = this.driver.findElement(By.xpath(messageXpath)).getText();
            String[] array = qty.split(" ");
            result = Integer.parseInt(array[array.length -1]);
        } catch (NumberFormatException e) {
            System.out.println("в сообщении о результатах поиска не число");
        }
        return result;
    }

    public int searchResultCounter (final String requestXpath) {
        List<WebElement> ruleList;
        int result = 0;
        int count = 1;
        boolean isNextPagePresent = false;
        do {
            String pagination = "//button[@automation-id='tui-pagination__element']//span[text()=' " + count + " ']";
            boolean isPresent = this.driver.findElements(By.xpath(pagination)).size() > 0;
            if (isPresent) {

                Helper.wait(500);
                ruleList = this.driver.findElements(By.xpath(requestXpath));
                result = result + ruleList.size();
                String nextPage = "//button[@automation-id='tui-pagination__element']" +
                        "//span[text()=' " + (count + 1) + " ']";
                isNextPagePresent = this.driver.findElements(By.xpath(nextPage)).size() > 0;
                if (isNextPagePresent) {
                    this.driver.findElement(By.xpath(nextPage)).click();
                    count++;
                }
            }
        } while (isNextPagePresent);
        return result;
    }

    public int searchRulesByAircraft(final String aircraft, final String pageSize, final int searchResult) {
        String aircraftXpath = String.format("//tr/td[text()=' %s '][1]", aircraft);
        int result = 0;
        int pageSwitcher = Integer.parseInt(pageSize);
        if (this.driver.findElements(By.xpath(aircraftXpath)).size() == 0) {
            System.out.println("Search list: 0");
            return result;
        }
        if (searchResult <= pageSwitcher) {
            return this.driver.findElements(By.xpath(aircraftXpath)).size();
        } else {
            return searchResultCounter(aircraftXpath);
        }
    }

    public int searchRulesByCode(final String code, final String pageSize, final int searchResult) {
        final String requestCodeXpath = String.format("//tr/td[text()='%s']", code);
        int result = 0;
        int pageSwitcher = Integer.parseInt(pageSize);
        if (this.driver.findElements(By.xpath(requestCodeXpath)).size() == 0) {
            System.out.println("Search list: 0");
            return result;
        }
        if (searchResult <= pageSwitcher) {
            return this.driver.findElements(By.xpath(requestCodeXpath)).size();
        } else {
            return searchResultCounter(requestCodeXpath);
        }
    }

    public int searchRulesByAirline(final String airline, final String pageSize, final int searchResult) {
        /*String valueXpath = String.format("//span[contains(text(), '%s')]", Constant.Ui.SEARCH_RULE_CARRIER);
        List<WebElement> result = this.driver.findElements(By.xpath(valueXpath));
        final int size = result.size();
        return size;*/
        final String requestCodeXpath = String.format("//tr/td[text()=' %s ']", airline);
        int result = 0;
        int pageSwitcher = Integer.parseInt(pageSize);
        if (this.driver.findElements(By.xpath(requestCodeXpath)).size() == 0) {
            System.out.println("Search list: 0");
            return result;
        }
        if (searchResult <= pageSwitcher) {
            return this.driver.findElements(By.xpath(requestCodeXpath)).size();
        } else {
            return searchResultCounter(requestCodeXpath);
        }
    }

    public String positionXpathFinder (final String position) {
        String positionXpath = switch (position) {
            case "LS", "LRS", "LJS" -> "//div[text()='Flight Deck']/following-sibling::div[@class='flight-deck__row'][1]/div[1]/div[1]";
            case "RS", "RLS", "RJS" -> "//div[text()='Flight Deck']/following-sibling::div[@class='flight-deck__row'][1]/div[2]/div[1]";
            case "JS1", "JLS1", "JLR1" -> "//div[text()='Flight Deck']/following-sibling::div[@class='flight-deck__row'][2]/div[1]/div[1]";
            case "JS2", "JLS2", "JLR2" -> "//div[text()='Flight Deck']/following-sibling::div[@class='flight-deck__row'][2]/div[2]/div[1]";
            case "S1" -> "//div[text()='Cabin']/following-sibling::div[@class='flight-deck__row'][1]/div[2]/div[1]";
            case "S2" -> "//div[text()='Cabin']/following-sibling::div[@class='flight-deck__row'][1]/div[1]/div[1]";
            case "S3" -> "//div[text()='Cabin']/following-sibling::div[@class='flight-deck__row'][2]/div[1]/div[1]";
            case "S4" -> "//div[text()='Cabin']/following-sibling::div[@class='flight-deck__row'][2]/div[2]/div[1]";
            default -> throw new IllegalArgumentException("oops, data wrong!");
        };
        String textOnBoard = this.driver.findElement(By.xpath(positionXpath)).getText();
        return textOnBoard;
    }

    public int codeControl(final String crewType) {
        int count = 0;
        String[] code = Constant.Ui.UNIQUE_CODES;
        listBox("Type", crewType);
        for(String s : code) {
            textFormUpdate("Code", s, 1);
            Actions actions = new Actions(this.driver);
            actions.sendKeys(Keys.TAB).perform();
            boolean isPresent = false;
            if (s.length() > 1) {
                isPresent = this.driver.findElements(By.xpath("//div[text()=' Maximum length is 1 character ']")).size() > 0;
            } else {
                if (crewType.equals("Trainer")) {
                    isPresent = this.driver.findElements(By.xpath("//div[text()=' Only upper case are allowed ']")).size() > 0;
                } else if (crewType.equals("Trainee")) {
                    isPresent = this.driver.findElements(By.xpath("//div[text()=' Only lower case are allowed ']")).size() > 0;
                }
            }
            if (isPresent) {
                count = count + 1;
            }
        }
        return count;
    }

    public String getCalendarValue (String dateTitle, String dateSeq) {
        String dateXpath = null;
        if (dateTitle.equals("Period of validity") & dateSeq.equals("From")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[2]";
        } else if (dateTitle.equals("Period of validity") & dateSeq.equals("To")) {
            dateXpath = "(//input[@automation-id='tui-primitive-textfield__native-input'])[3]";
        }
        return this.driver.findElement(By.xpath(dateXpath)).getAttribute("value");
    }

    public List<String> getListBoxValues (final String title) {
        List<String> data = new ArrayList<>();
        if (title.equals("Position")) {
            this.driver.findElement(By.xpath(String.format(
                    "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%d]",
                            title, this.index))).click();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            if(this.index <=(Constant.Ui.MAX_GENERAL_CREW_MEMBER + Constant.Ui.MAX_ADDITIONAL_CREW_MEMBER)) {
                String crewDataPosition;
                String crewDataSubPosition;
                for (int i = 1; i <= Constant.Dictionary.POSITION.size(); i++) {
                    WebElement crewDataString = this.driver.findElement(By.xpath(String.format(
                            "(//tui-data-list//button//tui-select-option[@class='ng-star-inserted'])[%d]", i)));
                    WebElement crewDataSubstring = this.driver.findElement(By.xpath(String.format("(//small)[%d]", i)));
                    crewDataPosition = crewDataString.getText().replaceAll("\n", "");
                    if (crewDataSubstring.getText().equals("LS") || crewDataSubstring.getText().equals("RS")) {
                        crewDataSubPosition = String.format("(%s)$", crewDataSubstring.getText());
                    } else {
                        crewDataSubPosition = crewDataSubstring.getText();
                    }
                    data.add(crewDataPosition.replaceAll(crewDataSubPosition, ""));
                }
            }
        } else if (List.of("Carrier", "Aircraft", "Role", "Subtask").contains(title)) {
            this.driver.findElement(By.xpath(String.format(
                    "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%d]",
                            title, this.index))).click();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            if(this.index <=(Constant.Ui.MAX_GENERAL_CREW_MEMBER + Constant.Ui.MAX_ADDITIONAL_CREW_MEMBER)) {
                List<String> dictionary = switch (title) {
                    case "Aircraft" -> Constant.Dictionary.AIRCRAFTS;
                    case "Carrier" -> Constant.Dictionary.AIRLINES;
                    case "Type" -> Constant.Dictionary.TYPE_ADDITIONAL;
                    case "Role" -> Constant.Dictionary.ROLE;
                    case "Subtask" -> Constant.Dictionary.SUB_TASK;
                    case "Crew" -> Constant.Dictionary.CREW_MEMBER_TYPE;
                    default -> throw new IllegalArgumentException("oops, data wrong!");
                };
                for (int i = 1; i <= dictionary.size(); i++) {
                    WebElement crewData = this.driver.findElement(By.xpath(String.format(
                            "(//tui-data-list//button//tui-select-option)[%d]", i)));
                    data.add(crewData.getText());
                }
            }
        } else if (title.equals("Qualification")) {
            this.driver.findElement(By.xpath(String.format(
                            "(//label[@tuilabel='%s']//div[@class='t-tags'])[%d]", title, this.index)))
                    .click();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            if(this.index <=(Constant.Ui.MAX_GENERAL_CREW_MEMBER + Constant.Ui.MAX_ADDITIONAL_CREW_MEMBER)) {
                for (int i = 1; i <= Constant.Dictionary.QUALIFICATION.size(); i++) {
                    WebElement crewData = this.driver.findElement(By.xpath(String.format(
                            "(//tui-data-list//button//tui-multi-select-option)[%d]", i)));
                    data.add(crewData.getText());
                }
            }
        } else if (title.equals("Type")) {
            this.driver.findElement(By.xpath(String.format(
                            "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%d]", title, this.index)))
                    .click();
            Helper.wait(Constant.Ui.SHORT_PAUSE);
            if(this.index <= Constant.Ui.MAX_GENERAL_CREW_MEMBER) {
                for (int i = 1; i <= Constant.Dictionary.TYPE_GENERAL.size(); i++) {
                    WebElement crewData = this.driver.findElement(By.xpath(String.format(
                            "(//tui-data-list//button//tui-select-option)[%d]", i)));
                    data.add(crewData.getText());
                }
            }
            if(this.index>Constant.Ui.MAX_GENERAL_CREW_MEMBER) {
                for (int i = 1; i <= Constant.Dictionary.TYPE_ADDITIONAL.size(); i++) {
                    WebElement crewData = this.driver.findElement(By.xpath(String.format(
                            "(//tui-data-list//button//tui-select-option)[%d]", i)));
                    data.add(crewData.getText());
                }
            }
                

        }
        if (title.equals("Position"))
            this.driver.findElement(By.xpath(String.format(
                            "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%d]",
                            title, this.index))).click();
        if (List.of("Carrier", "Aircraft", "Role", "Subtask").contains(title))
            this.driver.findElement(By.xpath(String.format(
                            "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%d]",
                            title, this.index))).click();
        if(title.equals("Qualification"))
            this.driver.findElement(By.xpath(String.format(
                            "(//label[@tuilabel='%s']//div[@class='t-tags'])[%d]", title, this.index))).click();
        if(title.equals("Type"))
            this.driver.findElement(By.xpath(String.format(
                        "(//label[@tuilabel='%s']//input[@automation-id='tui-primitive-textfield__native-input'])[%d]",
                        title, this.index))).click();
        return data;
    }

    public String getNewSeatRuleId () {
        String idXpath = "//label[@tuilabel='ID']//span[@class='t-content']";
        return this.driver.findElement(By.xpath(idXpath)).getText().replaceAll(" ", "");
    }

    public int generalMemberCounter () {
        final String memberXpath = "//div[@class='form-row ng-untouched ng-pristine ng-invalid ng-star-inserted']";
        for (int i = 1; i <= Constant.Ui.MAX_GENERAL_CREW_MEMBER + 1; i++) {
            addMember("general");
        }
        return this.driver.findElements(By.xpath(memberXpath)).size();
    }

    public int additionalMemberCounter () {
        final String memberXpath = "//div[@class='form-row ng-star-inserted']";
        for (int i = 1; i <= Constant.Ui.MAX_ADDITIONAL_CREW_MEMBER + 1; i++) {
            addMember("additional");
        }
        return this.driver.findElements(By.xpath(memberXpath)).size();
    }

    public void clickDeleteButton (final String seatRuleId, final String airline,
                                   final String aircraft, final String code) {
        String deleteXpath = String.format("//td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td/button[@icon='tuiIconTrash']",
                seatRuleId, airline, aircraft, code);
        this.driver.findElement(By.xpath(deleteXpath)).click();
        pushButton("Yes");
    }

    public void clickRecoverButton (final String seatRuleId, final String airline,
                                    final String aircraft, final String code) {
        String recoverXpath = String.format("//td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td/button[@icon='tuiIconRefreshCcw']",
                        seatRuleId, airline, aircraft, code);
        this.driver.findElement(By.xpath(recoverXpath)).click();
        pushButton("Yes");
    }

    public void clickViewButton (final String seatRuleId, final String airline,
                                 final String aircraft, final String code) {
        String viewXpath = String.format("//td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td[contains(text(), '%s')]" +
                        "/following-sibling::td/button[@icon='tuiIconEye']",
                        seatRuleId, airline, aircraft, code);
        this.driver.findElement(By.xpath(viewXpath)).click();
    }
}

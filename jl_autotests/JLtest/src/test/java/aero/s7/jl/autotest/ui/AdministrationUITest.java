// Автотесты UI раздела Settings. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministrationUITest extends TestBase {

    /*@Before
    public void choiceChapter () {
        headerLink("eCrew tracking");
    }*/
    @After
    public void goToMainChapter () {
        headerLink("eCrew tracking");
    }

    @Test
    public void newParentCategory () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Categories']")).click();
        Helper.wait(3000);
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

        settingsManager.pushButton("Back");
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME);
        Assert.assertTrue(isCategoryPresent);
    }

    @Test
    public void createNewCategoryNegative () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Categories']")).click();
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_2);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

        settingsManager.pushButton("Back");
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_2);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_NEW_CATEGORY_NAME_CONTROL);
        Helper.notificationControl(Constant.Ui.TOAST_NEW_CATEGORY_INDEX_CONTROL);
    }

    @Test
    public void newUnderParentCategory() {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Categories']")).click();
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        Helper.wait(2000);
        settingsManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME);
        settingsManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME);
        settingsManager.sortIndexForm(sortIndex);
        Helper.wait(2000);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

        settingsManager.pushButton("Back");
        settingsManager.showAllCategories();
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_NAME);
        Assert.assertTrue(isCategoryPresent);
    }

    @Test
    public void updateParentCategory () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Categories']")).click();
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_2);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
        settingsManager.pushButton("Back");
        Helper.wait(2000);
        settingsManager.showAllCategories();
        settingsManager.viewCategory(Constant.Ui.PARENT_CATEGORY_NAME_2);
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_2 + "update");
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_UPDATED);
    }

    @Test
    public void updateChildCategory () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Categories']")).click();
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_3);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

        settingsManager.pushButton("Back");
        Helper.wait(2000);

        settingsManager.showAllCategories();
        String sortIndex2 = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME_3);
        settingsManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME_3);
        settingsManager.sortIndexForm(sortIndex2);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

        settingsManager.pushButton("Back");
        Helper.wait(2000);
        settingsManager.showAllCategories();
        settingsManager.viewCategory(Constant.Ui.CHILD_CATEGORY_NAME_3);
        settingsManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME_3 + "update");
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_UPDATED);
    }

    @Test
    public void deleteParentCategory () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        driver.getDriver().findElement(By.xpath("//a[text()='Categories']")).click();
        Helper.wait(3000);
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_DELETE);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

        settingsManager.pushButton("Back");
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME_DELETE);
        Assert.assertTrue(isCategoryPresent);

        settingsManager.deleteCategoryAfterTest(Constant.Ui.PARENT_CATEGORY_NAME_DELETE);
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_DELETED);
    }

    @Test
    public void deleteChildCategory () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());
        TestBase.headerLink("Categories");
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_DELETE_2);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
        settingsManager.pushButton("Back");
        settingsManager.showAllCategories();
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME_DELETE_2);
        Assert.assertTrue(isCategoryPresent);

        String sortIndex2 = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME_DELETE_2);
        settingsManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME_2);
        settingsManager.sortIndexForm(sortIndex2);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
        settingsManager.pushButton("Back");
        settingsManager.showAllCategories();
        boolean isCategoryPresent2 = settingsManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_NAME_2);
        Assert.assertTrue(isCategoryPresent2);

        settingsManager.deleteCategoryAfterTest(Constant.Ui.CHILD_CATEGORY_NAME_2);
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_DELETED);
    }

    @Test
    public void deleteParentCategoryWithDocuments () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());
        TestBase.headerLink("Categories");
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
        settingsManager.pushButton("Back");
        //возможно снова потребуется раскрывать дерево категорий
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1);
        Assert.assertTrue(isCategoryPresent);

        TestBase.headerLink("Documents");
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        docpackingManager.pushButton("Add");
        docpackingManager.listOwnerForm(new String[]{"ДНО"});
        docpackingManager.fileLoad("SBT Memo.pdf");
        docpackingManager.markCategoryPasteAfter(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "VVL");
        docpackingManager.listBox("Crew", "FD");
        docpackingManager.listBox("Carrier", "GH");
        docpackingManager.copiesDocRule("1");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        //можно добавить уровень с поисковым запросом, чтобы убедиться что документ создан и находится в списке
        TestBase.headerLink("Settings");
        TestBase.headerLink("Categories");
        settingsManager.deleteCategoryAfterTest(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1);

        Helper.notificationControl(Constant.Ui.TOAST_DELETE_CATEGORY_WITH_DOCS);
    }

    @Test
    public void deleteParentCategoryWithChildCategoryWithDocuments () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());
        TestBase.headerLink("Categories");
        settingsManager.showAllCategories();
        String sortIndex = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);
        settingsManager.sortIndexForm(sortIndex);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
        settingsManager.pushButton("Back");
        settingsManager.showAllCategories();
        boolean isCategoryPresent = settingsManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);
        Assert.assertTrue(isCategoryPresent);

        String sortIndex2 = settingsManager.lastSortIndexFromCategories();
        settingsManager.pushButton("Add");
        settingsManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);
        settingsManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_2);
        settingsManager.sortIndexForm(sortIndex2);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
        settingsManager.pushButton("Back");
        settingsManager.showAllCategories();
        boolean isCategoryPresent2 = settingsManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_2);
        Assert.assertTrue(isCategoryPresent2);

        TestBase.headerLink("Documents");
        DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
        Assert.assertTrue(TestBase.isChapterPresent("Documents"));
        docpackingManager.pushButton("Add");
        docpackingManager.listOwnerForm(new String[]{"ДОПП"});
        docpackingManager.fileLoad("AIR_IKT.pdf");
        docpackingManager.markCategoryPasteAfter(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_2);
        docpackingManager.listBox("Rule", "INCLUDE");
        docpackingManager.listBox("Route category", "NO CATEGORY");
        docpackingManager.listBox("Flight type", "MVL");
        docpackingManager.listBox("Crew", "FD");
        docpackingManager.listBox("Carrier", "S7");
        docpackingManager.copiesDocRule("2");
        docpackingManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);
        //можно добавить уровень с поисковым запросом, чтобы убедиться что документ создан и находится в списке
        TestBase.headerLink("Settings");
        TestBase.headerLink("Categories");
        settingsManager.deleteCategoryAfterTest(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);

        Helper.notificationControl(Constant.Ui.TOAST_DELETE_CATEGORY_WITH_DOCS);
    }

    @Test
    public void testCreateFuelDeclaration() {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        TestBase.headerLink("Transport declaration");
        settingsManager.pushButton("Add");
        Helper.wait(2000);
        settingsManager.dateForm("From", Constant.Ui.DATE_FROM_CDV);
        settingsManager.dateForm("To", Constant.Ui.DATE_TO_CDV);
        settingsManager.fuelNumberForm(Constant.Ui.CDV_NUMBER);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SUCCESS_ACTION);
    }

    @Test
    public void testCreateFuelNumberNegative() {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        TestBase.headerLink("Transport declaration");
        settingsManager.pushButton("Add");
        settingsManager.dateForm("From", Constant.Ui.DATE_FROM_CDV);
        settingsManager.dateForm("To", Constant.Ui.DATE_TO_CDV);
        settingsManager.fuelNumberForm(Constant.Ui.CDV_NUMBER_WRONG);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_INVALID_VALUE);
    }

    @Test
    public void testUpdateFuelDeclaration () {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        TestBase.headerLink("Transport declaration");
        settingsManager.pushButton("Add");
        Helper.wait(1000);
        settingsManager.dateForm("From", Constant.Ui.DATE_FROM_CDV);
        settingsManager.dateForm("To", Constant.Ui.DATE_TO_CDV);
        settingsManager.fuelNumberForm(Constant.Ui.CDV_NUMBER);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SUCCESS_ACTION);
        boolean isDocumentPresent = settingsManager.findCDVDocument(Constant.Ui.DATE_FROM_CDV,
                                                                    Constant.Ui.DATE_TO_CDV,
                                                                    Constant.Ui.CDV_NUMBER);
        Assert.assertTrue(isDocumentPresent);

        settingsManager.viewFuelDeclaration(Constant.Ui.DATE_FROM_CDV, Constant.Ui.DATE_TO_CDV, Constant.Ui.CDV_NUMBER);
        settingsManager.fuelNumberForm(Constant.Ui.CDV_NUMBER_UPDATE);
        settingsManager.pushButton("Save");
        Helper.notificationControl(Constant.Ui.TOAST_SUCCESS_ACTION);

        boolean isDocumentPresent2 = settingsManager.findCDVDocument(Constant.Ui.DATE_FROM_CDV,
                                                                    Constant.Ui.DATE_TO_CDV,
                                                                    Constant.Ui.CDV_NUMBER);
        Assert.assertTrue(isDocumentPresent2);
    }

    @Test
    public void testUpdateFuelDeclarationNegativeWrongDate() {
        Assert.assertTrue(TestBase.isChapterPresent("Settings"));
        SettingsManager settingsManager = new SettingsManager(driver.getDriver());

        TestBase.headerLink("Transport declaration");
        settingsManager.pushButton("Add");
        Helper.wait(1000);
        settingsManager.dateForm("From", Constant.Ui.DATE_FROM_CDV_2);
        settingsManager.dateForm("To", Constant.Ui.DATE_TO_CDV_2);
        settingsManager.fuelNumberForm(Constant.Ui.CDV_NUMBER);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_SUCCESS_ACTION);
        boolean isDocumentPresent = settingsManager.findCDVDocument(Constant.Ui.DATE_FROM_CDV_2,
                                                                    Constant.Ui.DATE_TO_CDV_2,
                                                                    Constant.Ui.CDV_NUMBER);
        Assert.assertTrue(isDocumentPresent);

        settingsManager.viewFuelDeclaration(Constant.Ui.DATE_FROM_CDV_2,
                                            Constant.Ui.DATE_TO_CDV_2,
                                            Constant.Ui.CDV_NUMBER);
        settingsManager.fuelNumberForm(Constant.Ui.DATE_TO_CDV_WRONG);
        settingsManager.pushButton("Save");

        Helper.notificationControl(Constant.Ui.TOAST_INVALID_VALUE);
    }
}

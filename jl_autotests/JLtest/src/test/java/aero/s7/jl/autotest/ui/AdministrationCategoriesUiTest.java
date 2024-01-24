// Автотесты UI раздела Administration. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministrationCategoriesUiTest extends TestBase {

        @Before
        public void choiceChapter () {
            headerLink("Administration");
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());
            administrationManager.pushButton("Document categories");
            driver.getDriver().navigate().refresh();
        }
        @After
        public void goToMainChapter () {
            headerLink("eCrew tracking");
        }

        @Test
        public void createParentCategory () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME);
            administrationManager.sortIndexForm(String.valueOf(sortIndex+1));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME));
        }

        @Test
        public void createNewCategoryNegative () {
            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());
            String firstCategoryInList = driver.getDriver().findElement(By.xpath("//td/div/span")).getText();

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(firstCategoryInList);
            administrationManager.sortIndexForm(String.valueOf(sortIndex));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_NEW_CATEGORY_NAME_CONTROL);
            Helper.notificationControl(Constant.Ui.TOAST_NEW_CATEGORY_INDEX_CONTROL);
        }

        @Test
        public void newUnderParentCategory() {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME);
            administrationManager.sortIndexForm(String.valueOf(sortIndex+1));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_NAME));
        }

        @Test
        public void updateParentCategory () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_2);
            administrationManager.sortIndexForm(String.valueOf(sortIndex+1));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

            administrationManager.pushButton("Back");
            administrationManager.viewCategory(Constant.Ui.PARENT_CATEGORY_NAME_2);
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_2 + "update");
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_UPDATED);
        }

        @Test
        public void updateChildCategory () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_3);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

            administrationManager.pushButton("Back");
            Helper.wait(2000);

            int sortIndex2 = administrationManager.lastSortIndexFromCategories(TestBase.authToken());
            administrationManager.pushButton("Add");
            administrationManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME_3);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME_3);
            administrationManager.sortIndexForm(String.valueOf(sortIndex2 + 1));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

            administrationManager.pushButton("Back");
            Helper.wait(2000);
            administrationManager.showAllCategories();
            administrationManager.viewCategory(Constant.Ui.CHILD_CATEGORY_NAME_3);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME_3 + "update");
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_UPDATED);
        }

        @Test
        public void deleteParentCategory () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_DELETE);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");

            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);

            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME_DELETE));
            administrationManager.deleteCategory(Constant.Ui.PARENT_CATEGORY_NAME_DELETE);
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_DELETED);
        }

        @Test
        public void deleteChildCategory () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_NAME_DELETE_2);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_NAME_DELETE_2));

            int sortIndex2 = administrationManager.lastSortIndexFromCategories(TestBase.authToken());
            administrationManager.pushButton("Add");
            administrationManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_NAME_DELETE_2);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_NAME_2);
            administrationManager.sortIndexForm(String.valueOf(sortIndex2 + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_NAME_2));

            administrationManager.deleteCategory(Constant.Ui.CHILD_CATEGORY_NAME_2);
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_DELETED);
        }
        @Ignore("Unlock after jira OFS-2036 done")
        @Test
        public void deleteParentCategoryWithDocument () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");

            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1));

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

            headerLink("Administration");
            administrationManager.pushButton("Document categories");
            administrationManager.deleteCategory(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_1);

           Helper.modalWindowMessageControl(Constant.Ui.MODAL_DELETE_CATEGORY_WITH_DOCS);
        }
        @Ignore("Unlock after jira OFS-2036 done")
        @Test
        public void deleteParentCategoryWithChildCategoryWithDocument () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");

            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2));

            int sortIndex2 = administrationManager.lastSortIndexFromCategories(TestBase.authToken());
            administrationManager.pushButton("Add");
            administrationManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_2);
            administrationManager.sortIndexForm(String.valueOf(sortIndex2 + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_2));

            headerLink("Documents");
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

            headerLink("Administration");
            administrationManager.pushButton("Document categories");
            TestBase.headerLink("Categories");

            administrationManager.deleteCategory(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_2);

            Helper.modalWindowMessageControl(Constant.Ui.MODAL_DELETE_CATEGORY_WITH_DOCS);
        }
        @Ignore("modal message window isn't implemented")
        @Test
        public void deleteParentCategoryWithEmptyChildCategory () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_3);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");

            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_3));

            int sortIndex2 = administrationManager.lastSortIndexFromCategories(TestBase.authToken());
            administrationManager.pushButton("Add");
            administrationManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_3);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_3);
            administrationManager.sortIndexForm(String.valueOf(sortIndex2 + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_3));

            administrationManager.deleteCategory(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_3);
            administrationManager.pushButton("Yes");
            Helper.modalWindowMessageControl(Constant.Ui.MODAL_DELETE_CATEGORY_WITH_EMPTY_CHILD);
            administrationManager.pushButton("Ok");
        }

        @Test
        public void deleteChildCategoryWithDocument () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));
            int sortIndex = administrationManager.lastSortIndexFromCategories(TestBase.authToken());

            administrationManager.add("Document categories");
            administrationManager.categoryNaming(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_4);
            administrationManager.sortIndexForm(String.valueOf(sortIndex + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");

            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_4));

            int sortIndex2 = administrationManager.lastSortIndexFromCategories(TestBase.authToken());
            administrationManager.pushButton("Add");
            administrationManager.parentCategoryListBox(Constant.Ui.PARENT_CATEGORY_DELETE_NEGATIVE_4);
            administrationManager.categoryNaming(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_4);
            administrationManager.sortIndexForm(String.valueOf(sortIndex2 + 1));
            administrationManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_CATEGORY_CREATED);
            administrationManager.pushButton("Back");
            administrationManager.showAllCategories();
            Assert.assertTrue(administrationManager.findNewCategoryInList(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_4));

            headerLink("Documents");
            DocpackingManager docpackingManager = new DocpackingManager(driver.getDriver());
            Assert.assertTrue(TestBase.isChapterPresent("Documents"));
            docpackingManager.pushButton("Add");
            docpackingManager.listOwnerForm(new String[]{"ДНО"});
            docpackingManager.fileLoad("AIR_IKT.pdf");
            docpackingManager.markCategoryPasteAfter(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_4);
            docpackingManager.listBox("Rule", "INCLUDE");
            docpackingManager.listBox("Route category", "SPLITDUTY");
            docpackingManager.listBox("Flight type", "VVL");
            docpackingManager.listBox("Crew", "FD");
            docpackingManager.listBox("Carrier", "S7");
            docpackingManager.copiesDocRule("3");
            docpackingManager.pushButton("Save");
            Helper.notificationControl(Constant.Ui.TOAST_DOCUMENT_CREATED);

            headerLink("Administration");
            administrationManager.pushButton("Document categories");
            TestBase.headerLink("Categories");

            administrationManager.deleteCategory(Constant.Ui.CHILD_CATEGORY_DELETE_NEGATIVE_4);

            Helper.modalWindowMessageControl(Constant.Ui.MODAL_DELETE_CATEGORY_WITH_DOCS);
        }

        @Test
        public void recoveryParentCategory () {

        }

        @Test
        public void recoveryChildCategory () {

        }

        @Test
        public void exitFormWithoutSaveChange () {

        }

        @Test
        public void filterDeleteCategories () {
            AdministrationManager administrationManager = new AdministrationManager(driver.getDriver());

            Assert.assertTrue(TestBase.isChapterPresent("Administration"));

            administrationManager.deleteCheckbox();
            administrationManager.pushButton("Search");
        }
}

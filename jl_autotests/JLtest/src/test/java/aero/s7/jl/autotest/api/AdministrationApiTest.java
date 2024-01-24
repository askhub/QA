// Автотесты API раздела Administration. Korotchenko AS. 2023
package aero.s7.jl.autotest.api;

import aero.s7.jl.autotest.api.Documents.DocTemplateWithRulesCreateForm;
import aero.s7.jl.autotest.api.Documents.DocumentsPacking;
import aero.s7.jl.autotest.api.Documents.DocumentsPackingService;
import aero.s7.jl.autotest.api.Documents.DocumentsPackingServiceImpl;
import aero.s7.jl.autotest.api.Administration.*;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class AdministrationApiTest extends TestBase {

    SettingsService settingsService = new SettingsServiceImpl();
    DocumentsPackingService documentsPackingService = new DocumentsPackingServiceImpl();

    @Ignore("start with stable category list")
    @Test
    public void testGetMainCategoriesList () {
        List<Category> categoryData = settingsService.getAllCategory();
        List<String> categoryList = categoryData.stream().map(Category::getName).toList();
        Assert.assertEquals(new HashSet<>(categoryList), new HashSet<>(Constant.Dictionary.DOC_CATEGORIES));
    }

    @Test
    public void testGetCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();
        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("тестКатегория4",
                lastSortIndex+1,
                false)
                .build();
        Category newParentCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertEquals(newCategoryBody.getName(), newParentCategory.getName());
        Assert.assertEquals(Optional.of(newCategoryBody.getSortIndex()),
                Optional.of(newParentCategory.getSortIndex()));

        Category getNewCategory = settingsService.getCategory(newParentCategory.getDocumentCategoryId());
        Assert.assertEquals(newCategoryBody.getName(), getNewCategory.getName());
        Assert.assertEquals(Optional.of(newCategoryBody.getSortIndex()),
                Optional.of(getNewCategory.getSortIndex()));
    }

    @Test
    public void testCreateNewParentCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("тестКатегория3",
                                                                        lastSortIndex+1,
                                                                        false)
                                                                        .build();
        Category newParentCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertEquals(newCategoryBody.getName(), newParentCategory.getName());
        Assert.assertEquals(Optional.of(newCategoryBody.getSortIndex()),
                            Optional.of(newParentCategory.getSortIndex()));
    }

    @Test
    public void testCreateNewChildCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();
        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("дочерняя тестовая категория1",
                                                                        lastSortIndex+1,
                                                                        false)
                                                                        .setParentDocCategoryId(lastSortIndex)
                                                                        .build();
        Category newChildCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertEquals(newCategoryBody.getName(), newChildCategory.getName());
        Assert.assertEquals(Optional.of(newCategoryBody.getSortIndex()),
                Optional.of(newChildCategory.getSortIndex()));
        Assert.assertEquals(Optional.ofNullable(newCategoryBody.getParentDocumentCategoryId()),
                Optional.of(newChildCategory.getParentDocumentCategoryId()));
    }

    @Test
    public void testNewDuplicateNameCategoryNegative () {
        int lastSortIndex = Helper.getMaxSortIndex();
        List<Category> allCategory = settingsService.getAllCategory();
        Assert.assertNotNull(allCategory);

        String newCategoryName = allCategory.get(10).getName();
        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder(newCategoryName,
                                                                    lastSortIndex+1,
                                                                    false)
                                                                        .build();
        Assert.assertTrue(settingsService.createNewCategoryNegative(newCategoryBody));
    }

    @Ignore("test was blocked by database. Sort index control will be implements later")
    @Test
    public void testNewDuplicateSortIndexCategoryNegative () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("sameIndex", lastSortIndex,
                false)
                .build();
        Assert.assertTrue(settingsService.createNewCategoryNegative(newCategoryBody));
    }

    @Test
    public void testUpdateCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("new category2",
                                                                            lastSortIndex+1,
                                                                            false)
                                                                            .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertTrue(newCategory.getIsActive());
        Assert.assertEquals(newCategory.getName(), newCategoryBody.getName());

        CategoryUpdateForm updateCategoryBody = new CategoryUpdateFormBuilder("updateCat2",
                                                                                newCategory.getSortIndex(),
                                                                                false)
                                                                                .build();
        Category updateCategoryName = settingsService.updateCategory(newCategory.getDocumentCategoryId(),
                                                                    updateCategoryBody);
        Assert.assertEquals(updateCategoryName.getName(), updateCategoryBody.getName());
    }

    @Test
    public void testUpdateChildCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentCategoryForUpdate1",
                                                                                lastSortIndex+1,
                                                                                false)
                                                                                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertEquals(newParentCategory.getName(), newParentCategoryBody.getName());
        Assert.assertTrue(newParentCategory.getIsActive());

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildCategoryForUpdate1",
                lastSortIndex+2,
                false)
                .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertTrue(newChildCategory.getIsActive());
        Assert.assertEquals(newChildCategory.getName(), newChildCategoryBody.getName());

        CategoryUpdateForm updateCategoryBody = new CategoryUpdateFormBuilder("updateChildCat1",
                                                                                newChildCategory.getSortIndex(),
                                                                                false)
                                                                                .build();
        Category updateCategoryName = settingsService.updateCategory(newChildCategory.getDocumentCategoryId(),
                                                                                        updateCategoryBody);
        Assert.assertEquals(updateCategoryName.getName(), updateCategoryBody.getName());
    }

    @Test
    public void deleteCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("TestDelParentCat1",
                                                                        lastSortIndex+1,
                                                                        false)
                                                                        .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertTrue(newCategory.getIsActive());

        Category deactivateParentCategory = settingsService.deleteCategory(newCategory.getDocumentCategoryId());
        Assert.assertFalse(deactivateParentCategory.getIsActive());
    }

    @Test
    public void deleteParentCategoryWithDocuments () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("ParentDeleteWithDocs2",
                                                                            lastSortIndex+1,
                                                                            false)
                                                                            .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertTrue(newCategory.getIsActive());

        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(
                DocTemplateWithRulesCreateForm.docForSettingsTest(newCategory.getDocumentCategoryId()));
        Assert.assertNotNull(documentsPacking);
        Assert.assertTrue(documentsPacking.getIsActive());
        Assert.assertNotNull(documentsPacking.getDocRulesIds());
        Assert.assertTrue(documentsPacking.getDocRulesIds().size() > 0);
        Assert.assertEquals(documentsPacking.getDocCategoryId(), newCategory.getDocumentCategoryId());

        Assert.assertTrue(settingsService.deleteCategoryNegative(newCategory.getDocumentCategoryId()));
    }

    @Test
    public void deleteChildCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentForChildDelete1",
                                                                                lastSortIndex+1,
                                                                                false)
                                                                                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertTrue(newParentCategory.getIsActive());

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildCatDelete1",
                                                    lastSortIndex+2,
                                                    false)
                                                    .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                                                    .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertTrue(newChildCategory.getIsActive());

        Category deactivateChildCategory = settingsService.deleteCategory(newChildCategory.getDocumentCategoryId());
        Assert.assertFalse(deactivateChildCategory.getIsActive());
    }

    @Test
    public void deleteChildCategoryWithDocuments () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentNegativeDelete1",
                                                                                lastSortIndex+1,
                                                                                false)
                                                                                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertTrue(newParentCategory.getIsActive());

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildForDeleteWithDocs1",
                                                    lastSortIndex+2,
                                                    false)
                                                    .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                                                    .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertTrue(newChildCategory.getIsActive());

        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(
                DocTemplateWithRulesCreateForm.docForSettingsTest(newChildCategory.getDocumentCategoryId()));
        Assert.assertNotNull(documentsPacking);
        Assert.assertNotNull(documentsPacking.getDocRulesIds());
        Assert.assertTrue(documentsPacking.getDocRulesIds().size() > 0);
        Assert.assertEquals(documentsPacking.getDocCategoryId(), newChildCategory.getDocumentCategoryId());
        Assert.assertTrue(documentsPacking.getIsActive());

        Assert.assertTrue(settingsService.deleteCategoryNegative(newChildCategory.getDocumentCategoryId()));
    }

    @Test
    public void testRecoveryParentCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("TestRecoveryParentCat1",
                                                                            lastSortIndex+1,
                                                                            false)
                                                                            .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertTrue(newCategory.getIsActive());

        Assert.assertFalse(settingsService.deleteCategory(newCategory.getDocumentCategoryId()).getIsActive());
        Assert.assertTrue(settingsService.recoverCategory(newCategory.getDocumentCategoryId()).getIsActive());
    }

    @Test
    public void testRecoveryChildCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentForRecovery1",
                lastSortIndex+1,
                false)
                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertTrue(newParentCategory.getIsActive());

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildRecovery3",
                                                    lastSortIndex+2,
                                                    false)
                                                    .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                                                    .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertTrue(newChildCategory.getIsActive());

        Assert.assertFalse(settingsService.deleteCategory(newChildCategory.getDocumentCategoryId()).getIsActive());

        Assert.assertTrue(settingsService.recoverCategory(newChildCategory.getDocumentCategoryId()).getIsActive());
    }

    @Test
    public void testCreateDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-12-01",
                                                                       "2023-12-31",
                                                                  "01122083/122023/9123036")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertTrue(newDeclaration.getIsActive());
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());
    }

    @Test
    public void testCreateDeclarationDuplicate () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-12-01",
                                                                    "2024-12-31",
                                                                    "01122083/122024/3122024")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertTrue(newDeclaration.getIsActive());
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());
        TdTsCreateForm newDeclarationBodyDuplicate = new TdTsCreateFormBuilder("2023-12-01",
                                                                                "2024-12-31",
                                                                                "01122083/122024/3122024")
                                                                                .build();
        Assert.assertTrue(settingsService.createDeclarationNegative(newDeclarationBodyDuplicate));
    }

    @Test
    public void testGetTdDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-11-01",
                                                                        "2024-01-31",
                                                                    "01122023/122025/7229023")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertTrue(newDeclaration.getIsActive());
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());

        TdTs checkDeclaration = settingsService.getDeclaration(newDeclaration.getId());
        Assert.assertEquals(checkDeclaration.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(checkDeclaration.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(checkDeclaration.getFuelNumber(), newDeclaration.getFuelNumber());
    }

    @Test
    public void testCreateDeclarationNegativeWrongDate () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-11-01",
                                                              "2022-11-30",
                                                        "12365478/685236/9874723")
                                                                    .build();
        Assert.assertTrue(settingsService.createDeclarationNegative(newDeclarationBody));
    }
    @Ignore("request would be blocked by builder")
    @Test
    public void testCreateDeclarationNegativeMissFuelDeclarationNumber () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-11-01",
                                                                    "2023-11-30",
                                                            "98765432/235684/9674123")
                                                                        .build();
        Assert.assertTrue(settingsService.createDeclarationNegative(newDeclarationBody));
    }

    @Test
    public void testUpdateDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-05-01",
                                                                        "2024-05-31",
                                                                    "01052024/052024/3152094")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());

        TdTsUpdateForm updateDeclarationBody = new TdTsUpdateFormBuilder()
                .setDateStart("2024-03-01")
                .setDateEnd("2024-03-28")
                .setIsActive(true)
                .setFuelNumber("20240301/208402/0001100")
                .build();

        TdTs updateDeclaration = settingsService.updateDeclaration(newDeclaration.getId(), updateDeclarationBody);
        Assert.assertNotNull(updateDeclaration);
        Assert.assertEquals(updateDeclaration.getFuelNumber(), updateDeclarationBody.getFuelNumber());
        Assert.assertNotEquals(updateDeclaration.getFuelNumber(), newDeclaration.getFuelNumber());
    }

    @Test
    public void testUpdateDeclarationDateNegative () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-03-01",
                                                                        "2024-03-31",
                                                                        "01032027/032027/3932029")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());

        TdTsUpdateForm updateDeclarationBody = new TdTsUpdateFormBuilder()
                                                                    .setIsActive(true)
                                                                    .setDateStart("2024-03-01")
                                                                    .setDateEnd("2023-03-31")
                                                                    .setFuelNumber("01032024/032027/3532029")
                                                                    .build();
        Assert.assertTrue(settingsService.updateDeclarationNegative(newDeclaration.getId(), updateDeclarationBody));
    }

    @Test
    public void testUpdateDeclarationNumberNegative () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-02-01",
                                                                    "2024-08-31",
                                                                    "01022024/022024/3182024")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());

        TdTsUpdateForm updateDeclarationBody = new TdTsUpdateFormBuilder()
                                                                    .setIsActive(true)
                                                                    .setDateStart("2024-02-01")
                                                                    .setDateEnd("2024-08-31")
                                                                    .setFuelNumber("01022024/032024/318202")
                                                                    .build();
        Assert.assertTrue(settingsService.updateDeclarationNegative(newDeclaration.getId(), updateDeclarationBody));
    }

    @Test
    public void testDeleteDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-01-01",
                                                                    "2024-06-30",
                                                                "01032024/062034/3162034")
                                                                        .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertTrue(newDeclaration.getIsActive());
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());

        Assert.assertFalse(settingsService.deleteDeclaration(newDeclaration.getId()).getIsActive());
    }

    @Test
    public void testRecoveryDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-02-01",
                                                                        "2024-07-31",
                                                                        "01022024/022024/3172035")
                                                                        .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertTrue(newDeclaration.getIsActive());
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelNumber(), newDeclaration.getFuelNumber());
        System.out.println(newDeclaration.getId());
        Assert.assertFalse(settingsService.deleteDeclaration(newDeclaration.getId()).getIsActive());
        Assert.assertTrue(settingsService.recoveryDeclaration(newDeclaration.getId()).getIsActive());
    }
}

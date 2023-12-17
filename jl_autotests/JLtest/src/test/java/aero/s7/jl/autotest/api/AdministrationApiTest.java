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
        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("тестКатегория2",
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

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("тестКатегория1",
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
        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("дочерняя тестовая категория",
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

    @Test
    public void testNewDuplicateSortIndexCategoryNegative () {
        int lastSortIndex = Helper.getMaxSortIndex();
        List<Category> allCategory = settingsService.getAllCategory();
        
        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder("sameIndex", 39,
                false)
                .build();
        Assert.assertTrue(settingsService.createNewCategoryNegative(newCategoryBody));
    }

    @Test
    public void testUpdateCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("new category",
                                                                            lastSortIndex+1,
                                                                            false)
                                                                            .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getName(), newCategoryBody.getName());

        CategoryUpdateForm updateCategoryBody = new CategoryUpdateFormBuilder("updateCat",
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

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentCategoryForUpdate",
                lastSortIndex+1,
                false)
                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertEquals(newParentCategory.getName(), newParentCategoryBody.getName());
        Assert.assertTrue(newParentCategory.getIsActive());

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildCategoryForUpdate",
                lastSortIndex+2,
                false)
                .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertTrue(newChildCategory.getIsActive());
        Assert.assertEquals(newChildCategory.getName(), newChildCategoryBody.getName());

        CategoryUpdateForm updateCategoryBody = new CategoryUpdateFormBuilder("updateChildCat",
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

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("TestDelParentCat",
                                                                        lastSortIndex+1,
                                                                        false)
                                                                        .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertNotNull(newCategory);

        Category deactivateParentCategory = settingsService.deleteCategory(newCategory.getDocumentCategoryId());
        Assert.assertFalse(deactivateParentCategory.getIsActive());
    }

    @Test
    public void deleteParentCategoryWithDocuments () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newCategoryBody = new CategoryCreateFormBuilder ("ParentDeleteWithDocs",
                lastSortIndex+1,
                false)
                .build();
        Category newCategory = settingsService.createCategory(newCategoryBody);
        Assert.assertNotNull(newCategory);

        DocumentsPacking documentsPacking = documentsPackingService.createDocumentWithRule(
                DocTemplateWithRulesCreateForm.docForSettingsTest(newCategory.getDocumentCategoryId()));
        Assert.assertNotNull(documentsPacking);
        Assert.assertNotNull(documentsPacking.getDocRulesIds());
        Assert.assertTrue(documentsPacking.getDocRulesIds().size() > 0);
        Assert.assertEquals(documentsPacking.getDocCategoryId(), newCategory.getDocumentCategoryId());
        Assert.assertTrue(documentsPacking.getIsActive());

        Assert.assertTrue(settingsService.deleteCategoryNegative(newCategory.getDocumentCategoryId()));
    }

    @Test
    public void deleteChildCategory () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentForChildDelete",
                lastSortIndex+1,
                false)
                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertNotNull(newParentCategory);

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildCatDelete",
                lastSortIndex+2,
                false)
                .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertNotNull(newChildCategory);

        Category deactivateChildCategory = settingsService.deleteCategory(newChildCategory.getDocumentCategoryId());
        Assert.assertFalse(deactivateChildCategory.getIsActive());
    }

    @Test
    public void deleteChildCategoryWithDocuments () {
        int lastSortIndex = Helper.getMaxSortIndex();

        CategoryCreateForm newParentCategoryBody = new CategoryCreateFormBuilder ("ParentNegativeDelete",
                lastSortIndex+1,
                false)
                .build();
        Category newParentCategory = settingsService.createCategory(newParentCategoryBody);
        Assert.assertNotNull(newParentCategory);

        CategoryCreateForm newChildCategoryBody = new CategoryCreateFormBuilder ("ChildForDeleteWithDocs",
                lastSortIndex+2,
                false)
                .setParentDocCategoryId(newParentCategory.getDocumentCategoryId())
                .build();
        Category newChildCategory = settingsService.createCategory(newChildCategoryBody);
        Assert.assertNotNull(newChildCategory);

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
    public void testCreateTdDocument () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-12-01",
                                                                       "2023-12-31",
                                                                  "01122083/122023/3122036")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());
    }

    @Test
    public void testGetTdTsDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-12-01T00:00:00.000Z",
                                                            "2024-01-31T00:00:00.000Z",
                                                        "01122023/122024/3229023")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());

        TdTs checkDeclaration = settingsService.getDeclaration(newDeclaration.getId());
        Assert.assertEquals(checkDeclaration.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(checkDeclaration.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(checkDeclaration.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());
    }

    @Test
    public void testCreateDeclarationNegativeWrongDate () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-11-01T00:00:00Z",
                                                              "2022-11-30T00:00:00Z",
                                                        "12365478/985236/9874123")
                                                                    .build();
        Assert.assertTrue(settingsService.createDeclarationNegative(newDeclarationBody));
    }
    @Ignore("request would be blocked by builder")
    @Test
    public void testCreateDeclarationNegativeMissFuelDeclarationNumber () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2023-11-01T00:00:00Z",
                                                                    "2023-11-30T00:00:00Z",
                                                            "98765432/235689/9874123")
                                                                        .build();
        Assert.assertTrue(settingsService.createDeclarationNegative(newDeclarationBody));
    }

    @Test
    public void testUpdateDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-03-01T00:00:00Z",
                                                                        "2024-03-28T00:00:00Z",
                                                                    "01022029/022028/2872899")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        //Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        //Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());

        TdTsUpdateForm updateDeclarationBody = new TdTsUpdateFormBuilder()
                .setDateStart("2024-03-01T00:00:00Z")
                .setDateEnd("2024-03-28T00:00:00Z")
                .setIsActive(true)
                .setFuelDeclNumber("20240301/208402/0001000")
                .build();

        TdTs updateDeclaration = settingsService.updateDeclaration(newDeclaration.getId(), updateDeclarationBody);
        Assert.assertNotNull(updateDeclaration);
        Assert.assertEquals(updateDeclaration.getFuelDeclNumber(), updateDeclarationBody.getFuelDeclNumber());
        Assert.assertNotEquals(updateDeclaration.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());
    }

    @Test
    public void testUpdateDeclarationNegative () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-03-01T00:00:00.000Z",
                                                                        "2024-03-31T00:00:00.000Z",
                                                                        "01032024/032027/3932029")
                                                                    .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        //Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        //Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());

        TdTsUpdateForm updateDeclarationBody = new TdTsUpdateFormBuilder()
                .setIsActive(true)
                .setDateStart("2024-03-01T00:00:00.000Z")
                .setDateEnd("2023-03-31T00:00:00Z")
                .setFuelDeclNumber("01032024/032027/3932029")
                .build();
        Assert.assertTrue(settingsService.updateDeclarationNegative(newDeclaration.getId(), updateDeclarationBody));
    }

    @Test
    public void testDeleteDeclaration () {
        TdTsCreateForm newDeclarationBody = new TdTsCreateFormBuilder("2024-03-01T00:00:00Z",
                                                                    "2024-03-31T00:00:00Z",
                                                            "01032024/032024/3132024")
                                                                        .build();
        TdTs newDeclaration = settingsService.createDeclaration(newDeclarationBody);
        Assert.assertNotNull(newDeclaration);
        Assert.assertEquals(newDeclarationBody.getDateStart(), newDeclaration.getDateStart());
        Assert.assertEquals(newDeclarationBody.getDateEnd(), newDeclaration.getDateEnd());
        Assert.assertEquals(newDeclarationBody.getFuelDeclNumber(), newDeclaration.getFuelDeclNumber());

        Assert.assertTrue(settingsService.deleteTdTs(newDeclaration.getId()));
    }
}

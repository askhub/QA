package aero.s7.jl.autotest.api.Administration;

import java.util.List;

public interface SettingsService {
    List<Category> getAllCategory();
    Category getCategory (int id);
    Category createCategory (CategoryCreateForm form);
    Boolean createNewCategoryNegative (CategoryCreateForm form);
    Category updateCategory (int id, CategoryUpdateForm form);
    Category deleteCategory (int documentCategoryId);
    Category recoverCategory (int documentCategoryId);
    boolean deleteCategoryNegative (int documentCategoryId);
    List<TdTs> getAllDeclarations();
    TdTs getDeclaration (int id);
    TdTs createDeclaration (TdTsCreateForm form);
    boolean createDeclarationNegative (TdTsCreateForm form);
    TdTs updateDeclaration (int id, TdTsUpdateForm form);
    boolean updateDeclarationNegative (int id, TdTsUpdateForm form);
    TdTs deleteDeclaration (int id);
    TdTs recoveryDeclaration (int id);
}

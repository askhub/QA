package aero.s7.jl.autotest.api.Administration;

public class CategoryUpdateFormBuilder {
    Boolean isSystem;
    String name;
    Integer parentDocumentCategoryId;
    Integer sortIndex;

    public CategoryUpdateFormBuilder (String name, Integer sortIndex, Boolean isSystem) {
        this.isSystem = isSystem;
        this.name = name;
        this.sortIndex = sortIndex;
    }

    public CategoryUpdateFormBuilder setParentDocumentCategoryId(int parentDocumentCategoryId) {
        this.parentDocumentCategoryId = parentDocumentCategoryId;
        return this;
    }

    public CategoryUpdateForm build() {
        return new CategoryUpdateForm(this);
    }
}

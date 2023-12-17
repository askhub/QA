package aero.s7.jl.autotest.api.Administration;

public class CategoryCreateFormBuilder {

    Boolean isSystem;
    String name;
    Integer parentDocumentCategoryId;
    Integer sortIndex;


    public CategoryCreateFormBuilder (String name, Integer sortIndex, Boolean isSystem) {
        this.name = name;
        this.sortIndex = sortIndex;
        this.isSystem = isSystem;
    }

    public CategoryCreateFormBuilder setParentDocCategoryId(int parentDocumentCategoryId) {
        this.parentDocumentCategoryId = parentDocumentCategoryId;
        return this;
    }

    public CategoryCreateForm build() {
        return new CategoryCreateForm(this);
    }
}

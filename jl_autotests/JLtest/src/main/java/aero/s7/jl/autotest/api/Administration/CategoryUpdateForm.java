package aero.s7.jl.autotest.api.Administration;

public class CategoryUpdateForm {
    private final boolean isSystem;
    private final String name;
    private final Integer parentDocumentCategoryId;
    private final int sortIndex;

    public CategoryUpdateForm (CategoryUpdateFormBuilder categoryUpdateFormBuilder) {
        isSystem = categoryUpdateFormBuilder.isSystem;
        name = categoryUpdateFormBuilder.name;
        parentDocumentCategoryId = categoryUpdateFormBuilder.parentDocumentCategoryId;
        sortIndex = categoryUpdateFormBuilder.sortIndex;
    }

    public Boolean getIsSystem() {
        return isSystem;
    }

    public String getName() {
        return name;
    }

    public int getParentDocumentCategoryId() {
        return parentDocumentCategoryId;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }
}

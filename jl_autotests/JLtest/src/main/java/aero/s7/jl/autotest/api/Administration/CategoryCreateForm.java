package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryCreateForm {

    @JsonProperty("is_system")
    private final boolean isSystem;
    private final String name;
    @JsonProperty("parent_document_category_id")
    private final Integer parentDocumentCategoryId;
    @JsonProperty("sort_index")
    private final int sortIndex;

    public CategoryCreateForm (CategoryCreateFormBuilder categoryCreateFormBuilder) {
        isSystem = categoryCreateFormBuilder.isSystem;
        name = categoryCreateFormBuilder.name;
        parentDocumentCategoryId = categoryCreateFormBuilder.parentDocumentCategoryId;
        sortIndex = categoryCreateFormBuilder.sortIndex;
    }

    public boolean getIsSystem() {
        return isSystem;
    }
    public String getName() {
        return name;
    }
    public Integer getParentDocumentCategoryId() {
        return parentDocumentCategoryId;
    }
    public int getSortIndex() {
        return sortIndex;
    }
}

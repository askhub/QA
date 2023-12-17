package aero.s7.jl.autotest.api.Administration;

public class CategoryBaseForm {

    private boolean isSystem;
    private String name;
    private int parentDocCategoryId;
    private int sortIndex;

    public CategoryBaseForm() {
    }

    public boolean getIsSystem() {
        return isSystem;
    }
    public void setIsSystem(boolean isSystem) {
        this.isSystem = isSystem;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getParentDocCategoryId() {
        return parentDocCategoryId;
    }
    public void setParentDocCategoryId(int parentDocCategoryId) {
        this.parentDocCategoryId = parentDocCategoryId;
    }

    public int getSortIndex() {
        return sortIndex;
    }
    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}



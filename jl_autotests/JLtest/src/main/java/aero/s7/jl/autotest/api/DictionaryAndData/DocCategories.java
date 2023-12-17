package aero.s7.jl.autotest.api.DictionaryAndData;

public class DocCategories {
    private int id;
    private int parentDocCategoryId;
    private String name;
    private int sortIndex;
    private boolean isActive;
    private boolean isSystem;
    private int authorId;
    private String authorFullName;
    private String createDate;
    private String modifyAuthorFullName;
    private String modifyDate;
    private String modifyAuthorId;


    public DocCategories() {
    }

    public int getId() {
        return id;
    }
    public int getParentDocCategoryId() {
        return parentDocCategoryId;
    }
    public String getName() {
        return name;
    }
    public int getSortIndex() {
        return sortIndex;
    }
    public boolean getIsActive() {
        return isActive;
    }
    public boolean getIsSystem() {
        return isSystem;
    }
    public int getAuthorId() {
        return authorId;
    }
    public String getAuthorFullName() {
        return authorFullName;
    }
    public String getCreateDate() {
        return createDate;
    }
    public String getModifyAuthorFullName() {
        return modifyAuthorFullName;
    }
    public String getModifyDate() {
        return modifyDate;
    }
    public String getModifyAuthorId() {
        return modifyAuthorId;
    }
}

package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty("create_date")
    private String createDate; //"2023-10-17T05:52:28.763Z"

    @JsonProperty("create_user_full_name")
    private String createUserFullName;

    @JsonProperty("create_user_id")
    private int createUserId;

    @JsonProperty("document_category_id")
    private int documentCategoryId;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("is_system")
    private boolean isSystem;

    @JsonProperty("modify_user_full_name")
    private String modifyUserFullName;

    @JsonProperty("modify_user_id")
    private int modifyUserId;

    @JsonProperty("modify_date")
    private String modifyDate; // "2023-10-17T05:52:28.763Z"

    private String name;

    @JsonProperty("parent_document_category_id")
    private int parentDocumentCategoryId;

    @JsonProperty("sort_index")
    private int sortIndex;

    public Category() {
    }

    public String getCreateDate() {
        return createDate;
    }
    public String getCreateUserFullName() {
        return createUserFullName;
    }
    public int getCreateUserId() {
        return createUserId;
    }
    public int getDocumentCategoryId() {
        return documentCategoryId;
    }
    public boolean getIsActive() {
        return isActive;
    }
    public boolean getIsSystem() {
        return isSystem;
    }
    public String getModifyUserFullName() {
        return modifyUserFullName;
    }
    public int getModifyUserId() {
        return modifyUserId;
    }
    public String getModifyDate() {
        return modifyDate;
    }
    public String getName() {
        return name;
    }
    public int getParentDocumentCategoryId() {
        return parentDocumentCategoryId;
    }
    public int getSortIndex() {
        return sortIndex;
    }
}

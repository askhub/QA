package aero.s7.jl.autotest.api.DocumentsPacking;

import java.util.List;

public class DocumentsPacking {
    private String description;
    private int docCategoryId;
    private int docFileId;
    private List<Integer> docOwnerIds;
    private String docType;
    private boolean isActive;
    private String name;
    private int prevDocId;
    private String validityPeriodEnd; //"2023-07-21T05:01:55.135Z"
    private String validityPeriodStart;
    private boolean whitePage;

    private String authorFullName;
    private int authorId;
    private String authorName;
    private String createDate; //"2023-07-21T08:30:12.974Z"
    private List<Integer> docRulesIds;
    private List<Integer> docTemplateParamsIds;
    private int id;
    private  String modifyAuthorFullName;
    private int modifyAuthorId;
    private String modifyDate; // "2023-07-21T08:30:12.974Z"
    private int sortIndex;

    public DocumentsPacking() {
    }

    public String getDescription() {
        return description;
    }

    public Integer getDocCategoryId() {
        return docCategoryId;
    }

    public int getDocFileId() {
        return docFileId;
    }

    public List<Integer> getDocOwnerIds() {
        return docOwnerIds;
    }

    public String getDocType() {
        return docType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public Integer getPrevDocId() {
        return prevDocId;
    }

    public String getValidityPeriodEnd() {
        return validityPeriodEnd;
    }

    public String getValidityPeriodStart() {
        return validityPeriodStart;
    }

    public Boolean getWhitePage() {
        return whitePage;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public List<Integer> getDocRulesIds() {
        return docRulesIds;
    }

    public List<Integer> getDocTemplateParamsIds() {
        return docTemplateParamsIds;
    }

    public int getId() {
        return id;
    }

    public String getModifyAuthorFullName() {
        return modifyAuthorFullName;
    }

    public int getModifyAuthorId() {
        return modifyAuthorId;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public int getSortIndex() {
        return sortIndex;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setDocCategoryId(Integer docCategoryId) {
        this.docCategoryId = docCategoryId;
    }

    public void setDocFileId(Integer docFileId) {
        this.docFileId = docFileId;
    }

    public void setDocOwnerIds(List<Integer> docOwnerIds) {
        this.docOwnerIds = docOwnerIds;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrevDocId(Integer prevDocId) {
        this.prevDocId = prevDocId;
    }

    public void setValidityPeriodEnd(String validityPeriodEnd) {
        this.validityPeriodEnd = validityPeriodEnd;
    }

    public void setValidityPeriodStart(String validityPeriodStart) {
        this.validityPeriodStart = validityPeriodStart;
    }

    public void setWhitePage(Boolean whitePage) {
        this.whitePage = whitePage;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setDocRulesIds(List<Integer> docRulesIds) {
        this.docRulesIds = docRulesIds;
    }

    public void setDocTemplateParamsIds(List<Integer> docTemplateParamsIds) {
        this.docTemplateParamsIds = docTemplateParamsIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModifyAuthorFullName(String modifyAuthorFullName) {
        this.modifyAuthorFullName = modifyAuthorFullName;
    }

    public void setModifyAuthorId(int modifyAuthorId) {
        this.modifyAuthorId = modifyAuthorId;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}

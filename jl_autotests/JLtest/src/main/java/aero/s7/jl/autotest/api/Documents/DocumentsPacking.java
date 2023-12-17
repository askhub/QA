package aero.s7.jl.autotest.api.Documents;

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
    private boolean replaceWhitePage;


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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDocCategoryId() {
        return docCategoryId;
    }

    public void setDocCategoryId(int docCategoryId) {
        this.docCategoryId = docCategoryId;
    }

    public int getDocFileId() {
        return docFileId;
    }

    public void setDocFileId(int docFileId) {
        this.docFileId = docFileId;
    }

    public List<Integer> getDocOwnerIds() {
        return docOwnerIds;
    }

    public void setDocOwnerIds(List<Integer> docOwnerIds) {
        this.docOwnerIds = docOwnerIds;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrevDocId() {
        return prevDocId;
    }

    public void setPrevDocId(int prevDocId) {
        this.prevDocId = prevDocId;
    }

    public String getValidityPeriodEnd() {
        return validityPeriodEnd;
    }

    public void setValidityPeriodEnd(String validityPeriodEnd) {
        this.validityPeriodEnd = validityPeriodEnd;
    }

    public String getValidityPeriodStart() {
        return validityPeriodStart;
    }

    public void setValidityPeriodStart(String validityPeriodStart) {
        this.validityPeriodStart = validityPeriodStart;
    }

    public boolean getWhitePage() {
        return whitePage;
    }

    public void setWhitePage(boolean whitePage) {
        this.whitePage = whitePage;
    }

    public boolean replaceWhitePage() {
        return replaceWhitePage;
    }

    public void setReplaceWhitePage(boolean replaceWhitePage) {
        this.replaceWhitePage = replaceWhitePage;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Integer> getDocRulesIds() {
        return docRulesIds;
    }

    public void setDocRulesIds(List<Integer> docRulesIds) {
        this.docRulesIds = docRulesIds;
    }

    public List<Integer> getDocTemplateParamsIds() {
        return docTemplateParamsIds;
    }

    public void setDocTemplateParamsIds(List<Integer> docTemplateParamsIds) {
        this.docTemplateParamsIds = docTemplateParamsIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModifyAuthorFullName() {
        return modifyAuthorFullName;
    }

    public void setModifyAuthorFullName(String modifyAuthorFullName) {
        this.modifyAuthorFullName = modifyAuthorFullName;
    }

    public int getModifyAuthorId() {
        return modifyAuthorId;
    }

    public void setModifyAuthorId(int modifyAuthorId) {
        this.modifyAuthorId = modifyAuthorId;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}

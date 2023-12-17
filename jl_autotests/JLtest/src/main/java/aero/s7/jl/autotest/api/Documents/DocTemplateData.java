package aero.s7.jl.autotest.api.Documents;

import java.util.List;

public class DocTemplateData {
        private String authorFullName;
        private int authorId;
        private String authorName;
        private String createDate;
        private String description;
        private int docCategoryId;
        private int docFileId;
        private List<Integer> docOwnerIds;
        private List<Integer> docRulesIds;
        private List<Integer> docTemplateParamsIds;
        private String docType;
        private int id;
        private boolean isActive;
        private String modifyAuthorFullName;
        private int modifyAuthorId;
        private String modifyDate;
        private String name;
        private int prevDocId;
        private int sortIndex;
        private String validityPeriodEnd;
        private String validityPeriodStart;
        private boolean whitePage;
        private boolean replaceWhitePage;



        public DocTemplateData()
        {
            super();
        }

        public DocTemplateData(String authorFullName, int authorId, String authorName, String createDate,
                           String description, int docCategoryId, int docFileId, List<Integer> docOwnerIds,
                           List<Integer> docRulesIds, List<Integer> docTemplateParamsIds, String docType,
                           int id, boolean isActive, String modifyAuthorFullName, int modifyAuthorId,
                           String modifyDate, String name, int prevDocId, int sortIndex,
                           String validityPeriodEnd, String validityPeriodStart, boolean whitePage,
                           boolean replaceWhitePage) {
        this.authorFullName = authorFullName;
        this.authorId = authorId;
        this.authorName = authorName;
        this.createDate = createDate;
        this.description = description;
        this.docCategoryId = docCategoryId;
        this.docFileId = docFileId;
        this.docOwnerIds = docOwnerIds;
        this.docRulesIds = docRulesIds;
        this.docTemplateParamsIds = docTemplateParamsIds;
        this.docType = docType;
        this.id = id;
        this.isActive = isActive;
        this.modifyAuthorFullName = modifyAuthorFullName;
        this.modifyAuthorId = modifyAuthorId;
        this.modifyDate = modifyDate;
        this.name = name;
        this.prevDocId = prevDocId;
        this.sortIndex = sortIndex;
        this.validityPeriodEnd = validityPeriodEnd;
        this.validityPeriodStart = validityPeriodStart;
        this.whitePage = whitePage;
        this.replaceWhitePage = replaceWhitePage;
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
    public String getDescription() {
        return description;
    }
    public int getDocCategoryId() {
        return docCategoryId;
    }
    public int getDocFileId() {
        return docFileId;
    }
    public List<Integer> getDocOwnerIds() {
        return docOwnerIds;
    }
    public List<Integer> getDocRulesIds() {
        return docRulesIds;
    }
    public List<Integer> getDocTemplateParamsIds() {
        return docTemplateParamsIds;
    }
    public String getDocType() {
        return docType;
    }
    public int getId() {
        return id;
    }
    public boolean getIsActive() {
        return isActive;
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
    public String getName() {
        return name;
    }
    public int getPrevDocId() {
        return prevDocId;
    }
    public int getSortIndex() {
        return sortIndex;
    }
    public String getValidityPeriodEnd() {
        return validityPeriodEnd;
    }
    public String getValidityPeriodStart() {
        return validityPeriodStart;
    }
    public boolean getWhitePage() {
        return whitePage;
    }
    public boolean getReplaceWhitePage() {
        return replaceWhitePage;
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
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDocCategoryId(int docCategoryId) {
        this.docCategoryId = docCategoryId;
    }
    public void setDocFileId(int docFileId) {
        this.docFileId = docFileId;
    }
    public void setDocOwnerIds(List<Integer> docOwnerIds) {
        this.docOwnerIds = docOwnerIds;
    }
    public void setDocRulesIds(List<Integer> docRulesIds) {
        this.docRulesIds = docRulesIds;
    }
    public void setDocTemplateParamsIds(List<Integer> docTemplateParamsIds) {
        this.docTemplateParamsIds = docTemplateParamsIds;
    }
    public void setDocType(String docType) {
        this.docType = docType;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setPrevDocId(int prevDocId) {
        this.prevDocId = prevDocId;
    }
    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
    public void setValidityPeriodEnd(String validityPeriodEnd) {
        this.validityPeriodEnd = validityPeriodEnd;
    }
    public void setValidityPeriodStart(String validityPeriodStart) {
        this.validityPeriodStart = validityPeriodStart;
    }
    public void setWhitePage(boolean whitePage) {
        this.whitePage = whitePage;
    }
    public void setReplaceWhitePage(boolean replaceWhitePage) {
        this.replaceWhitePage = replaceWhitePage;
    }
}


    /*
    "content": [
            {
                "authorFullName": "string",
                "authorId": 0,
                "authorName": "string",
                "createDate": "2023-08-11T04:47:34.887Z",
                "description": "string",
                "docCategoryId": 0,
                "docFileId": 0,
                "docOwnerIds": [0],
                "docRulesIds": [0],
                "docTemplateParamsIds": [0],
                "docType": "DYNAMIC",
                "id": 0,
                "isActive": true,
                "modifyAuthorFullName": "string",
                "modifyAuthorId": 0,
                "modifyDate": "2023-08-11T04:47:34.887Z",
                "name": "string",
                "prevDocId": 0,
                "sortIndex": 0,
                "validityPeriodEnd": "2023-08-11T04:47:34.887Z",
                "validityPeriodStart": "2023-08-11T04:47:34.887Z",
                "whitePage": true
            }],
    "empty": true,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 0,
    "pageable": {
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 0,
            "paged": true,
            "sort": {
                    "empty": true,
                    "sorted": true,
                    "unsorted": true
                        },
            "unpaged": true},
    "size": 0,
    "sort": {
        "empty": true,
        "sorted": true,
        "unsorted": true},
    "totalElements": 0,
    "totalPages": 0

}
*/
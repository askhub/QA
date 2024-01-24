package aero.s7.jl.autotest.api.Documents;

import java.util.List;

public class DocumentsPackingBaseForm {

        public String description;
        public Integer docCategoryId;
        public String docFile;
        public int docFileId;
        public List<Integer> docOwnerIds;
        public String docType;
        public Boolean isActive;
        public String name;
        public Integer prevDocId;
        public String validityPeriodEnd; //"2023-07-21T05:01:55.135Z"
        public String validityPeriodStart;
        public Boolean isWhitePage;
        public Boolean isReplaceWhitePage;
        public List<Integer> docRulesIds;
        public List<Integer> docTemplateParamsIds;
        public int id;
        public String authorFullName;
        public int authorId;
        public String authorName;
        public  String createDate;
        public String modifyAuthorFullName;
        public int modifyAuthorId;
        public String modifyDate;
        public int sortIndex;

        public int aircraftId;
        public int airlineId;
        public String arrAirports;
        public String capCY;
        public int copies;
        public int countryArrId;
        public int countryDepId;
        public int crewRouteCategoryId;
        public String crewType;
        public int board;
        public String dateEnd; //2023-07-25T07:30:39.363Z
        public String dateStart;
        public String depAirports;
        public int docId;
        public int docTemplateId;
        public String flightNumbers;
        public String flightType;
        public String routeType;
        public String rule; // EXCLUDE, INCLUDE
        public Boolean isTechnicalStop;


        public DocumentsPackingBaseForm() {

        }

        public String getDescription() {
                return description;
        }
        public void setDescription(String description) {
                this.description = description;
        }

        public Integer getDocCategoryId() {
                return docCategoryId;
        }
        public void setDocCategoryId(Integer docCategoryId) {
                this.docCategoryId = docCategoryId;
        }

        public String getDocFile() {
                return docFile;
        }
        public void setDocFile(String docFile) {
                this.docFile = docFile;
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

        public Boolean getIsActive() {
                return isActive;
        }
        public void setIsActive(Boolean isActive) {
                this.isActive = isActive;
        }

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }

        public Integer getPrevDocId() {
                return prevDocId;
        }
        public void setPrevDocId(Integer prevDocId) {
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

        public Boolean getIsWhitePage() {
                return isWhitePage;
        }
        public void setIsWhitePage(Boolean isWhitePage) {
                this.isWhitePage = isWhitePage;
        }

        public Boolean getIsReplaceWhitePage() {
                return isReplaceWhitePage;
        }
        public void setIsReplaceWhitePage(Boolean isReplaceWhitePage) {
                this.isReplaceWhitePage = isReplaceWhitePage;
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

        public int getAircraftId() {
                return aircraftId;
        }
        public void setAircraftId(int aircraftId) {
                this.aircraftId = aircraftId;
        }

        public int getAirlineId() {
                return airlineId;
        }
        public void setAirlineId(int airlineId) {
                this.airlineId = airlineId;
        }

        public String getArrAirports() {
                return arrAirports;
        }
        public void setArrAirports(String arrAirports) {
                this.arrAirports = arrAirports;
        }

        public String getCapCY() {
                return capCY;
        }
        public void setCapCY(String capCY) {
                this.capCY = capCY;
        }

        public int getCopies() {
                return copies;
        }
        public void setCopies(int copies) {
                this.copies = copies;
        }

        public int getCountryArrId() {
                return countryArrId;
        }
        public void setCountryArrId(int countryArrId) {
                this.countryArrId = countryArrId;
        }

        public int getCountryDepId() {
                return countryDepId;
        }
        public void setCountryDepId(int countryDepId) {
                this.countryDepId = countryDepId;
        }

        public int getCrewRouteCategoryId() {
                return crewRouteCategoryId;
        }
        public void setCrewRouteCategoryId(int crewRouteCategoryId) {
                this.crewRouteCategoryId = crewRouteCategoryId;
        }

        public String getCrewType() {
                return crewType;
        }
        public void setCrewType(String crewType) {
                this.crewType = crewType;
        }

        public int getBoard() {
                return board;
        }
        public void setBoard(int board) {
                this.board = board;
        }

        public String getDateEnd() {
                return dateEnd;
        }
        public void setDateEnd(String dateEnd) {
                this.dateEnd = dateEnd;
        }

        public String getDateStart() {
                return dateStart;
        }
        public void setDateStart(String dateStart) {
                this.dateStart = dateStart;
        }

        public String getDepAirports() {
                return depAirports;
        }
        public void setDepAirports(String depAirports) {
                this.depAirports = depAirports;
        }

        public int getDocId() {
                return docId;
        }
        public void setDocId(int docId) {
                this.docId = docId;
        }

        public int getDocTemplateId() {
                return docTemplateId;
        }
        public void setDocTemplateId(int docTemplateId) {
                this.docTemplateId = docTemplateId;
        }

        public String getFlightNumbers() {
                return flightNumbers;
        }
        public void setFlightNumbers(String flightNumbers) {
                this.flightNumbers = flightNumbers;
        }

        public String getFlightType() {
                return flightType;
        }
        public void setFlightType(String flightType) {
                this.flightType = flightType;
        }

        public String getRouteType() {
                return routeType;
        }
        public void setRouteType(String routeType) {
                this.routeType = routeType;
        }

        public String getRule() {
                return rule;
        }
        public void setRule(String rule) {
                this.rule = rule;
        }

        public Boolean getIsTechnicalStop() {
                return isTechnicalStop;
        }
        public void setIsTechnicalStop(Boolean isTechnicalStop) {
                this.isTechnicalStop = isTechnicalStop;
        }
}

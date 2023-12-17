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
        public Boolean whitePage;
        public Boolean replaceWhitePage;
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
        public Boolean technicalStop;


        public DocumentsPackingBaseForm() {

        }

        public String getDescription() {
                return description;
        }

        public Integer getDocCategoryId() {
                return docCategoryId;
        }

        public String getDocFile() {
                return docFile;
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

        public Boolean getReplaceWhitePage() {
                return replaceWhitePage;
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

        public int getAircraftId() {
                return aircraftId;
        }

        public int getAirlineId() {
                return airlineId;
        }

        public String getArrAirports() {
                return arrAirports;
        }

        public String getCapCY() {
                return capCY;
        }

        public int getCopies() {
                return copies;
        }

        public int getCountryArrId() {
                return countryArrId;
        }

        public int getCountryDepId() {
                return countryDepId;
        }

        public int getCrewRouteCategoryId() {
                return crewRouteCategoryId;
        }

        public String getCrewType() {
                return crewType;
        }

        public String getDateEnd() {
                return dateEnd;
        }

        public String getDateStart() {
                return dateStart;
        }

        public String getDepAirports() {
                return depAirports;
        }

        public int getDocId() {
                return docId;
        }

        public int getDocTemplateId() {
                return docTemplateId;
        }

        public String getFlightNumbers() {
                return flightNumbers;
        }

        public String getFlightType() {
                return flightType;
        }

        public String getRouteType() {
                return routeType;
        }

        public String getRule() {
                return rule;
        }

        public Boolean getTechnicalStop() {
                return technicalStop;
        }

        public int getBoard() {
                return board;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setDocCategoryId(Integer docCategoryId) {
                this.docCategoryId = docCategoryId;
        }

        public void setDocFile(String docFile) {
                this.docFile = docFile;
        }

        public void setDocFileId(int docFileId) {
                this.docFileId = docFileId;
        }

        public void setDocOwnerIds(List<Integer> docOwnerIds) {
                this.docOwnerIds = docOwnerIds;
        }

        public void setDocType(String docType) {
                this.docType = docType;
        }

        public void setIsActive(Boolean isActive) {
                this.isActive = isActive;
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

        public void setReplaceWhitePage(Boolean replaceWhitePage) {
                this.replaceWhitePage = replaceWhitePage;
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

        public void setAircraftId(int aircraftId) {
                this.aircraftId = aircraftId;
        }

        public void setAirlineId(int airlineId) {
                this.airlineId = airlineId;
        }

        public void setArrAirports(String arrAirports) {
                this.arrAirports = arrAirports;
        }

        public void setCapCY(String capCY) {
                this.capCY = capCY;
        }

        public void setCopies(int copies) {
                this.copies = copies;
        }

        public void setCountryArrId(int countryArrId) {
                this.countryArrId = countryArrId;
        }

        public void setCountryDepId(int countryDepId) {
                this.countryDepId = countryDepId;
        }

        public void setCrewRouteCategoryId(int crewRouteCategoryId) {
                this.crewRouteCategoryId = crewRouteCategoryId;
        }

        public void setCrewType(String crewType) {
                this.crewType = crewType;
        }

        public void setDateEnd(String dateEnd) {
                this.dateEnd = dateEnd;
        }

        public void setDateStart(String dateStart) {
                this.dateStart = dateStart;
        }

        public void setDepAirports(String depAirports) {
                this.depAirports = depAirports;
        }

        public void setDocId(int docId) {
                this.docId = docId;
        }

        public void setDocTemplateId(int docTemplateId) {
                this.docTemplateId = docTemplateId;
        }

        public void setFlightNumbers(String flightNumbers) {
                this.flightNumbers = flightNumbers;
        }

        public void setFlightType(String flightType) {
                this.flightType = flightType;
        }

        public void setRouteType(String routeType) {
                this.routeType = routeType;
        }

        public void setRule(String rule) {
                this.rule = rule;
        }

        public void setTechnicalStop(Boolean technicalStop) {
                this.technicalStop = technicalStop;
        }

        public void setBoard(int board) {
                this.board = board;
        }
}

package aero.s7.jl.autotest.api.Filter;

import java.util.List;

public class DocumentsPackingSearch {

        private final Integer docCategoryId;
        private final String name;
        private final String docType;
        private final List<Integer> docOwnerIds;
        private final String createDateStart;
        private final String createDateEnd;
        private final Boolean isActive;
        private final String author;
        private final String validityPeriodStart;
        private final String validityPeriodEnd;
        private final String modifier;
        private final String modifyPeriodStart;
        private final String modifyPeriodEnd;
        private final String flightType;
        private final String crewType;
        private final Integer country;
        private final String airport;
        private final String flightNumbers;
        private final Integer crewRouteCategoryId;
        private final Boolean isTechnicalStop;

        DocumentsPackingSearch(DocumentsPackingSearchBuilder documentsPackingSearchBuilder) {
                docCategoryId = documentsPackingSearchBuilder.docCategoryId;
                name = documentsPackingSearchBuilder.name;
                docType = documentsPackingSearchBuilder.docType;
                docOwnerIds = documentsPackingSearchBuilder.docOwnerIds;
                createDateStart = documentsPackingSearchBuilder.createDateStart;
                createDateEnd = documentsPackingSearchBuilder.createDateEnd;
                isActive = documentsPackingSearchBuilder.isActive;
                author = documentsPackingSearchBuilder.author;
                validityPeriodStart = documentsPackingSearchBuilder.validityPeriodStart;
                validityPeriodEnd = documentsPackingSearchBuilder.validityPeriodEnd;
                modifier = documentsPackingSearchBuilder.modifier;
                modifyPeriodStart = documentsPackingSearchBuilder.modifyPeriodStart;
                modifyPeriodEnd = documentsPackingSearchBuilder.modifyPeriodEnd;
                flightType = documentsPackingSearchBuilder.flightType;
                crewType = documentsPackingSearchBuilder.crewType;
                country = documentsPackingSearchBuilder.country;
                airport = documentsPackingSearchBuilder.airport;
                flightNumbers = documentsPackingSearchBuilder.flightNumbers;
                crewRouteCategoryId = documentsPackingSearchBuilder.crewRouteCategoryId;
                isTechnicalStop = documentsPackingSearchBuilder.isTechnicalStop;
        }

        public Integer getDocCategoryId() {
                return docCategoryId;
        }
        public String getName() {
                return name;
        }
        public String getDocType() {
                return docType;
        }
        public List<Integer> getDocOwnerIds() {
                return docOwnerIds;
        }
        public String getCreateDateStart() {
                return createDateStart;
        }
        public String getCreateDateEnd() {
                return createDateEnd;
        }
        public Boolean getIsActive() {
                return isActive;
        }
        public String getAuthor() {
                return author;
        }
        public String getValidityPeriodStart() {
                return validityPeriodStart;
        }
        public String getValidityPeriodEnd() {
                return validityPeriodEnd;
        }
        public String getModifier() {
                return modifier;
        }
        public String getModifyPeriodStart() {
                return modifyPeriodStart;
        }
        public String getModifyPeriodEnd() {
                return modifyPeriodEnd;
        }
        public String getFlightType() {
                return flightType;
        }
        public String getCrewType() {
                return crewType;
        }
        public Integer getCountry() {
                return country;
        }
        public String getAirport() {
                return airport;
        }
        public String getFlightNumbers() {
                return flightNumbers;
        }
        public Integer getCrewRouteCategoryId() {
                return crewRouteCategoryId;
        }
        public Boolean getIsTechnicalStop() {
                return isTechnicalStop;
        }

}

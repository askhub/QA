package aero.s7.jl.autotest.api.Filter;

import java.util.List;

public class DocumentsPackingSearchBuilder {
    Integer docCategoryId;
    String name;
    String docType;
    List<Integer> docOwnerIds;
    String createDateStart;
    String createDateEnd;
    String author;
    String validityPeriodStart;
    String validityPeriodEnd;
    String modifier;
    String modifyPeriodStart;
    String modifyPeriodEnd;
    String flightType;
    String crewType;
    Integer country;
    String airport;
    String flightNumbers;
    Integer crewRouteCategoryId;
    Boolean isTechnicalStop;
    Boolean isActive;
    Boolean replaceWhitePage;

    public DocumentsPackingSearchBuilder(Boolean isActive) {
        this.isActive = isActive;
    }

    public DocumentsPackingSearchBuilder setDocCategoryId(Integer docCategoryId) {
        this.docCategoryId = docCategoryId;
        return this;
    }

    public DocumentsPackingSearchBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DocumentsPackingSearchBuilder setDocType(String docType) {
        this.docType = docType;
        return this;
    }

    public DocumentsPackingSearchBuilder setDocOwnerIds(List<Integer> docOwnerIds) {
        this.docOwnerIds = docOwnerIds;
        return this;
    }

    public DocumentsPackingSearchBuilder setCreateDateStart(String createDateStart) {
        this.createDateStart = createDateStart;
        return this;
    }

    public DocumentsPackingSearchBuilder setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
        return this;
    }

    public DocumentsPackingSearchBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public DocumentsPackingSearchBuilder setValidityPeriodStart(String validityPeriodStart) {
        this.validityPeriodStart = validityPeriodStart;
        return this;
    }

    public DocumentsPackingSearchBuilder setValidityPeriodEnd(String validityPeriodEnd) {
        this.validityPeriodEnd = validityPeriodEnd;
        return this;
    }

    public DocumentsPackingSearchBuilder setModifier(String modifier) {
        this.modifier = modifier;
        return this;
    }

    public DocumentsPackingSearchBuilder setModifyPeriodStart(String modifyPeriodStart) {
        this.modifyPeriodStart = modifyPeriodStart;
        return this;
    }

    public DocumentsPackingSearchBuilder setModifyPeriodEnd(String modifyPeriodEnd) {
        this.modifyPeriodEnd = modifyPeriodEnd;
        return this;
    }

    public DocumentsPackingSearchBuilder setFlightType(String flightType) {
        this.flightType = flightType;
        return this;
    }

    public DocumentsPackingSearchBuilder setCrewType(String crewType) {
        this.crewType = crewType;
        return this;
    }

    public DocumentsPackingSearchBuilder setCountry(Integer country) {
        this.country = country;
        return this;
    }

    public DocumentsPackingSearchBuilder setAirport(String airport) {
        this.airport = airport;
        return this;
    }

    public DocumentsPackingSearchBuilder setFlightNumbers(String flightNumbers) {
        this.flightNumbers = flightNumbers;
        return this;
    }

    public DocumentsPackingSearchBuilder setCrewRouteCategoryId(Integer crewRouteCategoryId) {
        this.crewRouteCategoryId = crewRouteCategoryId;
        return this;
    }

    public DocumentsPackingSearchBuilder setTechnicalStop(Boolean isTechnicalStop) {
        this.isTechnicalStop = isTechnicalStop;
        return this;
    }

    public DocumentsPackingSearchBuilder setReplaceWhitePage (Boolean replaceWhitePage) {
        this.replaceWhitePage = replaceWhitePage;
        return this;
    }

    public DocumentsPackingSearch build() {
        return new DocumentsPackingSearch (this);
    }
}

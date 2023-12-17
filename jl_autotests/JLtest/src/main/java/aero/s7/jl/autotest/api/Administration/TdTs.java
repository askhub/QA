package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TdTs {
    @JsonProperty("author_full_name")
    private String authorFullName;
    @JsonProperty("author_id")
    private int authorId;
    @JsonProperty("catering_number")
    private String cateringDeclNumber;
    @JsonProperty("create_date")
    private String createDate;
    @JsonProperty("end_date")
    private String dateEnd;
    @JsonProperty("start_date")
    private String dateStart;
    @JsonProperty("fuel_number")
    private String fuelDeclNumber;
    @JsonProperty("transport_declaration_id")
    private int id;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("modify_author_full_name")
    private String modifyAuthorFullName;
    @JsonProperty("modify_author_id")
    private int modifyAuthorId;
    @JsonProperty("modify_date")
    private String modifyDate;

    public TdTs() {
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

    public String getCateringDeclNumber() {
        return cateringDeclNumber;
    }
    public void setCateringDeclNumber(String cateringDeclNumber) {
        this.cateringDeclNumber = cateringDeclNumber;
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

    public String getFuelDeclNumber() {
        return fuelDeclNumber;
    }
    public void setFuelDeclNumber(String fuelDeclNumber) {
        this.fuelDeclNumber = fuelDeclNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}

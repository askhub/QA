package aero.s7.jl.autotest.api.Administration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TdTs {
    @JsonProperty("catering_number")
    private String cateringNumber;
    @JsonProperty("fuel_number")
    private String fuelNumber;
    @JsonProperty("end_date")
    private String dateEnd;
    @JsonProperty("start_date")
    private String dateStart;

    @JsonProperty("create_user_full_name")
    private String createUserFullName;
    @JsonProperty("create_user_id")
    private int createUserId;
    @JsonProperty("create_date")
    private String createDate;
    @JsonProperty("modify_date")
    private String modifyDate;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("transport_declaration_id")
    private int id;

    @JsonProperty("modify_user_full_name")
    private String modifyUserFullName;
    @JsonProperty("modify_user_id")
    private int modifyUserId;


    public TdTs() {
    }

    public String getCateringNumber() {
        return cateringNumber;
    }
    public void setCateringNumber(String cateringNumber) {
        this.cateringNumber = cateringNumber;
    }

    public String getFuelNumber() {
        return fuelNumber;
    }
    public void setFuelNumber(String fuelNumber) {
        this.fuelNumber = fuelNumber;
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

    public String getCreateUserFullName() {
        return createUserFullName;
    }
    public void setCreateUserFullName(String createUserFullName) {
        this.createUserFullName = createUserFullName;
    }

    public int getCreateUserId() {
        return createUserId;
    }
    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getModifyUserFullName() {
        return modifyUserFullName;
    }
    public void setModifyUserFullName(String modifyUserFullName) {
        this.modifyUserFullName = modifyUserFullName;
    }

    public int getModifyUserId() {
        return modifyUserId;
    }
    public void setModifyUserId(int modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
}

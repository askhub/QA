package aero.s7.jl.autotest.api.EcrewTracking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EcrewTrackingFlightLegInfo {

    @JsonProperty("aircraft_id")
    private Integer aircraftId;

    @JsonProperty("airline_id")
    private Integer airlineId;

    @JsonProperty("airport_id_arr")
    private Integer airportIdArr;

    @JsonProperty("airport_id_dep")
    private Integer airportIdDep;

    private String ata; //"2023-08-23T13:35:27.405Z"
    private String atd; // "2023-08-23T13:35:27.405Z"

    @JsonProperty("board_id")
    private Integer boardId;

    @JsonProperty("create_date")
    private String createDate; // "2023-08-23T13:35:27.405Z"

    private String eta; //"2023-08-22T07:42:20.958Z"
    private String etd; //"2023-08-22T07:42:20.958Z"

    @JsonProperty("flight_leg_id")
    private Integer flightLegId;

    @JsonProperty("flight_number")
    private Integer flightNumber;

    private String gateDep;

    @JsonProperty("general_crew_member_full_name")
    private String generalCrewMemberFullName;

    @JsonProperty("last_flight_task_file_id")
    private Integer lastFlightTaskFileId;

    @JsonProperty("leg_cd")
    private String legCd; //"A"

    @JsonProperty("leg_sequence")
    private Integer legSequence;

    private String localsta; // "2023-08-23T13:35:27.405Z"
    private String localstd; // "2023-08-23T13:35:27.405Z"

    @JsonProperty("main_status")
    private String mainStatus; //"ACTUAL"

    private String origsta; // "2023-08-23T13:35:27.405Z"
    private String origstd; //"2023-08-23T13:35:27.405Z"
    private String sta; //"2023-08-22T07:42:20.958Z"
    private String standArr;
    private String status; // "ACTUAL"
    private String std; //"2023-08-22T07:42:20.958Z"
    private String tdwn; //"2023-08-22T07:42:20.958Z"
    private String tkof; //"2023-08-23T13:35:27.405Z"

    @JsonProperty("update_date")
    private String updateDate; //"2023-08-23T13:35:27.405Z"

    public EcrewTrackingFlightLegInfo() {
    }

    public Integer getAircraftId() {
        return aircraftId;
    }
    public Integer getAirlineId() {
        return airlineId;
    }
    public Integer getAirportIdArr() {
        return airportIdArr;
    }
    public Integer getAirportIdDep() {
        return airportIdDep;
    }
    public String getAta() {
        return ata;
    }
    public String getAtd() {
        return atd;
    }
    public Integer getBoardId() {
        return boardId;
    }
    public String getCreateDate() {
        return createDate;
    }
    public String getEta() {
        return eta;
    }
    public String getEtd() {
        return etd;
    }
    public Integer getFlightLegId() {
        return flightLegId;
    }
    public Integer getFlightNumber() {
        return flightNumber;
    }
    public String getGateDep() {
        return gateDep;
    }
    public String getGeneralCrewMemberFullName() {
        return generalCrewMemberFullName;
    }
    public Integer getLastFlightTaskFileId() {
        return lastFlightTaskFileId;
    }
    public String getLegCd() {
        return legCd;
    }
    public Integer getLegSequence() {
        return legSequence;
    }
    public String getLocalsta() {
        return localsta;
    }
    public String getLocalstd() {
        return localstd;
    }
    public String getMainStatus() {
        return mainStatus;
    }
    public String getOrigsta() {
        return origsta;
    }
    public String getOrigstd() {
        return origstd;
    }
    public String getSta() {
        return sta;
    }
    public String getStandArr() {
        return standArr;
    }
    public String getStatus() {
        return status;
    }
    public String getStd() {
        return std;
    }
    public String getTdwn() {
        return tdwn;
    }
    public String getTkof() {
        return tkof;
    }
    public String getUpdateDate() {
        return updateDate;
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }
    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }
    public void setAirportIdArr(Integer airportIdArr) {
        this.airportIdArr = airportIdArr;
    }
    public void setAirportIdDep(Integer airportIdDep) {
        this.airportIdDep = airportIdDep;
    }
    public void setAta(String ata) {
        this.ata = ata;
    }
    public void setAtd(String atd) {
        this.atd = atd;
    }
    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public void setEta(String eta) {
        this.eta = eta;
    }
    public void setEtd(String etd) {
        this.etd = etd;
    }
    public void setFlightLegId(Integer flightLegId) {
        this.flightLegId = flightLegId;
    }
    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }
    public void setGateDep(String gateDep) {
        this.gateDep = gateDep;
    }
    public void setGeneralCrewMemberFullName(String generalCrewMemberFullName) {
        this.generalCrewMemberFullName = generalCrewMemberFullName;
    }
    public void setLastFlightTaskFileId(Integer lastFlightTaskFileId) {
        this.lastFlightTaskFileId = lastFlightTaskFileId;
    }
    public void setLegCd(String legCd) {
        this.legCd = legCd;
    }
    public void setLegSequence(Integer legSequence) {
        this.legSequence = legSequence;
    }
    public void setLocalsta(String localsta) {
        this.localsta = localsta;
    }
    public void setLocalstd(String localstd) {
        this.localstd = localstd;
    }
    public void setMainStatus(String mainStatus) {
        this.mainStatus = mainStatus;
    }
    public void setOrigsta(String origsta) {
        this.origsta = origsta;
    }
    public void setOrigstd(String origstd) {
        this.origstd = origstd;
    }
    public void setSta(String sta) {
        this.sta = sta;
    }
    public void setStandArr(String standArr) {
        this.standArr = standArr;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setStd(String std) {
        this.std = std;
    }
    public void setTdwn(String tdwn) {
        this.tdwn = tdwn;
    }
    public void setTkof(String tkof) {
        this.tkof = tkof;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}


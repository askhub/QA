package aero.s7.jl.autotest.api.Filter;

public class SeatRuleSearchBuilder {
    Integer acTypeId;
    String capCY;
    Integer carrierId;
    String code;
    Integer crewMemberType;
    Boolean isActive;
    Boolean isTemplate;

    public SeatRuleSearchBuilder (Boolean isActive) {
        this.isActive = isActive;
    }

    public SeatRuleSearchBuilder setAcTypeId(Integer acTypeId) {
        this.acTypeId = acTypeId;
        return this;
    }
    public SeatRuleSearchBuilder setCapCY(String capCY) {
        this.capCY = capCY;
        return this;
    }
    public SeatRuleSearchBuilder setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
        return this;
    }
    public SeatRuleSearchBuilder setCode(String code) {
        this.code = code;
        return this;
    }
    public SeatRuleSearchBuilder setCrewMemberType(Integer crewMemberType) {
        this.crewMemberType = crewMemberType;
        return this;
    }
    public SeatRuleSearchBuilder setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
        return this;
    }

    public SeatRuleSearch build () {
        return new SeatRuleSearch (this);
    }
}

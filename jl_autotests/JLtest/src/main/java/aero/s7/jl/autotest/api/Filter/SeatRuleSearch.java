package aero.s7.jl.autotest.api.Filter;

public class SeatRuleSearch {
        private  final Integer acTypeId;
        private  final String capCY;
        private  final Integer carrierId;
        private  final String code;
        private  final Integer crewMemberType;
        private  final Boolean isActive;
        private  final Boolean isTemplate;

        SeatRuleSearch (SeatRuleSearchBuilder seatRuleSearchBuilder) {
            acTypeId = seatRuleSearchBuilder.acTypeId;
            capCY = seatRuleSearchBuilder.capCY;
            carrierId = seatRuleSearchBuilder.carrierId;
            code = seatRuleSearchBuilder.code;
            crewMemberType = seatRuleSearchBuilder.crewMemberType;
            isActive = seatRuleSearchBuilder.isActive;
            isTemplate = seatRuleSearchBuilder.isTemplate;
        }

    public Integer getAcTypeId() {
        return acTypeId;
    }
    public String getCapCY() {
        return capCY;
    }
    public Integer getCarrierId() {
        return carrierId;
    }
    public String getCode() {
        return code;
    }
    public Integer getCrewMemberType() {
        return crewMemberType;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public Boolean getIsTemplate() {
        return isTemplate;
    }
}

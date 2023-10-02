package aero.s7.jl.autotest.api.SeatRules;

import aero.s7.jl.autotest.api.Dictionary.*;
import aero.s7.jl.autotest.api.Filter.SeatRuleSearch;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public interface SeatRuleService {

    SeatRule getSeatRule (int id);
    SeatRule createSeatRule (SeatRuleCreateForm form);
    boolean createSeatRuleNegative (SeatRuleCreateForm form);
    TaskToSeatRule getTaskToSeatRule (int id);
    SeatRule createSeatRuleWithTask (SeatRuleWithTaskToSeatRuleCreateForm form);
    boolean createSeatRuleWithTaskNegative (SeatRuleWithTaskToSeatRuleCreateForm form);
    SeatRule updateSeatRule (SeatRuleUpdateForm form);
    TaskToSeatRule updateTaskToSeatRule (SeatRuleUpdateForm form);
    List<SeatRuleData> searchSeatRule (SeatRuleSearch seatRuleSearch);
    boolean deleteSeatRule (int id);
    boolean deleteTaskToSeatRule (int taskId);
    boolean exists (int id);
    List<CrewMemberType> getCrewMemberType ();
    List<CrewCategory> getCrewCategory ();
    List<Position> getPosition ();
    List<Qualification> getQualification ();
    List<SubTask> getSubtask ();
    List<Type> getMemberType();
    List<Role> getRole ();

}

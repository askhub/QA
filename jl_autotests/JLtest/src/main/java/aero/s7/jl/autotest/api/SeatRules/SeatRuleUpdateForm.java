package aero.s7.jl.autotest.api.SeatRules;

import java.util.Collections;

public class SeatRuleUpdateForm extends SeatRuleBaseForm {

    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public static SeatRuleUpdateForm updateSeatRule (int id) {

        SeatRuleUpdateForm form = new SeatRuleUpdateForm();
        form.setId(id);
        form.setActypeId(201);
        form.setCarrierId(890);

        return form;
    }

    public static SeatRuleUpdateForm updateSeatRule2 (int id) {

        SeatRuleUpdateForm form = new SeatRuleUpdateForm();
        form.setId(id);
        form.setActypeId(63);
        form.setCarrierId(1094);

        return form;
    }

    public static SeatRuleUpdateForm updateTaskToSeatRule (int taskId) {

        SeatRuleUpdateForm form = new SeatRuleUpdateForm();

        form.setId(taskId);
        form.setCode("N");
        form.setSubTask(3);
        form.setType(1);
        form.setTaskId("T19.1");
        form.setQualificationIds(Collections.singletonList(2));
        form.setCrewPosId(2);
        form.setRole(2);
        form.setIsAdditional(false);
        return form;
    }
    public static SeatRuleUpdateForm updateTaskToSeatRule2 (int taskId) {

        SeatRuleUpdateForm form = new SeatRuleUpdateForm();

        form.setId(taskId);
        form.setCode("L");
        form.setSubTask(2);
        form.setType(1);
        form.setTaskId("T20.1");
        form.setQualificationIds(Collections.singletonList(2));
        form.setCrewPosId(2);
        form.setRole(3);
        form.setIsAdditional(false);
        return form;
    }
}

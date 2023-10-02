package aero.s7.jl.autotest.api.SeatRules;

import java.util.ArrayList;
import java.util.List;

public class SeatRuleWithTaskToSeatRuleCreateForm extends SeatRuleBaseForm {

    private SeatRuleCreateForm seatRuleCreateForm;
    private List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms;

    public SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm seatRuleCreateForm, List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms) {
        this.seatRuleCreateForm = seatRuleCreateForm;
        this.taskToSeatRuleCreateFroms = taskToSeatRuleCreateFroms;
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm newTaskToSeatRule() {

        List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms = new ArrayList<>();
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule());
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule2());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWithTask(), taskToSeatRuleCreateFroms);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm newTaskToSeatRuleRequiredFields() {

        List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms = new ArrayList<>();
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired());
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleRequiredFields(), taskToSeatRuleCreateFroms);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm newTaskToSeatRuleWithInvalidValue() {

        List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms = new ArrayList<>();
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule());
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRuleNegative());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWithTaskNegative(), taskToSeatRuleCreateFroms);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm newSeatRuleForDeleteMemberTest () {
        List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms = new ArrayList<>();
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToDelete());
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToDelete2());
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToDelete3());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWithTaskForDelete(), taskToSeatRuleCreateFroms);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm seatRuleWithMoreThanLimitGeneralMember () {
        List<TaskToSeatRuleCreateFrom> tasks = new ArrayList<>();
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule2());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule3());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule4());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule5());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule6());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule7());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWithTask(), tasks);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm seatRuleWithMoreThanLimitAdditionalMember () {
        List<TaskToSeatRuleCreateFrom> tasks = new ArrayList<>();
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule2());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule8());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule9());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule10());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWithTask(), tasks);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm seatRuleWithWrongDate () {
        List<TaskToSeatRuleCreateFrom> tasks = new ArrayList<>();
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule2());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWrongDate(), tasks);
    }

    public static SeatRuleWithTaskToSeatRuleCreateForm seatRuleWithSameCrewPosition () {
        List<TaskToSeatRuleCreateFrom> tasks = new ArrayList<>();
        tasks.add(TaskToSeatRuleCreateFrom.newTaskWithSamePosition());
        tasks.add(TaskToSeatRuleCreateFrom.newTaskWithSamePosition2());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRule(), tasks);
    }



    public SeatRuleCreateForm getSeatRuleCreateForm() {
        return seatRuleCreateForm;
    }

    public void setSeatRuleCreateForm(SeatRuleCreateForm seatRuleCreateForm) {
        this.seatRuleCreateForm = seatRuleCreateForm;
    }

    public List<TaskToSeatRuleCreateFrom> getTaskToSeatRuleCreateFroms() {
        return taskToSeatRuleCreateFroms;
    }

    public void setTaskToSeatRuleCreateFroms(List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms) {
        this.taskToSeatRuleCreateFroms = taskToSeatRuleCreateFroms;
    }
}

/*
private SeatRuleCreateForm seatRuleCreateForm;
    private List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms;

    public SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm seatRuleCreateForm, List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms) {
        this.seatRuleCreateForm = seatRuleCreateForm;
        this.taskToSeatRuleCreateFroms = taskToSeatRuleCreateFroms;
    }

    static SeatRuleWithTaskToSeatRuleCreateForm newTaskToSeatRule() {

        List<TaskToSeatRuleCreateFrom> taskToSeatRuleCreateFroms = new ArrayList<>();
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule());
        taskToSeatRuleCreateFroms.add(TaskToSeatRuleCreateFrom.newTaskToSeatRule2());

        return new SeatRuleWithTaskToSeatRuleCreateForm(SeatRuleCreateForm.newSeatRuleWithTask(), taskToSeatRuleCreateFroms);
 */

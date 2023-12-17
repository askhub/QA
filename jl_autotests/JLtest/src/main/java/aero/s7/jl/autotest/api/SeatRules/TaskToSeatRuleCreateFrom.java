package aero.s7.jl.autotest.api.SeatRules;

import java.util.Collections;

public class TaskToSeatRuleCreateFrom extends SeatRuleBaseForm {

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("&");
        task.setTaskId("T20.1");
        //task.setSubTask(1);
        task.setType(1);
        task.setQualificationIds(Collections.singletonList(2));
        task.setRole(2);
        task.setCrewPosId(2);
        task.setIsAdditional(false);

        return task;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule2 () {
        TaskToSeatRuleCreateFrom task2 = new TaskToSeatRuleCreateFrom();

        task2.setCode("z");
        task2.setTaskId("T20.1");
        //task2.setSubTask(2);
        task2.setType(2);
        task2.setQualificationIds(Collections.singletonList(3));
        task2.setRole(1);
        task2.setCrewPosId(1);
        task2.setIsAdditional(false);

        return task2;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule3 () {
        TaskToSeatRuleCreateFrom task3 = new TaskToSeatRuleCreateFrom();

        task3.setCode("z");
        task3.setTaskId("T20.1");
        task3.setType(2);
        task3.setQualificationIds(Collections.singletonList(1));
        task3.setCrewPosId(3);
        task3.setIsAdditional(false);

        return task3;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule4 () {
        TaskToSeatRuleCreateFrom task4 = new TaskToSeatRuleCreateFrom();

        task4.setCode("l");
        task4.setTaskId("T20.1");
        task4.setType(2);
        task4.setQualificationIds(Collections.singletonList(2));
        task4.setCrewPosId(4);
        task4.setIsAdditional(false);

        return task4;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule5 () {
        TaskToSeatRuleCreateFrom task5 = new TaskToSeatRuleCreateFrom();

        task5.setCode("u");
        task5.setTaskId("T20.1");
        task5.setType(2);
        task5.setQualificationIds(Collections.singletonList(4));
        task5.setCrewPosId(5);
        task5.setIsAdditional(false);

        return task5;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule6 () {
        TaskToSeatRuleCreateFrom task6 = new TaskToSeatRuleCreateFrom();

        task6.setCode("r");
        task6.setTaskId("T20.1");
        task6.setType(2);
        task6.setQualificationIds(Collections.singletonList(5));
        task6.setCrewPosId(6);
        task6.setIsAdditional(false);

        return task6;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule7 () {
        TaskToSeatRuleCreateFrom task7 = new TaskToSeatRuleCreateFrom();

        task7.setCode("*");
        task7.setTaskId("T20.1");
        task7.setType(2);
        task7.setQualificationIds(Collections.singletonList(3));
        task7.setCrewPosId(7);
        task7.setIsAdditional(false);

        return task7;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule8 () {
        TaskToSeatRuleCreateFrom task8 = new TaskToSeatRuleCreateFrom();

        task8.setCode("q");
        task8.setTaskId("T20.1");
        task8.setType(2);
        task8.setQualificationIds(Collections.singletonList(3));
        task8.setCrewPosId(6);
        task8.setIsAdditional(true);

        return task8;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule9 () {
        TaskToSeatRuleCreateFrom task9 = new TaskToSeatRuleCreateFrom();

        task9.setCode("j");
        task9.setTaskId("T20.1");
        task9.setType(2);
        task9.setQualificationIds(Collections.singletonList(4));
        task9.setCrewPosId(7);
        task9.setIsAdditional(true);

        return task9;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRule10 () {
        TaskToSeatRuleCreateFrom task10 = new TaskToSeatRuleCreateFrom();

        task10.setCode("z");
        task10.setTaskId("T20.1");
        task10.setType(2);
        task10.setQualificationIds(Collections.singletonList(5));
        task10.setCrewPosId(8);
        task10.setIsAdditional(true);

        return task10;
    }


    public static TaskToSeatRuleCreateFrom newTaskToSeatRuleRequired () {
        TaskToSeatRuleCreateFrom task3 = new TaskToSeatRuleCreateFrom();

        task3.setCode("z");
        task3.setTaskId("T20.1");
        task3.setType(2);
        task3.setQualificationIds(Collections.singletonList(3));
        task3.setCrewPosId(1);
        task3.setIsAdditional(false);

        return task3;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRuleRequired2 () {
        TaskToSeatRuleCreateFrom task4 = new TaskToSeatRuleCreateFrom();

        task4.setCode("U");
        task4.setTaskId("T20.1");
        task4.setType(1);
        task4.setQualificationIds(Collections.singletonList(4));
        task4.setCrewPosId(2);
        task4.setIsAdditional(false);

        return task4;
    }

    public static TaskToSeatRuleCreateFrom newTaskToSeatRuleNegative () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("&f");
        task.setTaskId("T19.1");
        //task.setSubTask(2);
        task.setType(2);
        task.setQualificationIds(Collections.singletonList(4));
        task.setRole(1);
        task.setCrewPosId(1);
        task.setIsAdditional(false);

        return task;
    }

    public static TaskToSeatRuleCreateFrom newTaskToDelete () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("f");
        task.setTaskId("T20.1");
        //task.setSubTask(1);
        task.setType(2);
        task.setQualificationIds(Collections.singletonList(4));
        task.setRole(1);
        task.setCrewPosId(1);
        task.setIsAdditional(false);

        return task;
    }

    public static TaskToSeatRuleCreateFrom newTaskToDelete2 () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("H");
        task.setTaskId("T20.1");
        //task.setSubTask(2);
        task.setType(1);
        task.setQualificationIds(Collections.singletonList(2));
        task.setRole(2);
        task.setCrewPosId(2);
        task.setIsAdditional(false);

        return task;
    }

    public static TaskToSeatRuleCreateFrom newTaskToDelete3 () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("k");
        task.setTaskId("T20.1");
        //task.setSubTask(null);
        task.setType(2);
        task.setQualificationIds(Collections.singletonList(5));
        task.setRole(null);
        task.setCrewPosId(3);
        task.setIsAdditional(true);

        return task;
    }

    public static TaskToSeatRuleCreateFrom newTaskWithSamePosition () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("k");
        task.setTaskId("T22.1");
        //task.setSubTask(null);
        task.setType(2);
        task.setQualificationIds(Collections.singletonList(5));
        task.setRole(1);
        task.setCrewPosId(1);
        task.setIsAdditional(false);

        return task;
    }

    public static TaskToSeatRuleCreateFrom newTaskWithSamePosition2 () {
        TaskToSeatRuleCreateFrom task = new TaskToSeatRuleCreateFrom();

        task.setCode("G");
        task.setTaskId("T22.1");
        //task.setSubTask(3);
        task.setType(1);
        task.setQualificationIds(Collections.singletonList(5));
        task.setRole(2);
        task.setCrewPosId(1);
        task.setIsAdditional(false);

        return task;
    }
}

/*
    private final String code;
    private final List<Integer> crewCategoryIds;
    private final int crewPosId;
    private final boolean isAdditional;
    private final List<Integer> qualificationIds;
    private final int role;
    private final int subTask;
    private final String taskId;
    private final int type;

    public TaskToSeatRuleCreateFrom(String code,
                                    List<Integer> crewCategoryIds,
                                    int crewPosId, boolean isAdditional,
                                    List<Integer> qualificationIds,
                                    int role,
                                    int subTask,
                                    String taskId,
                                    int type) {
        this.code = code;
        this.crewCategoryIds = crewCategoryIds;
        this.crewPosId = crewPosId;
        this.isAdditional = isAdditional;
        this.qualificationIds = qualificationIds;
        this.role = role;
        this.subTask = subTask;
        this.taskId = taskId;
        this.type = type;
    }

    static TaskToSeatRuleCreateFrom newTaskToSeatRule () {
        return new TaskToSeatRuleCreateFrom ("WW",
                Collections.singletonList(1),
                2,
                false,
                Collections.singletonList(1),
                2,
                1,
                "4.2",
                1);
    }

    static TaskToSeatRuleCreateFrom newTaskToSeatRule2 () {
        return new TaskToSeatRuleCreateFrom ("QQ",
                Collections.singletonList(1),
                1,
                false,
                Collections.singletonList(1),
                1,
                3,
                "4.2",
                2);
    }
 */
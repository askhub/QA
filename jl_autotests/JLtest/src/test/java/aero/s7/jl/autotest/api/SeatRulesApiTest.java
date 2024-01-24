// Автотесты API раздела Seat rules. Korotchenko AS. 2023
package aero.s7.jl.autotest.api;

import aero.s7.jl.autotest.api.DictionaryAndData.*;
import aero.s7.jl.autotest.api.Filter.SeatRuleSearch;
import aero.s7.jl.autotest.api.Filter.SeatRuleSearchBuilder;
import aero.s7.jl.autotest.api.SeatRules.*;
import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SeatRulesApiTest extends TestBase {

    SeatRuleService seatRuleService = new SeatRuleServiceImpl();

    @Test
    public void testGetSeatRuleById () {
        SeatRule newSeatRule = seatRuleService.createSeatRule(SeatRuleCreateForm.newSeatRule());
        Assert.assertNotNull(newSeatRule);

        SeatRule getSeatRule = seatRuleService.getSeatRule(newSeatRule.getId());
        Assert.assertEquals(newSeatRule.getId(), getSeatRule.getId());
    }

    @Test
    public void testCreateNewSeatRuleWithoutTask() {
        SeatRule seatRule = seatRuleService.createSeatRule(SeatRuleCreateForm.newSeatRule());
        Assert.assertNotNull(seatRule);

        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getCarrierId()), Optional.of(seatRule.getCarrierId()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getActypeId()), Optional.of(seatRule.getActypeId()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getCapCY()), Optional.ofNullable(seatRule.getCapCY()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getIsActive()), Optional.of(seatRule.getIsActive()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getIsTemplate()), Optional.of(seatRule.getIsTemplate()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getCrewMemberType()), Optional.of(seatRule.getCrewMemberType()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getValidityStart()), Optional.of(seatRule.getValidityStart()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRule().getValidityEnd()), Optional.of(seatRule.getValidityEnd()));
    }

    @Test
    public void testCreateSeatRuleNegative () {
        Assert.assertTrue(seatRuleService.createSeatRuleNegative(SeatRuleCreateForm.newSeatRuleWithEmptyField()));
    }

    @Test
    public void testCreateSeatRuleWithTasks () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);

        TaskToSeatRule task1 = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(0));
        TaskToSeatRule task2 = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(1));


        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleWithTask().getCarrierId()),
                Optional.of(seatRule.getCarrierId()));
        Assert.assertEquals(Optional.of(SeatRuleCreateForm.newSeatRuleWithTask().getActypeId()),
                Optional.of(seatRule.getActypeId()));
        Assert.assertEquals(Optional.of(SeatRuleCreateForm.newSeatRuleWithTask().getIsActive()),
                Optional.of(seatRule.getIsActive()));
        Assert.assertEquals(Optional.of(SeatRuleCreateForm.newSeatRuleWithTask().getIsTemplate()),
                Optional.of(seatRule.getIsTemplate()));
        Assert.assertEquals(Optional.of(SeatRuleCreateForm.newSeatRuleWithTask().getCrewMemberType()),
                Optional.of(seatRule.getCrewMemberType()));
        Assert.assertEquals(Optional.of(SeatRuleCreateForm.newSeatRuleWithTask().getCarrierId()),
                Optional.of(seatRule.getCarrierId()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleWithTask().getCapCY()),
                Optional.ofNullable(seatRule.getCapCY()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleWithTask().getValidityStart()),
                Optional.of(seatRule.getValidityStart()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleWithTask().getValidityEnd()),
                Optional.of(seatRule.getValidityEnd()));

        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getCode(), task1.getCode());
        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getTaskId(), task1.getTaskId());
        //Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getSubTask()), Optional.of(task1.getSubTask()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getType()), Optional.of(task1.getType()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getRole()), Optional.of(task1.getRole()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getCrewPosId()), Optional.of(task1.getCrewPosId()));
        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getIsAdditional(), task1.getIsAdditional());

        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRule2().getCode(), task2.getCode());
        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRule2().getTaskId(), task2.getTaskId());
        //Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule2().getSubTask()), Optional.of(task2.getSubTask()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule2().getType()), Optional.of(task2.getType()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule2().getRole()), Optional.of(task2.getRole()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRule2().getCrewPosId()), Optional.of(task2.getCrewPosId()));
        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRule().getIsAdditional(), task1.getIsAdditional());
    }

    @Test
    public void testCreateNewSeatRuleWithRequiredFields () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRuleRequiredFields());
        Assert.assertNotNull(seatRule);
        Assert.assertTrue(seatRule.getTaskToSeatRuleIDs().size() > 0);

        TaskToSeatRule task1 = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(0));
        TaskToSeatRule task2 = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(1));

        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleRequiredFields().getCarrierId()),
                Optional.of(seatRule.getCarrierId()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleRequiredFields().getCrewMemberType()),
                Optional.of(seatRule.getCrewMemberType()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleRequiredFields().getIsActive()),
                Optional.of(seatRule.getIsActive()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleRequiredFields().getIsTemplate()),
                Optional.of(seatRule.getIsTemplate()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleRequiredFields().getValidityStart()),
                Optional.of(seatRule.getValidityStart()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleCreateForm.newSeatRuleRequiredFields().getValidityEnd()),
                Optional.of(seatRule.getValidityEnd()));

        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getTaskId()),
                Optional.of(task1.getTaskId()));
        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getCode()),
                Optional.of(task1.getCode()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getType()),
                Optional.of(task1.getType()));
        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getTaskId()),
                Optional.of(task1.getTaskId()));
        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getQualificationIds()),
                Optional.of(task1.getQualificationIds()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getCrewPosId()),
                Optional.of(task1.getCrewPosId()));
        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired().getIsAdditional(), task1.getIsAdditional());

        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getTaskId()),
                Optional.of(task2.getTaskId()));
        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getCode()),
                Optional.of(task2.getCode()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getType()),
                Optional.of(task2.getType()));
        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getTaskId()),
                Optional.of(task2.getTaskId()));
        Assert.assertEquals(Optional.ofNullable(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getQualificationIds()),
                Optional.of(task2.getQualificationIds()));
        Assert.assertEquals(Optional.of(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getCrewPosId()),
                Optional.of(task2.getCrewPosId()));
        Assert.assertEquals(TaskToSeatRuleCreateFrom.newTaskToSeatRuleRequired2().getIsAdditional(), task2.getIsAdditional());

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testCreateSeatRuleWithExpiredDate () {
        Assert.assertTrue(seatRuleService.createSeatRuleWithTaskNegative(SeatRuleWithTaskToSeatRuleCreateForm.seatRuleWithWrongDate()));
    }

    @Test
    public void testCreateSeatRuleWithSameTaskToSeatRulePosition () {
        Assert.assertTrue(seatRuleService.createSeatRuleWithTaskNegative(SeatRuleWithTaskToSeatRuleCreateForm.seatRuleWithSameCrewPosition()));
    }

    @Test
    public void testCreateSeatRuleWithInvalidTaskCode () {
        Assert.assertTrue(seatRuleService.createSeatRuleWithTaskNegative(
                SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRuleWithInvalidValue()));
    }

    @Test
    public void testCreateSeatRuleWithMoreThanLimitGeneralMember () {
        Assert.assertTrue(seatRuleService.createSeatRuleWithTaskNegative(
                SeatRuleWithTaskToSeatRuleCreateForm.seatRuleWithMoreThanLimitGeneralMember()));
    }

    @Test
    public void testCreateSeatRuleWithMoreThanLimitAdditionalMember () {
        Assert.assertTrue(seatRuleService.createSeatRuleWithTaskNegative(
                SeatRuleWithTaskToSeatRuleCreateForm.seatRuleWithMoreThanLimitAdditionalMember()));
    }


    @Test
    public void testUpdateSeatRuleWithoutTask() {
        SeatRule seatRule = seatRuleService.createSeatRule(SeatRuleCreateForm.newSeatRule());
        Assert.assertNotNull(seatRule);
        SeatRule seatRuleUpdate = seatRuleService.updateSeatRule(SeatRuleUpdateForm.updateSeatRule(seatRule.getId()));

        Assert.assertEquals(Optional.ofNullable(SeatRuleUpdateForm.updateSeatRule(seatRule.getId()).getActypeId()),
                Optional.of(seatRuleUpdate.getActypeId()));
        Assert.assertEquals(Optional.ofNullable(SeatRuleUpdateForm.updateSeatRule(seatRule.getId()).getCarrierId()),
                Optional.of(seatRuleUpdate.getCarrierId()));

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testUpdateSeatRuleTask () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);
        Assert.assertTrue(seatRule.getTaskToSeatRuleIDs().size()>0);

        TaskToSeatRule firstTask = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(0));
        TaskToSeatRule taskUpdate = seatRuleService.updateTaskToSeatRule(SeatRuleUpdateForm.updateTaskToSeatRule(firstTask.getId()));

        Assert.assertEquals(SeatRuleUpdateForm.updateTaskToSeatRule(seatRule.getId()).getCode(), taskUpdate.getCode());
        Assert.assertEquals(Optional.ofNullable(SeatRuleUpdateForm.updateTaskToSeatRule(seatRule.getId()).getSubTask()), Optional.of(taskUpdate.getSubTask()));

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testDeleteSeatRule () {
        SeatRule seatRule = seatRuleService.createSeatRule(SeatRuleCreateForm.newSeatRule());
        Assert.assertNotNull(seatRule);

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testDeleteTaskToSeatRule () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newSeatRuleForDeleteMemberTest());
        Assert.assertNotNull(seatRule);
        Assert.assertEquals(seatRule.getTaskToSeatRuleIDs().size(), 3);

        Assert.assertTrue(seatRuleService.deleteTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(2)));

        SeatRule seatRuleAfterDeleteTask = seatRuleService.getSeatRule(seatRule.getId());
        Assert.assertNotEquals(seatRuleAfterDeleteTask.getTaskToSeatRuleIDs().size(), seatRule.getTaskToSeatRuleIDs().size());
    }

    @Test
    public void testSearchSeatRuleByCrewMemberType () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);

        SeatRuleSearch searchRequest = new SeatRuleSearchBuilder(true)
                .setCrewMemberType(seatRule.getCrewMemberType())
                .build();
        List<SeatRuleData> seatRuleList = seatRuleService.searchSeatRule(searchRequest);
        Assert.assertNotNull(seatRuleList);
        Assert.assertTrue(seatRuleList.size() > 0);

        seatRuleList.forEach(x -> Assert.assertEquals(searchRequest.getCrewMemberType(), x.getCrewMemberType()));

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testSearchSeatRuleByCode () {

        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);
        Assert.assertTrue(seatRule.getTaskToSeatRuleIDs().size() > 0);

        TaskToSeatRule firstCrewMember = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(0));
        TaskToSeatRule firstCrewMember1 = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(1));

        SeatRuleSearch searchRequest = new SeatRuleSearchBuilder(true)
                .setCode(firstCrewMember1.getCode())
                .build();

        List<SeatRuleData> seatRuleList = seatRuleService.searchSeatRule(searchRequest);
        Assert.assertNotNull(seatRuleList);
        Assert.assertTrue(seatRuleList.size() > 0);

        int count;
        for (SeatRuleData seatRuleData : seatRuleList) {
            count = 0;
            SeatRule findSeatRule = seatRuleService.getSeatRule(seatRuleData.getId());
            Assert.assertNotNull(findSeatRule);
            Assert.assertTrue(findSeatRule.getTaskToSeatRuleIDs().size() > 0);

            for (int j = 0; j <= findSeatRule.getTaskToSeatRuleIDs().size(); j++) {
                TaskToSeatRule task = seatRuleService.getTaskToSeatRule(findSeatRule.getTaskToSeatRuleIDs().get(j));
                Assert.assertNotNull(task);

                if (!Objects.equals(task.getCode(), searchRequest.getCode())) {
                    count = count + 1;
                    System.out.println("Code crew member not conform search request");
                    Assert.assertNotEquals(count, findSeatRule.getTaskToSeatRuleIDs().size());
                } else {
                    Assert.assertEquals(task.getCode(), searchRequest.getCode());
                    break;
                }
            }
        }
        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testSearchSeatRuleByCarrier () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);

        SeatRuleSearch searchRequest = new SeatRuleSearchBuilder(true)
                .setCarrierId(seatRule.getCarrierId())
                .build();
        List<SeatRuleData> seatRuleList = seatRuleService.searchSeatRule(searchRequest);
        Assert.assertNotNull(seatRuleList);
        Assert.assertTrue(seatRuleList.size() > 0);

        seatRuleList.forEach(x -> Assert.assertEquals(searchRequest.getCarrierId(), x.getCarrierId()));

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testSearchSeatRuleByActype () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);

        SeatRuleSearch searchRequest = new SeatRuleSearchBuilder(true)
                .setAcTypeId(seatRule.getActypeId())
                .build();
        List<SeatRuleData> seatRuleList = seatRuleService.searchSeatRule(searchRequest);
        Assert.assertNotNull(seatRuleList);
        Assert.assertTrue(seatRuleList.size() > 0);

        seatRuleList.forEach(x -> Assert.assertEquals(searchRequest.getAcTypeId(), x.getActypeId()));

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testSearchSeatRuleByActive () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);

        SeatRuleSearch searchRequest = new SeatRuleSearchBuilder(true)
                .build();
        List<SeatRuleData> seatRuleList = seatRuleService.searchSeatRule(searchRequest);
        Assert.assertNotNull(seatRuleList);
        Assert.assertTrue(seatRuleList.size() > 0);

        seatRuleList.forEach(x -> Assert.assertEquals(searchRequest.getIsActive(), x.getIsActive()));

        Assert.assertTrue(seatRuleService.deleteSeatRule(seatRule.getId()));
    }

    @Test
    public void testGetDataAsCrewMemberType () {
        List<CrewMemberType> crewMemberTypeData = seatRuleService.getCrewMemberType();
        Assert.assertNotNull(crewMemberTypeData);
        Assert.assertTrue(crewMemberTypeData.size()>0);

        List<String> crewMemberTypeList = crewMemberTypeData.stream().map(CrewMemberType::getName).toList();

        Assert.assertEquals(new HashSet<Object>(crewMemberTypeList), new HashSet<Object>(Constant.Dictionary.CREW_MEMBER_TYPE));
    }

    @Test
    public void testGetDataAsCrewCategory () {
        List<CrewCategories> crewCategoryData = seatRuleService.getCrewCategory();
        Assert.assertNotNull(crewCategoryData);
        Assert.assertTrue(crewCategoryData.size()>0);

        List<String> crewCategoryList = crewCategoryData.stream().map(CrewCategories::getName).toList();

        Assert.assertEquals(new HashSet<Object>(crewCategoryList), new HashSet<Object>(Constant.Dictionary.CREW_CATEGORY));
    }

    @Test
    public void testGetDataAsPosition () {
        List<Positions> positionData = seatRuleService.getPosition();
        Assert.assertNotNull(positionData);
        Assert.assertTrue(positionData.size()>0);

        List<String> positionList = positionData.stream().map(Positions::getName).toList();

        Assert.assertEquals(new HashSet<Object>(positionList), new HashSet<Object>(Constant.Dictionary.POSITION));
    }

    @Test
    public void testGetDataAsQualification () {
        List<Qualifications> qualificationData = seatRuleService.getQualification();
        Assert.assertNotNull(qualificationData);
        Assert.assertTrue(qualificationData.size()>0);

        List<String> qualificationList = qualificationData.stream().map(Qualifications::getName).toList();

        Assert.assertEquals(new HashSet<Object>(qualificationList), new HashSet<Object>(Constant.Dictionary.QUALIFICATION));
    }

    @Test
    public void testGetDataAsRole () {
        List<Roles> roleData = seatRuleService.getRole();
        Assert.assertNotNull(roleData);
        Assert.assertTrue(roleData.size()>0);

        List<String> roleList = roleData.stream().map(Roles::getName).toList();

        Assert.assertEquals(new HashSet<Object>(roleList), new HashSet<Object>(Constant.Dictionary.ROLE));
    }

    @Test
    public void testGetDataAsSubTask () {
        List<SubTasks> subTaskData = seatRuleService.getSubtask();
        Assert.assertNotNull(subTaskData);
        Assert.assertTrue(subTaskData.size()>0);

        List<String> subTaskList = subTaskData.stream().map(SubTasks::getName).toList();

        Assert.assertEquals(new HashSet<Object>(subTaskList), new HashSet<Object>(Constant.Dictionary.SUB_TASK));
    }

    @Test
    public void testGetDataAsType () {
        List<Types> typeData = seatRuleService.getMemberType();
        Assert.assertNotNull(typeData);
        Assert.assertTrue(typeData.size()>0);

        List<String> typeList = typeData.stream().map(Types::getName).toList();

        Assert.assertEquals(new HashSet<Object>(typeList), new HashSet<Object>(Constant.Dictionary.TYPE_ADDITIONAL));
    }

    @Test
    public void testHistoryLoggerUpdateSeatRule () {
        SeatRule seatRule = seatRuleService.createSeatRule(SeatRuleCreateForm.newSeatRule());
        Assert.assertNotNull(seatRule);
        for (int i = 0; i < 45; i++) {
            seatRuleService.updateSeatRule(SeatRuleUpdateForm.updateSeatRule(seatRule.getId()));
            seatRuleService.updateSeatRule(SeatRuleUpdateForm.updateSeatRule2(seatRule.getId()));
        }

    }

    @Test
    public void testHistoryLoggerUpdateSeatRuleTask () {
        SeatRule seatRule = seatRuleService.createSeatRuleWithTask(SeatRuleWithTaskToSeatRuleCreateForm.newTaskToSeatRule());
        Assert.assertNotNull(seatRule);
        Assert.assertTrue(seatRule.getTaskToSeatRuleIDs().size()>0);

        TaskToSeatRule firstTask = seatRuleService.getTaskToSeatRule(seatRule.getTaskToSeatRuleIDs().get(0));

        for(int i = 0; i < 45; i++) {
            seatRuleService.updateTaskToSeatRule(SeatRuleUpdateForm.updateTaskToSeatRule(firstTask.getId()));
            seatRuleService.updateTaskToSeatRule(SeatRuleUpdateForm.updateTaskToSeatRule2(firstTask.getId()));
        }
    }
}

        /*
        //вариант  через константу
        SeatRule seatRule = seatRuleService.getSeatRule(Constant.Api.SEAT_RULE_ID);
        Assert.assertEquals(Constant.Api.SEAT_RULE_ID, seatRule.getId());
         */
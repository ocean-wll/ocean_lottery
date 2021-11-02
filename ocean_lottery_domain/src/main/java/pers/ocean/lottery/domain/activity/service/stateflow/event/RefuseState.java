package pers.ocean.lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.AbstractState;

/**
 * @Description 审核拒绝状态
 * @Author ocean_wll
 * @Date 2021/11/2 2:14 下午
 */
@Component
public class RefuseState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        return Result.buildErrorResult("已审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        return Result.buildErrorResult("已审核状态不可重复审核");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        return Result.buildErrorResult("活动审核拒绝不可重复审核");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.EDIT);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "撤销成功") : Result.buildErrorResult("活动状态表更失败");
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "关闭成功") : Result.buildErrorResult("活动状态表更失败");
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        return Result.buildErrorResult("非关闭活动不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        return Result.buildErrorResult("审核拒绝不可执行活动为进行中");
    }
}

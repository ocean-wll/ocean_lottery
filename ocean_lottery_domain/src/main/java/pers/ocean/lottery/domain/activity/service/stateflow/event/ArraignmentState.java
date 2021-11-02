package pers.ocean.lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.AbstractState;

/**
 * @Description 提审状态
 * @Author ocean_wll
 * @Date 2021/11/2 11:21 上午
 */
@Component
public class ArraignmentState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动已经提审，不能重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.PASS);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动审核通过完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动审核拒绝完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.REVOKE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动审核撤销回到编辑中") : Result.buildErrorResult(
            "活动状态变更失败");
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动关闭完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动已经开启，不能重复开启");
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "待审核活动不可执行活动中变更");
    }
}

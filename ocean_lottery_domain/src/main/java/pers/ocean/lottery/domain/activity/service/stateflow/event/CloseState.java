package pers.ocean.lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.AbstractState;

/**
 * @Description : 关闭状态
 * @Author ocean_wll
 * @Date 2021/11/2 11:29 上午
 */
@Component
public class CloseState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动关闭不可提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动关闭不可审核通过");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动关闭不可审核拒绝");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动关闭不可撤回");
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动关闭不可重复关闭");
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.OPEN);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动开启成功") : Result.buildResult(
            ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动关闭不可变更活动中");
    }
}

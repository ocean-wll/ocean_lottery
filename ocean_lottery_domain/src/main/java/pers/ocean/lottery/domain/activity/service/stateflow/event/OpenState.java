package pers.ocean.lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.AbstractState;

/**
 * @Description 活动开启状态
 * @Author ocean_wll
 * @Date 2021/11/2 11:43 上午
 */
@Component
public class OpenState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动开启不可提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动开启不可审核通过");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动开启不可审核拒绝");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动开启不可撤回");
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动开启完成") : Result.buildResult(
            ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动开启不可重复开启");
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.DOING);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动变更活动中完成") : Result.buildResult(
            ResponseCode.UN_ERROR, "活动状态变更失败");
    }
}

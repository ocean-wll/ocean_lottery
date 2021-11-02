package pers.ocean.lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.AbstractState;

/**
 * @Description 进行(活动中)状态
 * @Author ocean_wll
 * @Date 2021/11/2 11:35 上午
 */
@Component
public class DoingState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动中不可提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动中不可审核通过");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动中不可撤回");
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动关闭成功") : Result.buildResult(
            ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动中不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "活动中不可重复进行");
    }
}

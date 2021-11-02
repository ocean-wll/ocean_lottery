package pers.ocean.lottery.domain.activity.service.stateflow.event;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.AbstractState;

/**
 * @Description 编辑状态
 * @Author ocean_wll
 * @Date 2021/11/2 11:38 上午
 */
@Component
public class EditingState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.ARRAIGNMENT);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动提审成功") : Result.buildResult(
            ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "编辑中不可审核通过");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "编辑中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "编辑中不可撤销审核");
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currState, ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(ResponseCode.SUCCESS, "活动关闭成功") : Result.buildResult(
            ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "非关闭活动不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        return Result.buildResult(ResponseCode.UN_ERROR, "编辑中活动不可执行活动中变更");
    }
}

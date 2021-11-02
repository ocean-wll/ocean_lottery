package pers.ocean.lottery.domain.activity.service.stateflow.impl;

import org.springframework.stereotype.Service;
import pers.ocean.lottery.common.Constants.ActivityState;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.service.stateflow.IStateHandler;
import pers.ocean.lottery.domain.activity.service.stateflow.StateConfig;

/**
 * @Description 状态处理服务
 * @Author ocean_wll
 * @Date 2021/11/2 2:28 下午
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {

    @Override
    public Result arraignment(Long activityId, Enum<ActivityState> currState) {
        return stateGroup.get(currState).arraignment(activityId, currState);
    }

    @Override
    public Result checkPass(Long activityId, Enum<ActivityState> currState) {
        return stateGroup.get(currState).checkPass(activityId, currState);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<ActivityState> currentState) {
        return stateGroup.get(currentState).checkRefuse(activityId, currentState);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<ActivityState> currState) {
        return stateGroup.get(currState).checkRevoke(activityId, currState);
    }

    @Override
    public Result close(Long activityId, Enum<ActivityState> currState) {
        return stateGroup.get(currState).close(activityId, currState);
    }

    @Override
    public Result open(Long activityId, Enum<ActivityState> currState) {
        return stateGroup.get(currState).open(activityId, currState);
    }

    @Override
    public Result doing(Long activityId, Enum<ActivityState> currState) {
        return stateGroup.get(currState).doing(activityId, currState);
    }
}

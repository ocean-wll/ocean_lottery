package pers.ocean.lottery.domain.activity.service.stateflow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.domain.activity.service.stateflow.event.ArraignmentState;
import pers.ocean.lottery.domain.activity.service.stateflow.event.CloseState;
import pers.ocean.lottery.domain.activity.service.stateflow.event.DoingState;
import pers.ocean.lottery.domain.activity.service.stateflow.event.EditingState;
import pers.ocean.lottery.domain.activity.service.stateflow.event.OpenState;
import pers.ocean.lottery.domain.activity.service.stateflow.event.PassState;
import pers.ocean.lottery.domain.activity.service.stateflow.event.RefuseState;

/**
 * @Description 状态流转配置
 * @Author ocean_wll
 * @Date 2021/11/2 2:27 下午
 */
public class StateConfig {

    @Resource
    private ArraignmentState arraignmentState;
    @Resource
    private CloseState closeState;
    @Resource
    private DoingState doingState;
    @Resource
    private EditingState editingState;
    @Resource
    private OpenState openState;
    @Resource
    private PassState passState;
    @Resource
    private RefuseState refuseState;

    protected Map<Enum<Constants.ActivityState>, AbstractState> stateGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        stateGroup.put(Constants.ActivityState.ARRAIGNMENT, arraignmentState);
        stateGroup.put(Constants.ActivityState.CLOSE, closeState);
        stateGroup.put(Constants.ActivityState.DOING, doingState);
        stateGroup.put(Constants.ActivityState.EDIT, editingState);
        stateGroup.put(Constants.ActivityState.OPEN, openState);
        stateGroup.put(Constants.ActivityState.PASS, passState);
        stateGroup.put(Constants.ActivityState.REFUSE, refuseState);
    }
}

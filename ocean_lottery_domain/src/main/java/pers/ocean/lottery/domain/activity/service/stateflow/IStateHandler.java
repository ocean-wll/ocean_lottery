package pers.ocean.lottery.domain.activity.service.stateflow;

import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Result;

/**
 * @Description 状态处理接口
 * @Author ocean_wll
 * @Date 2021/11/2 10:59 上午
 */
public interface IStateHandler {

    /**
     * 提审
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核通过
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核拒绝
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 撤销审核
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 关闭
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 开启
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 运行活动中
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 审核状态
     */
    Result doing(Long activityId, Enum<Constants.ActivityState> currentState);
}

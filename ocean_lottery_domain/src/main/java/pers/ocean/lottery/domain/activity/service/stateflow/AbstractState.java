package pers.ocean.lottery.domain.activity.service.stateflow;

import javax.annotation.Resource;

import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.repository.IActivityRepository;

/**
 * @Description 活动状态抽象类
 * @Author ocean_wll
 * @Date 2021/11/2 11:06 上午
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    /**
     * 活动提审
     *
     * @param activityId 活动Id
     * @param currState  当前状态
     * @return 执行结果
     */
    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> currState);

    /**
     * 审核通过
     *
     * @param activityId 活动Id
     * @param currState  当前状态
     * @return 执行结果
     */
    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> currState);

    /**
     * 审核拒绝
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核拒绝
     *
     * @param activityId 活动Id
     * @param currState  当前状态
     * @return 执行结果
     */
    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currState);

    /**
     * 活动关闭
     *
     * @param activityId 活动Id
     * @param currState  当前状态
     * @return 执行结果
     */
    public abstract Result close(Long activityId, Enum<Constants.ActivityState> currState);

    /**
     * 活动开启
     *
     * @param activityId 活动Id
     * @param currState  当前状态
     * @return 执行结果
     */
    public abstract Result open(Long activityId, Enum<Constants.ActivityState> currState);

    /**
     * 活动执行
     *
     * @param activityId 活动Id
     * @param currState  当前状态
     * @return 执行结果
     */
    public abstract Result doing(Long activityId, Enum<Constants.ActivityState> currState);
}

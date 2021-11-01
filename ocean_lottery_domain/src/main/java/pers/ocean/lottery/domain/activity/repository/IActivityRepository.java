package pers.ocean.lottery.domain.activity.repository;

import java.util.List;

import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.domain.activity.model.vo.ActivityVO;
import pers.ocean.lottery.domain.activity.model.vo.AwardVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyDetailVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyVO;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 8:21 下午
 */
public interface IActivityRepository {

    /**
     * 添加活动配置
     *
     * @param activity 活动配置
     */
    void addActivity(ActivityVO activity);

    /**
     * 添加奖品配置集合
     *
     * @param awardList 奖品配置集合
     */
    void addAward(List<AwardVO> awardList);

    /**
     * 添加策略配置
     *
     * @param strategy 策略配置
     */
    void addStrategy(StrategyVO strategy);

    /**
     * 添加策略明细配置
     *
     * @param strategyDetailList 策略明细集合
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    /**
     * 变更活动状态
     *
     * @param activityId  活动Id
     * @param beforeState 修改前状态
     * @param afterState  修改后状态
     * @return 更新信息
     */
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState,
        Enum<Constants.ActivityState> afterState);
}

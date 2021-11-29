package pers.ocean.lottery.domain.activity.repository;

import java.util.Date;

import pers.ocean.lottery.domain.activity.model.vo.UserTakeActivityVO;

/**
 * @Description 用户参与活动仓储接口
 * @Author ocean_wll
 * @Date 2021/11/20 3:27 下午
 */
public interface IUserTakeActivityRepository {

    /**
     * 扣减个人活动参与次数
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param userId            用户ID
     * @param partakeDate       领取时间
     * @return 更新结果
     */
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount,
        String userId, Date partakeDate);

    /**
     * 领取活动
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param userId            用户ID
     * @param takeDate          领取时间
     * @param takeId            领取ID
     */
    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String userId,
        Date takeDate, Long takeId);

    /**
     * 查询是否存在未执行抽奖领取活动单【user_take_activity 存在 state = 0，领取了但抽奖过程失败的，可以直接返回领取结果继续抽奖】
     *
     * @param activityId 活动ID
     * @param userId     用户ID
     * @return 领取单
     */
    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String userId);
}

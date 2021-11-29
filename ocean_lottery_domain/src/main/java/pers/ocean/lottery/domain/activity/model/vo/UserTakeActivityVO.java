package pers.ocean.lottery.domain.activity.model.vo;

import lombok.Data;

/**
 * @Description 用户领取活动记录
 * @Author ocean_wll
 * @Date 2021/11/29 3:26 下午
 */
@Data
public class UserTakeActivityVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0-未使用 1-已使用
     * Constants.TakeState
     */
    private Integer state;
}

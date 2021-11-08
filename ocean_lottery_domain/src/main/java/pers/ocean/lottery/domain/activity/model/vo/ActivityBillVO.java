package pers.ocean.lottery.domain.activity.model.vo;

import java.util.Date;

import lombok.Data;

/**
 * @Description 活动账单【库存、状态、日期、个人参与次数】
 * @Author ocean_wll
 * @Date 2021/11/5 2:07 下午
 */
@Data
public class ActivityBillVO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 开始时间
     */
    private Date beginDateTime;

    /**
     * 结束时间
     */
    private Date endDateTime;

    /**
     * 库存剩余
     */
    private Integer stockSurplusCount;

    /**
     * 活动状态
     */
    private Integer state;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 每人可参与次数
     */
    private Integer takeCount;

    /**
     * 已领取次数
     */
    private Integer userTakeLeftCount;

}

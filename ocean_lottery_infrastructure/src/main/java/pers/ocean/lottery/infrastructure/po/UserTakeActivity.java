package pers.ocean.lottery.infrastructure.po;

import java.util.Date;

import lombok.Data;

/**
 * @Description 用户领取活动表
 * @Author ocean_wll
 * @Date 2021/11/5 9:47 上午
 */
@Data
public class UserTakeActivity {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名
     */
    private String activityName;

    /**
     * 领取时间
     */
    private Date takeDate;

    /**
     * 领取次数
     */
    private Integer takeCount;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0未使用、1已使用
     * Constants.TaskState
     */
    private Integer state;

    /**
     * 防重ID
     */
    private String uuid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

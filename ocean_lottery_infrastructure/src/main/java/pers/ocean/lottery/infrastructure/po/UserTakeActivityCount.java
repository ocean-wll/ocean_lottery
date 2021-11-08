package pers.ocean.lottery.infrastructure.po;

import java.util.Date;

import lombok.Data;

/**
 * @Description 用户活动参与次数表
 * @Author ocean_wll
 * @Date 2021/11/8 10:41 上午
 */
@Data
public class UserTakeActivityCount {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 可领取次数
     */
    private Integer totalCount;

    /**
     * 已领取次数
     */
    private Integer leftCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}

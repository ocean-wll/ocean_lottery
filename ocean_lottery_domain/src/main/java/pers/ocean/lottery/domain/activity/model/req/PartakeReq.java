package pers.ocean.lottery.domain.activity.model.req;

import java.util.Date;

import lombok.Data;

/**
 * @Description 参加活动请求
 * @Author ocean_wll
 * @Date 2021/11/5 1:57 下午
 */
@Data
public class PartakeReq {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动领取时间
     */
    private Date partakeDate;

    public PartakeReq(String userId, Long activityId) {
        this.userId = userId;
        this.activityId = activityId;
        this.partakeDate = new Date();
    }

    public PartakeReq(String userId, Long activityId, Date partakeDate) {
        this.userId = userId;
        this.activityId = activityId;
        this.partakeDate = partakeDate;
    }
}

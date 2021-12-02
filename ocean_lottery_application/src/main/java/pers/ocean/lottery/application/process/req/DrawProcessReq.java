package pers.ocean.lottery.application.process.req;

import lombok.Data;

/**
 * @Description 抽奖请求
 * @Author ocean_wll
 * @Date 2021/11/30 2:43 下午
 */
@Data
public class DrawProcessReq {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;
}

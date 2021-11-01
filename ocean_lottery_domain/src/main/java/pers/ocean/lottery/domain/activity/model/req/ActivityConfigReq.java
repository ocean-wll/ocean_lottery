package pers.ocean.lottery.domain.activity.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import pers.ocean.lottery.domain.activity.model.aggregates.ActivityConfigRich;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 7:59 下午
 */
@Data
@AllArgsConstructor
public class ActivityConfigReq {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动配置信息
     */
    private ActivityConfigRich activityConfigRich;
}

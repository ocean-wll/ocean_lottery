package pers.ocean.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:49 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawResult {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 奖品id
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;
}

package pers.ocean.lottery.domain.activity.model.vo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @Description 策略详情配置
 * @Author ocean_wll
 * @Date 2021/11/1 8:12 下午
 */
@Data
public class StrategyDetailVO {

    /**
     * 策略Id
     */
    private Long strategyId;

    /**
     * 奖品Id
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品库存
     */
    private Integer awardCount;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
}

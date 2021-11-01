package pers.ocean.lottery.infrastructure.po;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:06 下午
 */
@Data
public class StrategyDetail {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品数量
     */
    private String awardCount;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public StrategyDetail() {
    }

    public StrategyDetail(Long strategyId, String awardId) {
        this.strategyId = strategyId;
        this.awardId = awardId;
    }
}

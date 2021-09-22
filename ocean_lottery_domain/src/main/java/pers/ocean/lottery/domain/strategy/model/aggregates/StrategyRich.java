package pers.ocean.lottery.domain.strategy.model.aggregates;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.ocean.lottery.infrastructure.po.Strategy;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:27 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrategyRich {

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 策略配置
     */
    private Strategy strategy;

    /**
     * 策略明细
     */
    private List<StrategyDetail> strategyDetailList;
}

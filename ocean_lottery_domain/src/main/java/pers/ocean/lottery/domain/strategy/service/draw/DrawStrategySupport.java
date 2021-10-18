package pers.ocean.lottery.domain.strategy.service.draw;

import javax.annotation.Resource;

import pers.ocean.lottery.domain.strategy.model.aggregates.StrategyRich;
import pers.ocean.lottery.domain.strategy.repository.IStrategyRepository;
import pers.ocean.lottery.infrastructure.po.Award;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/10/8 5:47 下午
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 根据策略id查询策略
     *
     * @param strategyId 策略id
     * @return StrategyRich
     */
    public StrategyRich queryStrategyByStrategyId(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 根据奖品id查询奖品信息
     *
     * @param awardId 奖品id
     * @return Award
     */
    public Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }
}

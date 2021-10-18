package pers.ocean.lottery.domain.strategy.repository;

import java.util.List;

import pers.ocean.lottery.domain.strategy.model.aggregates.StrategyRich;
import pers.ocean.lottery.infrastructure.po.Award;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:29 下午
 */
public interface IStrategyRepository {

    /**
     * 查询策略详情
     *
     * @param strategyId 策略id
     * @return StrategyRich对象
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 查询奖品详情
     *
     * @param awardId 奖品id
     * @return Award对象
     */
    Award queryAwardInfo(String awardId);

    /**
     * 查询没有库存的奖品列表
     *
     * @param strategyId 策略id
     * @return AwardId集合
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyId 策略id
     * @param awardId    奖品id
     * @return 扣减结果
     */
    Boolean deductStock(Long strategyId, String awardId);
}

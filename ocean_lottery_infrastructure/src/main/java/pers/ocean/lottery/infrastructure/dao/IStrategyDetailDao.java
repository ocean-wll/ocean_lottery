package pers.ocean.lottery.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:15 下午
 */
@Mapper
public interface IStrategyDetailDao {

    /**
     * 查询策略详情集合
     *
     * @param strategyId 策略id
     * @return StrategyDetail集合
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * 查询无库存策略奖品ID
     *
     * @param strategyId 策略ID
     * @return 返回结果
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyDetailReq 策略ID、奖品ID
     * @return 返回结果
     */
    int deductStock(StrategyDetail strategyDetailReq);
}

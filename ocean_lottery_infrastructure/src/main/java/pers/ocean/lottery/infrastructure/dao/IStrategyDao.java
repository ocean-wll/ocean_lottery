package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.Strategy;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:13 下午
 */
@Mapper
public interface IStrategyDao {

    /**
     * 查询策略数据
     *
     * @param strategyId 策略id
     * @return Strategy对象
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 插入策略配置
     *
     * @param req 策略配置
     */
    void insert(Strategy req);
}

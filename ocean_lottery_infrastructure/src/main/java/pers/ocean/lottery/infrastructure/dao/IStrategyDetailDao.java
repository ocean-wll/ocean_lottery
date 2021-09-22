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
}

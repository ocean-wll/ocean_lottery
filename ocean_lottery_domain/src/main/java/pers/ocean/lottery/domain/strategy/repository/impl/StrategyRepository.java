package pers.ocean.lottery.domain.strategy.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.domain.strategy.model.aggregates.StrategyRich;
import pers.ocean.lottery.domain.strategy.repository.IStrategyRepository;
import pers.ocean.lottery.infrastructure.dao.IAwardDao;
import pers.ocean.lottery.infrastructure.dao.IStrategyDao;
import pers.ocean.lottery.infrastructure.dao.IStrategyDetailDao;
import pers.ocean.lottery.infrastructure.po.Award;
import pers.ocean.lottery.infrastructure.po.Strategy;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:32 下午
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}

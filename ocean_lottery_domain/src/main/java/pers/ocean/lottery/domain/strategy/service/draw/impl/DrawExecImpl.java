package pers.ocean.lottery.domain.strategy.service.draw.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.ocean.lottery.domain.strategy.model.aggregates.StrategyRich;
import pers.ocean.lottery.domain.strategy.model.req.DrawReq;
import pers.ocean.lottery.domain.strategy.model.res.DrawResult;
import pers.ocean.lottery.domain.strategy.repository.IStrategyRepository;
import pers.ocean.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import pers.ocean.lottery.domain.strategy.service.draw.DrawBase;
import pers.ocean.lottery.domain.strategy.service.draw.IDrawExec;
import pers.ocean.lottery.infrastructure.po.Award;
import pers.ocean.lottery.infrastructure.po.Strategy;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:25 下午
 */
@Service("drawExec")
@Slf4j
public class DrawExecImpl extends DrawBase implements IDrawExec {

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        log.info("执行策略抽奖开始，strategyId:{}", req.getStrategyId());

        // 获取抽奖策略配置数据
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // 校验和初始化数据
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        // 根据策略方式抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);

        log.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", req.getUId(), awardId, award.getAwardName());

        // 封装结果
        return new DrawResult(req.getUId(), req.getStrategyId(), awardId, award.getAwardName());
    }
}

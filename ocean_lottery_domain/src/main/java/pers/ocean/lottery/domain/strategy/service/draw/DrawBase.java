package pers.ocean.lottery.domain.strategy.service.draw;

import java.util.ArrayList;
import java.util.List;

import pers.ocean.lottery.domain.strategy.model.vo.AwardRateInfo;
import pers.ocean.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:56 下午
 */
public class DrawBase extends DrawConfig {

    /**
     * 检查并且初始化抽奖数据
     *
     * @param strategyId         策略id
     * @param strategyMode       策略模式
     * @param strategyDetailList 策略详情集合
     */
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (1 != strategyMode) {
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) {
            return;
        }
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}

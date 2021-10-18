package pers.ocean.lottery.domain.strategy.service.draw;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Constants.StrategyMode;
import pers.ocean.lottery.domain.strategy.model.aggregates.StrategyRich;
import pers.ocean.lottery.domain.strategy.model.req.DrawReq;
import pers.ocean.lottery.domain.strategy.model.res.DrawResult;
import pers.ocean.lottery.domain.strategy.model.vo.AwardRateInfo;
import pers.ocean.lottery.domain.strategy.model.vo.DrawAwardInfo;
import pers.ocean.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import pers.ocean.lottery.infrastructure.po.Award;
import pers.ocean.lottery.infrastructure.po.Strategy;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description 抽奖策略模板类
 * @Author ocean_wll
 * @Date 2021/10/8 5:40 下午
 */
@Slf4j
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 1、获取抽奖策略
        StrategyRich rich = queryStrategyByStrategyId(req.getStrategyId());
        Strategy strategy = rich.getStrategy();

        // 2、校验抽奖策略是否已经初始化到内存
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), rich.getStrategyDetailList());

        // 3、获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());

        // 4、执行抽奖算法
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()),
            excludeAwardIds);

        // 5、包装中奖结果
        return buildDrawResult(req.getUId(), req.getStrategyId(), awardId);
    }

    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等，这类数据是含有业务逻辑的，所以需要由具体的实现方决定
     *
     * @param strategyId 策略id
     * @return 排除的奖品ID集合
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略id
     * @param drawAlgorithm   抽奖算法模型
     * @param excludeAwardIds 排除的抽奖id集合
     * @return 中奖奖品ID
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm,
        List<String> excludeAwardIds);

    /**
     * 校验抽奖策略是否已经初始化到内存
     *
     * @param strategyId         抽奖策略id
     * @param strategyMode       抽奖策略模式
     * @param strategyDetailList 抽奖策略详情
     */
    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        // 非单项概率，不必存入缓存
        if (!StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }

        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);

        // 已初始化过的数据，不必重复初始化
        if (drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        // 解析并初始化中奖概率数据到散列表
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        strategyDetailList.forEach(
            item -> awardRateInfoList.add(new AwardRateInfo(item.getAwardId(), item.getAwardRate())));

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

    /**
     * 包装抽奖结果
     *
     * @param uId        用户id
     * @param strategyId 策略id
     * @param awardId    奖品id
     * @return 中奖结果
     */
    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {
        if (null == awardId) {
            log.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        Award award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardName());
        log.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }
}

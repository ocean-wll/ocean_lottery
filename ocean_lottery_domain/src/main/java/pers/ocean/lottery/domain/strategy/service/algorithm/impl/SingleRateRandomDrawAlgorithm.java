package pers.ocean.lottery.domain.strategy.service.algorithm.impl;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.domain.strategy.service.algorithm.BaseAlgorithm;

/**
 * @Description 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 * @Author ocean_wll
 * @Date 2021/9/18 5:08 下午
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 获取策略对应的元组
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int randomVal = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(randomVal);

        // 返回结果
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) {
            return "未中奖";
        }

        return awardId;
    }
}

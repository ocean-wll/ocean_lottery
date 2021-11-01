package pers.ocean.lottery.domain.strategy.service.draw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import pers.ocean.lottery.common.Constants.StrategyMode;
import pers.ocean.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:54 下午
 */
public class DrawConfig {

    @Resource
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmGroup.put(StrategyMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}

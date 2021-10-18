package pers.ocean.lottery.domain.strategy.service.draw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import pers.ocean.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:54 下午
 */
public class DrawConfig {

    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmGroup.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(2, singleRateRandomDrawAlgorithm);
    }
}

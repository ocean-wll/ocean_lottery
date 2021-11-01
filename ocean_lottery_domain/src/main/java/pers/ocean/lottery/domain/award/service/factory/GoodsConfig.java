package pers.ocean.lottery.domain.award.service.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pers.ocean.lottery.domain.award.service.goods.IDistributionGoods;

/**
 * @Description 各类发奖奖品配置类
 * @Author ocean_wll
 * @Date 2021/11/1 2:37 下午
 */
public class GoodsConfig {

    /**
     * 奖品发放策略组
     */
    protected final static Map<Integer, IDistributionGoods> GOODS_MAP = new ConcurrentHashMap<>();

    /**
     * 构造函数
     *
     * @param distributionGoods 奖品发送类
     */
    public GoodsConfig(List<IDistributionGoods> distributionGoods) {
        distributionGoods.forEach(item -> GOODS_MAP.put(item.getAwardType().getCode(), item));
    }
}
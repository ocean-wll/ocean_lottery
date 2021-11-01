package pers.ocean.lottery.domain.award.service.factory;

import java.util.List;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.domain.award.service.goods.IDistributionGoods;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 2:44 下午
 */
@Component
public class DistributionGoodsFactory extends GoodsConfig {

    /**
     * 构造函数
     *
     * @param distributionGoods 奖品发送类
     */
    public DistributionGoodsFactory(List<IDistributionGoods> distributionGoods) {
        super(distributionGoods);
    }

    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return GOODS_MAP.get(awardType);
    }
}

package pers.ocean.lottery.domain.award.service.goods;

import pers.ocean.lottery.common.Constants.AwardType;
import pers.ocean.lottery.domain.award.model.req.GoodsReq;
import pers.ocean.lottery.domain.award.model.res.DistributionRes;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 1:54 下午
 */
public interface IDistributionGoods {

    AwardType getAwardType();

    /**
     * 奖品配送接口，奖品类型（1：文字描述、2：兑换码、3：优惠券、4：实物奖品）
     *
     * @param req 物品信息
     * @return 配送结果
     */
    DistributionRes doDistribution(GoodsReq req);
}

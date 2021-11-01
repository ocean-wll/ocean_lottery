package pers.ocean.lottery.domain.award.service.goods.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Constants.AwardType;
import pers.ocean.lottery.domain.award.model.req.GoodsReq;
import pers.ocean.lottery.domain.award.model.res.DistributionRes;
import pers.ocean.lottery.domain.award.service.goods.DistributionBase;
import pers.ocean.lottery.domain.award.service.goods.IDistributionGoods;

/**
 * @Description 实物奖品
 * @Author ocean_wll
 * @Date 2021/11/1 2:33 下午
 */
@Component
@Slf4j
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public AwardType getAwardType() {
        return AwardType.PHYSICAL_GOODS;
    }

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // 模拟调用实物奖品发放接口
        log.info("模拟调用实物奖品接口 uId：{} awardContent：{}", req.getUId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(),
            Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getUId(), Constants.AwardState.SUCCESS.getCode(),
            Constants.AwardState.SUCCESS.getInfo());
    }
}

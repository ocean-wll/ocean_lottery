package pers.ocean.lottery.domain.award.service.goods;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import pers.ocean.lottery.domain.award.repository.IAwardRepository;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 2:12 下午
 */
@Slf4j
public class DistributionBase {

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState,
        String awardStateInfo) {

        // TODO ocean_wll 后期添加分库分表后，在用户个人的抽奖记录表中记录奖品发奖状态

        log.info("TODO 后期添加分库分表后，在用户个人的抽奖记录表中记录奖品发奖状态 uId:{}", uId);
    }

}
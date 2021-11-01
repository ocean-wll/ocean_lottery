package pers.ocean.lottery.test;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.domain.award.model.req.GoodsReq;
import pers.ocean.lottery.domain.award.model.res.DistributionRes;
import pers.ocean.lottery.domain.award.service.factory.DistributionGoodsFactory;
import pers.ocean.lottery.domain.award.service.goods.IDistributionGoods;
import pers.ocean.lottery.domain.strategy.model.req.DrawReq;
import pers.ocean.lottery.domain.strategy.model.res.DrawResult;
import pers.ocean.lottery.domain.strategy.model.vo.DrawAwardInfo;
import pers.ocean.lottery.domain.strategy.service.draw.IDrawExec;
import pers.ocean.lottery.infrastructure.dao.IActivityDao;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 2:47 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringRunnerTest {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void test_award() {
        // 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("ocean_wll", 10001L));

        // 判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            log.info("未中奖 DrawAwardInfo is null");
            return;
        }

        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getUId(), "2109313442431", drawAwardInfo.getAwardId(),
            drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(
            drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        log.info("测试结果：{}", JSON.toJSONString(distributionRes));
    }
}

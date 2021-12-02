package pers.ocean.lottery.application.process.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import pers.ocean.lottery.application.process.IActivityProcess;
import pers.ocean.lottery.application.process.req.DrawProcessReq;
import pers.ocean.lottery.application.process.res.DrawProcessResult;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Constants.DrawState;
import pers.ocean.lottery.common.Constants.Ids;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.domain.activity.model.req.PartakeReq;
import pers.ocean.lottery.domain.activity.model.res.PartakeResult;
import pers.ocean.lottery.domain.activity.model.vo.DrawOrderVO;
import pers.ocean.lottery.domain.activity.service.partake.IActivityPartake;
import pers.ocean.lottery.domain.strategy.model.req.DrawReq;
import pers.ocean.lottery.domain.strategy.model.res.DrawResult;
import pers.ocean.lottery.domain.strategy.model.vo.DrawAwardInfo;
import pers.ocean.lottery.domain.strategy.service.draw.IDrawExec;
import pers.ocean.lottery.domain.support.ids.IIdGenerator;

/**
 * @Description 活动抽奖流程编排
 * @Author ocean_wll
 * @Date 2021/11/30 3:19 下午
 */
@Service
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private Map<Ids, IIdGenerator> idGeneratorMap;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {
        // 1、领取活动
        PartakeResult partakeResult = activityPartake.doPartake(new PartakeReq(req.getUserId(), req.getActivityId()));
        if (!ResponseCode.SUCCESS.getCode().equals(partakeResult.getCode())) {
            return new DrawProcessResult(partakeResult.getCode(), partakeResult.getInfo());
        }

        Long strategyId = partakeResult.getStrategyId();
        Long takeId = partakeResult.getTakeId();

        // 2、执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq(req.getUserId(), strategyId, String.valueOf(takeId)));
        if (DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            return new DrawProcessResult(ResponseCode.LOSING_DRAW.getCode(), ResponseCode.LOSING_DRAW.getInfo());
        }

        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();

        // 3、结果入库
        activityPartake.recordDrawOrder(buildDrawOrderVO(req, strategyId, takeId, drawAwardInfo));

        // 4、发送MQ，触发发奖流程

        // 5、返回结果
        return new DrawProcessResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), drawAwardInfo);
    }

    private DrawOrderVO buildDrawOrderVO(DrawProcessReq req, Long strategyId, Long takeId,
        DrawAwardInfo drawAwardInfo) {
        long orderId = idGeneratorMap.get(Ids.SNOW_FLAKE).nextId();
        DrawOrderVO drawOrderVO = new DrawOrderVO();
        drawOrderVO.setUserId(req.getUserId());
        drawOrderVO.setTakeId(takeId);
        drawOrderVO.setActivityId(req.getActivityId());
        drawOrderVO.setOrderId(orderId);
        drawOrderVO.setStrategyId(strategyId);
        drawOrderVO.setStrategyMode(drawAwardInfo.getStrategyMode());
        drawOrderVO.setGrantType(drawAwardInfo.getGrantType());
        drawOrderVO.setGrantDate(drawAwardInfo.getGrantDate());
        drawOrderVO.setGrantState(Constants.GrantState.INIT.getCode());
        drawOrderVO.setAwardId(drawAwardInfo.getAwardId());
        drawOrderVO.setAwardType(drawAwardInfo.getAwardType());
        drawOrderVO.setAwardName(drawAwardInfo.getAwardName());
        drawOrderVO.setAwardContent(drawAwardInfo.getAwardContent());
        return drawOrderVO;
    }
}

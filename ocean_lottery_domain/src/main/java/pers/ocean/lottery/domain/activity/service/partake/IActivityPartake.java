package pers.ocean.lottery.domain.activity.service.partake;

import pers.ocean.lottery.domain.activity.model.req.PartakeReq;
import pers.ocean.lottery.domain.activity.model.res.PartakeResult;

/**
 * @Description 抽奖活动参与接口
 * @Author ocean_wll
 * @Date 2021/11/1 7:55 下午
 */
public interface IActivityPartake {

    /**
     * 参加活动
     *
     * @param req 入参
     * @return 领取结果
     */
    PartakeResult doPartake(PartakeReq req);
}

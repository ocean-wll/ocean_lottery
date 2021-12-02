package pers.ocean.lottery.domain.activity.service.partake;

import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.model.req.PartakeReq;
import pers.ocean.lottery.domain.activity.model.res.PartakeResult;
import pers.ocean.lottery.domain.activity.model.vo.DrawOrderVO;

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

    /**
     * 保存奖品单
     *
     * @param drawOrderVO 奖品单
     * @return 保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrderVO);
}

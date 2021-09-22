package pers.ocean.lottery.domain.strategy.service.draw;

import pers.ocean.lottery.domain.strategy.model.req.DrawReq;
import pers.ocean.lottery.domain.strategy.model.res.DrawResult;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:45 下午
 */
public interface IDrawExec {

    /**
     * 执行抽奖
     *
     * @param req 请求
     * @return response
     */
    DrawResult doDrawExec(DrawReq req);
}

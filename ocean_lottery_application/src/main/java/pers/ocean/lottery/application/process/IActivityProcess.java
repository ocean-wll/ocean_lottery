package pers.ocean.lottery.application.process;

import pers.ocean.lottery.application.process.req.DrawProcessReq;
import pers.ocean.lottery.application.process.res.DrawProcessResult;

/**
 * @Description 活动抽奖流程编排接口
 * @Author ocean_wll
 * @Date 2021/11/30 2:41 下午
 */
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     *
     * @param req 抽奖请求
     * @return 抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}

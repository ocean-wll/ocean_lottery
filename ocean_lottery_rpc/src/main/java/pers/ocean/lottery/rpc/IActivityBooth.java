package pers.ocean.lottery.rpc;

import pers.ocean.lottery.rpc.req.ActivityReq;
import pers.ocean.lottery.rpc.res.ActivityRes;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:43 下午
 */
public interface IActivityBooth {

    /**
     * 根据id查询活动详情
     *
     * @param req 查询对象
     * @return ActivityRes
     */
    ActivityRes queryActivityById(ActivityReq req);
}

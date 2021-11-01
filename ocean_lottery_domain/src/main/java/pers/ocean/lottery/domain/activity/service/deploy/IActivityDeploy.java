package pers.ocean.lottery.domain.activity.service.deploy;

import pers.ocean.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @Description 部署活动配置接口
 * @Author ocean_wll
 * @Date 2021/11/1 7:54 下午
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);
}

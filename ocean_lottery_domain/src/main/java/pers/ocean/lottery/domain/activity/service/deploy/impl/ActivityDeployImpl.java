package pers.ocean.lottery.domain.activity.service.deploy.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import pers.ocean.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import pers.ocean.lottery.domain.activity.model.req.ActivityConfigReq;
import pers.ocean.lottery.domain.activity.model.vo.ActivityVO;
import pers.ocean.lottery.domain.activity.model.vo.AwardVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyDetailVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyVO;
import pers.ocean.lottery.domain.activity.repository.IActivityRepository;
import pers.ocean.lottery.domain.activity.service.deploy.IActivityDeploy;

/**
 * @Description 部署活动配置服务
 * @Author ocean_wll
 * @Date 2021/11/1 8:19 下午
 */
@Service
@Slf4j
public class ActivityDeployImpl implements IActivityDeploy {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    public void createActivity(ActivityConfigReq req) {
        log.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            log.info("创建活动配置完成，activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            log.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        // TODO ocean_wll 非核心功能后续补充
    }
}

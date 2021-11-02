package pers.ocean.lottery.domain.activity.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.domain.activity.model.vo.ActivityVO;
import pers.ocean.lottery.infrastructure.vo.AlterStateVO;
import pers.ocean.lottery.domain.activity.model.vo.AwardVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyDetailVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyVO;
import pers.ocean.lottery.domain.activity.repository.IActivityRepository;
import pers.ocean.lottery.infrastructure.dao.IActivityDao;
import pers.ocean.lottery.infrastructure.dao.IAwardDao;
import pers.ocean.lottery.infrastructure.dao.IStrategyDao;
import pers.ocean.lottery.infrastructure.dao.IStrategyDetailDao;
import pers.ocean.lottery.infrastructure.po.Activity;
import pers.ocean.lottery.infrastructure.po.Award;
import pers.ocean.lottery.infrastructure.po.Strategy;
import pers.ocean.lottery.infrastructure.po.StrategyDetail;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/2 3:16 下午
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState) beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}

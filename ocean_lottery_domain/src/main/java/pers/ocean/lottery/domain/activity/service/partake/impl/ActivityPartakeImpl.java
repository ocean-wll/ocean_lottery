package pers.ocean.lottery.domain.activity.service.partake.impl;

import java.util.Map;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.activity.model.req.PartakeReq;
import pers.ocean.lottery.domain.activity.model.vo.ActivityBillVO;
import pers.ocean.lottery.domain.activity.model.vo.DrawOrderVO;
import pers.ocean.lottery.domain.activity.model.vo.UserTakeActivityVO;
import pers.ocean.lottery.domain.activity.repository.IUserTakeActivityRepository;
import pers.ocean.lottery.domain.activity.service.partake.BaseActivityPartake;
import pers.ocean.lottery.domain.support.ids.IIdGenerator;
import pers.ocean.middleware.db.router.strategy.IDBRouterStrategy;

/**
 * @Description 活动参与功能实现
 * @Author ocean_wll
 * @Date 2021/11/20 3:14 下午
 */
@Service
@Slf4j
public class ActivityPartakeImpl extends BaseActivityPartake {

    @Resource
    private IUserTakeActivityRepository userTakeActivityRepository;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private IDBRouterStrategy dbRouter;

    @Override
    protected UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String userId) {
        return userTakeActivityRepository.queryNoConsumedTakeActivityOrder(activityId, userId);
    }

    @Override
    protected Result checkActivityBill(PartakeReq partake, ActivityBillVO bill) {
        // 校验：活动状态
        if (!Constants.ActivityState.DOING.getCode().equals(bill.getState())) {
            log.warn("活动当前状态非可用 state：{}", bill.getState());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动当前状态非可用");
        }

        // 校验：活动日期
        if (bill.getBeginDateTime().after(partake.getPartakeDate()) || bill.getEndDateTime().before(
            partake.getPartakeDate())) {
            log.warn("活动时间范围非可用 beginDateTime：{} endDateTime：{}", bill.getBeginDateTime(), bill.getEndDateTime());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动时间范围非可用");
        }

        // 校验：活动库存
        if (bill.getStockSurplusCount() <= 0) {
            log.warn("活动剩余库存非可用 stockSurplusCount：{}", bill.getStockSurplusCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动剩余库存非可用");
        }

        // 校验：个人库存 - 个人活动剩余可领取次数
        if (bill.getUserTakeLeftCount() <= 0) {
            log.warn("个人领取次数非可用 userTakeLeftCount：{}", bill.getUserTakeLeftCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "个人领取次数非可用");
        }

        return Result.buildSuccessResult();
    }

    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        int count = activityRepository.subtractionActivityStock(req.getActivityId());
        if (0 == count) {
            log.error("扣减活动库存失败 activityId：{}", req.getActivityId());
            return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
        }
        return Result.buildSuccessResult();
    }

    @Override
    protected Result grabActivity(PartakeReq partake, ActivityBillVO bill, Long takeId) {
        try {
            dbRouter.doRouter(partake.getUserId());
            return transactionTemplate.execute(status -> {
                try {
                    // 扣减个人已参与次数
                    int updateCount = userTakeActivityRepository.subtractionLeftCount(bill.getActivityId(),
                        bill.getActivityName(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getUserId(),
                        partake.getPartakeDate());
                    if (0 == updateCount) {
                        // 回滚事务
                        status.setRollbackOnly();
                        log.error("领取活动，扣减个人已参与次数失败 activityId：{} uId：{}", partake.getActivityId(),
                            partake.getUserId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }

                    // 插入领取活动信息
                    userTakeActivityRepository.takeActivity(bill.getActivityId(), bill.getActivityName(),
                        bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getUserId(), partake.getPartakeDate(),
                        takeId);
                } catch (DuplicateKeyException e) {
                    status.setRollbackOnly();
                    log.error("领取活动，唯一索引冲突 activityId：{} uId：{}", partake.getActivityId(), partake.getUserId(), e);
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
                }
                return Result.buildSuccessResult();
            });
        } finally {
            dbRouter.clear();
        }
    }

    @Override
    public Result recordDrawOrder(DrawOrderVO drawOrderVO) {
        try {
            dbRouter.doRouter(drawOrderVO.getUserId());
            return transactionTemplate.execute(status -> {
                try {
                    // 锁定活动领取记录
                    int lockCount = userTakeActivityRepository.lockTackActivity(drawOrderVO.getUserId(),
                        drawOrderVO.getActivityId(), drawOrderVO.getTakeId());
                    if (0 == lockCount) {
                        status.setRollbackOnly();
                        log.error("记录中奖单，个人参与活动抽奖已消耗完 activityId：{} userId：{}", drawOrderVO.getActivityId(),
                            drawOrderVO.getUserId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }

                    // 保存抽奖信息
                    userTakeActivityRepository.saveUserStrategyExport(drawOrderVO);
                } catch (DuplicateKeyException e) {
                    status.setRollbackOnly();
                    log.error("领取活动，唯一索引冲突 activityId：{} userId：{}", drawOrderVO.getActivityId(),
                        drawOrderVO.getUserId(), e);
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
                }
                return Result.buildSuccessResult();
            });
        } finally {
            dbRouter.clear();
        }
    }
}

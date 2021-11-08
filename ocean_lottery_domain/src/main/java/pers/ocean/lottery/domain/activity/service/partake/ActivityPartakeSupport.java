package pers.ocean.lottery.domain.activity.service.partake;

import javax.annotation.Resource;

import pers.ocean.lottery.domain.activity.model.req.PartakeReq;
import pers.ocean.lottery.domain.activity.model.vo.ActivityBillVO;
import pers.ocean.lottery.domain.activity.repository.IActivityRepository;

/**
 * @Description 活动领取操作，一些通用的数据服务
 * @Author ocean_wll
 * @Date 2021/11/5 2:05 下午
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    /**
     * 查询活动数据
     *
     * @param req 请求
     * @return ActivityBillVO
     */
    protected ActivityBillVO queryActivityBill(PartakeReq req) {
        return activityRepository.queryActivityBill(req);
    }
}

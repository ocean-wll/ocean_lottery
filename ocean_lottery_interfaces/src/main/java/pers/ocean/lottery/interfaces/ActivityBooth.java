package pers.ocean.lottery.interfaces;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;
import pers.ocean.lottery.common.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.infrastructure.dao.IActivityDao;
import pers.ocean.lottery.infrastructure.po.Activity;
import pers.ocean.lottery.rpc.IActivityBooth;
import pers.ocean.lottery.rpc.dto.ActivityDto;
import pers.ocean.lottery.rpc.req.ActivityReq;
import pers.ocean.lottery.rpc.res.ActivityRes;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:44 下午
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}

package pers.ocean.lottery.interfaces;

import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.dubbo.config.annotation.DubboService;
import pers.ocean.lottery.common.Constants.ResponseCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.infrastructure.dao.IActivityDao;
import pers.ocean.lottery.rpc.IActivityBooth;
import pers.ocean.lottery.rpc.dto.ActivityDto;
import pers.ocean.lottery.rpc.req.ActivityReq;
import pers.ocean.lottery.rpc.res.ActivityRes;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:44 下午
 */
@DubboService
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Map<String, String> attachments = RpcContext.getContext().getAttachments();
        String token = attachments.get("x-token");

        System.out.println(RpcContext.getContext());
        System.out.println(RpcContext.getContext().getAttachments());
        System.out.println(Thread.currentThread().getName());

        System.out.println("token:" + token);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Activity activity = activityDao.queryActivityById(req.getActivityId());
//
        ActivityDto activityDto = new ActivityDto();
//        activityDto.setActivityId(activity.getActivityId());
//        activityDto.setActivityName(activity.getActivityName());
//        activityDto.setActivityDesc(activity.getActivityDesc());
//        activityDto.setBeginDateTime(activity.getBeginDateTime());
//        activityDto.setEndDateTime(activity.getEndDateTime());
//        activityDto.setStockCount(activity.getStockCount());
//        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}

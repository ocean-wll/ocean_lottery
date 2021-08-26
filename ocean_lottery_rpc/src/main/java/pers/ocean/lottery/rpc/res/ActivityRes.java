package pers.ocean.lottery.rpc.res;

import java.io.Serializable;

import lombok.Data;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.rpc.dto.ActivityDto;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:33 下午
 */
@Data
public class ActivityRes implements Serializable {

    private static final long serialVersionUID = 3760696244884711709L;

    private Result result;

    private ActivityDto activity;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }
}

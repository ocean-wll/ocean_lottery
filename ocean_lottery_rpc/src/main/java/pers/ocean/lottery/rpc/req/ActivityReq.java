package pers.ocean.lottery.rpc.req;

import java.io.Serializable;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:33 下午
 */
@Data
public class ActivityReq implements Serializable {

    private static final long serialVersionUID = 1385839368190879665L;

    private Long activityId;
}

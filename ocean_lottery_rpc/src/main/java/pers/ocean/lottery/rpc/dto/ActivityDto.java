package pers.ocean.lottery.rpc.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:33 下午
 */
@Data
public class ActivityDto implements Serializable {

    private static final long serialVersionUID = 7071760835024293019L;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 开始时间
     */
    private Date beginDateTime;

    /**
     * 结束时间
     */
    private Date endDateTime;

    /**
     * 库存
     */
    private Integer stockCount;

    /**
     * 每人可参与次数
     */
    private Integer takeCount;

    /**
     * 活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启
     */
    private Integer state;
}

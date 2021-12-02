package pers.ocean.lottery.domain.activity.model.vo;

import java.util.Date;

import lombok.Data;

/**
 * @Description 奖品单
 * @Author ocean_wll
 * @Date 2021/11/30 4:42 下午
 */
@Data
public class DrawOrderVO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 策略方式（1：单项概率、2：总体概率）
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式（1：即时、2：定时[含活动结束]、3：人工）
     */
    private Integer grantType;

    /**
     * 发奖时间
     */
    private Date grantDate;

    /**
     * 发奖状态
     */
    private Integer grantState;

    /**
     * 发奖ID
     */
    private String awardId;

    /**
     * 奖品类型（1：文字描述，2：兑换码，3：优惠券，4：实物奖品）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容[文字描述、key、码]
     */
    private String awardContent;
}

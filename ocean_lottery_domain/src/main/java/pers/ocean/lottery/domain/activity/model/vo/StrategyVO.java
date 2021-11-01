package pers.ocean.lottery.domain.activity.model.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @Description 策略信息配置
 * @Author ocean_wll
 * @Date 2021/11/1 8:08 下午
 */
@Data
public class StrategyVO {

    /**
     * 策略Id
     */
    private Long strategyId;

    /**
     * 策略描述
     */
    private String strategyDesc;

    /**
     * 策略方式 1：单项概率、2：总体概率
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式 1：即时、2：定时[含活动结束]、3：人工
     */
    private Integer grantType;

    /**
     * 发放奖品时间
     */
    private Date grantDate;

    /**
     * 扩展信息
     */
    private String extInfo;

    /**
     * 策略详情配置
     */
    private List<StrategyDetailVO> strategyDetailList;
}

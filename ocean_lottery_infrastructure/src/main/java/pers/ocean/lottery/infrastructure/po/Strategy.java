package pers.ocean.lottery.infrastructure.po;

import java.util.Date;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:02 下午
 */
@Data
public class Strategy {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 策略描述
     */
    private String strategyDesc;

    /**
     * 策略方式（1：单项概率，2：总体概率）
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式（1：即时，2：定时，3：人工）
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}

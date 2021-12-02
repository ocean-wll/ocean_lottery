package pers.ocean.lottery.domain.strategy.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/10/18 8:07 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawAwardInfo {

    /**
     * 奖品Id
     */
    private String awardId;

    /**
     * 奖品类型
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容
     */
    private String awardContent;

    /**
     * 策略方式（1、单项概率，2、总体概率）
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式（1、即时，2、定时[含活动结束]，3、人工）
     */
    private Integer grantType;

    /**
     * 发奖时间
     */
    private Date grantDate;
}

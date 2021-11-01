package pers.ocean.lottery.domain.activity.model.vo;

import lombok.Data;

/**
 * @Description 奖品信息配置
 * @Author ocean_wll
 * @Date 2021/11/1 8:15 下午
 */
@Data
public class AwardVO {

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
     * 奖品内容（描述、奖品码、sku）
     */
    private String awardContent;
}

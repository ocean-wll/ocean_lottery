package pers.ocean.lottery.domain.strategy.model.vo;

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
}

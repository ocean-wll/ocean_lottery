package pers.ocean.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 奖品概率信息，奖品编号、库存、概率
 * @Author ocean_wll
 * @Date 2021/9/18 4:17 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AwardRateInfo {

    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
}

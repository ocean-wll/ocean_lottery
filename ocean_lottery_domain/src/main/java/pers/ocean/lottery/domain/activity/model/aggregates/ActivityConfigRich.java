package pers.ocean.lottery.domain.activity.model.aggregates;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.ocean.lottery.domain.activity.model.vo.ActivityVO;
import pers.ocean.lottery.domain.activity.model.vo.AwardVO;
import pers.ocean.lottery.domain.activity.model.vo.StrategyVO;

/**
 * @Description 活动配置聚合信息
 * @Author ocean_wll
 * @Date 2021/11/1 8:01 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityConfigRich {

    /**
     * 活动配置
     */
    private ActivityVO activity;

    /**
     * 策略配置（含策略明细）
     */
    private StrategyVO strategy;

    /**
     * 奖品配置
     */
    private List<AwardVO> awardList;
}

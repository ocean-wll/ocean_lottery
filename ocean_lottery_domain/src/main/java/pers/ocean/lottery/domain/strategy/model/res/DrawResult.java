package pers.ocean.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.ocean.lottery.common.Constants.DrawState;
import pers.ocean.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:49 下午
 */
@Data
public class DrawResult {

    /**
     * 用户id
     */
    private String uId;

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 中奖状态
     *
     * @see pers.ocean.lottery.common.Constants.DrawState
     */
    private Integer drawState = DrawState.FAIL.getCode();

    /**
     * 中奖奖品信息
     */
    private DrawAwardInfo drawAwardInfo;

    public DrawResult() {
    }

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }
}

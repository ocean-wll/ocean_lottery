package pers.ocean.lottery.domain.activity.model.res;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ocean.lottery.common.Result;

/**
 * @Description 活动参与结果
 * @Author ocean_wll
 * @Date 2021/11/5 2:01 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PartakeResult extends Result {

    private static final long serialVersionUID = 5285876407131407596L;

    /**
     * 策略Id
     */
    private Long strategyId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }
}

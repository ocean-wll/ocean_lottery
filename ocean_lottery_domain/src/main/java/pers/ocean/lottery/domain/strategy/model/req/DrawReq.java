package pers.ocean.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:48 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawReq {

    /**
     * 用户id
     */
    private String uId;

    /**
     * 策略id
     */
    private Long strategyId;
}

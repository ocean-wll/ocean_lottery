package pers.ocean.lottery.domain.strategy.model.req;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:48 下午
 */
@Data
@NoArgsConstructor
public class DrawReq {

    /**
     * 用户id
     */
    private String uId;

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 防重ID
     */
    private String uuid;

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public DrawReq(String uId, Long strategyId, String uuid) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }
}

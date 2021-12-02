package pers.ocean.lottery.application.process.res;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ocean.lottery.common.Result;
import pers.ocean.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/30 2:56 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DrawProcessResult extends Result {

    private static final long serialVersionUID = 9147220419231161630L;

    private DrawAwardInfo drawAwardInfo;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }
}

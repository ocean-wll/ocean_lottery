package pers.ocean.lottery.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 常量类
 * @Author ocean_wll
 * @Date 2021/10/18 5:44 下午
 */
public class Constants {

    @AllArgsConstructor
    @Getter
    public enum ResponseCode {

        SUCCESS("0000", "成功"),
        UN_ERROR("0001", "未知失败"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        INDEX_DUP("0003", "主键冲突");

        private String code;
        private String info;
    }

    /**
     * 抽奖策略模式：总体概率、单项概率
     * 场景：两种抽奖算法描述，场景A20%、B30%、C50%
     * 单项概率：如果A奖品抽空后，B和C保持目前中奖概率，用户抽奖扔有20%中为A，因A库存抽空则结果展示为未中奖。为了运营成本，通常这种情况的使用的比较多
     * 总体概率：如果A奖品抽空后，B和C奖品的概率按照 3:5 均分，相当于B奖品中奖概率由 0.3 升为 0.375
     */
    @AllArgsConstructor
    @Getter
    public enum StrategyMode {

        /**
         * 单项概率：如果A奖品抽空后，B和C保持目前中奖概率，用户抽奖扔有20%中为A，因A库存抽空则结果展示为未中奖。为了运营成本，通常这种情况的使用的比较多
         */
        SINGLE(1, "单项概率"),

        /**
         * 总体概率：如果A奖品抽空后，B和C奖品的概率按照 3:5 均分，相当于B奖品中奖概率由 0.3 升为 0.375
         */
        ENTIRETY(2, "总体概率");

        private Integer code;
        private String info;
    }

    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖
     */
    @AllArgsConstructor
    @Getter
    public enum DrawState {
        /**
         * 未中奖
         */
        FAIL(0, "未中奖"),

        /**
         * 已中奖
         */
        SUCCESS(1, "已中奖"),

        /**
         * 兜底奖
         */
        Cover(2, "兜底奖");

        private Integer code;
        private String info;
    }
}

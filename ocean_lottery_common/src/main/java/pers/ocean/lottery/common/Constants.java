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
     * 活动状态 1：编辑、2：提审、3：撤审、4：通过、5：运行(审核通过后worker扫描状态)、6：拒绝、7：关闭、8：开启
     */
    @AllArgsConstructor
    @Getter
    public enum ActivityState {

        /**
         * 编辑
         */
        EDIT(1, "编辑"),

        /**
         * 提审
         */
        ARRAIGNMENT(2, "提审"),

        /**
         * 撤审
         */
        REVOKE(3, "撤审"),

        /**
         * 通过
         */
        PASS(4, "通过"),

        /**
         * 运行(活动中)
         */
        DOING(5, "运行(活动中)"),

        /**
         * 拒绝
         */
        REFUSE(6, "拒绝"),

        /**
         * 关闭
         */
        CLOSE(7, "关闭"),

        /**
         * 开启
         */
        OPEN(8, "开启");

        private Integer code;
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

    /**
     * 发奖状态：0：等待发奖、1：发奖成功、2：发奖失败
     */
    @AllArgsConstructor
    @Getter
    public enum AwardState {
        /**
         * 等待发奖
         */
        WAIT(0, "等待发奖"),

        /**
         * 发奖成功
         */
        SUCCESS(1, "发奖成功"),

        /**
         * 发奖失败
         */
        FAILURE(2, "发奖失败");

        private Integer code;
        private String info;
    }

    /**
     * 奖品类型 0：文字描述、1：兑换码、2：优惠券、3：实物奖品
     */
    @AllArgsConstructor
    @Getter
    public enum AwardType {
        /**
         * 文字描述
         */
        DESC(0, "文字描述"),

        /**
         * 兑换码
         */
        REDEMPTION_CODE_GOODS(1, "兑换码"),

        /**
         * 优惠券
         */
        COUPON_GOODS(2, "优惠券"),

        /**
         * 实物奖品
         */
        PHYSICAL_GOODS(3, "实物奖品");

        private Integer code;
        private String info;
    }
}

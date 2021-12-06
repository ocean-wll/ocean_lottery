package pers.ocean.lottery.domain.rule.module.vo;

import lombok.Data;

/**
 * @Description 规则树线信息
 * @Author ocean_wll
 * @Date 2021/12/3 4:52 下午
 */
@Data
public class TreeNodeLineVO {

    /**
     * 节点From
     */
    private Long nodeIdFrom;

    /**
     * 节点To
     */
    private Long nodeIdTo;

    /**
     * 限定类型；
     * 1:=
     * 2:>
     * 3:<
     * 4:>=
     * 5<=
     * 6:enum[枚举范围]
     */
    private Integer ruleLimitType;

    /**
     * 限定值
     */
    private String ruleLimitValue;

}

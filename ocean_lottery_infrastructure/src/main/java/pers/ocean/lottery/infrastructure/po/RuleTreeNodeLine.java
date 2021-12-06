package pers.ocean.lottery.infrastructure.po;

import lombok.Data;

/**
 * @Description 规则树连接线
 * @Author ocean_wll
 * @Date 2021/12/6 2:40 下午
 */
@Data
public class RuleTreeNodeLine {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 节点From
     */
    private Long nodeIdFrom;

    /**
     * 节点To
     */
    private Long nodeIdTo;

    /**
     * 限定类型
     */
    private Integer ruleLimitType;

    /**
     * 限定值
     */
    private String ruleLimitValue;
}

package pers.ocean.lottery.infrastructure.po;

import lombok.Data;

/**
 * @Description 规则树节点
 * @Author ocean_wll
 * @Date 2021/12/6 2:36 下午
 */
@Data
public class RuleTreeNode {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 节点类型：1、子叶，2、果实
     */
    private Integer nodeType;

    /**
     * 节点值[nodeType=2]：果实值
     */
    private String nodeValue;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 规则描述
     */
    private String ruleDesc;
}

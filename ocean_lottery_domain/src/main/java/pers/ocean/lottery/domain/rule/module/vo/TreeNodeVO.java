package pers.ocean.lottery.domain.rule.module.vo;

import java.util.List;

import lombok.Data;

/**
 * @Description 树节点对象
 * @Author ocean_wll
 * @Date 2021/12/3 4:49 下午
 */
@Data
public class TreeNodeVO {

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 规则树节点ID
     */
    private Long treeNodeId;

    /**
     * 节点类型：1-子叶、2-果实
     */
    private Integer nodeType;

    /**
     * 节点值[nodeType=2]；果实值
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

    /**
     * 节点链路
     */
    private List<TreeNodeLineVO> treeNodeLineInfoList;
}

package pers.ocean.lottery.domain.rule.module.vo;

import lombok.Data;

/**
 * @Description 规则树对象
 * @Author ocean_wll
 * @Date 2021/12/3 2:46 下午
 */
@Data
public class TreeRootVO {

    /**
     * 规则树Id
     */
    private Long treeId;

    /**
     * 规则树名称
     */
    private String treeName;

    /**
     * 规则树根ID
     */
    private Long treeRootNodeId;
}

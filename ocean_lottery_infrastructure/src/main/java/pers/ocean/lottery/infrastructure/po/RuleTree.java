package pers.ocean.lottery.infrastructure.po;

import java.util.Date;

import lombok.Data;

/**
 * @Description 规则树
 * @Author ocean_wll
 * @Date 2021/12/6 2:33 下午
 */
@Data
public class RuleTree {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 规则树名称
     */
    private String treeName;

    /**
     * 规则树描述
     */
    private String treeDesc;

    /**
     * 规则树根ID
     */
    private Long treeRootNodeId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

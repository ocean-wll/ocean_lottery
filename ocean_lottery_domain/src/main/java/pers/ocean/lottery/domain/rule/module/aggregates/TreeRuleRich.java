package pers.ocean.lottery.domain.rule.module.aggregates;

import java.util.Map;

import lombok.Data;
import pers.ocean.lottery.domain.rule.module.vo.TreeNodeVO;
import pers.ocean.lottery.domain.rule.module.vo.TreeRootVO;

/**
 * @Description 规则树聚合
 * @Author ocean_wll
 * @Date 2021/12/3 5:01 下午
 */
@Data
public class TreeRuleRich {

    /**
     * 树根信息
     */
    private TreeRootVO treeRoot;

    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNodeVO> treeNodeMap;
}

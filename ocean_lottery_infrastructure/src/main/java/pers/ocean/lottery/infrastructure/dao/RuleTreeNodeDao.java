package pers.ocean.lottery.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.RuleTreeNode;

/**
 * @Description 规则树节点Dao
 * @Author ocean_wll
 * @Date 2021/12/6 3:48 下午
 */
@Mapper
public interface RuleTreeNodeDao {

    /**
     * 查询规则树节点
     *
     * @param treeId 规则树ID
     * @return 规则树节点集合
     */
    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    /**
     * 查询规则树节点数量
     *
     * @param treeId 规则树ID
     * @return 节点数量
     */
    int queryTreeNodeCount(Long treeId);

    /**
     * 查询规则树规则集合
     *
     * @param treeId 规则树ID
     * @return 节点集合
     */
    List<RuleTreeNode> queryTreeRulePoint(Long treeId);
}

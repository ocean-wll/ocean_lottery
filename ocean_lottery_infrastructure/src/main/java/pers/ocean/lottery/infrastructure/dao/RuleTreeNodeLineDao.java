package pers.ocean.lottery.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.RuleTreeNodeLine;

/**
 * @Description 规则树节点连线Dao
 * @Author ocean_wll
 * @Date 2021/12/6 3:48 下午
 */
@Mapper
public interface RuleTreeNodeLineDao {

    /**
     * 查询规则树节点连线集合
     *
     * @param req 入参
     * @return 规则树节点连线集合
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * 查询规则树连线数量
     *
     * @param treeId 规则树ID
     * @return 规则树连线数量
     */
    int queryTreeNodeLineCount(Long treeId);
}

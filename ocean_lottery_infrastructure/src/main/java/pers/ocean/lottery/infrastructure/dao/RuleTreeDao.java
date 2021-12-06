package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.RuleTree;

/**
 * @Description 规则树配置Dao
 * @Author ocean_wll
 * @Date 2021/12/6 2:46 下午
 */
@Mapper
public interface RuleTreeDao {

    /**
     * 规则树查询
     *
     * @param treeId 规则树ID
     * @return 规则树
     */
    RuleTree queryRuleTreeByTreeId(Long treeId);

    /**
     * 规则树简要信息查询
     *
     * @param treeId 规则树ID
     * @return 规则树
     */
    RuleTree queryTreeSummaryInfo(Long treeId);
}

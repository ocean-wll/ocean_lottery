package pers.ocean.lottery.domain.rule.repository;

import pers.ocean.lottery.domain.rule.module.aggregates.TreeRuleRich;

/**
 * @Description 规则信息仓储服务接口
 * @Author ocean_wll
 * @Date 2021/12/6 11:56 上午
 */
public interface IRuleRepository {

    /**
     * 查询规则决策树配置
     *
     * @param treeId 决策树Id
     * @return 决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}

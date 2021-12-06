package pers.ocean.lottery.domain.rule.service.logic;

import java.util.List;

import pers.ocean.lottery.domain.rule.module.req.DecisionMatterReq;
import pers.ocean.lottery.domain.rule.module.vo.TreeNodeLineVO;

/**
 * @Description 规则过滤器接口
 * @Author ocean_wll
 * @Date 2021/12/3 5:09 下午
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点
     * @return 下一个节点ID
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     * 获取决策值
     *
     * @param decisionMatter 决策物料
     * @return 决策值
     */
    String matterValue(DecisionMatterReq decisionMatter);
}

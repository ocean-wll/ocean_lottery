package pers.ocean.lottery.domain.rule.service.logic;

import java.util.List;

import pers.ocean.lottery.common.Constants.Global;
import pers.ocean.lottery.common.Constants.RuleLimitType;
import pers.ocean.lottery.domain.rule.module.vo.TreeNodeLineVO;

/**
 * @Description 规则基础抽象类
 * @Author ocean_wll
 * @Date 2021/12/6 11:11 上午
 */
public abstract class BaseLogic implements LogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList) {
        for (TreeNodeLineVO nodeLineVO : treeNodeLineInfoList) {
            if (decisionLogic(matterValue, nodeLineVO)) {
                return nodeLineVO.getNodeIdTo();
            }
        }
        return Global.TREE_NULL_NODE;
    }

    /**
     * 决策逻辑
     *
     * @param matterValue 匹配值
     * @param nodeLine    决策规则
     * @return 是否满足，true满足，false不满足
     */
    private boolean decisionLogic(String matterValue, TreeNodeLineVO nodeLine) {
        if (nodeLine == null) {
            return false;
        }
        switch (nodeLine.getRuleLimitType()) {
            case RuleLimitType.EQUAL:
                return matterValue.equals(nodeLine.getRuleLimitValue());
            case RuleLimitType.GT:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLine.getRuleLimitValue());
            case RuleLimitType.LT:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLine.getRuleLimitValue());
            case RuleLimitType.GE:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLine.getRuleLimitValue());
            case RuleLimitType.LE:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLine.getRuleLimitValue());
            default:
                return false;
        }
    }
}

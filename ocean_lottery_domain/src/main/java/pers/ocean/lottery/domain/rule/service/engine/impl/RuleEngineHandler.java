package pers.ocean.lottery.domain.rule.service.engine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ocean.lottery.domain.rule.module.aggregates.TreeRuleRich;
import pers.ocean.lottery.domain.rule.module.req.DecisionMatterReq;
import pers.ocean.lottery.domain.rule.module.res.EngineResult;
import pers.ocean.lottery.domain.rule.module.vo.TreeNodeVO;
import pers.ocean.lottery.domain.rule.repository.IRuleRepository;
import pers.ocean.lottery.domain.rule.service.engine.EngineBase;

/**
 * @Description 规则引擎处理器
 * @Author ocean_wll
 * @Date 2021/12/6 11:53 上午
 */
@Service
public class RuleEngineHandler extends EngineBase {

    @Autowired
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        // 决策规则树
        TreeRuleRich ruleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (ruleRich == null) {
            throw new RuntimeException("Tree Rule is null!");
        }

        // 决策节点
        TreeNodeVO treeNodeVO = engineDecisionMaker(ruleRich, matter);

        // 决策结果
        return new EngineResult(matter.getUserId(), treeNodeVO.getTreeId(), treeNodeVO.getTreeNodeId(),
            treeNodeVO.getNodeValue());
    }
}

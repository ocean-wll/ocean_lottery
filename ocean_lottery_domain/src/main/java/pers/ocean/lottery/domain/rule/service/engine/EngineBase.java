package pers.ocean.lottery.domain.rule.service.engine;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import pers.ocean.lottery.common.Constants.NodeType;
import pers.ocean.lottery.domain.rule.module.aggregates.TreeRuleRich;
import pers.ocean.lottery.domain.rule.module.req.DecisionMatterReq;
import pers.ocean.lottery.domain.rule.module.res.EngineResult;
import pers.ocean.lottery.domain.rule.module.vo.TreeNodeVO;
import pers.ocean.lottery.domain.rule.module.vo.TreeRootVO;
import pers.ocean.lottery.domain.rule.service.logic.LogicFilter;

/**
 * @Description 规则引擎基础类
 * @Author ocean_wll
 * @Date 2021/12/6 11:36 上午
 */
@Slf4j
public class EngineBase extends EngineConfig implements EngineFilter {

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        throw new RuntimeException("未实现规则引擎服务");
    }

    /**
     * 引擎决策者
     *
     * @param treeRuleRich 树规则
     * @param req          决策请求
     * @return 树节点
     */
    protected TreeNodeVO engineDecisionMaker(TreeRuleRich treeRuleRich, DecisionMatterReq req) {
        TreeRootVO treeRoot = treeRuleRich.getTreeRoot();
        Map<Long, TreeNodeVO> treeNodeMap = treeRuleRich.getTreeNodeMap();

        // 获取根节点
        TreeNodeVO treeNodeInfo = treeNodeMap.get(treeRoot.getTreeRootNodeId());

        // 节点类型[NodeType]；1、子叶，2、果实
        while (NodeType.STEM.equals(treeNodeInfo.getNodeType())) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(req);
            Long nextNodeId = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
            treeNodeInfo = treeNodeMap.get(nextNodeId);
            log.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(),
                req.getUserId(), req.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }

        return treeNodeInfo;
    }
}

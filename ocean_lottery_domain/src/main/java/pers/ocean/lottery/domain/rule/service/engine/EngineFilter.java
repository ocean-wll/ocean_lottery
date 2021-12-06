package pers.ocean.lottery.domain.rule.service.engine;

import pers.ocean.lottery.domain.rule.module.req.DecisionMatterReq;
import pers.ocean.lottery.domain.rule.module.res.EngineResult;

/**
 * @Description 规则过滤器引擎
 * @Author ocean_wll
 * @Date 2021/12/6 11:27 上午
 */
public interface EngineFilter {

    /**
     * 规则过滤器接口
     *
     * @param matter 规则决策物料
     * @return 规则决策结果
     */
    EngineResult process(final DecisionMatterReq matter);
}

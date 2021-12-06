package pers.ocean.lottery.domain.rule.service.logic.impl;

import org.springframework.stereotype.Component;
import pers.ocean.lottery.domain.rule.module.req.DecisionMatterReq;
import pers.ocean.lottery.domain.rule.service.logic.BaseLogic;

/**
 * @Description 性别规则
 * @Author ocean_wll
 * @Date 2021/12/6 11:23 上午
 */
@Component
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }
}

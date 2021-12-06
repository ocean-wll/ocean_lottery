package pers.ocean.lottery.domain.rule.module.req;

import java.util.Map;

import lombok.Data;

/**
 * @Description 决策物料
 * @Author ocean_wll
 * @Date 2021/12/3 5:03 下午
 */
@Data
public class DecisionMatterReq {

    /**
     * 规则树Id
     */
    private Long treeId;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 决策值
     */
    private Map<String, Object> valMap;
}

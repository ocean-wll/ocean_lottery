package pers.ocean.lottery.domain.rule.module.res;

import lombok.Data;

/**
 * @Description 决策结果
 * @Author ocean_wll
 * @Date 2021/12/3 5:05 下午
 */
@Data
public class EngineResult {

    /**
     * 执行结果
     */
    private boolean isSuccess;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 规则树Id
     */
    private Long treeId;

    /**
     * 果实节点Id
     */
    private Long nodeId;

    /**
     * 果实节点值
     */
    private String nodeValue;

    public EngineResult() {
    }

    public EngineResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public EngineResult(String userId, Long treeId, Long nodeId, String nodeValue) {
        this.isSuccess = true;
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }
}

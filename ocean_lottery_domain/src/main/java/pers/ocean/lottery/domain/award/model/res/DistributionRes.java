package pers.ocean.lottery.domain.award.model.res;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 1:56 下午
 */
@Data
public class DistributionRes {

    /**
     * 用户id
     */
    private String uId;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述
     */
    private String info;

    /**
     * 结算单ID，如：发劵后有劵码、发货后有单号等，用于存根查询
     */
    private String statementId;

    public DistributionRes() {
    }

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }

    public DistributionRes(String uId, Integer code, String info, String statementId) {
        this.uId = uId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }
}

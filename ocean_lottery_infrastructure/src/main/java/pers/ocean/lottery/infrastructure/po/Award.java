package pers.ocean.lottery.infrastructure.po;

import java.util.Date;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 2:58 下午
 */
@Data
public class Award {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 奖品id
     */
    private String awardId;

    /**
     * 奖品类型（文字描述、兑换码、优惠券、实物奖品等）
     */
    private Integer awardType;

    /**
     * 奖品数量
     */
    private Integer awardCount;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容（文字描述、key、码）
     */
    private String awardContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}

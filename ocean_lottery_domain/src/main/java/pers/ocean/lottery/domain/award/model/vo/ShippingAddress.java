package pers.ocean.lottery.domain.award.model.vo;

import lombok.Data;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/1 2:04 下午
 */
@Data
public class ShippingAddress {

    /**
     * 收货人
     */
    private String name;

    /**
     * 一级地址Id
     */
    private String provinceId;

    /**
     * 一级地址名称
     */
    private String provinceName;

    /**
     * 二级地址Id
     */
    private String cityId;

    /**
     * 二级地址名称
     */
    private String cityName;

    /**
     * 三级地址Id
     */
    private String countyId;

    /**
     * 三级地址名称
     */
    private String countyName;

    /**
     * 四级地址Id
     */
    private String townId;

    /**
     * 四级地址名称
     */
    private String townName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;
}

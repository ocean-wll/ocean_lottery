package pers.ocean.lottery.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 响应code码
 * @Author ocean_wll
 * @Date 2021/8/26 5:26 下午
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS("0000", "成功"),
    UN_ERROR("0001", "未知失败"),
    ILLEGAL_PARAMETER("0002", "非法参数"),
    INDEX_DUP("0003", "主键冲突");

    private String code;
    private String info;

}

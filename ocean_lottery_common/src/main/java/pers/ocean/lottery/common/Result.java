package pers.ocean.lottery.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import pers.ocean.lottery.common.Constants.ResponseCode;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 5:30 下午
 */
@AllArgsConstructor
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -2001713649756741559L;

    private String code;
    private String info;

    public static Result buildResult(String code, String info) {
        return new Result(code, info);
    }

    public static Result buildSuccessResult() {
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildErrorResult() {
        return new Result(ResponseCode.UN_ERROR.getCode(), ResponseCode.UN_ERROR.getInfo());
    }
}

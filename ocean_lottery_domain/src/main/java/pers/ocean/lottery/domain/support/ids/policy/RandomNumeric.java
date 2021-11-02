package pers.ocean.lottery.domain.support.ids.policy;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import pers.ocean.lottery.domain.support.ids.IIdGenerator;

/**
 * @Description 工具类生成随机数字 org.apache.commons.lang3.RandomStringUtils
 * @Author ocean_wll
 * @Date 2021/11/2 4:21 下午
 */
@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}

package pers.ocean.lottery.domain.support.ids.policy;

import javax.annotation.PostConstruct;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import org.springframework.stereotype.Component;
import pers.ocean.lottery.domain.support.ids.IIdGenerator;

/**
 * @description: hutool 工具包下的雪花算法，15位雪花算法推荐：https://github.com/yitter/idgenerator/blob/master/Java/source/src/main
 * /java/com/github/yitter/core/SnowWorkerM1.java
 * @Author ocean_wll
 * @Date 2021/11/2 4:24 下午
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        // 0 ~ 31 位，可以采用配置的方式使用
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;

        long dataCenterId = 1L;
        snowflake = new Snowflake(workerId, dataCenterId);
    }

    @Override
    public long nextId() {
        return snowflake.nextId();
    }
}

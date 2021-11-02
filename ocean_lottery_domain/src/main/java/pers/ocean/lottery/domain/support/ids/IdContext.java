package pers.ocean.lottery.domain.support.ids;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Constants.Ids;
import pers.ocean.lottery.domain.support.ids.policy.RandomNumeric;
import pers.ocean.lottery.domain.support.ids.policy.ShortCode;
import pers.ocean.lottery.domain.support.ids.policy.SnowFlake;

/**
 * @Description Id 策略模式上下文配置「在正式的完整的系统架构中，ID 的生成会有单独的服务来完成，其他服务来调用 ID 生成接口即可」
 * @Author ocean_wll
 * @Date 2021/11/2 4:35 下午
 */
@Configuration
public class IdContext {

    /**
     * 创建 ID 生成策略对象，属于策略设计模式的使用方式
     *
     * @param snowFlake     雪花算法，长码，大量
     * @param shortCode     日期算法，短码，少量，全局唯一需要自己保证
     * @param randomNumeric 随机算法，短码，大量，全局唯一需要自己保证
     * @return IIdGenerator 实现类
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode,
        RandomNumeric randomNumeric) {
        Map<Constants.Ids, IIdGenerator> idGeneratorMap = new HashMap<>(8);
        idGeneratorMap.put(Ids.SNOW_FLAKE, snowFlake);
        idGeneratorMap.put(Ids.SHORT_CODE, shortCode);
        idGeneratorMap.put(Ids.RANDOM_NUMERIC, randomNumeric);
        return idGeneratorMap;
    }
}

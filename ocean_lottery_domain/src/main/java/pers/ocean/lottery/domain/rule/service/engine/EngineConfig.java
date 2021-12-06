package pers.ocean.lottery.domain.rule.service.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import pers.ocean.lottery.domain.rule.service.logic.LogicFilter;
import pers.ocean.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import pers.ocean.lottery.domain.rule.service.logic.impl.UserGenderFilter;

/**
 * @Description 规则配置
 * @Author ocean_wll
 * @Date 2021/12/6 11:30 上午
 */
public class EngineConfig {

    protected static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Autowired
    private UserAgeFilter userAgeFilter;

    @Autowired
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init() {
        logicFilterMap.put("userAge", userAgeFilter);
        logicFilterMap.put("userGender", userGenderFilter);
    }
}

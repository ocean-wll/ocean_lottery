package pers.ocean.lottery.test;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ocean.lottery.domain.rule.module.req.DecisionMatterReq;
import pers.ocean.lottery.domain.rule.module.res.EngineResult;
import pers.ocean.lottery.domain.rule.service.engine.EngineFilter;

/**
 * @Description 规则引擎测试
 * @Author ocean_wll
 * @Date 2021/12/6 4:47 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RuleTest {

    @Autowired
    private EngineFilter engineFilter;

    @Test
    public void testProcess() {
        DecisionMatterReq req = new DecisionMatterReq();
        req.setTreeId(2110081902L);
        req.setUserId("ocean_wll");
        req.setValMap(new HashMap<String, Object>() {{
            put("age", "25");
            put("gender", "man");
        }});

        EngineResult res = engineFilter.process(req);
        log.info("请求参数：{}", JSON.toJSONString(req));
        log.info("测试结果：{}", JSON.toJSONString(res));
    }
}

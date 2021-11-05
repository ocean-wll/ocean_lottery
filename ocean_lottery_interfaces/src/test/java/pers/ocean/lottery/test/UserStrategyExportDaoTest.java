package pers.ocean.lottery.test;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ocean.lottery.common.Constants;
import pers.ocean.lottery.common.Constants.Ids;
import pers.ocean.lottery.domain.support.ids.IIdGenerator;
import pers.ocean.lottery.infrastructure.dao.IUserStrategyExportDao;
import pers.ocean.lottery.infrastructure.po.UserStrategyExport;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/5 11:32 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserStrategyExportDaoTest {

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Resource
    private Map<Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_insert() {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setUserId("Uhdgkw766120d");
        userStrategyExport.setActivityId(idGeneratorMap.get(Ids.SHORT_CODE).nextId());
        userStrategyExport.setOrderId(idGeneratorMap.get(Ids.SNOW_FLAKE).nextId());
        userStrategyExport.setStrategyId(idGeneratorMap.get(Ids.RANDOM_NUMERIC).nextId());
        userStrategyExport.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        userStrategyExport.setGrantType(1);
        userStrategyExport.setGrantDate(new Date());
        userStrategyExport.setGrantState(1);
        userStrategyExport.setAwardId("1");
        userStrategyExport.setAwardType(Constants.AwardType.DESC.getCode());
        userStrategyExport.setAwardName("IMac");
        userStrategyExport.setAwardContent("奖品描述");
        userStrategyExport.setUuid(String.valueOf(userStrategyExport.getOrderId()));

        userStrategyExportDao.insert(userStrategyExport);
    }

    @Test
    public void test_select() {
        UserStrategyExport userStrategyExport = userStrategyExportDao.queryUserStrategyExportByUId("Uhdgkw766120d");
        log.info("测试结果：{}", JSON.toJSONString(userStrategyExport));
    }


}

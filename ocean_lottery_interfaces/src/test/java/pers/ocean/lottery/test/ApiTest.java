package pers.ocean.lottery.test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ocean.lottery.infrastructure.dao.IActivityDao;
import pers.ocean.lottery.infrastructure.po.Activity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IActivityDao activityDao;

    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100002L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("ocean");
        activityDao.insert(activity);
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(activity));
    }

    @Test
    public void test_DrawStrategy() {

        List<Map<String, String>> strategyList = new ArrayList<>();

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "一等奖：彩电");
            put("awardId", "10001");
            put("awardCount", "3");
            put("awardRate", "20");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "二等奖：冰箱");
            put("awardId", "10002");
            put("awardCount", "5");
            put("awardRate", "30");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "三等奖：洗衣机");
            put("awardId", "10003");
            put("awardCount", "10");
            put("awardRate", "50");
        }});

        DrawStrategy drawStrategy = new DrawStrategy();
        drawStrategy.initRateTuple(strategyList);

        for (int i = 0; i < 20; i++) {
            System.out.println("中奖结果：" + drawStrategy.randomDraw());
        }

    }

}

class DrawStrategy {

    // 黄金分割点：(√5 - 1) / 2 = 0.6180339887     1.618:1 == 1:0.618，Math.pow(2, 32) * 0.6180339887 = 0x61c88647
    private final int HASH_INCREMENT = 0x61c88647;

    // 用于保存0-100，斐波那契散列索引的结果
    private String[] rateTuple = new String[128];

    /**
     *
     * 初始化概率索引数组
     * 不同奖项概率 0.20、0.30、0.50，调整为三个奖项的范围值；
     * 一等奖：0-20
     * 二等奖：21-30
     * 三等奖：51-100
     *
     * 再把各个区间范围填充到数组中，索引位置和对应的奖品值
     * @param drawConfig
     */
    public void initRateTuple(List<Map<String, String>> drawConfig) {
        int cursorVal = 0;
        for (Map<String, String> drawMap : drawConfig) {
            int rateVal = Integer.parseInt(drawMap.get("awardRate"));

            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {
                // 计算数组索引并填充数据
                int hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
                int idx = hashCode & (rateTuple.length - 1);
                rateTuple[idx] = drawMap.get("awardDesc");
            }

            cursorVal += rateVal;

        }
    }

    /**
     * 随机抽奖
     * @return 中奖结果
     */
    public String randomDraw() {
        // 随机数
        int rate = new SecureRandom().nextInt(100) + 1;
        // 索引位置
        int hashCode = rate * HASH_INCREMENT + HASH_INCREMENT;
        int idx = hashCode & (rateTuple.length - 1);
        return rateTuple[idx];
    }

}

package pers.ocean.lottery.test;

import java.util.Date;

import javax.annotation.Resource;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ocean.lottery.infrastructure.dao.IUserTakeActivityDao;
import pers.ocean.lottery.infrastructure.po.UserTakeActivity;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/5 10:20 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTakeActivityDaoTest {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUserId("Ukdli109op811d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(121019889411L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid(RandomUtil.randomString(32));

        userTakeActivityDao.insert(userTakeActivity);
    }

}

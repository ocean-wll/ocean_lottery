package pers.ocean.lottery.test;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/11/2 8:29 下午
 */
public class SimpleTest {

    @Test
    public void test1() {
        long startTime = System.currentTimeMillis();
        double num;
        for (int i = 0; i < 1000000000; i++) {
            num = Math.random();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
    }
}

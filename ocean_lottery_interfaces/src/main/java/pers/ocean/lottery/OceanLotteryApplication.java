package pers.ocean.lottery;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:40 下午
 */
@SpringBootApplication
@Configurable
@EnableDubbo
@MapperScan(basePackages = {"pers.ocean.lottery.infrastructure.dao"})
public class OceanLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanLotteryApplication.class, args);
    }
}

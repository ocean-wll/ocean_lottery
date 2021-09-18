package pers.ocean.lottery.domain.strategy.service.algorithm;

import java.util.List;

import pers.ocean.lottery.domain.strategy.model.vo.AwardRateInfo;

/**
 * @Description 抽奖算法接口
 * @Author ocean_wll
 * @Date 2021/9/18 4:16 下午
 */
public interface IDrawAlgorithm {

    /**
     * 程序启动的时候初始化概率元组，在初始化完成后使用过程中不允许修改元组数据
     *
     * 元组数据作用在于将百分比内(0.2、0.3、0.5)的数据，转换成一整条数组上分区数据，如下：
     * 0.2 = 0 ~ 0.2
     * 0.3 = 0 + 0.2 ~ 0.2 + 0.3  = 0.2 ~ 0.5
     * 0.5 = 0.5 ~ 1
     *
     * 通过数据拆分为整条后，再根据0-100中各个区间的奖品信息，使用斐波那契散列计算出索引位置，把奖品数据存放到元组中。例如：
     * 1. 把 0.2 转换为 20
     * 2. 20 对应的斐波那契值哈希值：（20 * HASH_INCREMENT + HASH_INCREMENT）= -1549107828 HASH_INCREMENT = 0x61c88647
     * 3. 再通过哈希值计算索引位置：hashCode & (rateTuple.length - 1) = 12
     * 4. 那么tup[12] = 0.2 中奖概率对应的奖品
     * 5. 当后续通过随机数获取到1-100的值后，可以直接定位到对应的奖品信息，通过这样的方式把轮训算奖的时间复杂度从O(n) 降低到 0(1)
     *
     * @param strategyId        策略id
     * @param awardRateInfoList 奖品概率配置集合
     */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    /**
     * 判断是否已经做了数据初始化
     *
     * @param strategyId 策略id
     * @return true已经初始化，false尚未初始化
     */
    boolean isExistRateTuple(Long strategyId);

    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId      策略id
     * @param excludeAwardIds 排除掉已经不能作为抽奖的奖品ID，留给风控和空库存使用
     * @return 中奖结果
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}

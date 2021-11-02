package pers.ocean.lottery.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.Award;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/9/22 3:10 下午
 */
@Mapper
public interface IAwardDao {

    /**
     * 查询奖品信息
     *
     * @param awardId 奖品id
     * @return Award对象
     */
    Award queryAwardInfo(String awardId);

    /**
     * 插入奖品配置
     *
     * @param list 奖品配置
     */
    void insertList(List<Award> list);
}

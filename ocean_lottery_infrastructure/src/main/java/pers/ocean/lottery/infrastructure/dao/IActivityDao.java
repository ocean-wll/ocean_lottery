package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.Activity;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:54 下午
 */
@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long activityId);
}

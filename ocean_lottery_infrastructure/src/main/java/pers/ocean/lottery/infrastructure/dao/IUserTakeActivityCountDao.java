package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.ocean.lottery.infrastructure.po.UserTakeActivityCount;

/**
 * @Description 用户参加活动次数表
 * @Author ocean_wll
 * @Date 2021/11/8 10:42 上午
 */
@Mapper
public interface IUserTakeActivityCountDao {

    /**
     * 根据用户id及活动id查询用户参加活动次数
     *
     * @param userId     用户Id
     * @param activityId 活动Id
     * @return UserTakeActivityCount对象
     */
    UserTakeActivityCount queryByUserIdAndActivityId(@Param("userId") String userId,
        @Param("activityId") Long activityId);

    /**
     * 插入领取次数信息
     *
     * @param userTakeActivityCount 请求入参
     */
    void insert(UserTakeActivityCount userTakeActivityCount);

    /**
     * 更新领取次数信息
     *
     * @param userTakeActivityCount 请求入参
     * @return 更新数量
     */
    Integer updateLeftCount(UserTakeActivityCount userTakeActivityCount);

}

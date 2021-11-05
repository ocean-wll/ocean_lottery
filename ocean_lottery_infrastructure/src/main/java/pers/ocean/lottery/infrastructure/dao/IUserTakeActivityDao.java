package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.UserTakeActivity;
import pers.ocean.middleware.db.router.annotation.DBRouter;

/**
 * @Description 用户领取活动表DAO
 * @Author ocean_wll
 * @Date 2021/11/5 9:46 上午
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动表
     *
     * @param userTakeActivity 用户领取活动实体对象
     */
    @DBRouter(key = "userId")
    void insert(UserTakeActivity userTakeActivity);
}

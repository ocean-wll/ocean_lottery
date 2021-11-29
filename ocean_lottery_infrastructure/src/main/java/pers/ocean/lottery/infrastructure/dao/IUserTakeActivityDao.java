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

    /**
     * 查询是否存在未执行抽奖领取活动单【user_take_activity 存在 state = 0，领取了但抽奖过程失败的，可以直接返回领取结果继续抽奖】
     * 查询此活动ID，用户最早领取但未消费的一条记录【这部分一般会有业务流程限制，比如是否处理最先还是最新领取单，要根据自己的业务实际场景进行处理】
     *
     * @param userTakeActivity 请求入参
     * @return                 领取结果
     */
    @DBRouter
    UserTakeActivity queryNoConsumedTakeActivityOrder(UserTakeActivity userTakeActivity);
}

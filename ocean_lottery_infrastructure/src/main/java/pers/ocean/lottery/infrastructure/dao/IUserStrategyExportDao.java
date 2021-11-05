package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.UserStrategyExport;
import pers.ocean.middleware.db.router.annotation.DBRouter;
import pers.ocean.middleware.db.router.annotation.DBRouterStrategy;

/**
 * @Description 用户策略计算结果表
 * @Author ocean_wll
 * @Date 2021/11/5 10:52 上午
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    /**
     * 新增数据
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "userId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}

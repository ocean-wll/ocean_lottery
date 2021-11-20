package pers.ocean.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ocean.lottery.infrastructure.po.Activity;
import pers.ocean.lottery.infrastructure.vo.AlterStateVO;

/**
 * @Description
 * @Author ocean_wll
 * @Date 2021/8/26 6:54 下午
 */
@Mapper
public interface IActivityDao {

    /**
     * 插入数据
     *
     * @param req 入参
     */
    void insert(Activity req);

    /**
     * 根据活动号查询活动信息
     *
     * @param activityId 活动号
     * @return 活动信息
     */
    Activity queryActivityById(Long activityId);

    /**
     * 变更活动状态
     *
     * @param alterStateVO [activityId、beforeState、afterState]
     * @return 更新数量
     */
    int alterState(AlterStateVO alterStateVO);

    /**
     * 扣减活动库存
     *
     * @param activityId 活动Id
     * @return 更新数量
     */
    Integer subtractionActivityStock(Long activityId);
}

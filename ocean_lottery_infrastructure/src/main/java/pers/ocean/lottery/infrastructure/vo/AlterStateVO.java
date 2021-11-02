package pers.ocean.lottery.infrastructure.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 活动变更状态对象
 * @Author ocean_wll
 * @Date 2021/11/2 3:36 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlterStateVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 更新前状态
     */
    private Integer beforeState;

    /**
     * 更新后状态
     */
    private Integer afterState;
}

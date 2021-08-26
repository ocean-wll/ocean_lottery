# lottery
抽奖系统


```sql
create schema lottery;
create table activity
(
    id bigint auto_increment comment '自增ID' primary key,
    activityId bigint null comment '活动ID',
    beginDateTime datetime not null comment '开始时间',
    endDateTime datetime not null comment '结束时间',
    stockCount int not null comment '库存',
    takeCount int null comment '每人可参与次数',
    state int null comment '活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启',
    creator varchar(64) not null comment '创建人',
    activityName varchar(64) not null comment '活动名称',
    activityDesc varchar(128) null comment '活动描述',
    createTime datetime not null comment '创建时间',
    updateTime datetime not null comment '修改时间'
);

insert into activity(activityId,beginDateTime,endDateTime,stockCount,takeCount,state,creator,activityName,
                     activityDesc,createTime,updateTime)
                     values (100001,now(),now(),1000,10,0,"ocean_wll","ocean抽奖活动","这是ocean的抽奖活动",now(),now());

create unique index activity_id_uindex
    on activity (id);
```
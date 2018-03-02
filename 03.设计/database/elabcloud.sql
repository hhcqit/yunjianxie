/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/12/21 10:34:20                          */
/*==============================================================*/


drop table if exists attachment;

drop table if exists equipment;

drop table if exists equipment_examine;

drop table if exists equipment_examine_item;

drop table if exists message_notify_option;

drop table if exists notification;

drop table if exists org;

drop table if exists org_option;

drop table if exists org_relation;

drop table if exists plan;

drop table if exists smsCode;

drop table if exists smsSend;

drop table if exists task;

drop table if exists task_comment;

drop table if exists task_modify;

drop table if exists task_repair;

drop table if exists task_supplement;

drop table if exists user;

drop table if exists wechat_user;

drop table if exists work;

/*==============================================================*/
/* Table: attachment                                            */
/*==============================================================*/
create table attachment
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   mediaId              varchar(256) not null comment '微信端文件ID',
   name                 varchar(256) not null comment '名称',
   type                 int not null default 0 comment '类型
            0、未定义
            1、图片
            2、语音
            3、文件',
   size                 int not null default 0 comment '大小，单位字节',
   status               int not null default 0 comment '当前状态
            0、未启用
            1、启用',
   orgId                bigint(20) not null comment '归属组织',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) not null comment '更新用户',
   updateTime           datetime not null comment '更新时间',
   path                 varchar(256) not null comment '附件路径',
   url                  varchar(256) not null comment '附件地址',
   width                int default 0 comment '图片宽度',
   height               int default 0 comment '图片高度',
   duration             int default 0 comment '语音时长',
   remark               varchar(128) comment '备注',
   reserved             varchar(128) comment '预留字段',
   tableName            varchar(64) comment '关联表名，允许为空',
   tableId              varchar(64) comment '关联表主键ID',
   primary key (id)
);

alter table attachment comment '附件表';

/*==============================================================*/
/* Table: equipment                                             */
/*==============================================================*/
create table equipment
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   orgId                bigint(20) not null comment '归属组织',
   relatedOrgId         bigint(20) comment '关联组织',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) not null comment '更新用户',
   code                 varchar(128) not null comment '设备编号',
   name                 varchar(128) not null comment '设备名称',
   status               int not null default 0 comment '状态
            0、未启用
            1、启用',
   checkPermission      int not null default 0 comment '检定权限
            0、无限制
            1、实验室
            2、服务商',
   checkPeriod          int not null default 0 comment '检定周期，单位天',
   area                 varchar(128) comment '设备所在区域',
   address              varchar(128) comment '设备所在详细地址',
   place                varchar(128) comment '设备安装位置',
   model                varchar(128) comment '型号',
   category             varchar(128) comment '设备类型',
   supplier             varchar(128) comment '供应商',
   supplierContact      varchar(128) comment '供应商联系人',
   supplierTelephone    varchar(128) comment '供应商联系人',
   manufacturer         varchar(128) comment '制造商',
   manufacturerContact  varchar(128) comment '制造商联系人',
   manufacturerTelephone varchar(128) comment '制造商联系人',
   madeArea             varchar(128) comment '产地',
   madeTime             date comment '出厂日期',
   batchNo              varchar(128) comment '批次编号',
   madeNo               varchar(128) comment '出厂编号',
   barcode              varchar(128) comment '设备条码',
   usedDept             varchar(128) comment '使用部门',
   owner                varchar(128) comment '责任人',
   barcodeImg           varchar(256) comment '条码图片',
   img                  varchar(256) comment '设备图片',
   purchasedTime        date comment '购买日期',
   usedTime             date comment '投用日期',
   updateTime           datetime not null comment '更新时间',
   remark               varchar(128) comment '备注',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table equipment comment '设备表';

/*==============================================================*/
/* Table: equipment_examine                                     */
/*==============================================================*/
create table equipment_examine
(
   id                   bigint(20) not null auto_increment comment '用户主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   equipId              bigint(20) not null comment '设备主键',
   orgId                bigint(20) not null comment '归属组织',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) comment '更新用户',
   updateTime           datetime comment '更新时间',
   examineTime          datetime comment '验收时间',
   reference            varchar(512) comment '验收依据',
   conclusion           varchar(512) comment '验收结论',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table equipment_examine comment '设备验收记录表';

/*==============================================================*/
/* Table: equipment_examine_item                                */
/*==============================================================*/
create table equipment_examine_item
(
   id                   bigint(20) not null auto_increment comment '用户主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   examineId            bigint(20) not null comment '验收主键',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) comment '更新用户',
   updateTime           datetime comment '更新时间',
   name                 varchar(128) comment '项目名称',
   unit                 varchar(128) comment '计量单位',
   standardValue        varchar(128) comment '标准值',
   measureValue         varchar(128) comment '测量值',
   deviationValue       varchar(128) comment '误差值',
   isQualified          int comment '是否合格
            0、不合格
            1、合格',
   remark               varchar(512) comment '备注',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table equipment_examine_item comment '设备验收项目记录表';

/*==============================================================*/
/* Table: message_notify_option                                 */
/*==============================================================*/
create table message_notify_option
(
   id                   bigint(20) not null auto_increment comment '用户主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   userId               bigint(20) not null comment '用户主键',
   wechatNotify         int not null comment '微信消息通知
            0、关闭
            1、打开',
   taskNotify           int not null comment '消息通知总开关
            0、关闭
            1、打开',
   repairedTaskNotify   int not null comment '修好消息通知
            0、关闭
            1、打开',
   patchTaskNotify      int not null comment '补充记录消息通知
            0、关闭
            1、打开',
   newTaskNotify        int not null comment '新报修消息通知
            0、关闭
            1、打开',
   updateTime           datetime comment '更新时间',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table message_notify_option comment '用户消息通知配置表';

/*==============================================================*/
/* Table: notification                                          */
/*==============================================================*/
create table notification
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   orgId                bigint(20) not null comment '归属组织',
   createUser           bigint(20) not null comment '创建用户',
   title                varchar(128) not null comment '标题',
   content              varchar(500) not null comment '标题',
   img1                 varchar(256) comment '图片',
   img2                 varchar(256) comment '图片',
   img3                 varchar(256) comment '图片',
   type                 int not null comment '通告类型
            0、所有人
            1、报修人
            2、检修团队',
   updateTime           datetime comment '更新时间',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table notification comment '通告表';

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   name                 varchar(128) not null comment '公司名称',
   owner                bigint(20) not null comment '所有人',
   type                 int not null comment '类型
            1、实验室
            2、服务商
            ',
   contact              varchar(30) comment '联系人',
   telephone            varchar(30) comment '联系电话',
   email                varchar(128) comment '邮箱',
   postcode             varchar(10) comment '所在区域',
   area                 varchar(128) comment '所在区域',
   address              varchar(128) comment '详细地址',
   updateTime           datetime comment '更新时间',
   qrcodeImg            varchar(256) comment '邀请二维码图片',
   reserved             varchar(128) comment '预留字段',
   remark               varchar(128) comment '备注',
   primary key (id)
);

alter table org comment '组织结构表';

/*==============================================================*/
/* Table: org_option                                            */
/*==============================================================*/
create table org_option
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   orgId                bigint(20) not null comment '归属组织',
   equipId              int not null default 0 comment '设备编号
            0、不需要
            1、需要但可以不填
            2、必须填写',
   equipQrcode          int not null default 0 comment '设备二维码
            0、关闭
            1、打开',
   repairUser           int not null default 0 comment '报修人姓名
            0、关闭
            1、打开',
   repairDept           int not null default 0 comment '报修人部门
            0、关闭
            1、打开',
   repairMobile         int not null default 0 comment '报修人电话
            0、关闭
            1、打开',
   repairUrgent         int not null default 0 comment '报修加急
            0、关闭
            1、打开',
   repairModify         int not null default 0 comment '报修内容修改
            0、关闭
            1、打开',
   repairModifyExpiry   int not null default 0 comment '报修内容修改期限
            0、无限制
            1、1小时
            3、3小时
            6、6小时
            12、12小时',
   repairedRemainExpiry int not null default 0 comment '已修好保留期限
            0、无限制
            1、1天
            3、3天
            5、5天
            7、7天
            10、10天',
   repairedConfirm      int not null default 0 comment '已修好确认
            0、未开启
            1、开启',
   acceptedSendBack     int not null default 0 comment '受理后退回
            0、未开启
            1、开启',
   updateTime           datetime comment '更新时间',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table org_option comment '平台功能设置表';

/*==============================================================*/
/* Table: org_relation                                          */
/*==============================================================*/
create table org_relation
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   orgId                bigint(20) not null comment '归属组织',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) not null comment '更新用户',
   labId                bigint(20) not null comment '实验室主键',
   providerId           bigint(20) not null comment '服务商主键',
   updateTime           datetime not null comment '更新时间',
   remark               varchar(128) comment '备注',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table org_relation comment '组织关系表';

/*==============================================================*/
/* Table: plan                                                  */
/*==============================================================*/
create table plan
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   name                 varchar(128) not null comment '名称',
   type                 int not null default 0 comment '类型
            1、保养计划
            2、检定计划',
   periodType           int not null default 0 comment '周期类型
            0、自定义
            1、每日
            2、每周
            3、每月
            4、每3月
            5、每半年
            6、每年',
   period               int not null default 0 comment '周期
            自定义时使用，单位天',
   warnDay              int not null default 0 comment '预警时间
            自定义时使用，单位天',
   executePermission    int not null default 0 comment '执行权限
            0、不限
            1、内部
            2、外部',
   status               int not null default 0 comment '当前状态
            0、未启用
            1、启用',
   equipId              bigint(20) not null comment '设备主键',
   orgId                bigint(20) not null comment '归属组织',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) not null comment '更新用户',
   content              varchar(512) not null comment '计划内容',
   executeCount         int not null default 0 comment '已执行次数',
   startTime            datetime not null comment '开始时间',
   latestExecuteTime    datetime not null default CURRENT_TIMESTAMP comment '最近执行时间',
   updateTime           datetime not null comment '更新时间',
   remark               varchar(128) comment '备注',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table plan comment '计划表';

/*==============================================================*/
/* Table: smsCode                                               */
/*==============================================================*/
create table smsCode
(
   id                   bigint(20) not null auto_increment,
   createTime           datetime not null default CURRENT_TIMESTAMP,
   deleteFlag           int not null,
   mobile               varchar(11) not null,
   code                 varchar(6) not null,
   type                 int(11) not null comment '1、注册
            2、找回密码
            3、动态密码',
   expiresTime          datetime not null,
   usedStatus           bit(1) not null,
   primary key (id),
   unique key id (id)
)
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

alter table smsCode comment '短信验证码表';

/*==============================================================*/
/* Table: smsSend                                               */
/*==============================================================*/
create table smsSend
(
   id                   bigint(20) not null auto_increment,
   addTime              datetime not null default CURRENT_TIMESTAMP,
   deleteStatus         bit(1) not null,
   mobile               varchar(1024) not null comment '手机号码，多个号码用户英文逗号（,）分隔',
   content              varchar(1024) not null,
   type                 int(11) not null comment '0、其他/未分类
            1、注册
            2、找回密码
            3、动态密码
            9、系统通知',
   relateId             varchar(48) comment '关联id，如：用户ID、订单ID等',
   sid                  varchar(20) comment '短信接口测ID',
   send                 int comment '发送条数',
   response             varchar(255) comment '短信接口响应消息',
   primary key (id),
   unique key id (id)
)
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

alter table smsSend comment '短信发送表';

/*==============================================================*/
/* Table: task                                                  */
/*==============================================================*/
create table task
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   status               int not null default 0 comment '当前状态
            10、待受理
            11、报修人撤销
            12、维修人删除
            20、待维修
            21、报修人撤销
            22、维修人删除
            23、被拒绝
            30、待确认
            40、已完成
            50、已关闭',
   commentStatus        int not null default 0 comment '评论状态
            0、未评论
            1、已评论',
   orgId                bigint(20) not null comment '归属组织',
   labId                bigint(20) not null comment '实验室ID',
   providerId           bigint(20) not null comment '服务商ID',
   createUser           bigint(20) not null comment '创建用户',
   repairerUser         bigint(20) not null comment '维修用户',
   examinerUser         bigint(20) not null comment '检验用户',
   updateUser           bigint(20) not null comment '更新用户',
   equipId              bigint(20) not null comment '设备主键',
   description          varchar(512) not null comment '报修描述',
   canceledReason       varchar(512) comment '取消原因',
   examineCalibrate     varchar(512) comment '检定情况',
   examineQc            varchar(512) comment '质控情况',
   examineSample        varchar(512) comment '留样情况',
   examineDescription   varchar(512) comment '验收说明',
   malfunctionDuration  int comment '故障时长，单位小时',
   acceptTime           datetime comment '受理时间',
   repairedTime         datetime comment '修复时间',
   examineTime          datetime comment '检验时间',
   finishedTime         datetime comment '完成时间',
   updateTime           datetime not null comment '更新时间',
   remark               varchar(128) comment '备注',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table task comment '报修任务表';

/*==============================================================*/
/* Table: task_comment                                          */
/*==============================================================*/
create table task_comment
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   taskId               bigint(20) not null comment '任务主键',
   createUser           bigint(20) not null comment '创建用户',
   service              int not null default 0 comment '服务态度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分',
   technology           int not null default 0 comment '技术能力
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分',
   response             int not null default 0 comment '响应速度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分',
   description          varchar(512) not null comment '描述',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table task_comment comment '报修评价表';

/*==============================================================*/
/* Table: task_modify                                           */
/*==============================================================*/
create table task_modify
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   taskId               bigint(20) not null comment '任务主键',
   createUser           bigint(20) not null comment '创建用户',
   equipId              bigint(20) comment '设备主键',
   equipCode            varchar(128) comment '设备编号',
   equipName            varchar(128) not null comment '设备名称',
   address              varchar(128) not null comment '地点',
   description          varchar(512) not null comment '描述',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table task_modify comment '任务修改记录表';

/*==============================================================*/
/* Table: task_repair                                           */
/*==============================================================*/
create table task_repair
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   taskId               bigint(20) not null comment '任务主键',
   createUser           bigint(20) not null comment '创建用户',
   description          varchar(512) not null comment '描述',
   acceptTime           datetime not null comment '受理时间',
   finishedTime         datetime not null comment '完成时间',
   visibleStatus        int not null default 0 comment '是否可见状态
            0、否
            1、是',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table task_repair comment '任务维修记录表';

/*==============================================================*/
/* Table: task_supplement                                       */
/*==============================================================*/
create table task_supplement
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   taskId               bigint(20) not null comment '任务主键',
   createUser           bigint(20) not null comment '创建用户',
   description          varchar(512) not null comment '描述',
   visibleStatus        int not null default 0 comment '是否可见状态
            0、否
            1、是',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table task_supplement comment '任务维修补充表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   orgId                bigint(20) not null comment '归属组织',
   dept                 varchar(128) comment '归属部门',
   userName             varchar(32) not null comment '用户名',
   password             varchar(32) not null comment '密码',
   realName             varchar(20) comment '真实姓名',
   userType             int not null comment '用户类型
            0、系统管理员
            1、平台管理员，一个平台只有一个
            2、业务管理员，一个平台可以有多个
            3、普通用户
            ',
   email                varchar(128) comment '电子邮箱',
   blacklistFlag        int not null default 0 comment '黑名单标记
            0、否
            1、是',
   updateTime           datetime comment '更新时间',
   headImgUrl           varchar(128) comment '头像图片地址',
   reserved             varchar(128) comment '预留字段',
   remark               varchar(128) comment '备注',
   primary key (id)
);

alter table user comment '用户表';

/*==============================================================*/
/* Table: wechat_user                                           */
/*==============================================================*/
create table wechat_user
(
   id                   bigint(20) not null auto_increment,
   createTime           datetime not null default CURRENT_TIMESTAMP,
   deleteStatus         int not null comment '删除状态
            0、未删除
            1、已删除',
   openId               varchar(128) not null comment '用户的唯一标识',
   orgId                bigint(20) comment '公司主键',
   userId               bigint(20) comment '用户主键',
   unionId              varchar(128) comment '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
   nickname             varchar(32) comment '用户昵称',
   sex                  int comment '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
   country              varchar(16) comment '国家，如中国为CN',
   province             varchar(32) comment '用户个人资料填写的省份',
   city                 varchar(32) comment '普通用户个人资料填写的城市',
   headImgUrl           varchar(128) comment '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
   privilege            varchar(128) comment '用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
   subscribeStatus      int comment '关注状态
            0：未关注
            1：已关注',
   updateTime           datetime comment '更新时间',
   primary key (id),
   unique key id (id)
)
ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

alter table wechat_user comment '微信用户表';

/*==============================================================*/
/* Table: work                                                  */
/*==============================================================*/
create table work
(
   id                   bigint(20) not null auto_increment comment '主键',
   createTime           datetime not null comment '创建时间',
   deleteStatus         int not null default 0 comment '删除状态
            0、未删除
            1、已删除',
   planId               bigint(20) not null comment '计划主键',
   periodType           int not null default 0 comment '周期类型
            0、自定义
            1、每日
            2、每周
            3、每月
            4、每3月
            5、每半年
            6、每年',
   period               int not null default 0 comment '周期
            自定义时使用，单位天',
   executePermission    int not null default 0 comment '执行权限
            0、不限
            1、内部
            2、外部',
   origin               int not null default 0 comment '来源
            1、计划生成
            2、手工生成',
   type                 int not null default 0 comment '类型
            1、保养计划
            2、检定计划',
   orgId                bigint(20) not null comment '归属组织',
   labId                bigint(20) not null comment '实验室ID',
   providerId           bigint(20) not null comment '服务商ID',
   status               int not null default 0 comment '当前状态
            0、未开始
            1、执行中
            2、待确认
            3、已完成',
   createUser           bigint(20) not null comment '创建用户',
   updateUser           bigint(20) not null comment '更新用户',
   updateTime           datetime not null comment '更新时间',
   equipId              bigint(20) not null comment '设备主键',
   executeOrgId         bigint(20) comment '执行组织',
   executeUser          bigint(20) comment '执行用户',
   certificateNo        varchar(128) comment '证书编号',
   certificateFileName  varchar(128) comment '证书文件',
   certificateFilePath  varchar(128) comment '证书文件',
   name                 varchar(128) comment '名称',
   content              varchar(512) comment '描述，可以是保养内容也可以是检定内容',
   result               varchar(512) comment '执行结果，可以是保养说明也可以是检定结论',
   acceptTime           datetime comment '接收时间',
   executeTime          datetime comment '执行时间',
   finishedTime         datetime comment '完成时间',
   remark               varchar(128) comment '备注',
   reserved             varchar(128) comment '预留字段',
   primary key (id)
);

alter table work comment '作业表';


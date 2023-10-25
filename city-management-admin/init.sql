-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL COMMENT '主键',
                        `username` varchar(32) NOT NULL COMMENT '用户名',
                        `password` varchar(64) NOT NULL COMMENT '密码',
                        `auth` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0:无权限，1:有权限',
                        `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 0:禁用，1:启用',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        `create_user` bigint(20) NOT NULL COMMENT '创建人',
                        `update_user` bigint(20) NOT NULL COMMENT '修改人',
                        PRIMARY KEY (`id`) USING BTREE,
                        UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
                        `id` bigint(20) NOT NULL COMMENT 'posts_id',
                        `post_content` longtext COMMENT 'md5类型正文',
                        `post_title` text COMMENT '标题',
                        `html_content` longtext COMMENT '正文html',
                        `menu_id` bigint(20) NOT NULL COMMENT '分栏id',
                        `image` varchar(200) NOT NULL COMMENT '图片',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        `create_user` bigint(20) NOT NULL COMMENT '创建人',
                        `update_user` bigint(20) NOT NULL COMMENT '修改人',
                        `page_view` int unsigned DEFAULT '0' NULL COMMENT '浏览量',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';


-- ----------------------------
-- Table structure for member
-- ----------------------------

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
                        `id` bigint(20) NOT NULL COMMENT 'member_id',
                        `name` varchar(64) NOT NULL COMMENT '成员名称',
                        `image` varchar(200) NOT NULL COMMENT '成员头像/照片',
                        `intro` longtext COMMENT '成员简介',
                        `home_page` varchar(200) COMMENT '个人主页url',
                        `email` varchar(200) COMMENT '邮箱',
                        `position` varchar(200) COMMENT '职务',
                        `company` varchar(200) COMMENT '任职单位',
                        `menu_id` bigint(20) NOT NULL COMMENT '分栏id',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        `create_user` bigint(20) NOT NULL COMMENT '创建人',
                        `update_user` bigint(20) NOT NULL COMMENT '修改人',
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成员';






-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
                        `id` bigint(20) NOT NULL COMMENT '主键',
                        `name` varchar(64) NOT NULL COMMENT '栏目名称',
                        `father_menu` bigint(20) NOT NULL COMMENT '父栏目id 0 代表无父栏目',
                        `has_son` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0:无子栏目，1:有子栏目',
                        `member_flag` int(11) NOT NULL DEFAULT '0' COMMENT '状态 1:该栏目为成员栏目，0:不是成员栏目',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        `create_user` bigint(20) NOT NULL COMMENT '创建人',
                        `update_user` bigint(20) NOT NULL COMMENT '修改人',
                        PRIMARY KEY (`id`) USING BTREE,
                        UNIQUE KEY `idx_category_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目分类';



DROP TABLE IF EXISTS `menu_post`;
CREATE TABLE `menu_post` (
                             `id` bigint(20) NOT NULL COMMENT '主键',
                             `menu_id` bigint(20) NOT NULL COMMENT '栏目id',
                             `post_id` bigint(20) NOT NULL COMMENT '文章id',
                             `name` varchar(64) NOT NULL COMMENT '口味名称',
                             `value` varchar(500) DEFAULT NULL COMMENT '口味数据list',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '更新时间',
                             `create_user` bigint(20) NOT NULL COMMENT '创建人',
                             `update_user` bigint(20) NOT NULL COMMENT '修改人',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目文章关系表';





DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
                           `id` bigint(20) NOT NULL COMMENT '主键',
                           `name` varchar(64) NOT NULL COMMENT '联系人姓名',
                           `email` varchar(64) NOT NULL COMMENT '联系人邮箱',
                           `phone` varchar(64) NOT NULL COMMENT '联系人手机',
                           `content` text COMMENT '联系内容',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联系我们';



INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713216489037795329, '实验室概况', 0, 1, 0, '2023-10-14 23:33:36', '2023-10-14 23:33:36', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217212890828802, '实验室简介', 1713216489037795329, 0, 0, '2023-10-14 23:36:28', '2023-10-14 23:36:28', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217242255151105, '实验室定位', 1713216489037795329, 0, 0, '2023-10-14 23:36:35', '2023-10-14 23:36:35', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217288639959042, '学术委员会', 1713216489037795329, 0, 0, '2023-10-14 23:36:46', '2023-10-14 23:36:46', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217331929370626, '实验室人员', 1713216489037795329, 0, 0, '2023-10-14 23:36:57', '2023-10-14 23:36:57', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217392260239361, '实验室主任', 1713216489037795329, 0, 0, '2023-10-14 23:37:11', '2023-10-14 23:37:11', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217432240345089, '实验室文化', 1713216489037795329, 0, 0, '2023-10-14 23:37:21', '2023-10-14 23:37:21', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217464158998530, '实验室管理', 1713216489037795329, 0, 0, '2023-10-14 23:37:28', '2023-10-14 23:37:28', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217489937190913, '实验室环境', 1713216489037795329, 0, 0, '2023-10-14 23:37:34', '2023-10-14 23:37:34', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217794091339777, '新闻动态', 0, 1, 0, '2023-10-14 23:38:47', '2023-10-14 23:38:47', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217904690941954, '实验室新闻', 1713217794091339777, 0, 0, '2023-10-14 23:39:13', '2023-10-14 23:39:13', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217940480937986, '通知公告', 1713217794091339777, 0, 0, '2023-10-14 23:39:22', '2023-10-14 23:39:22', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217963784491009, '最新论文', 1713217794091339777, 0, 0, '2023-10-14 23:39:27', '2023-10-14 23:39:27', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713217987666857986, '实验室风采', 1713217794091339777, 0, 0, '2023-10-14 23:39:33', '2023-10-14 23:39:33', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714152963463778306, '师资队伍', 0, 1, 0, '2023-10-17 13:34:49', '2023-10-17 13:34:49', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153137288318978, '全职教师', 1714152963463778306, 0, 1, '2023-10-17 13:35:30', '2023-10-17 13:35:30', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153167856406530, '兼职教授', 1714152963463778306, 0, 1, '2023-10-17 13:35:37', '2023-10-17 13:35:37', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153188064563201, '博士后', 1714152963463778306, 0, 1, '2023-10-17 13:35:42', '2023-10-17 13:35:42', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153214106996737, '访问学者', 1714152963463778306, 0, 1, '2023-10-17 13:35:48', '2023-10-17 13:35:48', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153300044091393, '人才培养', 0, 1, 0, '2023-10-17 13:36:09', '2023-10-17 13:36:09', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153453962465282, '课堂教学', 1714153300044091393, 0, 0, '2023-10-17 13:36:46', '2023-10-17 13:36:46', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153477614145538, '科创竞赛', 1714153300044091393, 0, 0, '2023-10-17 13:36:51', '2023-10-17 13:36:51', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153510505877506, '在读博士生', 1714153300044091393, 0, 1, '2023-10-17 13:36:59', '2023-10-17 13:36:59', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153542500028418, '在读硕士生', 1714153300044091393, 0, 1, '2023-10-17 13:37:07', '2023-10-17 13:37:07', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153589853720577, '毕业博士生', 1714153300044091393, 0, 1, '2023-10-17 13:37:18', '2023-10-17 13:37:18', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153616244281345, '毕业硕士生', 1714153300044091393, 0, 1, '2023-10-17 13:37:24', '2023-10-17 13:37:24', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153643964436481, '毕业本科生', 1714153300044091393, 0, 1, '2023-10-17 13:37:31', '2023-10-17 13:37:31', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153746389340161, '科学研究', 0, 1, 0, '2023-10-17 13:37:55', '2023-10-17 13:37:55', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153940392677378, '研究方向', 1714153746389340161, 0, 0, '2023-10-17 13:38:41', '2023-10-17 13:38:41', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153960957349889, '研究小组', 1714153746389340161, 0, 0, '2023-10-17 13:38:46', '2023-10-17 13:38:46', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714153982327328770, '研究成果', 1714153746389340161, 0, 0, '2023-10-17 13:38:51', '2023-10-17 13:38:51', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154010886344706, '科研项目', 1714153746389340161, 0, 0, '2023-10-17 13:38:58', '2023-10-17 13:38:58', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154030616350721, '实验展示', 1714153746389340161, 0, 0, '2023-10-17 13:39:03', '2023-10-17 13:39:03', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154087386255362, '科研平台', 0, 1, 0, '2023-10-17 13:39:17', '2023-10-17 13:39:17', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154232391733250, '气浮式空间模拟系统', 1714154087386255362, 0, 0, '2023-10-17 13:39:51', '2023-10-17 13:39:51', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154267019907074, '超算平台', 1714154087386255362, 0, 0, '2023-10-17 13:39:59', '2023-10-17 13:39:59', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154360951345154, '合作交流', 0, 1, 0, '2023-10-17 13:40:22', '2023-10-17 13:40:22', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154425744953346, '海外合作', 1714154360951345154, 0, 0, '2023-10-17 13:40:37', '2023-10-17 13:40:37', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154447643414529, '国内合作', 1714154360951345154, 0, 0, '2023-10-17 13:40:42', '2023-10-17 13:40:42', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154517335969793, '招生招聘', 0, 1, 0, '2023-10-17 13:40:59', '2023-10-17 13:40:59', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154685099741185, '招生信息', 1714154517335969793, 0, 0, '2023-10-17 13:41:39', '2023-10-17 13:41:39', 1713122010360557569, 1713122010360557569);
INSERT INTO `city`.`menu` (`id`, `name`, `father_menu`, `has_son`, `member_flag`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1714154710575943681, '招聘信息', 1714154517335969793, 0, 0, '2023-10-17 13:41:45', '2023-10-17 13:41:45', 1713122010360557569, 1713122010360557569);



INSERT INTO `contact` (`id`, `name`, `email`, `phone`, `content`, `create_time`) VALUES (1713490529644208129, 'Kepass1ove', 'cnlyuhan@163.com', '13291267856', '这是第一个contact！', '2023-10-15 17:42:32');


INSERT INTO `user` (`id`, `username`, `password`, `auth`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713122010360557569, 'admin', '123456', 1, 1, '2023-10-14 17:18:10', '2023-10-14 17:18:10', 1111111111111111111, 1111111111111111111);
INSERT INTO `user` (`id`, `username`, `password`, `auth`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713153881337286658, 'kepass1ove', '123456', 0, 1, '2023-10-14 19:24:49', '2023-10-14 19:24:49', 1713122010360557569, 1713122010360557569);
INSERT INTO `user` (`id`, `username`, `password`, `auth`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1713218429268267009, 'cnlyuhan', '123456', 0, 1, '2023-10-14 23:41:18', '2023-10-14 23:41:18', 1713122010360557569, 1713122010360557569);










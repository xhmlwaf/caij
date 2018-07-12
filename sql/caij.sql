/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : caij

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 12/07/2018 17:15:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(10) NOT NULL COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `target_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标URL',
  `entity_list_xpath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列表xpath',
  `params_rule_map` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性配置',
  `detail_page_config` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情页配置',
  `detail_params_rule_map` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情页属性配置',
  `is_dynamic` tinyint(3) NULL DEFAULT NULL COMMENT '是否动态页面',
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(3) NULL DEFAULT NULL COMMENT '状态1新建 2开始 3完成 4失败',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for task_detail
-- ----------------------------
DROP TABLE IF EXISTS `task_detail`;
CREATE TABLE `task_detail`  (
  `id` int(10) NOT NULL COMMENT '主键',
  `task_id` int(10) NULL DEFAULT NULL COMMENT '任务ID',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务页面',
  `result_size` int(10) NULL DEFAULT NULL COMMENT '结果量',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `created_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 10/10/2019 10:23:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for publish
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creat_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reply_count` int(255) NULL DEFAULT NULL,
  `view_count` int(255) NULL DEFAULT NULL,
  `gmt_create` bigint(255) NULL DEFAULT NULL,
  `gmt_modified` bigint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publish
-- ----------------------------
INSERT INTO `publish` VALUES (17, 'SQL', 'select * FROM user_info where account_id=#{id}', 'sql', '17', 0, 0, 1566971753221, 1566971753221);
INSERT INTO `publish` VALUES (19, 'sdasdas', 'asdsadasd', 'asdsad', '18', 0, 0, 1566973804054, 1566973804054);

SET FOREIGN_KEY_CHECKS = 1;

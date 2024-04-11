/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 80200
Source Host           : localhost:3306
Source Database       : 大创

Target Server Type    : MYSQL
Target Server Version : 80200
File Encoding         : 65001

Date: 2024-04-04 21:50:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `solution` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of advice
-- ----------------------------
INSERT INTO `advice` VALUES ('1', '慢性肾脏病饮食生活小妙招', '在烹饪食物时尽量选择蒸、炖、焖、煮的方式，食物烹饪时可以先飞水（锅内加水淹没食材，煮至断生），之后再烹调，最后下调味品。\r\n在尽量不要吃烟熏、烧烤、腌制等过度加工食品。控制盐、油、糖和调味品的使用量。', '1');
INSERT INTO `advice` VALUES ('2', '慢性肾脏病运动生活小妙招', '适量的运动对于慢性肾脏病患者来说有利于增加个人的心肺耐力，降低心血管疾病的风险!\r\n在条件和身体情况适宜下可以尝试一些中等强度运动。\r\n比如步行、慢跑、滑冰、游泳、骑自行车、跳广场舞、太极拳、广场舞、八段锦等等。在身体和条件适宜的情况下可以每次锻炼30~60min，每周锻炼3~5次。', '2');
INSERT INTO `advice` VALUES ('3', '泡沫尿的成因', '正常尿液颜色是淡黄透明的，尿液排出后，表面有一定的张力，产生一定量的泡沫，不过会很快消散。但当尿液中的成分发生改变时，比如蛋白、粘液增多，增加了尿液表面的张力，就会产生更多泡沫。对于肾病患者来说，肾脏被损害，尿液中的蛋白含量异常升高，尿液表面就会漂浮着一层细小的泡沫，大小不一，久不消失。       \r\n对于肾病综合征患者具体而言，由于肾小球滤过膜分子屏障和电荷屏障作用受损，使原尿中蛋白含量增多，当超过肾近曲小管回吸收量时，形成大量蛋白尿。因此当出现高血压、高蛋白饮食等因素时，可加重尿蛋白的排出。', '3');
INSERT INTO `advice` VALUES ('4', '肾活组织穿穿刺注意事项', '肾穿刺活检，也称为经皮肾穿刺检查，是肾内科最常见、最重要的一项有创性常规检查。通常是在B超的引导下使用专用的肾穿刺活检针取少量肾皮质组织（一般0.5～1.5cm，2条）进行详细的病理学检查及诊断。\r\n1.穿刺前需协助医生完善各项检查，如：血常规、尿常规、凝血功能、肝肾功能、腹部B超等。\r\n2.术前训练，术中及术后配合医生要求。术前进行呼吸练习即吸气后屏气，尽量保持在30s以上，练习床上排尿（术后6小时内绝对卧床，24小时内卧床）。\r\n3.患者需准备吸管（术后饮水）、便盆（床上排尿）、腹带（术后包扎）等用物。\r\n4.做完肾穿刺后，医生会立即用纱布按压穿刺处至少15分钟，用腹带捆紧，平车推回病房取仰卧位，绝对卧床6～8小时，24小时内不可下床，给予心电监护，监测血压、心率等生命体征。\r\n5.术后患者需多饮水，以尽快排出尿液中少量血凝块；排出的前三次尿液均需留取标本送检。    \r\n', '4');
INSERT INTO `advice` VALUES ('5', '24小时尿蛋白定量的测量方法', '准备一个清洁干燥带盖的广口容器，容量约3000-5000ml。\r\n留尿之日晨7时主动排尿，作为第一次尿液标本留存。\r\n7时以后至次日7时，24小时内每次的排尿量，应全部保留在该干净的容器内。\r\n次日7时也应主动排尿，作为最后一次尿液标本留存。\r\n将24小时的尿收集搅匀，记总量（毫升数）。\r\n将混匀的24小时尿液取出20-50毫升，及时送检验科检测24小时尿蛋白定量，并告知检验科医生总尿量。\r\n如果是在炎热夏季，为避免尿糖分解，发酵及细菌繁殖，需要将尿液标本放置于阴凉、避光处。', '5');
INSERT INTO `advice` VALUES ('6', '肾病综合征的饮食指导', '饮食原则为：优质蛋白、高热量、低盐低脂、高膳食纤维', '6');
INSERT INTO `advice` VALUES ('7', '控盐小妙招', '1.选用新鲜食材，巧用替代方法：新鲜食材保留着食材本身的天然味道，烹调时就不需要加入过多的食盐来增加食物的味道；还可以在制作时放少许醋，使用花椒、八角、辣椒、葱、姜、蒜等天然调味料来调味，减少对咸味的依赖。\r\n2.合理运用烹调方法：烹饪菜肴等到快出锅时或关火后再加盐，能够在保持同样咸度的情况下，减少食盐用量。如果选用咸菜作为做菜的配料，要先冲洗或者浸泡，以减少盐的含量。\r\n3.做好总量控制：在家烹调时的用盐量不应完全按每人每天5g计算，应考虑成人、孩子的差别，还有日常食用的零食、即食食品、黄酱、酱油等的食盐含量，以及在外就餐，也应该计算在内。\r\n4.注意隐形盐（钠）问题：鸡精、味精、蚝油等调味料含钠量较高，某些预包装食品往往属于高盐（钠）食品。为控制食盐摄入量，最好的办法是少买高盐（钠）食品，少吃腌制食品。\r\n5.巧用控盐瓶  ：推荐大家准备专用的控盐瓶，方便精准把控用盐量。', '7');
INSERT INTO `advice` VALUES ('8', '肾病综合征的用药指导', '（1）治疗肾病综合征，糖皮质激素（简称“激素”）是全世界公认的首选最有效药物。就是说，激素是最好的。但激素副作用较大，不能长期大量吃。治疗肾病综合征应用激素要遵循的原则是：起始足量、缓慢减药、长期维持的“八字方针”。勿自行减量或停用激素，观察激素的副作用。\r\n（2） 应用利尿剂期间应观察尿量，尿量过多时与医生联系，减量或停用，注意补充电解质，防止发生电解质紊乱。\r\n（3） 使用免疫抑制剂（如环磷酰胺）治疗时，注意观察白细胞数下降，脱发、胃肠道反应及出血性膀胱炎等副作用。用药期间要适量多饮水和定期查血象，减少药物副作用。\r\n（4） 应用抗凝剂过程中若出现口腔、皮肤黏膜、胃肠道等的出血倾向时，应及时遵医嘱减量并予以处理，必要时停药。', '8');
INSERT INTO `advice` VALUES ('9', null, null, null);
INSERT INTO `advice` VALUES ('10', null, null, null);
INSERT INTO `advice` VALUES ('11', null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `height` decimal(5,2) DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `gfr_value` decimal(5,2) DEFAULT NULL,
  `activity_intensity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `complications` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dietary_preference` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `allergy` varchar(10) DEFAULT NULL,
  `dialysis_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '45', '1838523652', '1.80', '75.00', '5.00', '轻度', '高血压', '[\"川菜\",\"粤菜\",\"苏菜\"]', '1', '123456', '洋葱', '血液透析');

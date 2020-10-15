INSERT INTO `lte_menu`(`menu_id`, `note`, `router_component`, `router_name`, `router_path`) VALUES (1, '个人中心', 'Personal', 'Personal', '/personal');
INSERT INTO `lte_menu`(`menu_id`, `note`, `router_component`, `router_name`, `router_path`) VALUES (2, '用户管理', 'AccountManage', 'AccountManage', '/accountManage');

INSERT INTO `lte_button`(`button_id`, `button_name`, `note`) VALUES (1, 'editPersonal', '编辑');
INSERT INTO `lte_button`(`button_id`, `button_name`, `note`) VALUES (2, 'editAccount', '编辑');
INSERT INTO `lte_button`(`button_id`, `button_name`, `note`) VALUES (3, 'addAccount', '新增');
INSERT INTO `lte_button`(`button_id`, `button_name`, `note`) VALUES (4, 'delAccount', '删除');

INSERT INTO `role`(`id`, `name`, `note`) VALUES (1, 'dev', '开发');
INSERT INTO `role`(`id`, `name`, `note`) VALUES (2, 'admin', '管理员');
INSERT INTO `role`(`id`, `name`, `note`) VALUES (3, 'user', '用户');
INSERT INTO `role`(`id`, `name`, `note`) VALUES (4, 'test', '测试');



INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (1, 'fengqy', NULL, '风清扬', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (2, 'bubai', NULL, '东方不败', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (3, 'wentian', NULL, '向问天', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (5, 'lhc', NULL, '令狐冲', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (6, 'ybq', NULL, '岳不群', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (7, 'nzz', NULL, '宁中则', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (8, 'ryy', NULL, '任盈盈', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (9, 'fez', NULL, '风二中', '123456', NULL, NULL);
INSERT INTO `user`(`id`, `account`, `add_time`, `name`, `pwd`, `update_time`, `version`) VALUES (10, 'lf', NULL, '李风', '123456', NULL, NULL);


INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (1, 1);
INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (1, 4);
INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (2, 1);
INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (3, 1);
INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (3, 4);
INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (4, 1);
INSERT INTO `role_button`(`button_id`, `role_id`) VALUES (4, 4);

INSERT INTO `role_menu`(`menu_id`, `role_id`) VALUES (1, 1);
INSERT INTO `role_menu`(`menu_id`, `role_id`) VALUES (1, 4);
INSERT INTO `role_menu`(`menu_id`, `role_id`) VALUES (2, 1);
INSERT INTO `role_menu`(`menu_id`, `role_id`) VALUES (2, 4);

INSERT INTO `role_user`(`role_id`, `user_id`) VALUES (1, 2);
INSERT INTO `role_user`(`role_id`, `user_id`) VALUES (1, 5);
INSERT INTO `role_user`(`role_id`, `user_id`) VALUES (2, 1);
INSERT INTO `role_user`(`role_id`, `user_id`) VALUES (3, 3);
INSERT INTO `role_user`(`role_id`, `user_id`) VALUES (4, 5);

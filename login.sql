CREATE TABLE `wx_login` (
    `id` int NOT NULL AUTO_INCREMENT,
    `openid` varchar(255) DEFAULT NULL,
    `session_key` varchar(255) DEFAULT NULL,
    `nickName` varchar(255) DEFAULT NULL,
    `gender` int DEFAULT NULL,
    `country` varchar(255) DEFAULT NULL,
    `province` varchar(255) DEFAULT NULL,
    `city` varchar(255) DEFAULT NULL,
    `avatarUrl` varchar(255) DEFAULT NULL,
    `addTime` datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;
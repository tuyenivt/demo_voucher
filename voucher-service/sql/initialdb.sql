CREATE DATABASE IF NOT EXISTS `voucher`;

CREATE TABLE IF NOT EXISTS `voucher`.`voucher` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `phone` varchar(32) NOT NULL,
  `code` varchar(64) NOT NULL,
  KEY `phone_idx` (`phone`)
);

INSERT INTO voucher.voucher(phone, code) VALUES
('123456', 'asdhakjsdh'),
('892754', 'aaaaaa'),
('892754', 'bbbbbb');

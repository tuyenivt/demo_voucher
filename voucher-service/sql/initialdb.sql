CREATE DATABASE IF NOT EXISTS `voucher`;

CREATE TABLE IF NOT EXISTS `voucher`.`voucher` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `phone` varchar(32) NOT NULL,
  `code` varchar(255) NOT NULL,
  KEY `phone_idx` (`phone`)
);

INSERT INTO voucher.voucher(phone, code) VALUES
('123456', 'cyCagsvGMNCOaEOjLJa+oCC7OT6K5C+kFbFRr/wYJ999wKoGHhwVMI7z+vQd6MoE'),
('892754', 'd2a9nRzhFZIiv923Y2gz7eDjJCTl2JdkVMMRgjcVX60vEMeWH2YtfVfAhXU43eUz'),
('892754', 'l3nsNDA7MKJHGnJQOJYtRjfNvwBPI1kworX/ksE/7/FW17TaSSMzK1ru1CJqC12t');

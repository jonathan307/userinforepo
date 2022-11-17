DROP TABLE IF EXISTS USERINFO;
CREATE TABLE UserInfo
as select * from  CSVREAD('classpath:UserInfo.csv')
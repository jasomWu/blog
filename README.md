blog
=

 blog系统，后台管理系统，前台展示
 
 -----

1、参考了一些b站视频，特此感谢<br/>
2、原视频用的jpa，自己用mybatis进行了改写，想学习mybatis的同学可以进行了解参考<br/>
3、后面会陆续添加一些功能，慢慢完善，有兴趣的朋友可以交流<br/>

-------
个人联系方式qq:750595292 (注明来意)

难点
=

mybatis的一对多，多对一<br/>
mybatis的动态sql语句<br/>
数据库的设计，为了（范式规范）连表查询，所以在设计数据库时，blog表包含了很多其他表的id<br/>

---
环境：

idea<br/>
mysql 5.7<br/>
springboot2.2.2<br/>
技术栈

mybatis<br/>
springMVC<br/>
springboot<br/>
thymeleaf<br/>
Semantic Ui<br/>

-----------------------------
9.23<br/>
环境搭建+用户部分模块的处理
使用了基于logback的日志处理，统一的异常处理。管理员模块的访问过滤，用户密码md5加密方式。

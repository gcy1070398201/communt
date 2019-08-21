## 技术文档
[Spring boot 文档](https://spring.io)\
[thymeleaf 文档](https://www.thymeleaf.org)\
[Bootstrap 文档](https://www.bootcss.com)\
[MyBatis 文档](http://www.mybatis.org/mybatis-3/zh/index.html)
~~~~~
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.0</version>
</dependency>
~~~~~
~~~~
application.yml配置
mybatis:
  config-location: classpath:mybatis/mybatis_config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
~~~~
[mySql 文档](https://www.runoob.com/sql/sql-tutorial.html)
~~~~
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
~~~~
~~~~
application.yml配置
spring:
  datasource:
    username: 
    password: 
    url: jdbc:
    driver-class-name: com.mysql.cj.jdbc.Driver
# 注意
# Mysql 版本8.0 以上 driver-class-name: com.mysql.cj.jdbc.Driver
# Mysql 版本8.0以下 river-class-name: com.mysql.jdbc.Driver
~~~~
## 使用工具
[lombok]<br>
[git]
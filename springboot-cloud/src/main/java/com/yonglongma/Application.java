/**
 * <p>Title: Application.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MaYongLong
 * @date 2017-11-22 12:44
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */

@SpringBootApplication//触发了 Component-Scanning 和 自动配置。实际上这个注解做了其他三个注解做的事儿
//@Configuration 等价于在XML中配置了Beans。这个是基于Java的配置。
//@ComponentScan。相当于启动了 Component scanning，其他标记@Controller和@Component的类可以在Spring的Context中被发现和注册。
//@EnableAutoConfiguration 。这个注解本身就是Spring Boot 开启自动配置的。
@EnableTransactionManagement//启用注解事务管理
//要将Application放在最外层，也就是要包含所有子包,spring-boot会自动加载启动类所在包下及其子包下的所有组件.
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    //继承springboot提供的servlet初始化容器，重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}

/**
 * <p>Title: Application.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.sample;

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
@SpringBootApplication
@EnableTransactionManagement//启用注解事务管理
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

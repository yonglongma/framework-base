/**
 * <p>Title: HelloProgram.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.ioc.setting;

import com.yonglongma.module.ioc.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author MaYongLong
 * @date 2017-11-18 22:59
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class HelloProgram {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService service = (HelloWorldService)context.getBean("helloWorldService");

        HelloWorld helloWorld = service.getHelloWorld();
        helloWorld.sayHello();
    }
}

/**
 * <p>Title: HelloWorldService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.ioc.constructor;

import com.yonglongma.module.ioc.HelloWorld;

/**
 * @author MaYongLong
 * @date 2017-11-18 22:56
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//Spring 将通过构造函数注入
public class HelloWorldService {

    private HelloWorld helloWorld;

    public HelloWorldService(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }

   /* public void sayHello(){
        helloWorld.sayHello();
    }*/

    public HelloWorld getHelloWorld(){
        return this.helloWorld;
    }


}

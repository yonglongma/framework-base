/**
 * <p>Title: HelloWorldService.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.ioc.setting;

import com.yonglongma.module.ioc.HelloWorld;

/**
 * @author MaYongLong
 * @date 2017-11-18 22:56
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//Spring 将通过setting注入
public class HelloWorldService {

    private HelloWorld helloWorld;

    public HelloWorldService(){

    }

    public HelloWorld getHelloWorld(){
        return this.helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
}

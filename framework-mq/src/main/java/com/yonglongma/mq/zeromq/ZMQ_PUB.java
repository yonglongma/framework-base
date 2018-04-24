/**
 * <p>Title: ZMQ_PUB.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.mq.zeromq;

import org.zeromq.ZMQ;

/**
 * @author MaYongLong
 * @date 2017-12-27 19:56
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//发布-订阅者模式之发布服务
public class ZMQ_PUB {

    public static void main(String[] args) throws InterruptedException {
        //准备上下文和套接字
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://221.215.87.102:10006");
        //发布100条消息
        Thread.sleep(1000);
        for (int i = 0; i < 100; i++) {
            publisher.send(("admin " + i).getBytes(), ZMQ.NOBLOCK);
            System.out.println("pub msg " + i);
            Thread.sleep(1000);
        }

        //关闭套接字和上下文
        publisher.close();
        context.term();
    }
}

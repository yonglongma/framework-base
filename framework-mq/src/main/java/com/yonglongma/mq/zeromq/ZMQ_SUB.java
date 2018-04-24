/**
 * <p>Title: ZMQ_SUB.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.mq.zeromq;

import org.zeromq.ZMQ;

/**
 * @author MaYongLong
 * @date 2017-12-27 19:30
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//发布-订阅者模式之订阅客户端。持续接收消息
public class ZMQ_SUB{

    public static  void main(String[] args) {
        //准备上下文
        //套接字连接至服务器
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        String address = "tcp://221.215.87.102:10006"; //pub地址
        subscriber.connect(address); //连接pub
        subscriber.subscribe("".getBytes()); //订阅所有Topic;

        //事件监控
        subscriber.monitor("inproc://reqmoniter", ZMQ.EVENT_CONNECTED | ZMQ.EVENT_DISCONNECTED);
        final ZMQ.Socket moniter = context.socket(ZMQ.PAIR);
        moniter.connect("inproc://reqmoniter");
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    zmq.ZMQ.Event event = zmq.ZMQ.Event.read(moniter.base());
                    System.out.println(event.event + "  " + event.addr);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
        while (true) {
            byte[] msg = subscriber.recv();
            try {
                String _head = new String(msg, "utf-8");
                System.out.println("Varible [_head] ->" + _head);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //关闭套接字和上下文
            subscriber.close();
            context.term();
        }
    }
}

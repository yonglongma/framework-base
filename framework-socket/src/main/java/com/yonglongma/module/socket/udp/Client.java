/**
 * <p>Title: Client.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author MaYongLong
 * @date 2017-11-09 17:12
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//客户端
public class Client {

    public static void main(String[] args) throws Exception{
        //1、定义服务器的地址、端口号、数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 10010;
        byte[] data = "用户名：admin;密码：123".getBytes();
        //2、创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3、创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4、向服务器发送数据
        socket.send(packet);


        //接受服务器端响应数据
        //1、创建数据报，用于接受服务器端响应数据
        byte[] data1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data1,data1.length);
        //2、接受服务器响应的数据
        socket.receive(packet1);
        String reply = new String(data1,0,packet1.getLength());
        System.out.println("我是客户端，服务端说："+reply);
        //3、关闭资源
        socket.close();
    }
}

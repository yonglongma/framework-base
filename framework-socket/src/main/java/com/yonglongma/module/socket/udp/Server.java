/**
 * <p>Title: Server.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author MaYongLong
 * @date 2017-11-09 17:04
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class Server {

    public static void main(String[] args) throws Exception{
        //1、创建服务器端DatagramSocket，指定端口
        DatagramSocket socket = new DatagramSocket(10010);
        //2、创建数据报，用于接受客户端发送的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        //3、接受客户端发送的数据
        socket.receive(packet);//此方法在接受数据报之前会一致阻塞
        //4、读取数据
        String info = new String(data,0,data.length);
        System.out.println("我是服务器，客户端告诉我"+info);

        //向客户端响应数据
        //1、定义客户端的地址、端口号、数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data1 = "欢迎您！".getBytes();
        //2、创建数据报，包含响应的数据信息
        DatagramPacket packet1 = new DatagramPacket(data1,data1.length,address,port);
        //3、响应客户端
        socket.send(packet1);
        //4、关闭资源
        socket.close();
    }
}

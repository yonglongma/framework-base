/**
 * <p>Title: MultiThreadServer.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author MaYongLong
 * @date 2017-11-09 16:41
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//应用多线程实现服务器与多客户端之间的通信
public class MultiThreadServer {

    //和本线程相关的socket
    Socket socket =null;

    public MultiThreadServer(Socket socket){
        this.socket = socket;
    }

    public void run() throws IOException{
        //服务器处理代码
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info;
        while ((info=bufferedReader.readLine())!= null){
            System.out.println(info);
        }
        socket.shutdownInput();

        //发送给客户端
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("成功收到啦。。。。");
        printWriter.flush();

        //关闭资源
        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        socket.close();

    }

    public static void main(String[] args) throws IOException{
        //服务器端创建ServerSocket，循环调用accept()等待客户端连接
        ServerSocket serverSocket =new ServerSocket(10086);
        Socket socket =null;
        int count =0;//记录客户端的数量
        while(true){
            socket = serverSocket.accept();
            MultiThreadServer multiThreadServer =new MultiThreadServer(socket);
            multiThreadServer.run();
            count++;
            System.out.println("客户端连接的数量："+count);
        }
    }
}

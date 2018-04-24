/**
 * <p>Title: TcpClient.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author MaYongLong
 * @date 2017-11-08 18:33
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class Client {

    // 搭建客户端
    public static void main(String[] args) throws IOException {
        try {
            //1、创建客户端Socket，指定服务器地址和端口
            Socket socket =new Socket("localhost",10086);
            //2、获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
            pw.write("用户名：admin；密码：123");
            pw.flush();
            socket.shutdownOutput();
            //3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info=br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+info);
            }
            //4、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);// 出错，打印出错信息
        }
    }

}

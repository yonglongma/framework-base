/**
 * <p>Title: ReceiveThread.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.tcp.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author MaYongLong
 * @date 2017-11-09 18:58
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//接消息多线程类
public class ReceiveThread extends Thread {

    ServerSocket serverSocket;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    BufferedReader userin;


    public ReceiveThread(ServerSocket serverSocket,Socket socket,BufferedReader in, PrintWriter out,BufferedReader userin){
        this.serverSocket= serverSocket;
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.userin = userin;
    }

    public ReceiveThread(Socket socket,BufferedReader in, PrintWriter out,BufferedReader userin){
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.userin = userin;
    }

    @Override
    public void run(){
        try {
            while (true){
                String info = in.readLine();
                while (info != null){
                    System.out.println(info);
                    info = in.readLine();
                }
                if(in.readLine().equals("end")){
                    break;
                }
                in.close();
                out.close();
                userin.close();
                if(socket != null){
                    socket.close();
                }
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

/**
 * <p>Title: Server.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.tcp.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author MaYongLong
 * @date 2017-11-09 18:43
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));

            new ReceiveThread(serverSocket,socket,in,out,userin).start();
            new SendThread(out,userin,true).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

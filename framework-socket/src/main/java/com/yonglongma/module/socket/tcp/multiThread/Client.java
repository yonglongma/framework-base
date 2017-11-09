/**
 * <p>Title: Client.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.tcp.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author MaYongLong
 * @date 2017-11-09 18:48
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(),8888);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));

            new SendThread(out,userin,false).start();
            new ReceiveThread(socket,in,out,userin).start();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

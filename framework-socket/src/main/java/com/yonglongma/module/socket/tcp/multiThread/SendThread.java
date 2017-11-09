/**
 * <p>Title: SendThread.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.module.socket.tcp.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MaYongLong
 * @date 2017-11-09 18:52
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
//发消息多线程类
public class SendThread extends Thread{

    PrintWriter out;
    BufferedReader userin;
    boolean isServer;

    public SendThread(PrintWriter out,BufferedReader userin,boolean isServer){
        this.out = out;
        this.userin = userin;
        this.isServer = isServer;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            while (true){
                if(isServer){
                    out.println("server "+sdf.format(new Date())+"\n\t"+userin.readLine());
                }else{
                    out.println("client "+sdf.format(new Date())+"\n\t"+userin.readLine());
                }
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

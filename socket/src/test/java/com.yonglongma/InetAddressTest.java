/**
 * <p>Title: InetAddressTest.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author MaYongLong
 * @date 2017-10-30 21:38
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class InetAddressTest {

    @Test
    public void testInetAddress() throws UnknownHostException{
        //获取本机InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println(Arrays.toString(bytes));
        System.out.println(address);

        //根据机器名获取InetAddress实例
        //InetAddress inetAddress = InetAddress.getByName("mayonglong-PC");
        InetAddress inetAddress = InetAddress.getByName("192.168.0.103");
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }
}

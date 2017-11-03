/**
 * <p>Title: URLTest.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author MaYongLong
 * @date 2017-10-30 21:47
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class URLTest {

    @Test
    public void testURL() {
        //创建一个URL实例
        try {
            URL url = new URL("http://www.baidu.com");
            URL context = new URL(url,"/index.html?username=a#b");
            System.out.println("协议"+context.getProtocol());
            System.out.println("主机"+context.getHost());
            System.out.println("端口"+context.getPort());
            System.out.println("文件路径"+context.getPath());
            System.out.println("文件名"+context.getFile());
            System.out.println("锚点相对路径"+context.getRef());
            System.out.println("查询字符串"+context.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getURLContext(){
        try {
            URL context = new URL("http://www.baidu.com");
            //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream inputStream = context.openStream();
            //把字节输入流转成字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            //为字符输入流添加缓存
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();//读取数据
            while (data != null){
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

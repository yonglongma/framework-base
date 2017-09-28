package com.yonglongma.single.annotation;

import java.io.*;

/**
 * Author MaYongLong
 * Create in 20:10 2017/9/11
 * Description
 */
public class SerializableUtil {

    //序列化
    public static byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        byte[] bs = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            bs = bai.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bai != null) {
                try {
                    bai.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bs;
    }
    //反序列化
    public static Object unserizlize(byte[] bs) {
        ByteArrayInputStream bis = null;
        Object obj = null;
        try {
            bis = new ByteArrayInputStream(bs);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}

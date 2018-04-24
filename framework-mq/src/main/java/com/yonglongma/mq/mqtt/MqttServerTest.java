/**
 * <p>Title: MqttServerTest.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.mq.mqtt;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author MaYongLong
 * @date 2018-03-29 14:31
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class MqttServerTest {

    public static final String HOST = "tcp://127.0.0.1:61613";

    public static final String TOPIC = "toclient/124";

    public static final String TOPIC125 = "toclient/125";

    public static final String clientid = "server-id-0";

    private MqttClient client;

    private MqttTopic topic;

    private MqttTopic topic125;

    private String userName = "admin";

    private String password = "password";

    private MqttMessage message;

    public MqttServerTest() throws MqttException{
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST,clientid,new MemoryPersistence());
        connect();
    }

    private void connect(){
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(10);//设置超时时间
        options.setKeepAliveInterval(20);//设置会话心跳时间
        try {
            client.setCallback(new PushCallBack());
            client.connect(options);
            topic = client.getTopic(TOPIC);
            topic125 = client.getTopic(TOPIC125);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void publish(MqttTopic topic,MqttMessage message) throws MqttException{
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely:"+token.isComplete());
    }

    public static void main(String[] args) throws MqttException{
        MqttServerTest server =new MqttServerTest();
        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        server.message.setPayload("给客户端124推送的信息".getBytes());
        server.publish(server.topic,server.message);

        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        server.message.setPayload("给客户端125推送的信息".getBytes());
        server.publish(server.topic125,server.message);

        System.out.println(server.message.isRetained()+"....ratained状态");

    }
}


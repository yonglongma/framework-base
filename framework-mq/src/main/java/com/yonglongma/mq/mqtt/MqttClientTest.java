/**
 * <p>Title: MqttClientTest.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.mq.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @author MaYongLong
 * @date 2018-03-29 15:20
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class MqttClientTest {
    public static final String HOST = "tcp://127.0.0.1:61613";

    public static final String TOPIC = "toclient/124";

    private static final String clientid = "client124";

    private MqttClient client;

    private MqttConnectOptions options;

    private String userName = "admin";

    private String password = "password";

    private ScheduledExecutorService scheduler;

    private void start(){
        try {
            //host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client= new MqttClient(HOST, clientid, new MemoryPersistence());
            //MQTT的连接设置
            options= new MqttConnectOptions();
            //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为tr
            options.setCleanSession(true);
            //设置连接的用户名
            options.setUserName(userName);
            options.setPassword(password.toCharArray());
            //设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            //设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客
            options.setKeepAliveInterval(20);
            //设置回调
            client.setCallback(new PushCallBack());
            MqttTopic topic = client.getTopic(TOPIC);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            options.setWill(topic,"close".getBytes(),2,true);
            client.connect(options);
            //订阅消息
            int[] Qos = {1};
            String[] topic1 = {TOPIC};
            client.subscribe(topic1,Qos);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MqttClientTest mqttClientTest = new MqttClientTest();
        mqttClientTest.start();
    }

}

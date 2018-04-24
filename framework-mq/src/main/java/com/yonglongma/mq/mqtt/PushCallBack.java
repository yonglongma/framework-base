/**
 * <p>Title: PushCallBack.java</p>
 * <p>Copyright: Copyright (c) 2017 - </p>
 */
package com.yonglongma.mq.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author MaYongLong
 * @date 2018-03-29 15:10
 * -------------------------------------------------------------------------
 * Modified Date		Modified By			Why & What's modified
 * -------------------------------------------------------------------------
 */
public class PushCallBack implements MqttCallback {

    public void connectionLost(Throwable throwable) {
        //连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //subscribe后得到的消息会执行到这里面
        System.out.println("接收消息主题: " + topic);
        System.out.println("接收消息Qos : " + message.getQos());
        System.out.println("接收消息内容: " + new String(message.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------"+ token.isComplete());
    }
}

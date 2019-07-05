package com.client;

import org.java_websocket.WebSocket;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author
 * @Description
 * @Date 2018/12/28 0028下午 1:30
 * 模拟用户操作
 **/

public class Testmin {

    public static void main(String[] args) throws URISyntaxException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            Client client = new Client("ws://172.16.140.150:2020/remoteservice/callDeviceServer?vcDevId=10020");
            client.connect();
            long start = System.currentTimeMillis();
            while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {//获取连接状态
                System.out.println(sdf.format(new Date()) + "还没有打开");
            }
            System.out.println(sdf.format(new Date()) + "建立websocket连接");
            long end = System.currentTimeMillis();
        System.out.println(end - start);
//            while (true) {
//                client.send("{\"type\":\"00\",\"dateTime\":\"23456\"}");//发送消息
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
    }
}

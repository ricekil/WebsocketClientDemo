package com.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author
 * @Description
 * @Date 2018/12/28 0028上午 10:03
 **/

public class Client extends WebSocketClient {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    public Client(String url) throws URISyntaxException {
        super(new URI(url));
        // 连接地址
    }

    @Override
    public void onOpen(ServerHandshake shake) {
        System.out.println("客户端连接了服务器");
    }

    @Override
    public void onMessage(String paramString) {
        System.out.println( sdf.format(new Date()) + "接收到消息：" + paramString);
    }

    @Override
    public void onClose(int paramInt, String paramString, boolean paramBoolean) {
        System.out.println("服务器关闭...");
    }

    @Override
    public void onError(Exception e) {
        System.out.println("连接异常" + e);

    }

    @Override
    public void onMessage(ByteBuffer bytes) {
        super.onMessage(bytes);
        System.err.println("这里是onmessage：");
    }

}
package me.jessyan.mvparms.demo.app.service.im;

import com.jess.arms.utils.LogUtils;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;

/**
 * @Author :hexingbo
 * @Date :2020/5/9
 * @FileName： JWebSocketClient
 * @Describe :
 */
public class JWebSocketClient extends WebSocketClient {

    public JWebSocketClient(URI serverUri, Map<String, String> map) {
        //构造方法中的new Draft_6455()代表使用的协议版本，这里可以不写或者写成这样即可。
        super(serverUri, new Draft_6455(), map);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        //其中onOpen()方法在websocket连接开启时调用
        LogUtils.debugInfo("JWebSocketClient", "onOpen()");
    }

    @Override
    public void onMessage(String message) {
        //onMessage()方法在接收到消息时调用，
        LogUtils.debugInfo("JWebSocketClient", "onMessage()");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        //onClose()方法在连接断开时调用，
        LogUtils.debugInfo("JWebSocketClient", "onClose()");
    }

    @Override
    public void onError(Exception ex) {
        //onError()方法在连接出错时调用。
        LogUtils.debugInfo("JWebSocketClient", "onError()");
    }
}

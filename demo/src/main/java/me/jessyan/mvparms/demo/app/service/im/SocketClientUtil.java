package me.jessyan.mvparms.demo.app.service.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.jess.arms.utils.LogUtils;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * @Author :hexingbo
 * @Date :2020/5/9
 * @FileName： SocketClientUtil
 * @Describe :
 */
public class SocketClientUtil {

    private Activity mActivity;

    private JWebSocketClientService.JWebSocketClientBinder binder;
    private JWebSocketClientService jWebSClientService;
    private JWebSocketClient client;

    public SocketClientUtil(Activity mActivity) {
        this.mActivity = mActivity;
        //启动服务
        startJWebSClientService();
        //绑定服务
        bindService();
    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtils.debugInfo("SocketClientUtil", "服务与活动成功绑定");
            binder = (JWebSocketClientService.JWebSocketClientBinder) iBinder;
            jWebSClientService = binder.getService();
            client = jWebSClientService.client;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.debugInfo("SocketClientUtil", "服务与活动成功断开");
        }
    };

    /**
     * 启动服务（websocket客户端服务）
     */
    public void startJWebSClientService() {
        Intent intent = new Intent(mActivity, JWebSocketClientService.class);
        mActivity.startService(intent);
    }

    /**
     * 绑定服务
     */
    private void bindService() {
        Intent bindIntent = new Intent(mActivity, JWebSocketClientService.class);
        mActivity.bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
    }


}


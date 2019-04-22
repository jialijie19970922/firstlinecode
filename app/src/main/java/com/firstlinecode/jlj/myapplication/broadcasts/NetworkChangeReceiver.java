package com.firstlinecode.jlj.myapplication.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.firstlinecode.jlj.myapplication.utli.NetWorkUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//         TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String hostIP = NetWorkUtil.getHostIP();
        if (NetWorkUtil.is3gConnected(context)){
            Toast.makeText(context,"您当前使用数据流量",Toast.LENGTH_LONG).show();
//        }else if (NetWorkUtil.isLinkAvailable(hostIP)){
//            Toast.makeText(context,"ip地址："+hostIP,Toast.LENGTH_LONG).show();
        }
        if (NetWorkUtil.isNetConnected(context)){
            Toast.makeText(context,"您当前网络不可用",Toast.LENGTH_LONG).show();
        }else if (NetWorkUtil.isWifiConnected(context)){
            Toast.makeText(context,"您当前使用WiFi",Toast.LENGTH_LONG).show();
        }
//        Log.e("myMessage", "onReceive: ---------*******------------");
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}

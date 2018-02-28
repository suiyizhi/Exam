package com.bwie.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by cuiha on 2017/12/11.
 */

public class NetStateUtil {
    //判断网络
    public static boolean isConn(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null && info.isAvailable()){
            return true;
        }
        return false;
    }
}

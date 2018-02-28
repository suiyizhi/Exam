package com.example.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by cuiha on 2017/12/19.
 */

public class NetStateUtil {
    //网络判断
    public static boolean isConn(Context context){
        ConnectivityManager service = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = service.getActiveNetworkInfo();
        if (info!=null && info.isAvailable()){
            return true;
        }
        return false;
    }
    //打开提示框
    public static void openDg(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage("请设置网络");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("取消",null);
        builder.show();
    }
}

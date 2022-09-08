package com.smarthub.obvious.utils;

import android.util.Log;

public class AppLogger {
    public static String TAG = "status";

    public static void d(String msg){
        Log.d(TAG,msg);
    }

    public static void d(String tag,String msg){
        Log.d(tag,msg);
    }

    public static void e(String tag,String msg,Throwable extra){
        Log.e(tag,msg,extra);
    }

    public static void e(String msg,Throwable extra){
        Log.e(TAG,msg,extra);
    }

}

package com.smarthub.obvious.utils;

import androidx.multidex.MultiDexApplication;

import com.google.gson.Gson;
import com.smarthub.obvious.R;
import com.smarthub.obvious.model.ImageList;

import java.io.IOException;

/**
 * AppController class for handling all initial process
 * initialize all pre launch screen process
 */
public class AppController extends MultiDexApplication {

    String errorMsg = "";
    ImageList imageListItems;
    private static AppController instance;

    public static AppController getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initConfig();
    }

//    start initialization of process
    void initConfig() {
        AppLogger.d("AppController f: initConfig");
        try {
            imageListItems = new Gson().fromJson(Util.readResFileContent(R.raw.data,this),ImageList.class);
            AppLogger.d("AppController f: list "+imageListItems.size());
        }catch (Exception e){
            errorMsg = e.getLocalizedMessage();
            AppLogger.d("AppController error: initConfig"+e.getLocalizedMessage());
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ImageList getImageListItems() {
        return imageListItems;
    }
}

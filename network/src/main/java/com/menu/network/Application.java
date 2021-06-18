package com.menu.network;

import android.content.Context;

import com.menu.network.util.LogUtil;
import com.menu.network.util.SpModel;

/***
 *created by 
 *on 2020/8/4
 */
public class Application extends android.app.Application {

    public static boolean isPDA = true;
    public static int PROWER = 15;
    private static Application INSTANCE;
    private static SpModel spModel;

    public static Application getInstance() {
        return INSTANCE;
    }

    public static Context getContext() {
        return INSTANCE;
    }

    public static SpModel getSpModel(){
        return spModel;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        LogUtil.init();
        spModel = SpModel.getInstance(Application.getContext(), Constant.APP_TABLE_NAME);
    }
}

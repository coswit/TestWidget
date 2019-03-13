package com.coswit;

import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;


/**
 * Created by jingzheng on 2018/6/19.
 */

public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }


}

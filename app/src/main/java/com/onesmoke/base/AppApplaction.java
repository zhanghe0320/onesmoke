package com.onesmoke.base;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.hjq.toast.ToastUtils;


/**
 * 主启动
 */
public class AppApplaction extends MultiDexApplication {


    private static AppApplaction mOneSmockApplication;
    private static Context mContext;

    public static AppApplaction getInstance() {
        // 双重判空机制 保证线程安全
        if (mOneSmockApplication == null) {
            synchronized (AppApplaction.class) {
                if (mOneSmockApplication == null) {
                    mOneSmockApplication = new AppApplaction();
                }
            }
        }
        return mOneSmockApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //架构必须要初始化操作
       // Rocket.init(this);
        //RoLogUtil.stopALLLog();
        //ToastUtils.init(this);
        ToastUtils.init(this);
        mContext = this;
        //重写生命周期
        registerActivityLifecycleCallbacks(new ActivityHelper());


    }

    public static Context getmContext(){

        return mContext;
    }
    @Override
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }


}
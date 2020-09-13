package com.project.treadrandomservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RandomService extends Service {

    private Thread work;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化线程
        work = new Thread(null,backgroundWork,"WorkThread");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(!work.isAlive()) {
            work.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        work.interrupt();
    }

    private Runnable backgroundWork = new Runnable() {
        @Override
        public void run() {
            /**
             * 测试线程是否被中断
             */
            while(!Thread.interrupted()) {
                double randomeDouble = Math.random();
            }
        }
    };
}

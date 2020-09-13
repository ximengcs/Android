package com.project.servicebonddemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MathService extends Service {


    private final IBinder mbinder = new LocalBinder();

    /**
     * Binder用于进程内部和进程间过程调用的轻量级接口
     *          定义了与远程通信交互的抽象协议
     */
    public class LocalBinder extends Binder {
        MathService getService() {
            return MathService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"onBind",Toast.LENGTH_SHORT).show();
        return mbinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Toast.makeText(this,"取消绑定",Toast.LENGTH_SHORT).show();

        /**
         * 返回false；destory
         * 返回true；重新绑定
         */
        return false;
    }

    /**
     * SERVICE中的公开方法
     */
    public long add(long a,long b) {
        return a+b;
    }
}

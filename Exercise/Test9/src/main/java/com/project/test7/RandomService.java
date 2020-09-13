package com.project.test7;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RandomService extends Service {

    /**
     * 当service被绑定时调用
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("oncreate","oncreate");
        Toast.makeText(this,"(1)调用onCreate()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this,"(2)调用onStart()",Toast.LENGTH_SHORT).show();

        /**
         * 启动服务时创建随机数
         */
        double randomDouble = Math.random();
        String msg = "随机数:"+String.valueOf(randomDouble);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"(3)调用onDestory()",Toast.LENGTH_SHORT);
    }
}

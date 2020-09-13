package com.project.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ShowServer extends Service {

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void show() throws RemoteException {
            Log.i("test","reach");
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}

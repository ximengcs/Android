package com.project.remotemath;

import android.app.Service;
import android.os.RemoteException;

public class MathService extends Service {

    private final IMathService.Stub mBinder = new IMathService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    }
}

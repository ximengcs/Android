package com.project.test5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ShowServer extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
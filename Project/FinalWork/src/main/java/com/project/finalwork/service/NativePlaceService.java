package com.project.finalwork.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.project.finalwork.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class NativePlaceService extends Service {

    HashMap<String,String> info;

    LocalBinder localBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public NativePlaceService getService() {
            return NativePlaceService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        info = new HashMap<>();
        initialInfo();
        return localBinder;
    }

    public String getYear(String ID_number) {
        return ID_number.substring(6,10);
    }

    public String getMonth(String ID_number) {
        return ID_number.substring(10,12);
    }

    public String getDay(String ID_number) {
        return ID_number.substring(12,14);
    }

    public String getNativePlaceInfo(String ID_number) {
        char[] numArray = ID_number.toCharArray();

        if(numArray.length < 18)
            return null;

        int result = ((int)numArray[0]-48) *7 +
                ((int)numArray[1]-48) *9 +
                ((int)numArray[2]-48) *10 +
                ((int)numArray[3]-48) *5 +
                ((int)numArray[4]-48) *8 +
                ((int)numArray[5]-48) *4 +
                ((int)numArray[6]-48) *2 +
                ((int)numArray[7]-48) *1 +
                ((int)numArray[8]-48) *6 +
                ((int)numArray[9]-48) *3 +
                ((int)numArray[10]-48) *7 +
                ((int)numArray[11]-48) *9 +
                ((int)numArray[12]-48) *10 +
                ((int)numArray[13]-48) *5 +
                ((int)numArray[14]-48) *8 +
                ((int)numArray[15]-48) *4 +
                ((int)numArray[16]-48) *2;
        int mod = result%11;

        switch (mod) {
            case 0:
                if(1 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 1:
                if(0 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 2:
                if('x' == numArray[17]-48)
                    return info.get(ID_number.substring(0,6));
                break;
            case 3:
                if(9 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 4:
                if(8 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 5:
                if(7 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 6:
                if(6 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 7:
                if(5 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 8:
                if(4 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 9:
                if(3 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
            case 10:
                if(2 == ((int)numArray[17]-48))
                    return info.get(ID_number.substring(0,6));
                break;
        }
        return null;
    }

    private void initialInfo() {

        InputStream inputStream =
                getResources().openRawResource(R.raw.table);

        BufferedReader buffer =
                null;
        try {
            buffer = new BufferedReader(
                    new InputStreamReader(inputStream,"gbk"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            int ch = 0;
            do{
                String string = buffer.readLine();
                String[] kv = string.split(":");
                if( kv[0].equals("") != true ) {
                    info.put(kv[0], kv[1]);
                    ch = buffer.read();
                }
            }while(ch!=-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

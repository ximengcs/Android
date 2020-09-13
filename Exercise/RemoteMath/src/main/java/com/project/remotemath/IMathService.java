package com.project.remotemath;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * IInterface：AIDL基类的接口
 */
public interface IMathService extends IInterface {

    long add(long a,long b);
    /**
     * 绑定服务时调用BINDER获取服务实例
     */
    abstract class Stub extends Binder implements IMathService {
        private static final String DESCRPTION = "com.project.remotemath.IMathService";

        static final int TRANSACTION_Add=(IBinder.FIRST_CALL_TRANSACTION+0);

        public Stub() {
            this.attachInterface(this,DESCRPTION);
        }

        /**
         * 获取远程服务的实例
         * @param obj
         * @return
         */
        public static IMathService asInterface(IBinder obj) {
            if((obj==null)) {
                return null;
            }
            //通过DESCROPTION构造IIterface实例
            IInterface iin = obj.queryLocalInterface(DESCRPTION);
            //判断是否为本地服务
            if((iin!=null)&&(iin instanceof IMathService)) {
                return (IMathService)iin;
            }
            //如果是远程服务
            return new Proxy(obj);
        }

        /**
         * 获取Binder对象
         * @return
         */
        @Override
        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags )
            throws RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(DESCRPTION);
                    return true;
                }
                case TRANSACTION_Add:
                {
                    data.enforceInterface(DESCRPTION);
                    long _arg0;
                    _arg0=data.readLong();
                    long _arg1;
                    _arg1=data.readLong();
                    long _result=_arg0+_arg1;
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                }
            }
            return super.onTransact(code,data,reply,flags);
        }

        private static class Proxy implements IMathService {
            private IBinder mremote;
            Proxy(IBinder remote) {
                mremote=remote;
            }
            public IBinder asBinder() {
                return mremote;
            }

            // 远程服务的描述为DESCIPRION
            public String getInterfaceDescrption() {
                return DESCRPTION;
            }

            public long add(long a,long b)throws RemoteException {
                // 进程间通信数据的打包和拆包
                Parcel _data=Parcel.obtain();
                Parcel _reply=Parcel.obtain();
                long _result;
                try{
                    _data.writeInterfaceToken(DESCRPTION);
                    _data.writeLong(a);
                    _data.writeLong(b);
                    mremote.transact(TRANSACTION_Add,_data,_reply,0);
                    _reply.readException();
                    _result=_reply.readLong();
                }finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }
        }
    }
}

package com.project.getinfoservice;

import android.os.Parcel;
import android.os.Parcelable;

public class MyContact implements Parcelable {

    public String name;
    public String phone;

    public MyContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    protected MyContact(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    public static final Creator<MyContact> CREATOR = new Creator<MyContact>() {
        @Override
        public MyContact createFromParcel(Parcel in) {
            return new MyContact(in);
        }

        @Override
        public MyContact[] newArray(int size) {
            return new MyContact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }
}


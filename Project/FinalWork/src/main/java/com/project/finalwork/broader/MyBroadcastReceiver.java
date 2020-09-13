package com.project.finalwork.broader;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.project.finalwork.BasicInfoActivity;
import com.project.finalwork.OtherInfoActivity;
import com.project.finalwork.R;
import com.project.finalwork.db.DBAdapter;
import com.project.finalwork.instance.StudentInfoEntities;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static DBAdapter dbAdapter = new DBAdapter(OtherInfoActivity.instance);

    @Override
    public void onReceive(final Context context, final Intent intent) {
        final StudentInfoEntities student = (StudentInfoEntities) intent.getSerializableExtra("student");

        AlertDialog.Builder configInfo_dialog = new AlertDialog.Builder(OtherInfoActivity.instance, AlertDialog.THEME_HOLO_DARK);
        configInfo_dialog.setTitle("个人信息确认");
        configInfo_dialog.setMessage(student.toString());
        configInfo_dialog.setCancelable(false);
        configInfo_dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbAdapter.open();

                dbAdapter.insert(student);

                dbAdapter.close();
            }
        });
        configInfo_dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                intent.setClass(OtherInfoActivity.instance,BasicInfoActivity.class);
                context.startActivity(intent);
            }
        });
        configInfo_dialog.create().show();
    }
}

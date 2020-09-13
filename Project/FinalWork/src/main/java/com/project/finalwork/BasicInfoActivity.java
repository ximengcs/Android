package com.project.finalwork;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.project.finalwork.instance.StudentInfoEntities;
import com.project.finalwork.listener.ID_numberInputListener;
import com.project.finalwork.service.NativePlaceService;

public class BasicInfoActivity extends Activity {

    public static NativePlaceService nativePlaceService;

    private final StudentInfoEntities studentInfoEntities = new StudentInfoEntities();

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            nativePlaceService = ((NativePlaceService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            nativePlaceService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicinfo);

        final EditText stu_id = findViewById(R.id.stu_id);
        final EditText name = findViewById(R.id.name);
        final EditText id_number = findViewById(R.id.id_number);
        final RadioButton male = findViewById(R.id.male);
        final EditText native_place = findViewById(R.id.native_place);
        final EditText year = findViewById(R.id.year);
        final EditText month = findViewById(R.id.month);
        final EditText day = findViewById(R.id.day);

        ID_numberInputListener id_numberInputListener = new ID_numberInputListener(
                native_place,year,month,day,id_number);

        id_number.addTextChangedListener(id_numberInputListener);

        Intent serviceIntent = new Intent(BasicInfoActivity.this,NativePlaceService.class);
        serviceIntent.setPackage(getPackageName());
        bindService(serviceIntent,serviceConnection, Context.BIND_AUTO_CREATE);

        findViewById(R.id.enterSchoolInfo).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();

                        String str_stu_id = stu_id.getText().toString();
                        String str_id_number = id_number.getText().toString();
                        String str_sex;
                        if(male.isChecked())
                            str_sex = "男";
                        else
                            str_sex = "女";

                        String str_name = name.getText().toString();
                        String str_native_place = native_place.getText().toString();
                        String str_birthday = year.getText().toString() + "年" +
                                month.getText().toString() + "月" +
                                day.getText().toString() + "日";

                        studentInfoEntities.setName(str_name);
                        studentInfoEntities.setBirthday(str_birthday);
                        studentInfoEntities.setId_number(str_id_number);
                        studentInfoEntities.setNative_place(str_native_place);
                        studentInfoEntities.setStudent_id(str_stu_id);
                        studentInfoEntities.setSex(str_sex);

                        intent.putExtra("student",studentInfoEntities);

                        intent.setClass(BasicInfoActivity.this,SchoolInfoActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }
    public void m() {

    }
}

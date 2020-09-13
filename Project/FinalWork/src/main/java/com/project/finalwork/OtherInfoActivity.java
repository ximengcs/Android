package com.project.finalwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.project.finalwork.instance.StudentInfoEntities;

public class OtherInfoActivity extends Activity {

    public static OtherInfoActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherinfo);

        instance = this;

        final EditText phone = findViewById(R.id.phone_label);
        final EditText email = findViewById(R.id.email_label);
        final EditText weixin = findViewById(R.id.weixin_label);

        final CheckBox music = findViewById(R.id.music);
        final CheckBox arts = findViewById(R.id.arts);
        final CheckBox handwriting = findViewById(R.id.handwriting);
        final CheckBox basketball = findViewById(R.id.basketball);
        final CheckBox football = findViewById(R.id.football);
        final CheckBox swimming = findViewById(R.id.swimming);

        findViewById(R.id.commit).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        String str_phone = phone.getText().toString();
                        String str_email = email.getText().toString();
                        String str_weixin = weixin.getText().toString();

                        String str_special_skill = "";
                        if(music.isChecked())
                            str_special_skill += getText(R.string.music);
                        if(arts.isChecked())
                            str_special_skill +=  "、" + getText(R.string.arts);
                        if(handwriting.isChecked())
                            str_special_skill += "、" + getText(R.string.handwriting);
                        if(basketball.isChecked())
                            str_special_skill += "、" + getText(R.string.basketball);
                        if(football.isChecked())
                            str_special_skill += "、" + getText(R.string.football);
                        if(swimming.isChecked())
                            str_special_skill += "、" + getText(R.string.swimming);

                        if(str_special_skill.indexOf("、") == 0)
                            str_special_skill = str_special_skill.substring(1,str_special_skill.length());

                        StudentInfoEntities student = (StudentInfoEntities) intent.getSerializableExtra("student");

                        student.setPhone(str_phone);
                        student.setEmail(str_email);
                        student.setWeixin_number(str_weixin);
                        student.setSpecial_skill(str_special_skill);

                        Intent broadcast = new Intent("com.project.finalwork.broader.MyBroadcastReceiver");
                        broadcast.setPackage(getPackageName());
                        broadcast.putExtra("student",student);
                        sendBroadcast(broadcast);
                    }
                }
        );
    }
}

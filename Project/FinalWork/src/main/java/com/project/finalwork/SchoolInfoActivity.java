package com.project.finalwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.finalwork.instance.StudentInfoEntities;

public class SchoolInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schoolinfo);

        final Spinner school = findViewById(R.id.school);
        final EditText major = findViewById(R.id.major);
        final EditText stu_class = findViewById(R.id.stu_class);

        findViewById(R.id.enterOtherInfo).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        String str_school = school.getSelectedItem().toString();
                        String str_major = major.getText().toString();
                        String str_stu_class = stu_class.getText().toString();

                        StudentInfoEntities student = (StudentInfoEntities)intent.getSerializableExtra("student");
                        student.setSchool(str_school);
                        student.setMajor(str_major);
                        student.setStudent_class(str_stu_class);
                        intent.setClass(SchoolInfoActivity.this,OtherInfoActivity.class);

                        startActivity(intent);
                    }
                }
        );
    }
}

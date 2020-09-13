package com.project.finalwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    final Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.enterSystem).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent.setPackage(getPackageName());
                        intent.setClass(MainActivity.this,BasicInfoActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }


}

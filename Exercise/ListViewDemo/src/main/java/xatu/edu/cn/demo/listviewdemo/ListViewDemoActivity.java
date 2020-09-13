package xatu.edu.cn.demo.listviewdemo;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }

    public  void AdapterButtonOnClick(View v)
    {
        Intent intent=new Intent(this,ListView1Activity.class);
        startActivity(intent);
    }
    public  void ResourceButtonOnClick(View v)
    {
        Intent intent=new Intent(this,ListView2Activity.class);
        startActivity(intent);
    }
    public  void ContactButtonOnClick(View v)
    {
        Intent intent=new Intent(this,ListView3Activity.class);
        startActivity(intent);
    }
}
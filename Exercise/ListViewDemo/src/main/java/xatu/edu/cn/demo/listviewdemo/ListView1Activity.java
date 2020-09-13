package xatu.edu.cn.demo.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListView1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        final TextView textView = (TextView)findViewById(R.id.TextView01);
        ListView listView = (ListView)findViewById(R.id.ListView01);

        List<String> list  = new ArrayList<String>();
        list .add("ListView子项1");
        list .add("ListView子项2");
        list .add("ListView子项3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list );
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
               TextView tv = (TextView)arg1;
                textView.setText(tv.getText());
            }};

        listView.setOnItemClickListener(listViewListener);
    }
}

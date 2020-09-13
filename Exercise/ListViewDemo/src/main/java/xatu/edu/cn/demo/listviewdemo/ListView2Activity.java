package xatu.edu.cn.demo.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListView2Activity extends Activity {

    private ListView lv;
    private  TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        tv1=(TextView)findViewById(R.id.TextView01);
        lv=(ListView)findViewById(R.id.ListView01);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv =(TextView)view;
                tv1.setText(tv.getText());

            }
        });
    }
}

package com.project.servicebonddemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServiceBondDemo extends AppCompatActivity {

    private MathService mathService;
    private boolean isBound=false;
    TextView labelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        labelView=findViewById(R.id.show);
        Button b1 = findViewById(R.id.bind);
        Button b2 = findViewById(R.id.cancel);
        Button b3 = findViewById(R.id.add);
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //如果没有绑定
                        if(!isBound) {
                            final Intent serviceIntent = new Intent(ServiceBondDemo.this
                            ,MathService.class);
                            //第一个参数：即将绑定的服务
                            //第二个参数:绑定成功后，调用该接口中的方法
                            //第三个参数:只要绑定存在，就自动建立服务
                            bindService(serviceIntent,connection,Context.BIND_AUTO_CREATE);
                            isBound=true;
                        }
                    }
                }
        );
        //取消绑定
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 绑定标识false；
                        isBound=false;
                        //传递connection
                        unbindService(connection);
                        mathService=null;
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mathService==null) {
                            labelView.setText("未绑定服务");
                            return;
                        }
                        long a=Math.round(Math.random()*100);
                        long b=Math.round(Math.random()*100);
                        long result=mathService.add(a,b);
                        labelView.setText(String.valueOf(result));
                    }
                }
        );
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mathService=((MathService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mathService=null;
        }
    };
}

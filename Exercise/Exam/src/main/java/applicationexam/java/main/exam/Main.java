package applicationexam.java.main.exam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.i1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main.this,Choice.class);
                        intent.setPackage(getPackageName());
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.i2).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main.this,Choice.class);
                        intent.setPackage(getPackageName());
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.i3).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main.this,Choice.class);
                        intent.setPackage(getPackageName());
                        startActivity(intent);
                    }
                }
        );

        findViewById(R.id.i4).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main.this,Choice.class);
                        intent.setPackage(getPackageName());
                        startActivity(intent);
                    }
                }
        );
    }

    private boolean isExit = false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                this.finish();
            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                isExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        isExit= false;
                    }}, 2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

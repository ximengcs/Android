package xatu.edu.cn.demo.linearlayout;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LinearLayoutActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void VerticalOnClick(View v)
    {
        Intent intent = new Intent(this,LinearVerticalActivity.class);
        startActivity(intent);
    }
    public void HorizentalOnClick(View v)
    {
        Intent intent = new Intent(this,LinearHorizontalActivity.class);
        startActivity(intent);
    }
}
package applicationexam.java.main.exam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Choice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        findViewById(R.id.c1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.model = 0;
                        enter();
                    }
                }
        );
        findViewById(R.id.c1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.model = 1;
                        enter();
                    }
                }
        );
    }

    private void enter() {
        Intent intent = new Intent(Choice.this,TK.class);
        intent.setPackage(getPackageName());
        startActivity(intent);
    }
}

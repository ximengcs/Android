package com.project.testview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    Paint paint = new Paint(Color.RED);

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0,0,100,100,paint);
    }
}

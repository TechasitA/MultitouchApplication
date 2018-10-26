package com.example.pc708.multitouchapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    int x1, x2, y1, y2;
    int titleBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

//        // get bar height
//        Rect rect = new Rect();
//        Window window = getWindow();
//        window.getDecorView().getWindowVisibleDisplayFrame(rect);
//        int statusBarHeight = rect.bottom;
//        int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getBottom();
//        titleBarHeight = contentViewTop - statusBarHeight;
//
//        Log.i("MyLog", Integer.toString(statusBarHeight));
//        Log.i("MyLog", Integer.toString(contentViewTop));
//        Log.i("MyLog", Integer.toString(titleBarHeight));
    }

    class MyView extends View {
        Paint paint = new Paint();

        public MyView(Context context) {super(context);}

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            paint.setColor(Color.GREEN);

            canvas.drawRect(x1, y1, x2, y2, paint);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            x1 = (int) event.getX(0);
            y1 = (int) event.getY(0)- 225;
            x2 = (int) event.getX(1);
            y2 = (int) event.getY(1)- 225;

            setContentView(new MyView(this));
        }

        return super.onTouchEvent(event);
    }
}

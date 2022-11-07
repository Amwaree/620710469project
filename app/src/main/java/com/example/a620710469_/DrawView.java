package com.example.a620710469_;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;



public class DrawView extends View {
    private Paint brush = new Paint();
    private Path path = new Path();

    public DrawView(Context context){
        super(context);

        brush.setAntiAlias(true);
        brush.setStrokeWidth(6f);
        brush.setColor(Color.BLUE);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    public boolean onTouchEvent(MotionEvent pos){

        float x = pos.getX();
        float y = pos.getY();

        switch (pos.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas drawer){
        drawer.drawPath(path, brush);

    }
}


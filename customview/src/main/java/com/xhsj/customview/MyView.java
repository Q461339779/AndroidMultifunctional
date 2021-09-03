package com.xhsj.customview;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint mPaint;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

        mPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(40);
        canvas.drawRect(100,0,200,100,mPaint);
        canvas.restore();

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(100,0,200,100,mPaint);
    }
}

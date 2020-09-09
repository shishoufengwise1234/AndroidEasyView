package com.easy.view.canvas.geometry.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.graphics.PaintKt;

/**
 * Created by shishoufeng on 2020/9/6.
 * email:shoufengshi@lagou.com
 * <p>
 * desc: 自定义 三角形view
 */
public class CustomTriangleView extends View {

    private Context mContext;

    private Paint paint;

    @ColorInt
    private int paintColor = Color.BLACK;

    public CustomTriangleView(Context context) {
        this(context, null);
    }

    public CustomTriangleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;


        paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setColor(paintColor);






    }

    public int getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(int paintColor) {
        this.paintColor = paintColor;
    }
}

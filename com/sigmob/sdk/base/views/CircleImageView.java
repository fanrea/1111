package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CircleImageView extends ImageView {
    protected float a;
    protected boolean b;
    private BitmapShader c;
    private float d;
    private float e;
    private Paint f;
    private Matrix g;
    private RectF h;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.b = false;
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.g = new Matrix();
        this.a = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
    }

    private BitmapShader a() {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return null;
        }
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float fMax = Math.max(this.d / bitmap.getWidth(), this.d / bitmap.getHeight());
        this.g.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.g);
        return bitmapShader;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        BitmapShader bitmapShaderA = a();
        this.c = bitmapShaderA;
        if (bitmapShaderA == null) {
            super.onDraw(canvas);
            return;
        }
        this.f.setShader(bitmapShaderA);
        if (this.b) {
            float f = this.d;
            canvas.drawCircle(f / 2.0f, f / 2.0f, f / 2.0f, this.f);
        } else {
            RectF rectF = this.h;
            float f2 = this.a;
            canvas.drawRoundRect(rectF, f2, f2, this.f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.d = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.e = measuredHeight;
        this.d = Math.min(this.d, measuredHeight);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.h = new RectF(0.0f, 0.0f, getHeight(), getHeight());
    }

    public void setCircle(boolean circle) {
        this.b = circle;
    }
}

package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadProgressBar extends View {
    private float aTn;
    private String atK;
    private Runnable avO;
    Paint bLm;
    Paint cps;
    Paint cpt;
    private Rect cpu;
    private LinearGradient cpv;
    private LinearGradient cpw;
    private LinearGradient cpx;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avO = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.bLm = new Paint(1);
        this.cps = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.cpt = paint;
        paint.setTextSize(com.kwad.sdk.c.a.a.a(context, 16.0f));
        this.cpt.setColor(-1);
        this.cpt.setTextAlign(Paint.Align.CENTER);
        this.cpu = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }

    public void setText(String str) {
        this.atK = str;
        invalidate();
    }

    public void setProgress(float f) {
        this.aTn = f;
        invalidate();
        if (f == 0.0f || f == 100.0f) {
            removeCallbacks(this.avO);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.avO);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            float f = this.aTn;
            if (f <= 0.0f || f >= 100.0f) {
                return;
            }
            this.mStartTime = SystemClock.elapsedRealtime();
            post(this.avO);
            return;
        }
        removeCallbacks(this.avO);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.avO);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.cpv = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.cpw = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.bLm.setShader(this.cpv);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.cpx = linearGradient;
        this.cps.setShader(linearGradient);
        float f = i;
        this.mRectF.set(0.0f, 0.0f, f, i2);
        this.mPath.reset();
        float f2 = f / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.bLm.setShader(this.cpv);
        canvas.drawRect(this.mRectF, this.bLm);
        this.bLm.setShader(this.cpw);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aTn) / 100.0f, getHeight(), this.bLm);
        float f = this.aTn;
        float f2 = 0.0f;
        if (f > 0.0f && f < 100.0f) {
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            float f3 = jElapsedRealtime >= 1500 ? 0.0f : jElapsedRealtime / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.cpx.setLocalMatrix(this.mMatrix);
            this.cps.setShader(this.cpx);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aTn) / 100.0f) * f3, getHeight(), this.cps);
            if (jElapsedRealtime > 500 && jElapsedRealtime <= 1500) {
                f2 = (jElapsedRealtime - 500) / 1000.0f;
            }
            float width = ((getWidth() * this.aTn) / 100.0f) * f2;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.cpx.setLocalMatrix(this.mMatrix);
            this.cps.setShader(this.cpx);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.cps);
        }
        String str = this.atK;
        if (str != null) {
            this.cpt.getTextBounds(str, 0, str.length(), this.cpu);
            canvas.drawText(this.atK, getWidth() / 2.0f, (getHeight() / 2.0f) - ((this.cpu.top + this.cpu.bottom) / 2.0f), this.cpt);
        }
    }
}

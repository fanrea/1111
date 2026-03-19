package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TextProgressBar extends ProgressBar {
    private int XA;
    private Rect XB;
    private int[] XC;
    private int XD;
    private int XE;
    private boolean XF;
    private String Xr;
    private LinearGradient Xs;
    private Matrix Xt;
    private boolean Xu;
    private boolean Xv;
    private boolean Xw;
    private int Xx;
    private int Xy;
    private Drawable Xz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(m.wrapContextIfNeed(context), attributeSet);
        this.Xv = false;
        this.Xw = true;
        this.XB = new Rect();
        sc();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.Xw) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.Xv) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Xr)) {
            Paint paint = this.mPaint;
            String str = this.Xr;
            paint.getTextBounds(str, 0, str.length(), this.XB);
        }
        int height = (getHeight() / 2) - this.XB.centerY();
        Drawable drawable = this.Xz;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.Xz.getIntrinsicHeight();
            int width2 = (((getWidth() - this.XB.width()) - intrinsicWidth) - this.XA) / 2;
            int i = intrinsicWidth + width2;
            this.Xz.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.Xz.draw(canvas);
            width = i + this.XA;
        } else {
            width = (getWidth() / 2) - this.XB.centerX();
        }
        if (this.XC != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f = width;
            if (progress >= f) {
                if (this.Xs == null) {
                    this.Xs = new LinearGradient(f, 0.0f, width + this.XB.width(), 0.0f, this.XC, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.Xt = matrix;
                    this.Xs.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.Xs);
                this.Xt.setScale(((progress - f) * 1.0f) / this.XB.width(), 1.0f, f, 0.0f);
                this.Xs.setLocalMatrix(this.Xt);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Xr, f, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.XF) {
            this.mPaint.setColor(this.XD);
            String str2 = this.Xr;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int iSave = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.XE);
        String str3 = this.Xr;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.XD);
        String str4 = this.Xr;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Xr)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.Xr;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                layoutParams.width = rect.width() + this.Xx + this.Xy;
                i = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            if (layoutParams.height == -2) {
                layoutParams.height = rect.height();
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
        }
        if (this.Xv) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.Xv) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    private void sc() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
        this.XA = com.kwad.sdk.c.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.XD = -1;
        this.XE = -117146;
    }

    private void setProgressText(int i) {
        this.Xr = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void e(String str, int i) {
        this.Xr = str;
        this.Xu = true;
        setProgress(i);
        invalidate();
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.XF = false;
        this.XD = i;
        postInvalidate();
    }

    public final void setTextColor(int i, int i2) {
        this.XF = true;
        this.XD = i;
        this.XE = i2;
        postInvalidate();
    }

    public void setVertical(boolean z) {
        this.Xv = z;
    }

    public void setHasProgress(boolean z) {
        this.Xw = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.Xx = i;
        this.Xy = i3;
    }

    public void setDrawableLeft(Drawable drawable) {
        this.Xz = drawable;
    }

    public void setDrawablePadding(int i) {
        this.XA = i;
    }
}

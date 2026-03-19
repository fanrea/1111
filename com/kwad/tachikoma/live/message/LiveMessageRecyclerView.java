package com.kwad.tachikoma.live.message;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.framework.tachikoma.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class LiveMessageRecyclerView extends b {
    private Paint Dq;
    private Matrix Dr;
    private Shader Ds;
    private int Dt;
    private int Du;
    private int Dv;

    public LiveMessageRecyclerView(Context context) {
        this(context, null);
    }

    public LiveMessageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMessageRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ae();
    }

    private void ae() {
        this.Dq = new Paint();
        this.Ds = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, -16777216, 0, Shader.TileMode.CLAMP);
        this.Dq.setShader(this.Ds);
        this.Dq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.Dr = new Matrix();
        this.Du = com.kwad.tachikoma.t.e.a(getContext(), 36.0f);
        iu();
        this.Dv = getContext().getResources().getDimensionPixelSize(a.C0561a.ksad_live_message_default_height);
    }

    public void setMathHeight(int i) {
        this.Dv = i;
        postInvalidate();
    }

    private void iu() {
        if (Build.VERSION.SDK_INT >= 21) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setCustomFadingEdgeTop(int i) {
        if (this.Dt == i || this.Du <= 0) {
            return;
        }
        this.Dt = i;
        postInvalidate();
    }

    public int getCustomFadingEdgeTop() {
        return this.Dt;
    }

    public void setCustomFadingEdgeLength(int i) {
        this.Du = i;
    }

    public void onMeasure(int i, int i2) {
        int i3 = this.Dv;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = this.Dv;
        if (i > 0) {
            int height = i - getHeight();
            int i2 = this.Du;
            if (i2 > height) {
                c(canvas, i2 - height);
                return;
            }
            return;
        }
        int height2 = getHeight();
        int i3 = this.Du;
        if (height2 > i3 * 2) {
            c(canvas, i3);
        }
    }

    private void c(Canvas canvas, int i) {
        if (i <= 0) {
            return;
        }
        int i2 = this.Dt;
        int width = getWidth();
        this.Dr.setScale(1.0f, i);
        this.Dr.postTranslate(0.0f, i2);
        this.Ds.setLocalMatrix(this.Dr);
        this.Dq.setShader(this.Ds);
        canvas.drawRect(0.0f, 0.0f, width, i2 + i, this.Dq);
    }
}

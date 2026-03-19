package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CircleRippleView extends View {
    private int an;
    private float b;
    private int c;
    private int d;
    private List<Integer> gb;
    private boolean h;
    private int hc;
    private int k;
    private Paint mk;
    private float mq;
    private Paint tc;
    private List<Integer> tt;
    private float u;
    private float uo;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -1;
        this.hc = SupportMenu.CATEGORY_MASK;
        this.b = 18.0f;
        this.c = 3;
        this.u = 50.0f;
        this.an = 2;
        this.h = false;
        this.gb = new ArrayList();
        this.tt = new ArrayList();
        this.k = 24;
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.tc = paint;
        paint.setAntiAlias(true);
        this.tc.setStrokeWidth(this.k);
        this.gb.add(255);
        this.tt.add(0);
        Paint paint2 = new Paint();
        this.mk = paint2;
        paint2.setAntiAlias(true);
        this.mk.setColor(Color.parseColor("#0FFFFFFF"));
        this.mk.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.mq = f;
        this.uo = i2 / 2.0f;
        float f2 = f - (this.k / 2.0f);
        this.u = f2;
        this.b = f2 / 4.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.tc.setShader(new LinearGradient(this.mq, 0.0f, this.uo, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.gb.size()) {
                break;
            }
            Integer num = this.gb.get(i);
            this.tc.setAlpha(num.intValue());
            Integer num2 = this.tt.get(i);
            if (this.b + num2.intValue() < this.u) {
                canvas.drawCircle(this.mq, this.uo, this.b + num2.intValue(), this.tc);
            }
            if (num.intValue() > 0 && num2.intValue() < this.u) {
                this.gb.set(i, Integer.valueOf(num.intValue() - this.an > 0 ? num.intValue() - (this.an * 3) : 1));
                this.tt.set(i, Integer.valueOf(num2.intValue() + this.an));
            }
            i++;
        }
        List<Integer> list = this.tt;
        if (list.get(list.size() - 1).intValue() >= this.u / this.c) {
            this.gb.add(255);
            this.tt.add(0);
        }
        if (this.tt.size() >= 3) {
            this.tt.remove(0);
            this.gb.remove(0);
        }
        this.tc.setAlpha(255);
        this.tc.setColor(this.hc);
        canvas.drawCircle(this.mq, this.uo, this.b, this.mk);
        if (this.h) {
            invalidate();
        }
    }

    public void d() {
        this.h = true;
        invalidate();
    }

    public void hc() {
        this.h = false;
        this.tt.clear();
        this.gb.clear();
        this.gb.add(255);
        this.tt.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.d = i;
    }

    public void setCoreColor(int i) {
        this.hc = i;
    }

    public void setCoreRadius(int i) {
        this.b = i;
    }

    public void setDiffuseWidth(int i) {
        this.c = i;
    }

    public void setMaxWidth(int i) {
        this.u = i;
    }

    public void setDiffuseSpeed(int i) {
        this.an = i;
    }
}

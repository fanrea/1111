package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UGProgressBar extends FrameLayout {
    private View b;
    private TextView c;
    private b d;
    private View hc;
    private int u;

    public UGProgressBar(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        this.hc = new View(context);
        this.b = new View(context);
        addView(this.hc);
        addView(this.b);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hc.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.hc.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams2.width = this.u;
        layoutParams2.gravity = 5;
        this.b.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setTextColor(-1);
        this.c.setTextSize(16.0f);
        this.c.setGravity(17);
        addView(this.c);
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hc.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.hc.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.b.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void setProgressColor(int i) {
        this.hc.setBackgroundColor(i);
    }

    public void setProgressBgColor(int i) {
        this.b.setBackgroundColor(i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.u = i;
        b bVar = this.d;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(i, i2);
        }
        super.onMeasure(i, i2);
        this.u = d(0, i);
    }

    private int d(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void d(b bVar) {
        this.d = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(z);
        }
    }
}

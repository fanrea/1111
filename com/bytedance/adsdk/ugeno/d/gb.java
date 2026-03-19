package com.bytedance.adsdk.ugeno.d;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb implements h {
    private float an;
    private float b;
    private float c;
    private View d;
    private float hc;
    private float u;

    public gb(View view) {
        this.d = view;
    }

    public void d(float f) {
        View view = this.d;
        if (view == null) {
            return;
        }
        this.hc = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float d() {
        return this.hc;
    }

    public void hc(float f) {
        View view = this.d;
        if (view == null) {
            return;
        }
        this.b = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getRipple() {
        return this.b;
    }

    public void b(float f) {
        View view = this.d;
        if (view == null) {
            return;
        }
        this.c = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getShine() {
        return this.c;
    }

    public void c(float f) {
        this.u = f;
        this.d.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getStretch() {
        return this.u;
    }

    public void u(float f) {
        this.an = f;
        this.d.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getRubIn() {
        return this.an;
    }

    public void d(int i) {
        View view = this.d;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}

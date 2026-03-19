package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private AnimatorSet an;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private ImageView hc;
    private int u;

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void d(Context context) {
    }

    public ClickSlideUpView2(Context context) {
        super(context);
        this.an = new AnimatorSet();
        hc(context);
    }

    private void hc(Context context) {
        addView(com.bytedance.sdk.component.adexpress.b.d.hc(context));
        this.hc = (ImageView) findViewById(2097610751);
        this.b = (ImageView) findViewById(2097610750);
        this.c = (ImageView) findViewById(2097610749);
        this.d = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setText(str);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.u;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + 195;
        this.c.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + 195;
        this.b.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + 195;
        this.hc.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void d() {
        c();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void hc() {
        this.an.cancel();
    }
}

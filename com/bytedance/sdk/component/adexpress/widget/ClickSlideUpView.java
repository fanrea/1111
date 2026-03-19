package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ClickSlideUpView extends SlideUpView {
    private AnimatorSet b;
    private TextView d;
    private View hc;

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void d(Context context) {
    }

    public ClickSlideUpView(Context context) throws Resources.NotFoundException {
        super(context);
        this.b = new AnimatorSet();
        hc(context);
    }

    private void hc(Context context) throws Resources.NotFoundException {
        View viewD = com.bytedance.sdk.component.adexpress.b.d.d(context);
        this.hc = viewD;
        addView(viewD);
        setClipChildren(false);
        this.d = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setText(str);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hc, "translationY", 0.0f, gb.d(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hc, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.b.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.b.setDuration(1000L);
        this.b.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void d() {
        c();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void hc() {
        this.b.cancel();
    }
}

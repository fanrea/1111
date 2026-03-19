package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ClickInteractView extends FrameLayout {
    private ImageView d;
    private AnimatorSet hc;

    public ClickInteractView(Context context) {
        super(context);
        b();
        c();
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        this.d = imageView;
        imageView.setImageResource(jh.u(getContext(), "tt_white_hand"));
        int iD = (int) gb.d(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iD, iD);
        layoutParams.gravity = 17;
        addView(this.d, layoutParams);
    }

    private void c() {
        this.hc = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.hc.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void d() {
        AnimatorSet animatorSet = this.hc;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void hc() {
        AnimatorSet animatorSet = this.hc;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}

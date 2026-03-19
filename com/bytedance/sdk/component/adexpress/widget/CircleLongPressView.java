package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.adexpress.c.tt;
import com.bytedance.sdk.component.utils.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CircleLongPressView extends FrameLayout {
    private AnimatorSet an;
    private ImageView b;
    private TextView c;
    private Context d;
    private ImageView hc;
    private RingProgressView u;

    public CircleLongPressView(Context context) {
        super(context);
        this.an = new AnimatorSet();
        this.d = context;
        u();
        an();
    }

    private void u() {
        FrameLayout frameLayout = new FrameLayout(this.d);
        this.u = new RingProgressView(this.d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gb.d(this.d, 95.0f), (int) gb.d(this.d, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.u, layoutParams);
        this.hc = new ImageView(this.d);
        int iD = j.d(this.d, 60.0f);
        this.hc.setImageDrawable(tt.d(1, null, null, new int[]{iD, iD}, Integer.valueOf(j.d(this.d, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gb.d(this.d, 75.0f), (int) gb.d(this.d, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.hc, layoutParams2);
        this.b = new ImageView(this.d);
        int iD2 = j.d(this.d, 50.0f);
        this.b.setImageDrawable(tt.d(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iD2, iD2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) gb.d(this.d, 63.0f), (int) gb.d(this.d, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.b, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.d);
        this.c = textView;
        textView.setTextColor(-1);
        this.c.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.c, layoutParams4);
    }

    private void an() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.an.setDuration(800L);
        this.an.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.c.setText(str);
    }

    public void d() {
        this.an.start();
    }

    public void hc() {
        this.an.cancel();
    }

    public void b() {
        this.u.d();
    }

    public void c() {
        this.u.hc();
        this.u.b();
    }
}

package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class au extends v {
    private as a;
    private at b;
    private ObjectAnimator c;
    private boolean d;

    public au(Context context) {
        super(context);
        c();
    }

    public au(Context context, AttributeSet attrs) {
        super(context, attrs);
        c();
    }

    public au(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        c();
    }

    private void c() {
        addView(new f(getContext()), new FrameLayout.LayoutParams(-1, -1));
        this.a = new as(getContext());
        this.b = new at(getContext());
        addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, (Property<at, Float>) View.ROTATION_Y, -45.0f, 0.0f, 45.0f);
        this.c = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(1000L);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(2);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.d = true;
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.c.start();
        }
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.d = false;
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }
}

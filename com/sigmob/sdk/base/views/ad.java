package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ad extends RelativeLayout {
    public static final int a = 1;
    public static final int b = 2;
    private ImageView c;
    private TextView d;
    private TextView e;
    private AnimatorSet f;
    private ObjectAnimator g;
    private ObjectAnimator h;
    private View i;
    private boolean j;

    /* renamed from: com.sigmob.sdk.base.views.ad$1, reason: invalid class name */
    class AnonymousClass1 implements Animator.AnimatorListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (ad.this.j) {
                return;
            }
            ad.this.g.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.ad$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            }, 300L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public ad(Context context) {
        super(context);
        a(context);
    }

    public ad(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public ad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, b(context), this);
        this.c = (ImageView) findViewById(ResourceUtil.getId(context, "sig_shakeImageView"));
        this.d = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeTitleView"));
        this.e = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeDescView"));
        this.i = findViewById(ResourceUtil.getId(context, "sig_shake_view"));
        c();
        b();
    }

    private int b(Context context) {
        return ResourceUtil.getLayoutId(context, "sig_shake_view_layout");
    }

    private void b() {
        int i = this.c.getLayoutParams().height;
        this.c.setPivotX(this.c.getLayoutParams().width);
        this.c.setPivotY(i * 0.8f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "rotation", 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.g = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.g.addListener(new AnonymousClass1());
        this.g.setDuration(1500L);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.i, "translationY", 0.0f, 30.0f, 0.0f, -30.0f, 0.0f);
        this.h = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.h.setRepeatCount(2);
        this.h.setDuration(400L);
    }

    void a() {
        this.h.start();
    }

    public void a(int animatorType) {
        ObjectAnimator objectAnimator;
        if (animatorType != 1) {
            this.j = true;
            this.g.cancel();
            objectAnimator = this.h;
        } else {
            objectAnimator = this.g;
        }
        objectAnimator.start();
    }
}

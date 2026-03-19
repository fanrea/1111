package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ac extends v {
    private ImageView a;
    private ObjectAnimator b;
    private boolean c;
    private f d;

    /* renamed from: com.sigmob.sdk.base.views.ac$2, reason: invalid class name */
    class AnonymousClass2 implements Animator.AnimatorListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            ac.this.b.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (ac.this.c) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.ac$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                }, 300L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public ac(Context context) throws Resources.NotFoundException {
        super(context);
        c();
    }

    public ac(Context context, AttributeSet attrs) throws Resources.NotFoundException {
        super(context, attrs);
        c();
    }

    public ac(Context context, AttributeSet attrs, int defStyleAttr) throws Resources.NotFoundException {
        super(context, attrs, defStyleAttr);
        c();
    }

    private void c() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        f fVar = new f(getContext());
        this.d = fVar;
        addView(fVar, layoutParams);
        int iDipsToIntPixels = Dips.dipsToIntPixels(45.0f, getContext());
        this.a = new ImageView(getContext());
        this.a.setImageDrawable(getResources().getDrawable(ResourceUtil.getDrawableId(getContext(), "sig_image_shake_new")));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams2.addRule(13);
        addView(this.a, layoutParams2);
        d();
    }

    private void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.ac.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = ac.this.getHeight();
                int width = ac.this.getWidth();
                if (height == 0 || width == 0) {
                    return;
                }
                ac.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = ac.this.a.getLayoutParams();
                int i = height / 2;
                layoutParams.width = i;
                layoutParams.height = i;
                ac.this.a.setLayoutParams(layoutParams);
                float f = height / 2.0f;
                ac.this.a.setPivotX(f);
                ac.this.a.setPivotY(f * 0.8f);
            }
        });
    }

    private void e() {
        if (this.b != null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "rotation", 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.b = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.b.addListener(new AnonymousClass2());
        this.b.setDuration(1200L);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null && !this.c) {
            objectAnimator.start();
        }
        this.c = true;
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.c = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        d();
        e();
        if (this.c) {
            this.b.cancel();
            this.b.start();
        }
    }
}

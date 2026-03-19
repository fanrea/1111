package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsRotateTypeTwoView extends c {
    private ImageView LT;
    private ImageView LU;
    private int LV;
    private ImageView jY;

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return 500;
    }

    public KsRotateTypeTwoView(Context context) {
        super(context);
    }

    public KsRotateTypeTwoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateTypeTwoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.LV = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_rotate_combo_phone);
        typedArrayObtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.LT = imageView;
        imageView.setImageResource(R.drawable.ksad_splash_rotate_combo_left_arrow);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 5.0f), com.kwad.sdk.c.a.a.a(context, 14.0f));
        layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(context, 2.0f);
        layoutParams.gravity = 16;
        addView(this.LT, layoutParams);
        this.jY = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 15.0f), com.kwad.sdk.c.a.a.a(context, 23.0f));
        layoutParams2.leftMargin = com.kwad.sdk.c.a.a.a(context, 9.0f);
        layoutParams2.gravity = 16;
        addView(this.jY, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        this.LU = imageView2;
        imageView2.setImageResource(R.drawable.ksad_splash_rotate_combo_right_arrow);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 5.0f), com.kwad.sdk.c.a.a.a(context, 14.0f));
        layoutParams3.leftMargin = com.kwad.sdk.c.a.a.a(context, 26.0f);
        layoutParams3.gravity = 16;
        addView(this.LU, layoutParams3);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void ny() {
        ImageView imageView = this.jY;
        if (imageView != null) {
            imageView.setImageResource(this.LV);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fS() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, -25.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, "rotation", -25.0f, 25.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, "rotation", 25.0f, -12.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "rotation", -12.0f, 0.0f).setDuration(100L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nz() {
        getInteractionView().setRotation(0.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.jY;
    }
}

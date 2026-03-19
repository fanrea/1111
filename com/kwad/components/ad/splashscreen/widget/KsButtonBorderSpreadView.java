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
public class KsButtonBorderSpreadView extends c {
    private ImageView LP;
    private int LQ;

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return 0;
    }

    public KsButtonBorderSpreadView(Context context) {
        super(context);
    }

    public KsButtonBorderSpreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsButtonBorderSpreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.LQ = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_shake_combo_border);
        typedArrayObtainStyledAttributes.recycle();
        this.LP = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 267.0f), com.kwad.sdk.c.a.a.a(context, 66.0f));
        layoutParams.gravity = 17;
        addView(this.LP, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void ny() {
        this.LP.setImageResource(this.LQ);
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(interactionView, "scaleX", 1.0f, 1.1f).setDuration(1000L), ObjectAnimator.ofFloat(interactionView, "scaleY", 1.0f, 1.4f).setDuration(1000L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 0.0f).setDuration(1000L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nz() {
        getInteractionView().setScaleX(1.0f);
        getInteractionView().setScaleY(1.0f);
        getInteractionView().setAlpha(1.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.LP;
    }
}

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
public class KsSlideArrowView extends c {
    private ImageView Mm;
    private int Mn;
    private int Mo;

    public KsSlideArrowView(Context context) {
        super(context);
        this.Mo = 0;
    }

    public KsSlideArrowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mo = 0;
    }

    public KsSlideArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Mo = 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Mn = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_slide_tag);
        typedArrayObtainStyledAttributes.recycle();
        this.Mm = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.Mm.setScaleType(ImageView.ScaleType.FIT_XY);
        this.Mm.setAlpha(0.0f);
        addView(this.Mm, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void ny() {
        ImageView imageView = this.Mm;
        if (imageView != null) {
            imageView.setImageResource(this.Mn);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fS() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 0.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 0.0f).setDuration(200L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nz() {
        getInteractionView().setAlpha(1.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.Mm;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return this.Mo;
    }

    public void setAnimationDelayTime(int i) {
        this.Mo = i;
    }
}

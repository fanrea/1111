package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class c extends KSFrameLayout {
    private Animator rS;
    private boolean rT;

    protected void a(Context context, AttributeSet attributeSet, int i) {
    }

    protected abstract Animator fS();

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected abstract void ny();

    protected abstract void nz();

    public c(Context context) {
        this(context, null, 0);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rT = false;
        a(context, attributeSet, i);
        ny();
    }

    public final void fR() {
        Animator animator = this.rS;
        if (animator != null) {
            animator.cancel();
            this.rS = null;
        }
        Animator animatorFS = fS();
        this.rS = animatorFS;
        if (animatorFS != null) {
            animatorFS.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (c.this.rT) {
                        return;
                    }
                    c.this.getInteractionView().postDelayed(new bh() { // from class: com.kwad.components.ad.splashscreen.widget.c.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            if (c.this.rS != null) {
                                c.this.rS.start();
                            }
                        }
                    }, c.this.getAnimationDelayTime());
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    c.this.nz();
                }
            });
            this.rS.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        Animator animator = this.rS;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void nA() {
        this.rT = true;
        Animator animator = this.rS;
        if (animator != null) {
            animator.cancel();
        }
    }
}

package com.kwad.components.ct.home.refreshview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.components.ct.refreshview.d;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsAdHotShootRefreshView extends RelativeLayout implements d {
    private static final float aKG = a.a(ServiceProvider.getContext(), 10.0f);
    private RefreshLayout.b aKD;
    private LottieAnimationView anA;

    @Override // com.kwad.components.ct.refreshview.d
    public final int GV() {
        return 200;
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void reset() {
    }

    public KsAdHotShootRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
        this.anA = lottieAnimationView;
        lottieAnimationView.setVisibility(0);
        com.kwad.components.ct.d.a.Jd().b(this.anA, false);
        this.anA.setRepeatMode(1);
        this.anA.setRepeatCount(-1);
    }

    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.aKD = bVar;
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void GT() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getTop(), 0);
        valueAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ct.home.refreshview.KsAdHotShootRefreshView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                KsAdHotShootRefreshView.this.setTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.home.refreshview.KsAdHotShootRefreshView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (KsAdHotShootRefreshView.this.aKD != null) {
                    KsAdHotShootRefreshView.this.aKD.onRefresh();
                } else {
                    GW();
                }
            }

            private void GW() {
                if (KsAdHotShootRefreshView.this.anA != null) {
                    KsAdHotShootRefreshView.this.anA.post(new bh() { // from class: com.kwad.components.ct.home.refreshview.KsAdHotShootRefreshView.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            if (KsAdHotShootRefreshView.this.aKD != null) {
                                KsAdHotShootRefreshView.this.aKD.onRefresh();
                            }
                        }
                    });
                }
            }
        });
        valueAnimatorOfInt.start();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void GU() {
        setAlpha(0.0f);
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void x(float f) {
        float f2 = aKG;
        if (f < f2) {
            setAlpha(0.0f);
            if (this.anA.isAnimating()) {
                this.anA.Qa();
                return;
            }
            return;
        }
        if (!this.anA.isAnimating()) {
            this.anA.PZ();
        }
        setAlpha(Math.min(1.0f, (f - f2) / (f2 * 2.0f)));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}

package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.msdk.d.u.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RefreshableBannerView extends FrameLayout {
    private d an;
    private boolean b;
    private final Rect c;
    private boolean d;
    private boolean hc;
    private final ViewTreeObserver.OnScrollChangedListener u;

    public interface d {
        void d(boolean z);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.d = true;
        this.hc = true;
        this.b = true;
        this.c = new Rect();
        this.u = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.hc = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.c);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.d(refreshableBannerView2.hc);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.u);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.u);
    }

    public void d(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        b.d("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        this.d = z;
        d(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        boolean z2 = this.d && this.hc;
        if (z) {
            if (!z2 || this.b) {
                return;
            }
            this.b = true;
            d dVar = this.an;
            if (dVar != null) {
                dVar.d(true);
                return;
            }
            return;
        }
        if (z2 || !this.b) {
            return;
        }
        this.b = false;
        d dVar2 = this.an;
        if (dVar2 != null) {
            dVar2.d(false);
        }
    }

    public void setVisibilityChangeListener(d dVar) {
        this.an = dVar;
    }
}

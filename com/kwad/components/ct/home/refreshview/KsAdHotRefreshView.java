package com.kwad.components.ct.home.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.components.ct.refreshview.b;
import com.kwad.components.ct.refreshview.d;
import com.kwad.components.ct.refreshview.e;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsAdHotRefreshView extends e {
    private static final float aKC = com.kwad.sdk.c.a.a.a(ServiceProvider.getContext(), 37.5f);
    private RefreshLayout.b aKD;
    private LottieAnimationView anA;

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    public final int ct(int i) {
        return i;
    }

    public KsAdHotRefreshView(Context context) {
        this(context, null);
    }

    public KsAdHotRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setRefreshTargetOffset(aKC - 1.0f);
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.aKD = bVar;
        super.setOnRefreshListener(new RefreshLayout.b() { // from class: com.kwad.components.ct.home.refreshview.KsAdHotRefreshView.1
            @Override // com.kwad.components.ct.refreshview.RefreshLayout.b
            public final void onRefresh() {
                if (KsAdHotRefreshView.this.aSi instanceof KsAdHotShootRefreshView) {
                    ((KsAdHotShootRefreshView) KsAdHotRefreshView.this.aSi).setOnRefreshListener(KsAdHotRefreshView.this.aKD);
                }
            }
        });
    }

    static class a implements Runnable {
        private final boolean aKF;
        private WeakReference<KsAdHotRefreshView> abc;

        a(KsAdHotRefreshView ksAdHotRefreshView, boolean z) {
            this.abc = new WeakReference<>(ksAdHotRefreshView);
            this.aKF = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KsAdHotRefreshView ksAdHotRefreshView = this.abc.get();
            if (ksAdHotRefreshView != null) {
                if (!ksAdHotRefreshView.isRefreshing() && ksAdHotRefreshView.aSj != null) {
                    ksAdHotRefreshView.aSj.GU();
                }
                ksAdHotRefreshView.bV(this.aKF);
            }
        }
    }

    public final boolean GQ() {
        return this.aSi.getVisibility() == 0 && this.aSi.getAlpha() != 0.0f;
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    public void setRefreshing(boolean z) {
        if (!z) {
            postDelayed(new a(this, z), 600L);
        } else {
            super.setRefreshing(z);
        }
    }

    public final void bV(boolean z) {
        super.setRefreshing(z);
    }

    @Override // com.kwad.components.ct.refreshview.e, com.kwad.components.ct.refreshview.RefreshLayout
    public final void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_hot_shoot_refresh_view_2, (ViewGroup) this, true);
        this.aSi = findViewById(R.id.ksad_shoot_refresh_view);
        this.aSi.setVisibility(8);
        this.anA = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
        com.kwad.components.ct.d.a.Jd().b(this.anA, false);
        if (this.aSi instanceof d) {
            this.aSj = (d) this.aSi;
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    @Override // com.kwad.components.ct.refreshview.e, com.kwad.components.ct.refreshview.RefreshLayout
    public final b GR() {
        return new b() { // from class: com.kwad.components.ct.home.refreshview.KsAdHotRefreshView.2
            @Override // com.kwad.components.ct.refreshview.b
            public final float w(float f) {
                return Math.min(KsAdHotRefreshView.aKC, 200.0f - (80000.0f / (f + 400.0f)));
            }
        };
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    public final void a(int i, Animation.AnimationListener animationListener) {
        if (this.aSi.getTop() == 0 || this.aSi.getTop() == getRefreshTargetOffset()) {
            this.aSi.setTop(0);
            clearAnimation();
            this.anA.Qa();
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        super.a(i, animationListener);
    }
}

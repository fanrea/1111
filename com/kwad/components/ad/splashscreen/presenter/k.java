package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends e implements com.kwad.sdk.core.j.c {
    private View Iu;
    private View Iv;
    private ViewTreeObserver.OnGlobalLayoutListener Iw;
    private boolean It = false;
    private boolean Ix = false;

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
    }

    static /* synthetic */ boolean a(k kVar, View view) {
        return v(view);
    }

    static /* synthetic */ boolean a(k kVar, boolean z) {
        kVar.It = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.HX.mAdTemplate.addStartTime = SystemClock.elapsedRealtime();
        this.HX.Hk.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.f(this.HX.mAdTemplate, SystemClock.elapsedRealtime() - this.HX.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.aq(this.HX.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cT(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate))) {
            this.HX.U(getContext());
        }
        try {
            this.Iv = getRootView();
            this.Iw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ad.splashscreen.presenter.k.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    try {
                        if (k.this.Iu == null || k.this.Iv == null || k.this.Iu.getVisibility() != 0 || k.this.It) {
                            return;
                        }
                        k.a(k.this, true);
                        com.kwad.components.ad.splashscreen.monitor.b.md();
                        com.kwad.components.ad.splashscreen.monitor.b.ak(k.this.HX.mAdTemplate);
                        k.this.Iv.postDelayed(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.k.1.1
                            @Override // com.kwad.sdk.utils.bh
                            public final void doTask() {
                                if (k.this.Iv.getVisibility() == 0) {
                                    if (k.this.HX.mAdTemplate.mPvReported) {
                                        com.kwad.components.ad.splashscreen.monitor.b.md();
                                        com.kwad.components.ad.splashscreen.monitor.b.al(k.this.HX.mAdTemplate);
                                        return;
                                    }
                                    if (!k.this.HX.Hk.wO()) {
                                        boolean zA = k.a(k.this, k.this.Iv);
                                        boolean z = false;
                                        if (k.this.Iu != null && k.this.Iu.getVisibility() == 0) {
                                            z = true;
                                        }
                                        com.kwad.components.ad.splashscreen.monitor.b.md();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(k.this.HX.mAdTemplate, zA, z, k.this.Ix);
                                        return;
                                    }
                                    com.kwad.components.ad.splashscreen.monitor.b.md();
                                    com.kwad.components.ad.splashscreen.monitor.b.am(k.this.HX.mAdTemplate);
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.md();
                                com.kwad.components.ad.splashscreen.monitor.b.an(k.this.HX.mAdTemplate);
                            }
                        }, 1000L);
                    } catch (Throwable unused) {
                    }
                }
            };
            if (this.Iv != null && getRootView().getParent() != null && (getRootView().getParent() instanceof View)) {
                View view = (View) getRootView().getParent();
                this.Iu = view;
                if (view.getViewTreeObserver() != null) {
                    this.Iu.getViewTreeObserver().addOnGlobalLayoutListener(this.Iw);
                    return;
                }
                return;
            }
            if (this.Iv == null) {
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.ao(this.HX.mAdTemplate);
            } else {
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.ap(this.HX.mAdTemplate);
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Ix = true;
        this.HX.Hk.b(this);
        View view = this.Iu;
        if (view != null && view.getViewTreeObserver() != null && this.Iw != null) {
            this.Iu.getViewTreeObserver().removeOnGlobalLayoutListener(this.Iw);
        }
        this.Iu = null;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        this.HX.U(getContext());
    }

    private static boolean v(View view) {
        if (view == null) {
            return false;
        }
        com.kwad.sdk.core.c.b.aaf();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.aaf();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && ca.a(view, 70, true);
        }
        return ca.a(view, 70, true);
    }
}

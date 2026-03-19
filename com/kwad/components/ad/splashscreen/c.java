package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.ad.splashscreen.presenter.k;
import com.kwad.components.ad.splashscreen.presenter.r;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.core.n.d<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener GW;
    private com.kwad.components.ad.splashscreen.e.d GX;
    private com.kwad.sdk.core.j.b fa;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    @Override // com.kwad.components.core.n.d
    public final boolean am() {
        return true;
    }

    private c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        this.mAdTemplate = adTemplateS;
        this.mAdScene = adTemplateS.mAdScene;
        qG();
    }

    public static c a(Context context, AdResultData adResultData, boolean z, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) throws Throwable {
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        c cVar = null;
        try {
            adTemplateS.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.aj(adTemplateS);
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplateS, l.UL().Vp(), z);
            c cVar2 = new c(m.wrapContextIfNeed(context), adResultData);
            try {
                cVar2.setPageExitListener(bVar);
                cVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
                return cVar2;
            } catch (Throwable th) {
                th = th;
                cVar = cVar2;
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplateS, th.toString(), z);
                if (l.UL().TQ()) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    return cVar;
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.fa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* renamed from: lC, reason: merged with bridge method [inline-methods] */
    public h ap() {
        com.kwad.components.ad.splashscreen.e.d dVar = new com.kwad.components.ad.splashscreen.e.d(this.pQ, com.kwad.sdk.core.response.b.a.cU(this.mAdInfo));
        this.GX = dVar;
        dVar.a(this.fa);
        this.GX.wK();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.a(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.GW);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.Hk = this.GX;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.Hj = d(this.mAdTemplate);
        hVar.mTimerHelper = new bw();
        if (com.kwad.sdk.core.response.b.a.bi(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.Hi = aVar;
            hVar.Hk.a(aVar);
        }
        hVar.Hk.a(a(hVar));
        return hVar;
    }

    private com.kwad.sdk.core.j.c a(final h hVar) {
        return new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                if (hVar.mTimerHelper != null) {
                    hVar.mTimerHelper.AG();
                }
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                if (hVar.mTimerHelper != null) {
                    hVar.mTimerHelper.AH();
                }
            }
        };
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.GW = splashScreenAdInteractionListener;
        if (this.Tj != 0) {
            ((h) this.Tj).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = ksVideoPlayConfigBuild;
        this.mAdTemplate.mInitVoiceStatus = ksVideoPlayConfigBuild.isVideoSoundEnable() ? 2 : 1;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.n.d
    public final void ao() {
        this.mRootContainer = (AdBaseFrameLayout) this.pQ.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.pQ.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.c.a.a.Wl() || !c.n(c.this.mAdInfo) || c.this.Tj == null) {
                    return;
                }
                ((h) c.this.Tj).c(1, view.getContext(), 53, 2);
            }
        });
    }

    private int getSplashLayoutId() {
        return R.layout.ksad_splash_screen_layout;
    }

    @Override // com.kwad.components.core.n.d
    public final Presenter onCreatePresenter() {
        getContext();
        return ac(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        post(new bh() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (h.ad(adTemplate) || ((h) c.this.Tj).Hi == null) {
                    return;
                }
                ((h) c.this.Tj).Hi.no();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void af() {
        /*
            r5 = this;
            super.af()
            r0 = 0
            android.view.View r1 = r5.getRootView()     // Catch: java.lang.Throwable -> L46
            r2 = 1
            if (r1 == 0) goto L17
            android.view.View r1 = r5.getRootView()     // Catch: java.lang.Throwable -> L46
            int r1 = r1.getVisibility()     // Catch: java.lang.Throwable -> L46
            if (r1 != 0) goto L17
            r1 = r2
            goto L18
        L17:
            r1 = r0
        L18:
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L47
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L47
            android.view.ViewParent r3 = r3.getParent()     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L47
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L47
            android.view.ViewParent r3 = r3.getParent()     // Catch: java.lang.Throwable -> L47
            boolean r3 = r3 instanceof android.view.View     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L47
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L47
            android.view.ViewParent r3 = r3.getParent()     // Catch: java.lang.Throwable -> L47
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> L47
            int r3 = r3.getVisibility()     // Catch: java.lang.Throwable -> L47
            if (r3 != 0) goto L47
            r0 = r2
            goto L47
        L46:
            r1 = r0
        L47:
            com.kwad.components.ad.splashscreen.monitor.b.md()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r5.mAdTemplate
            com.kwad.sdk.l r3 = com.kwad.sdk.l.UL()
            long r3 = r3.Vp()
            com.kwad.components.ad.splashscreen.monitor.b.a(r2, r3, r1, r0)
            com.kwad.components.core.e.d.c r0 = r5.mApkDownloadHelper
            if (r0 == 0) goto L64
            r1 = 0
            r0.setOnDismissListener(r1)
            com.kwad.components.core.e.d.c r0 = r5.mApkDownloadHelper
            r0.setOnShowListener(r1)
        L64:
            com.kwad.components.ad.splashscreen.e.d r0 = r5.GX
            r0.wL()
            r5.lD()
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            com.kwai.adclient.kscommerciallogger.model.BusinessType r0 = com.kwad.sdk.commercial.d.bt(r0)
            com.kwad.components.core.g.a.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.c.af():void");
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    private void lD() {
        com.kwad.sdk.a.a.c.VC().VE();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean zPh = dialogInterface instanceof com.kwad.components.core.e.c.b ? ((com.kwad.components.core.e.c.b) dialogInterface).ph() : false;
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
            if (splashScreenAdInteractionListener != null) {
                if (zPh) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private static StyleTemplate d(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.ej(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateK != null) {
            styleTemplate.templateId = matrixTemplateK.templateId;
            styleTemplate.templateMd5 = matrixTemplateK.templateMd5;
            styleTemplate.templateUrl = matrixTemplateK.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateK.templateVersionCode;
        }
        return styleTemplate;
    }

    public static boolean n(AdInfo adInfo) {
        return adInfo.adSplashInfo != null && adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    private static Presenter ac(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, adInfoEP);
        if (h.ad(adTemplate)) {
            presenter.d(new com.kwad.components.ad.splashscreen.presenter.playcard.a());
        } else {
            presenter.d(new j());
        }
        return presenter;
    }

    private static void a(Presenter presenter, AdInfo adInfo) {
        presenter.d(new k());
        presenter.d(new r());
        if (h.r(adInfo)) {
            presenter.d(new com.kwad.components.ad.splashscreen.presenter.endcard.f());
        }
    }
}

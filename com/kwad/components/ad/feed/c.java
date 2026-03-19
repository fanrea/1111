package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.feed.widget.r;
import com.kwad.components.ad.feed.widget.s;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    private final KsAdVideoPlayConfig dG;
    private KsFeedAd.AdInteractionListener iB;
    private com.kwad.components.core.widget.b iC;
    private s iD;
    private boolean iE;
    private final AdInfo mAdInfo;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private AtomicBoolean iF = new AtomicBoolean(false);
    private AtomicBoolean iG = new AtomicBoolean(false);
    private AtomicInteger iH = new AtomicInteger(2);
    private com.kwad.components.core.internal.api.c dl = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.j.b fa = new com.kwad.sdk.core.j.b() { // from class: com.kwad.components.ad.feed.c.1
        @Override // com.kwad.sdk.core.j.b
        public final void aP() {
            c.this.dl.h(c.this);
        }

        @Override // com.kwad.sdk.core.j.b
        public final void aQ() {
            c.this.dl.i(c.this);
        }
    };

    public interface a {
        void d(int i, String str);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.dl.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.dl.b(bVar);
    }

    public c(AdResultData adResultData, boolean z) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        this.mAdTemplate = adTemplateS;
        adTemplateS.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplateS);
        this.iE = z;
        this.dG = new KSAdVideoPlayConfigImpl();
        com.kwad.components.ad.i.b.fW().a(this);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        this.dG.setVideoSoundEnable(z);
        if (this.dG.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void render(final KsFeedAd.AdRenderListener adRenderListener) {
        com.kwad.components.ad.feed.monitor.b.o(this.mAdTemplate);
        if (this.iG.get()) {
            if (this.iC == null) {
                adRenderListener.onAdRenderFailed(com.kwad.sdk.core.network.e.bCD.errorCode, com.kwad.sdk.core.network.e.bCD.msg);
                this.iG.set(false);
                this.iF.set(false);
                return;
            }
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.c.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    adRenderListener.onAdRenderSuccess(c.this.iC);
                    com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bh(c.this.mAdInfo), c.this.iH.get());
                }
            });
            return;
        }
        if (this.iF.get()) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final int i = com.kwad.sdk.core.response.b.b.dA(this.mAdTemplate) ? 3 : 2;
        this.iF.set(true);
        a(new a() { // from class: com.kwad.components.ad.feed.c.3
            @Override // com.kwad.components.ad.feed.c.a
            public final void d(int i2, String str) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.getAdTemplate(), i2, i, SystemClock.elapsedRealtime() - jElapsedRealtime, str);
                c.this.iH.set(i2);
                c.this.iG.set(true);
                try {
                    if (adRenderListener != null) {
                        if (c.this.iC == null) {
                            adRenderListener.onAdRenderFailed(com.kwad.sdk.core.network.e.bCD.errorCode, com.kwad.sdk.core.network.e.bCD.msg);
                        } else {
                            bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.3.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    adRenderListener.onAdRenderSuccess(c.this.iC);
                                    com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bh(c.this.mAdInfo), c.this.iH.get());
                                }
                            });
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.dG.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.dG.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            } else if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.dG.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.dG.setDataFlowAutoStart(com.kwad.sdk.core.config.e.Ym());
                try {
                    this.dG.setVideoAutoPlayType(0);
                } catch (NoSuchMethodError unused) {
                } catch (Throwable th) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }
            com.kwad.components.core.widget.b bVar = this.iC;
            if (bVar instanceof r) {
                ((r) bVar).setVideoPlayConfig(this.dG);
            }
            com.kwad.components.core.widget.b bVar2 = this.iC;
            if (bVar2 instanceof s) {
                ((s) bVar2).setVideoPlayConfig(this.dG);
            }
            com.kwad.components.core.widget.b bVar3 = this.iC;
            if (bVar3 instanceof com.kwad.components.ad.feed.widget.c) {
                ((com.kwad.components.ad.feed.widget.c) bVar3).setVideoPlayConfig(this.dG);
            }
        }
        if (isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dG;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.b.a.cj(this.mAdInfo);
    }

    public final void a(final a aVar) {
        Context context = ServiceProvider.getContext();
        this.mAdTemplate.loadType = 2;
        this.iF.set(true);
        com.kwad.components.core.widget.b<?, ?> bVarC = C(context);
        this.iC = bVarC;
        if (bVarC != null) {
            if (bVarC instanceof r) {
                r rVar = (r) bVarC;
                rVar.setPreloadListener(new r.a() { // from class: com.kwad.components.ad.feed.c.4
                    @Override // com.kwad.components.ad.feed.widget.r.a
                    public final void d(int i, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.iC, false);
                        c.this.iG.set(true);
                        aVar.d(i, str);
                    }
                });
                rVar.d(this.mAdResultData);
                return;
            } else {
                if (bVarC instanceof s) {
                    s sVar = (s) bVarC;
                    sVar.setTKLoadListener(new s.a() { // from class: com.kwad.components.ad.feed.c.5
                        @Override // com.kwad.components.ad.feed.widget.s.a
                        public final void d(int i, String str) {
                            c cVar = c.this;
                            cVar.a(cVar.iC, false);
                            c.this.iG.set(true);
                            aVar.d(i, str);
                        }
                    });
                    sVar.d(this.mAdResultData);
                    return;
                }
                bVarC.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.iC;
                if (bVar instanceof com.kwad.components.ad.feed.widget.c) {
                    ((com.kwad.components.ad.feed.widget.c) bVar).b(this.dG);
                }
                a(this.iC, true);
                this.iG.set(true);
                aVar.d(1, "");
                return;
            }
        }
        this.iG.set(false);
        this.iF.set(false);
        aVar.d(1, "render Failed");
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.iB = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.Yf()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bk(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aU(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        if (context == null || !l.UL().TT()) {
            return null;
        }
        try {
            Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
            com.kwad.sdk.commercial.d.c.bZ(this.mAdTemplate);
            com.kwad.components.core.widget.b bVar = this.iC;
            if (bVar != null) {
                try {
                    if (bVar.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.iC.getParent()).removeView(this.iC);
                    }
                } catch (NullPointerException unused) {
                }
                return this.iC;
            }
            cc();
            this.mAdTemplate.loadType = 1;
            com.kwad.components.core.widget.b<?, ?> bVarC = C(contextWrapContextIfNeed);
            this.iC = bVarC;
            if (bVarC == null) {
                return null;
            }
            bVarC.d(this.mAdResultData);
            com.kwad.components.core.widget.b bVar2 = this.iC;
            if (bVar2 instanceof com.kwad.components.ad.feed.widget.c) {
                ((com.kwad.components.ad.feed.widget.c) bVar2).b(this.dG);
            }
            com.kwad.components.core.widget.b bVar3 = this.iC;
            if (bVar3 instanceof r) {
                a(bVar3, false);
            } else {
                a(bVar3, true);
            }
            return this.iC;
        } catch (Throwable th) {
            if (l.UL().TQ()) {
                ServiceProvider.reportSdkCaughtException(th);
                return null;
            }
            throw th;
        }
    }

    private void cc() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.b.a.ZH().remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private com.kwad.components.core.widget.b<?, ?> C(Context context) {
        com.kwad.components.core.widget.b<?, ?> bVarA;
        int width = this.mAdTemplate.mAdScene.getWidth();
        if (width < com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzz) * com.kwad.sdk.utils.m.getScreenWidth(context)) {
            com.kwad.components.ad.feed.monitor.b.a(width, com.kwad.sdk.core.response.b.a.bk(this.mAdInfo), this.mAdTemplate.type, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.b.b.dA(this.mAdTemplate)) {
            s sVar = new s(m.wrapContextIfNeed(context));
            this.iD = sVar;
            sVar.setWidth(width);
            this.iD.setVideoPlayConfig(this.dG);
            bVarA = this.iD;
        } else if (this.iE && com.kwad.sdk.core.response.b.b.dz(this.mAdTemplate)) {
            try {
                context = m.wrapContextIfNeed(context);
                r rVar = new r(context);
                rVar.setWidth(width);
                rVar.setVideoPlayConfig(this.dG);
                bVarA = rVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                bVarA = null;
            }
        } else {
            bVarA = b.a(context, FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType), com.kwad.sdk.core.response.b.a.bk(this.mAdInfo));
        }
        if (bVarA != null) {
            if (!(bVarA instanceof s)) {
                bVarA.setMargin(com.kwad.sdk.c.a.a.a(context, 16.0f));
            }
            bVarA.setPageExitListener(this.fa);
        }
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.widget.b bVar, final boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ad.feed.c.6
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (c.this.iB != null) {
                    c.this.iB.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(4, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bh(c.this.mAdInfo), z ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                com.kwad.components.ad.feed.monitor.b.p(c.this.mAdTemplate);
                com.kwad.sdk.commercial.d.c.ca(c.this.mAdTemplate);
                if (c.this.iB != null) {
                    c.this.iB.onAdShow();
                }
                com.kwad.components.ad.feed.monitor.b.a(3, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bh(c.this.mAdInfo), z ? 1 : 2);
                if (z) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    a.C0576a c0576a = new a.C0576a();
                    FeedType feedTypeFromInt = FeedType.fromInt(c.this.mAdTemplate.type, c.this.mAdTemplate.defaultType);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0576a.templateId = String.valueOf(feedTypeFromInt.getType());
                    c0576a.bvk = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
                    bVar2.b(c0576a);
                    bVar2.G(c.this.iC.getHeight(), c.this.iC.getWidth());
                    com.kwad.components.core.u.b.tq().a(c.this.mAdTemplate, null, bVar2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (c.this.iB != null) {
                    c.this.iB.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
                com.kwad.components.ad.feed.monitor.b.a(5, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bh(c.this.mAdInfo), z ? 1 : 2);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (c.this.iB != null) {
                    try {
                        c.this.iB.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (c.this.iB != null) {
                    try {
                        c.this.iB.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}

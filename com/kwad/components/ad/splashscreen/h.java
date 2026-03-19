package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.e.d.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bw;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.sdk.mvp.a {
    private KsSplashScreenAd.SplashScreenAdInteractionListener GW;
    public long HA;
    public com.kwad.components.ad.splashscreen.d.a Hi;
    public StyleTemplate Hj;
    public com.kwad.sdk.core.j.a Hk;
    public int Hs;
    public int Ht;
    public long Hu;
    public long Hv;
    public long Hw;
    public long Hx;
    public long Hy;
    public long Hz;
    public AdResultData mAdResultData;
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;
    public bw mTimerHelper;
    public KsVideoPlayConfig mVideoPlayConfig;
    private List<g> Hl = new CopyOnWriteArrayList();
    private List<f> Hm = new CopyOnWriteArrayList();
    public boolean Hn = false;
    private boolean Ho = false;
    public boolean Hp = false;
    public boolean Hq = false;
    public boolean dA = false;
    public long Hr = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;

    public interface a {
        void b(com.kwad.sdk.core.adlog.c.b bVar);
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    public static boolean r(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.dM(adInfo) && com.kwad.sdk.core.response.b.a.bj(adInfo);
    }

    public static boolean ad(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfoDU;
        return com.kwad.sdk.core.config.e.Yc() && (splashPlayCardTKInfoDU = com.kwad.sdk.core.response.b.b.dU(adTemplate)) != null && !TextUtils.isEmpty(splashPlayCardTKInfoDU.templateId) && splashPlayCardTKInfoDU.renderType == 1;
    }

    public final void c(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, null);
    }

    public final void a(final int i, Context context, final int i2, int i3, final a aVar) {
        com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        com.kwad.components.core.e.d.a.a(new a.C0469a(context).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(i3).aq(i3 == 1).aF(i2).aE(i).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() throws JSONException {
                com.kwad.components.ad.splashscreen.monitor.a.mb().ah(h.this.mAdTemplate);
                if (h.this.GW != null) {
                    h.this.GW.onAdClicked();
                }
                com.kwad.components.ad.splashscreen.monitor.a.mb().af(h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    if (h.this.Hi != null) {
                        jSONObject.put("duration", h.this.Hi.getCurrentPosition());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
                com.kwad.sdk.core.adlog.c.b bVarF = new com.kwad.sdk.core.adlog.c.b().eP(i2).f(h.this.mRootContainer.getTouchCoords());
                if (i == 2) {
                    bVarF.eY(6);
                }
                com.kwad.sdk.core.adlog.c.a(h.this.mAdTemplate, bVarF, jSONObject);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(bVarF);
                }
            }
        }));
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.GW = splashScreenAdInteractionListener;
    }

    public final void ab() {
        this.mAdTemplate.converted = true;
        com.kwad.components.ad.splashscreen.monitor.a.mb().ah(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mb().af(this.mAdTemplate);
    }

    public final void af(boolean z) {
        if (this.Ho) {
            return;
        }
        this.Ho = true;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (z && com.kwad.sdk.core.config.e.Zb()) {
            com.kwad.components.core.u.b.tq().a(this.mAdTemplate, null, null);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mAdTemplate.showTime = jElapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.a(this.mAdTemplate, jElapsedRealtime - this.mAdTemplate.showStartTime, jElapsedRealtime - this.mAdTemplate.addStartTime, jElapsedRealtime - this.mAdTemplate.requestStartTime);
        com.kwad.components.ad.splashscreen.monitor.c.ar(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.a.mb().w(this.mAdTemplate);
        com.kwad.sdk.a.a.c.VC().cs(true);
        bw bwVar = this.mTimerHelper;
        if (bwVar != null) {
            bwVar.startTiming();
        }
    }

    public final void lL() {
        com.kwad.components.ad.splashscreen.monitor.a.mb().ai(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mb().x(this.mAdTemplate);
    }

    public final void lM() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "onMediaPlayError");
        }
    }

    public final void lN() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    public final void lO() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    public final void lP() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
    }

    public final void lQ() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    public final void lR() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void lS() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void lT() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void lU() {
        if (this.Hn) {
            return;
        }
        this.Hn = true;
        if (!r(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)) || this.mAdTemplate.converted) {
            a.C0576a c0576a = new a.C0576a();
            bw bwVar = this.mTimerHelper;
            if (bwVar != null) {
                c0576a.duration = bwVar.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eQ(14).eY(22).b(c0576a), (JSONObject) null);
            com.kwad.components.ad.splashscreen.monitor.a.mb().ai(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            com.kwad.components.ad.splashscreen.monitor.a.mb().x(this.mAdTemplate);
        } else {
            lZ();
        }
        lX();
    }

    public final void lV() {
        com.kwad.components.ad.splashscreen.monitor.a.mb().ai(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mb().x(this.mAdTemplate);
    }

    public final void lW() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.mb().x(this.mAdTemplate);
        lX();
    }

    public final void c(int i, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GW;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i, str);
        }
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, i, String.valueOf(str));
        lX();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Hi;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.j.a aVar2 = this.Hk;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void a(g gVar) {
        this.Hl.add(gVar);
    }

    public final void b(g gVar) {
        this.Hl.remove(gVar);
    }

    private void lX() {
        lY();
        Iterator<g> it = this.Hl.iterator();
        while (it.hasNext()) {
            it.next().lK();
        }
    }

    public final void al(int i) {
        Iterator<g> it = this.Hl.iterator();
        while (it.hasNext()) {
            it.next().ak(i);
        }
    }

    private void lY() {
        long jDU;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setLoadType(this.mAdTemplate.splashAdLoadType).setStatus(8).setElementTypes(com.kwad.components.core.webview.tachikoma.e.a.wk().wl());
        bw bwVar = this.mTimerHelper;
        SplashMonitorInfo rotateComposeTimeout = elementTypes.setShowEndTime(bwVar != null ? bwVar.getTime() : -1L).setRotateComposeTimeout(this.dA);
        if (ad(this.mAdTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(this.mAdTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate));
        }
        com.kwad.sdk.commercial.b.m(rotateComposeTimeout.setTkDefaultTimeout(jDU).setSoSource(this.Hs).setSoLoadTime(this.Hu).setOfflineSource(this.Ht).setOfflineLoadTime(this.Hv).setTkFileLoadTime(this.Hw).setTkInitTime(this.Hx).setTkRenderTime(this.Hy).setNativeLoadTime(this.Hz).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.HA).setInteractiveStyle(com.kwad.sdk.core.response.b.b.eb(adInfoEP)).setInteractivityDefaultStyle(com.kwad.sdk.core.response.b.b.ec(adInfoEP)).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setAdTemplate(this.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.a.wk().wm();
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Hm.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Hm.remove(fVar);
    }

    private void lZ() {
        Iterator<f> it = this.Hm.iterator();
        while (it.hasNext()) {
            it.next().lG();
        }
    }

    public final void ma() {
        this.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.pe()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.lV();
                }
            }
        });
    }

    public final void U(Context context) {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        com.kwad.components.ad.splashscreen.local.a.V(context);
        if (!com.kwad.sdk.core.config.e.Zb()) {
            com.kwad.components.core.u.b.tq().a(this.mAdTemplate, null, null);
        }
        com.kwad.sdk.commercial.d.c.ca(this.mAdTemplate);
        af(true);
    }

    public static boolean n(AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }
}

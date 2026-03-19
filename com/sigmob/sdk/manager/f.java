package com.sigmob.sdk.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.videoAd.j;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class f extends b implements g.b, n.b, e.a {
    protected final Handler f = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.manager.f.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 8193 && f.this.b == AdStatus.AdStatusLoading) {
                f.this.f.removeMessages(8193);
                f.this.a(WindAdError.ERROR_SIGMOB_AD_TIME_OUT);
            }
        }
    };
    protected String g;
    protected String h;
    protected String i;
    protected long j;
    protected LoadAdRequest k;
    protected BaseAdUnit l;
    protected List<BaseAdUnit> m;
    protected com.sigmob.sdk.mraid.e n;
    protected j o;
    protected l p;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseAdUnit adUnit, String error, boolean isPreload) {
        com.sigmob.sdk.base.network.g.a(adUnit, m.a((CharSequence) error) ? com.sigmob.sdk.base.common.a.B : com.sigmob.sdk.base.common.a.C);
        ac.a(PointCategory.LOADEND, m.a((CharSequence) error) ? "1" : "0", adUnit, (WindAdRequest) null, this.k, (ac.a) null);
        this.f.removeMessages(8193);
        if (adUnit == null) {
            return;
        }
        if (isPreload) {
            a(adUnit, this.k);
        }
        if (adUnit.getPlayMode() == 0) {
            if (m.a((CharSequence) error)) {
                this.j = adUnit.getCreate_time();
                if (com.sigmob.sdk.base.utils.n.b(Boolean.valueOf(isPreload))) {
                    a((WindAdError) null);
                    return;
                }
                return;
            }
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            windAdError.setMessage(error);
            a(adUnit, "load", adUnit.getAd_type(), adUnit.getAdslot_id(), adUnit.getLoad_id(), windAdError);
            if (com.sigmob.sdk.base.utils.n.b(Boolean.valueOf(isPreload))) {
                a(windAdError);
            }
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LoadAdRequest loadAdRequest) {
        ac.a(PointCategory.RESPOND, "0", loadAdRequest);
    }

    private boolean b(LoadAdRequest request, String traceId) {
        if (!c()) {
            return false;
        }
        BaseAdUnit baseAdUnitE = e();
        if (com.sigmob.sdk.base.utils.n.b(baseAdUnitE)) {
            baseAdUnitE.setTraceId(traceId);
            baseAdUnitE.setRequestSceneType(request.getRequest_scene_type());
        }
        this.n.a((Map<String, Object>) null, baseAdUnitE);
        SigmobLog.d("loadAd isReady placementId = [" + this.g + "]");
        k();
        a((WindAdError) null);
        k(baseAdUnitE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(BaseAdUnit adUnit) {
        ac.a(PointCategory.LOADSTART, (String) null, adUnit, (WindAdRequest) null, this.k, (ac.a) null);
        com.sigmob.sdk.base.network.g.a(adUnit, "load");
    }

    private void p(BaseAdUnit adUnit) {
        if (adUnit == null || this.k == null) {
            return;
        }
        String vid = adUnit.getVid();
        int playMode = adUnit.getPlayMode();
        boolean disableAutoLoad = adUnit.getDisableAutoLoad();
        SigmobLogger.d(this.a, "onInterstitialDismissed: vid = " + vid + ", playMode = " + playMode + ", disableAutoLoad = " + disableAutoLoad, new Object[0]);
        if (disableAutoLoad || playMode == 0) {
            return;
        }
        String bid_token = adUnit.getBid_token();
        SigmobLogger.d(this.a, "onInterstitialDismissed: bidToken = " + bid_token, new Object[0]);
        if (m.a((CharSequence) bid_token) && adUnit.bidding_response == null) {
            this.k.setLastCampid(adUnit.getCamp_id());
            this.k.setLastCrid(adUnit.getCrid());
            a(this.k, com.sigmob.sdk.base.j.AutoNextPreload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.l = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        a(this.k, com.sigmob.sdk.base.j.AutoNextPreload);
    }

    public String a() {
        return h(this.b == AdStatus.AdStatusPlaying ? this.l : e());
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int error, String message, String requestId, LoadAdRequest loadAdRequest) {
        b(loadAdRequest);
        ac.a(PointCategory.RESPOND, "0", error, message, loadAdRequest);
        WindAdError windAdError = WindAdError.getWindAdError(error);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(error, message);
        }
        b(windAdError);
        a(windAdError);
    }

    @Override // com.sigmob.sdk.base.common.g.b
    public void a(BaseAdUnit adUnit) {
        o(adUnit);
    }

    @Override // com.sigmob.sdk.base.common.g.b
    public void a(BaseAdUnit adUnit, String error) {
        a(adUnit, error, false);
    }

    protected void a(LoadAdRequest loadAdRequest, com.sigmob.sdk.base.j sceneType) {
        a(loadAdRequest, sceneType, (String) null, new e.a() { // from class: com.sigmob.sdk.manager.f.2
            @Override // com.sigmob.sdk.base.network.e.a
            public void a(int error, String message, String request_id, LoadAdRequest loadAdRequest2) {
                f.this.b(loadAdRequest2);
                ac.a(PointCategory.RESPOND, "0", error, message, loadAdRequest2);
            }

            @Override // com.sigmob.sdk.base.network.e.a
            public void a(List<BaseAdUnit> adUnits, LoadAdRequest loadAdRequest2) {
                if (com.sigmob.sdk.base.utils.e.a(adUnits)) {
                    return;
                }
                BaseAdUnit baseAdUnit = adUnits.get(0);
                f.this.i = baseAdUnit.getRequestId();
                f.this.m = adUnits;
                f.this.a(adUnits, loadAdRequest2, baseAdUnit);
                int request_scene_type = loadAdRequest2.getRequest_scene_type();
                f.this.a(request_scene_type);
                SigmobLogger.d(f.this.a, "preloadAdsRequest: requestSceneType = " + request_scene_type, new Object[0]);
                if (com.sigmob.sdk.base.utils.n.b(f.this.n) && !f.this.n.a(baseAdUnit)) {
                    f.this.a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                    return;
                }
                for (BaseAdUnit baseAdUnit2 : f.this.m) {
                    if (b.m(baseAdUnit2)) {
                        g.g().f(baseAdUnit2);
                    }
                }
                int playMode = baseAdUnit.getPlayMode();
                if (playMode != 0) {
                    f.this.j = baseAdUnit.getCreate_time();
                }
                g.a(adUnits);
                g.b bVar = new g.b() { // from class: com.sigmob.sdk.manager.f.2.1
                    @Override // com.sigmob.sdk.base.common.g.b
                    public void a(BaseAdUnit adUnit) {
                        f.this.o(adUnit);
                    }

                    @Override // com.sigmob.sdk.base.common.g.b
                    public void a(BaseAdUnit adUnit, String error) {
                        f.this.a(adUnit, error, true);
                    }
                };
                int creativeType = baseAdUnit.getCreativeType();
                SigmobLogger.d(f.this.a, "preloadAdsRequest: playMode = " + playMode + ", creativeType = " + creativeType, new Object[0]);
                if (creativeType != com.sigmob.sdk.base.common.l.CreativeTypeMRAIDTWO.a()) {
                    if (playMode == 2) {
                        f.this.a(baseAdUnit, loadAdRequest2);
                        return;
                    } else {
                        f.this.n.a(new HashMap(), baseAdUnit);
                        g.g().a(baseAdUnit, bVar);
                        return;
                    }
                }
                boolean zA = new com.sigmob.sdk.base.common.d(adUnits, bVar, f.this.k).a(false);
                SigmobLogger.d(f.this.a, "preloadAdsRequest: cache = " + zA, new Object[0]);
                if (zA) {
                    f.this.n.a(new HashMap(), baseAdUnit);
                } else {
                    f.this.a(baseAdUnit, loadAdRequest2);
                }
            }
        });
    }

    protected void a(LoadAdRequest loadAdRequest, com.sigmob.sdk.base.j sceneType, String traceId, e.a listener) {
        g();
        boolean zA = a(sceneType);
        loadAdRequest.setOriginVid(zA ? this.d : "");
        loadAdRequest.setOriginPrice(zA ? this.e : "");
        loadAdRequest.setRequest_scene_type(sceneType.a());
        loadAdRequest.setExpired(d());
        if (!m.b(traceId)) {
            traceId = b.j();
        }
        this.k.setTraceId(traceId);
        a(loadAdRequest);
        com.sigmob.sdk.base.network.e.a(loadAdRequest, listener);
    }

    public void a(LoadAdRequest loadAdRequest, l windAdShowListener) throws UnsupportedEncodingException {
        this.p = windAdShowListener;
        this.k = loadAdRequest;
        com.sigmob.sdk.mraid.e eVarM = m();
        if (eVarM == null) {
            return;
        }
        BaseAdUnit baseAdUnitE = e();
        this.l = baseAdUnitE;
        this.h = baseAdUnitE.getRequestId();
        String loadId = this.k.getLoadId();
        String adSceneId = this.k.getAdSceneId();
        String adSceneDesc = this.k.getAdSceneDesc();
        this.l.setLoad_id(loadId);
        this.l.setAd_scene_id(adSceneId);
        this.l.setAd_scene_desc(adSceneDesc);
        SigMacroCommon macroCommon = this.l.getMacroCommon();
        if (m.b(adSceneDesc)) {
            macroCommon.addMarcoKey(SigMacroCommon._ADSCENE_, adSceneDesc);
        }
        if (m.b(adSceneId)) {
            macroCommon.addMarcoKey(SigMacroCommon._ADSCENEID_, adSceneId);
        }
        String video_url = this.l.getVideo_url();
        if (m.b(video_url)) {
            macroCommon.addMarcoKey(SigMacroCommon._VMD5_, g.g().k(this.l.getVideoPath()));
            try {
                macroCommon.addMarcoKey(SigMacroCommon._VURL_, URLEncoder.encode(video_url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                SigmobLog.e(e.getMessage());
            }
        }
        boolean z = true;
        if (this.l.getCreativeType() == com.sigmob.sdk.base.common.l.CreativeTypeMRAIDTWO.a()) {
            if (!new com.sigmob.sdk.base.common.d(this.m, this, this.k).a(true)) {
                eVarM.a(new HashMap(), this.l);
            }
        } else if (this.l.getPlayMode() == 2) {
            eVarM.a(new HashMap(), this.l);
            g.g().a(this.l, this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.sigmob.sdk.base.n.v, this.k.isEnable_keep_on() || o.a().i());
        if (!this.k.isEnable_screen_lock_displayad() && !o.a().h()) {
            z = false;
        }
        bundle.putBoolean(com.sigmob.sdk.base.n.u, z);
        eVarM.a(this.l, bundle);
        this.b = AdStatus.AdStatusPlaying;
        this.j = 0L;
    }

    public void a(LoadAdRequest request, String traceId) {
        this.b = AdStatus.AdStatusLoading;
        if (request == null || m.a((CharSequence) request.getPlacementId())) {
            SigmobLog.e("loadAd error loadAdRequest or placementId is null");
            a(WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY);
            return;
        }
        try {
            WindAdError sigMobError = Sigmob.getInstance().getSigMobError();
            if (com.sigmob.sdk.base.utils.n.b(sigMobError)) {
                SigmobLog.e("check loadAd error " + sigMobError);
                PointEntitySigmobError.SigmobError("load", sigMobError.getErrorCode(), sigMobError.getMessage()).commit();
                a(sigMobError);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (m.b(request.getBidToken())) {
            g();
        }
        this.g = request.getPlacementId();
        this.k = request;
        if (this.n == null) {
            this.n = l();
        }
        if (b(request, traceId)) {
            return;
        }
        if (m.b(this.h)) {
            g.b(this.h);
        }
        if (m.b(this.i)) {
            g.b(this.i);
        }
        request.setLastCampid(g.g().o());
        request.setLastCrid(g.g().n());
        a(request, com.sigmob.sdk.base.j.NormalRequest, traceId, this);
        this.f.sendEmptyMessageDelayed(8193, o.a().x());
    }

    public void a(j windAdLoadListener) {
        this.o = windAdLoadListener;
    }

    protected void a(WindAdError error) {
        if (this.b != AdStatus.AdStatusLoading) {
            return;
        }
        if (error == null) {
            this.b = AdStatus.AdStatusReady;
            a(this);
            a(e(), this.k);
        } else {
            this.b = AdStatus.AdStatusNone;
        }
        if (this.o == null) {
            return;
        }
        String strH = h();
        if (error == null) {
            this.o.onAdLoadSuccess(strH);
        } else {
            this.o.onAdLoadError(error, strH);
        }
    }

    public void a(String key, String value) {
        a(this.b == AdStatus.AdStatusPlaying ? this.l : e(), key, value);
    }

    @Override // com.sigmob.sdk.manager.b
    public void a(String originVid, String originPrice, com.sigmob.sdk.base.j requestSceneType) {
        super.a(originVid, originPrice, requestSceneType);
        LoadAdRequest loadAdRequestF = f();
        if (loadAdRequestF != null && m.a((CharSequence) loadAdRequestF.getBidToken())) {
            loadAdRequestF.setLastCampid("");
            loadAdRequestF.setLastCrid("");
            a(loadAdRequestF, requestSceneType);
        }
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(List<BaseAdUnit> adUnits, LoadAdRequest loadAdRequest) {
        try {
            if (com.sigmob.sdk.base.utils.e.a(adUnits)) {
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                b(windAdError);
                ac.a(PointCategory.RESPOND, "0", windAdError.getErrorCode(), windAdError.getMessage(), loadAdRequest);
                a(windAdError);
                return;
            }
            BaseAdUnit baseAdUnit = adUnits.get(0);
            this.h = baseAdUnit.getRequestId();
            this.m = adUnits;
            a(adUnits, loadAdRequest, baseAdUnit);
            if (this.n == null) {
                this.n = l();
            }
            if (!this.n.a(baseAdUnit)) {
                a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE);
                return;
            }
            k();
            g.a(adUnits);
            for (BaseAdUnit baseAdUnit2 : this.m) {
                if (m(baseAdUnit2)) {
                    g.g().f(baseAdUnit2);
                }
            }
            int playMode = baseAdUnit.getPlayMode();
            if (playMode != 0) {
                this.j = baseAdUnit.getCreate_time();
                a((WindAdError) null);
            }
            if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.l.CreativeTypeMRAIDTWO.a()) {
                if (new com.sigmob.sdk.base.common.d(adUnits, this, this.k).a(false)) {
                    this.n.a(new HashMap(), baseAdUnit);
                    return;
                }
                return;
            }
            if (playMode == 2) {
                return;
            }
            this.n.a(new HashMap(), baseAdUnit);
            g.g().a(baseAdUnit, this);
        } catch (Throwable th) {
            String message = th.getMessage();
            SigmobLog.e(message);
            g();
            WindAdError windAdError2 = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
            int errorCode = windAdError2.getErrorCode();
            windAdError2.setMessage(message);
            ac.a(PointCategory.RESPOND, "0", errorCode, message, loadAdRequest);
            a(windAdError2);
        }
    }

    public Map<String, BiddingResponse> b() {
        return i(this.b == AdStatus.AdStatusPlaying ? this.l : e());
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void b(BaseAdUnit adUnit) {
        SigmobLogger.d(this.a, "onInterstitialShown", new Object[0]);
        a("start", adUnit);
        n();
        g();
        b(this);
        if (com.sigmob.sdk.base.utils.n.b(this.p)) {
            this.p.onAdShow(this.g);
        }
        if (adUnit == null || this.k == null) {
            return;
        }
        String vid = adUnit.getVid();
        int playMode = adUnit.getPlayMode();
        boolean disableAutoLoad = adUnit.getDisableAutoLoad();
        SigmobLogger.d(this.a, "onInterstitialShown: vid = " + vid + ", playMode = " + playMode + ", disableAutoLoad = " + disableAutoLoad, new Object[0]);
        if (disableAutoLoad || playMode != 0) {
            return;
        }
        String bid_token = adUnit.getBid_token();
        SigmobLogger.d(this.a, "onInterstitialShown: bidToken = " + bid_token, new Object[0]);
        if (m.a((CharSequence) bid_token) && adUnit.bidding_response == null) {
            this.k.setLastCampid(adUnit.getCamp_id());
            this.k.setLastCrid(adUnit.getCrid());
            this.f.post(new Runnable() { // from class: com.sigmob.sdk.manager.f$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.r();
                }
            });
        }
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void b(BaseAdUnit adUnit, String errMsg) {
        this.f.removeMessages(8193);
        SigmobLog.d("onInterstitialFailed() called with: errorCode = [" + errMsg + "]");
        ac.a(PointCategory.LOADEND, "0", adUnit, (WindAdRequest) null, this.k, (ac.a) null);
        com.sigmob.sdk.base.network.g.a(adUnit, com.sigmob.sdk.base.common.a.C);
        g();
        if (adUnit != null && adUnit.getPlayMode() == 0) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            windAdError.setMessage(errMsg);
            a(adUnit, "load", adUnit.getAd_type(), adUnit.getAdslot_id(), adUnit.getLoad_id(), windAdError);
            a(windAdError);
        }
    }

    protected void b(WindAdError error) {
        j jVar;
        if (this.b != AdStatus.AdStatusLoading || (jVar = this.o) == null) {
            return;
        }
        jVar.onAdPreLoadFail(error, this.g);
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void c(BaseAdUnit adUnit) {
        SigmobLogger.d(this.a, "onInterstitialClicked", new Object[0]);
        a("click", adUnit);
        if (com.sigmob.sdk.base.utils.n.b(this.p)) {
            this.p.onAdClicked(this.g);
        }
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean c() {
        com.sigmob.sdk.mraid.e eVar;
        BaseAdUnit baseAdUnitE = e();
        if (baseAdUnitE != null && !d() && g(baseAdUnitE) && (eVar = this.n) != null && eVar.a(baseAdUnitE) && g.e(baseAdUnitE.getUuid()) != null) {
            return true;
        }
        if (!com.sigmob.sdk.base.utils.n.b(baseAdUnitE)) {
            return false;
        }
        g.g().e(baseAdUnitE);
        return false;
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void d(BaseAdUnit adUnit) {
        SigmobLogger.d(this.a, "onInterstitialDismissed", new Object[0]);
        a("dismissed", (Map<String, String>) null);
        if (this.b == AdStatus.AdStatusClose) {
            return;
        }
        this.b = AdStatus.AdStatusClose;
        if (com.sigmob.sdk.base.utils.n.b(this.n)) {
            this.n.b(adUnit);
        }
        o();
        if (com.sigmob.sdk.base.utils.n.b(this.p)) {
            this.p.onAdClosed(this.g);
        }
        this.f.post(new Runnable() { // from class: com.sigmob.sdk.manager.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.q();
            }
        });
        p(adUnit);
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean d() {
        if (this.j == 0) {
            return false;
        }
        return f(e());
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit e() {
        if (com.sigmob.sdk.base.utils.e.a(this.m)) {
            return null;
        }
        return this.m.get(0);
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void e(BaseAdUnit adUnit) {
        if (adUnit == null) {
            return;
        }
        g.g().j(adUnit.getCamp_id());
        g.g().i(adUnit.getCrid());
        g();
    }

    @Override // com.sigmob.sdk.manager.b
    public LoadAdRequest f() {
        return this.k;
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit i() {
        return this.l;
    }

    protected void k() {
        j jVar;
        if (this.b != AdStatus.AdStatusLoading || (jVar = this.o) == null) {
            return;
        }
        jVar.onAdPreLoadSuccess(this.g);
    }

    public abstract com.sigmob.sdk.mraid.e l();

    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sigmob.sdk.mraid.e m() {
        /*
            r6 = this;
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_CHECK_FAIL
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r6.e()
            com.czhj.sdk.common.models.AdStatus r2 = r6.b
            com.czhj.sdk.common.models.AdStatus r3 = com.czhj.sdk.common.models.AdStatus.AdStatusPlaying
            r4 = 0
            r5 = 0
            if (r2 != r3) goto L18
            com.sigmob.windad.WindAdError r1 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_AD_PLAY_HAS_PLAYING
            java.lang.String r1 = r1.getMessage()
        L14:
            r0.setMessage(r1)
            goto L54
        L18:
            java.util.List<com.sigmob.sdk.base.models.BaseAdUnit> r2 = r6.m
            if (r2 == 0) goto L51
            if (r1 != 0) goto L1f
            goto L51
        L1f:
            com.czhj.sdk.common.models.AdStatus r2 = r6.b
            com.czhj.sdk.common.models.AdStatus r3 = com.czhj.sdk.common.models.AdStatus.AdStatusReady
            if (r2 == r3) goto L28
            java.lang.String r1 = "ad status is not ready"
            goto L14
        L28:
            com.sigmob.sdk.mraid.e r2 = r6.n
            if (r2 != 0) goto L2f
            java.lang.String r1 = "interstitial object is null"
            goto L14
        L2f:
            boolean r2 = r6.d()
            if (r2 == 0) goto L38
            com.sigmob.windad.WindAdError r0 = com.sigmob.windad.WindAdError.ERROR_SIGMOB_EXPIRED
            goto L55
        L38:
            boolean r2 = r6.g(r1)
            if (r2 != 0) goto L44
            java.lang.String r2 = "check ad unit endcard is invalid"
        L40:
            r0.setMessage(r2)
            goto L55
        L44:
            com.sigmob.sdk.mraid.e r2 = r6.n
            boolean r2 = r2.a(r1)
            if (r2 != 0) goto L4f
            java.lang.String r2 = "check ad unit info is invalid"
            goto L40
        L4f:
            r5 = 1
            goto L55
        L51:
            java.lang.String r1 = "not ready adUnit"
            goto L14
        L54:
            r1 = r4
        L55:
            if (r5 != 0) goto L67
            com.sigmob.sdk.videoAd.l r2 = r6.p
            r6.a(r0, r2)
            r6.b(r6)
            com.sigmob.sdk.base.models.LoadAdRequest r2 = r6.k
            java.lang.String r3 = "play"
            com.sigmob.sdk.base.common.ac.a(r3, r0, r1, r2)
            return r4
        L67:
            com.sigmob.sdk.mraid.e r0 = r6.n
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.manager.f.m():com.sigmob.sdk.mraid.e");
    }

    protected void n() {
    }

    public void n(BaseAdUnit adUnit) {
        if (com.sigmob.sdk.base.utils.n.b(this.p)) {
            this.p.onVideoAdPlayEnd(this.g);
        }
    }

    protected void o() {
    }

    public void p() {
        a("destroy", (Map<String, String>) null);
        if (m.b(this.h)) {
            g.b(this.h);
        }
        if (m.b(this.i)) {
            g.b(this.i);
        }
        g();
        this.o = null;
        this.p = null;
        this.l = null;
        this.f.removeCallbacksAndMessages(null);
        b(this);
    }
}

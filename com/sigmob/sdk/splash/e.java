package com.sigmob.sdk.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.splash.d;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e extends com.sigmob.sdk.manager.b implements g.b, e.a, d.a {
    private static final int f = 131073;
    private final LoadAdRequest g;
    private List<BaseAdUnit> i;
    private BaseAdUnit j;
    private BaseAdUnit k;
    private WindSplashADListener m;
    private g n;
    private int q;
    private long s;
    private int o = 0;
    private int p = 0;
    private final Handler r = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.splash.e.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == e.f && e.this.b == AdStatus.AdStatusLoading) {
                e.this.r.removeMessages(e.f);
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_TIME_OUT;
                e.this.a(windAdError.getErrorCode(), windAdError.getMessage(), e.this.g);
                e.this.a(windAdError, true);
            }
        }
    };
    private final Runnable h = new Runnable() { // from class: com.sigmob.sdk.splash.e.2
        @Override // java.lang.Runnable
        public void run() {
            e.this.p();
            if (e.this.n == null) {
                return;
            }
            if (e.this.q <= 0) {
                e.this.n.setDuration(0);
                return;
            }
            e.this.n.setDuration(e.this.q);
            e.f(e.this);
            e.this.r.postDelayed(e.this.h, 1000L);
        }
    };
    private final d l = new d(this);

    public e(WindSplashAdRequest splashAdRequest, WindSplashADListener splashADListener) {
        this.g = new LoadAdRequest(splashAdRequest);
        this.m = splashADListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int code, String message, LoadAdRequest loadAdRequest) {
        ac.a("request", (String) null, code, message, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.splash.e$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                e.a(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WindAdError error, boolean isLoadError) {
        SigmobLogger.e(this.a, "handleError: error = " + error + ", isLoadError = " + isLoadError, new Object[0]);
        this.b = AdStatus.AdStatusNone;
        p();
        if (c(Integer.valueOf(this.g.getRequest_scene_type())) && n.b(this.m)) {
            String placementId = this.g.getPlacementId();
            if (isLoadError) {
                this.m.onSplashAdLoadFail(error, placementId);
            } else {
                this.m.onSplashAdShowError(error, placementId);
            }
        }
        if (n.b(this.l)) {
            this.l.b(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setAdx_id(null);
        }
    }

    private boolean a(ViewGroup viewGroup, BaseAdUnit adUnit) {
        if (adUnit == null) {
            return false;
        }
        this.n = new g(viewGroup.getContext().getApplicationContext());
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (width <= 0 || height <= 0) {
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.n.setLayoutParams(layoutParams);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            if (childMeasureSpec == 0) {
                childMeasureSpec = View.MeasureSpec.makeMeasureSpec(ClientMetadata.getInstance().getDisplayMetrics().widthPixels, 1073741824);
            }
            int i = layoutParams.height;
            this.n.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            width = this.n.getMeasuredWidth();
            height = this.n.getMeasuredHeight();
        }
        if (width > 0 && height > 0) {
            this.n.setAspectRatio((width * 1.0f) / height);
        }
        this.n.b();
        this.n.setShowAppLogo(this.o != 0);
        return this.n.a(adUnit, o.d(viewGroup));
    }

    static /* synthetic */ int f(e eVar) {
        int i = eVar.q;
        eVar.q = i - 1;
        return i;
    }

    private Activity s() {
        Activity activityC = o.c(this.n);
        SigmobLogger.d(this.a, "getActivity: activityFromView = " + activityC, new Object[0]);
        return activityC;
    }

    private boolean t() {
        boolean z = c() && n.b(this.l);
        SigmobLogger.d(this.a, "isExistCache: cached = " + z, new Object[0]);
        if (z) {
            this.l.a((Map<String, Object>) null, this.k);
            com.sigmob.sdk.base.common.g.g().a(this.k, this);
            SigmobLogger.d(this.a, "isExistCache: ready", new Object[0]);
            k(this.k);
        }
        return z;
    }

    private void u() {
        LoadAdRequest loadAdRequest;
        if (this.n == null || (loadAdRequest = this.g) == null || loadAdRequest.isDisableAutoHideAd()) {
            return;
        }
        o.a(this.n);
        this.n = null;
    }

    private void v() {
        if (this.b == AdStatus.AdStatusPlaying) {
            this.b = AdStatus.AdStatusClose;
            WindSplashADListener windSplashADListener = this.m;
            if (windSplashADListener == null) {
                return;
            }
            windSplashADListener.onSplashAdClose(this.g.getPlacementId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        String strH = h();
        SigmobLogger.d(this.a, "loadEnd: placementId = " + strH, new Object[0]);
        WindSplashADListener windSplashADListener = this.m;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdLoadSuccess(strH);
    }

    @Override // com.sigmob.sdk.base.common.n.c
    public void a() {
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int code, String message, String requestId, LoadAdRequest loadAdRequest) {
        WindAdError windAdError = WindAdError.getWindAdError(code);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(code, message);
        }
        ac.a(PointCategory.RESPOND, "0", loadAdRequest);
        a(code, message, loadAdRequest);
        a(windAdError, true);
    }

    public void a(Activity activity) {
        if (this.n == null || activity != s()) {
            return;
        }
        this.n.d();
        p();
    }

    public void a(ViewGroup viewGroup) {
        if (!(1 == ClientMetadata.getInstance().getOrientationInt().intValue())) {
            o();
            return;
        }
        if (viewGroup != null) {
            if (!a(viewGroup, this.k)) {
                a_();
                return;
            }
            BaseAdUnit baseAdUnit = this.k;
            this.j = baseAdUnit;
            this.l.a(baseAdUnit, (Bundle) null);
            if (n.b(this.l.c)) {
                this.q = this.l.c.l();
            }
            this.n.setDuration(this.q);
            if (this.n.c()) {
                viewGroup.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
        }
        a_();
    }

    @Override // com.sigmob.sdk.base.common.g.b
    public void a(BaseAdUnit adUnit) {
    }

    @Override // com.sigmob.sdk.base.common.g.b
    public void a(BaseAdUnit adUnit, String error) {
        SigmobLogger.d(this.a, "loadEnd: error = " + error + ", mAdStatus = " + this.b, new Object[0]);
        if (m.b(error)) {
            b(this.k, error);
            return;
        }
        if (this.b == AdStatus.AdStatusClose) {
            FileUtil.writeToCache(adUnit, com.sigmob.sdk.base.utils.i.c(this.g.getPlacementId()));
        }
        int request_scene_type = this.g.getRequest_scene_type();
        SigmobLogger.d(this.a, "loadEnd: requestSceneType = " + request_scene_type, new Object[0]);
        a(adUnit, this.g);
        if (this.b == AdStatus.AdStatusLoading && request_scene_type == j.NormalRequest.a()) {
            if (!(1 == ClientMetadata.getInstance().getOrientationInt().intValue())) {
                o();
                return;
            }
            p();
            this.b = AdStatus.AdStatusReady;
            a((com.sigmob.sdk.manager.b) this);
            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.e$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.w();
                }
            });
        }
    }

    public void a(String bidToken, int bidFloor, String currency, int fetchTime, boolean preload, j sceneType, String traceId) {
        boolean zA = a(sceneType);
        this.g.setOriginVid(zA ? this.d : "");
        this.g.setOriginPrice(zA ? this.e : "");
        this.g.setRequest_scene_type(sceneType.a());
        this.g.setBidToken(bidToken);
        this.g.setBidFloor(bidFloor);
        this.g.setCurrency(currency);
        if (!m.b(traceId)) {
            traceId = com.sigmob.sdk.manager.b.j();
        }
        this.g.setTraceId(traceId);
        SigmobLogger.d(this.a, "loadAd: preload = " + preload + ", sceneType = " + sceneType.a(), new Object[0]);
        if (n.b(Boolean.valueOf(preload))) {
            this.b = AdStatus.AdStatusLoading;
            if (t()) {
                return;
            }
        }
        a(this.g);
        com.sigmob.sdk.base.network.e.a(this.g, this);
        this.r.sendEmptyMessageDelayed(f, fetchTime * 1000);
    }

    public void a(String key, String value) {
        a(this.k, key, value);
    }

    @Override // com.sigmob.sdk.manager.b
    public void a(String originVid, String originPrice, j requestSceneType) {
        super.a(originVid, originPrice, requestSceneType);
        if (m.b(this.g.getBidToken())) {
            return;
        }
        g();
        a(null, 0, WindAds.CNY, 45, true, requestSceneType, null);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(List<BaseAdUnit> adUnits, LoadAdRequest loadAdRequest) {
        if (com.sigmob.sdk.base.utils.e.a(adUnits)) {
            return;
        }
        this.i = adUnits;
        BaseAdUnit baseAdUnit = adUnits.get(0);
        SigmobLogger.d(this.a, "onSuccess(实时广告): vid = " + baseAdUnit.getVid(), new Object[0]);
        a(adUnits, loadAdRequest, baseAdUnit);
        a(loadAdRequest.getRequest_scene_type());
        d dVar = this.l;
        if (dVar != null && !dVar.a(baseAdUnit)) {
            a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE, true);
            return;
        }
        this.k = baseAdUnit;
        d dVar2 = this.l;
        if (dVar2 != null) {
            dVar2.a((Map<String, Object>) null, baseAdUnit);
        }
        com.sigmob.sdk.base.common.g.g().a(this.k, this);
    }

    @Override // com.sigmob.sdk.splash.d.a
    public void a_() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_RESOURCE;
        ac.a("play", windAdError, this.k);
        a(windAdError, false);
        n();
    }

    @Override // com.sigmob.sdk.base.common.n.c
    public void b() {
        BaseBroadcastReceiver.a(com.sigmob.sdk.b.e(), this.k.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
    }

    public void b(Activity activity) {
        if (this.n == null || activity != s()) {
            return;
        }
        this.n.e();
        this.r.post(this.h);
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void b(BaseAdUnit adUnit) {
        a("start", adUnit);
        this.b = AdStatus.AdStatusPlaying;
        m();
        com.sigmob.sdk.base.common.g.a(adUnit);
        if (this.n.getDuration() > 0 && this.n.getDuration() < this.q) {
            this.q = this.n.getDuration();
        }
        g gVar = this.n;
        if (gVar != null) {
            gVar.setDuration(this.q);
            this.n.setVisibility(0);
        }
        b((com.sigmob.sdk.manager.b) this);
        WindSplashADListener windSplashADListener = this.m;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdShow(this.g.getPlacementId());
        }
        this.p = this.q;
        this.r.post(this.h);
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void b(BaseAdUnit adUnit, String error) {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(error);
        a(windAdError, true);
        ac.a("load", windAdError, this.k);
    }

    @Override // com.sigmob.sdk.splash.d.a
    public void b_() {
        this.n.setDuration(0);
        WindSplashADListener windSplashADListener = this.m;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdSkip(this.g.getPlacementId());
        }
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void c(BaseAdUnit adUnit) {
        WindSplashADListener windSplashADListener;
        a("click", adUnit);
        if (!com.sigmob.sdk.base.utils.c.a(com.sigmob.sdk.base.utils.c.b(this.a, adUnit)) || (windSplashADListener = this.m) == null) {
            return;
        }
        windSplashADListener.onSplashAdClick(this.g.getPlacementId());
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean c() {
        try {
            if (this.k == null) {
                String strC = com.sigmob.sdk.base.utils.i.c(this.g.getPlacementId());
                Object fromCache = FileUtil.readFromCache(strC);
                if ((fromCache instanceof BaseAdUnit) && ((BaseAdUnit) fromCache).getAd() != null) {
                    FileUtil.deleteFile(strC);
                    BaseAdUnit baseAdUnit = (BaseAdUnit) fromCache;
                    baseAdUnit.setTraceId(this.g.getTraceId());
                    baseAdUnit.setRequestSceneType(this.g.getRequest_scene_type());
                    this.k = baseAdUnit;
                    SigmobLogger.d(this.a, "isReady(缓存广告): vid = " + this.k.getVid(), new Object[0]);
                }
            }
            if (this.k == null) {
                return false;
            }
            SigmobLogger.d(this.a, "isReady(正在使用): vid = " + this.k.getVid(), new Object[0]);
            boolean zCanRead = new File(this.k.getSplashFilePath()).canRead();
            boolean zIsExpiredAd = this.k.isExpiredAd();
            boolean zA = this.l.a(this.k);
            boolean z = zCanRead && !zIsExpiredAd && zA;
            SigmobLogger.d(this.a, "isReady: ready = " + z + ", isExist = " + zCanRead + ", isExpired = " + zIsExpiredAd + ", isValid = " + zA, new Object[0]);
            return z;
        } catch (Exception e) {
            SigmobLogger.e(this.a, "isReady: error = " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void d(BaseAdUnit adUnit) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.s <= 500) {
            SigmobLogger.d(this.a, "onInterstitialDismissed: unavailable callback", new Object[0]);
            return;
        }
        this.s = jCurrentTimeMillis;
        this.b = AdStatus.AdStatusClose;
        if (n.b(this.m)) {
            this.m.onSplashAdClose(this.g.getPlacementId());
        }
        this.r.post(new Runnable() { // from class: com.sigmob.sdk.splash.e$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n();
            }
        });
        String bid_token = adUnit.getBid_token();
        SigmobLogger.d(this.a, "onInterstitialDismissed: bidToken = " + bid_token, new Object[0]);
        if (m.a((CharSequence) bid_token)) {
            a(null, 0, WindAds.CNY, 45, true, j.SplashCloseRequest, null);
        }
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean d() {
        return f(this.k);
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit e() {
        return (this.k == null && com.sigmob.sdk.base.utils.e.b(this.i)) ? this.i.get(0) : this.k;
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void e(BaseAdUnit adUnit) {
    }

    @Override // com.sigmob.sdk.manager.b
    public LoadAdRequest f() {
        return this.g;
    }

    @Override // com.sigmob.sdk.manager.b
    protected void g() {
        com.sigmob.sdk.base.common.g.b(this.k);
        this.k = null;
        this.i = null;
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit i() {
        return this.j;
    }

    @Override // com.sigmob.sdk.splash.d.a
    public void k() {
    }

    @Override // com.sigmob.sdk.splash.d.a
    public void l() {
        p();
    }

    public void m() {
        if (this.k.getSessionManager() == null) {
            new i().a(this.k);
        }
    }

    public void n() {
        if (n.b(this.l)) {
            this.l.b(this.k);
        }
        v();
        u();
        g();
        this.m = null;
        this.j = null;
        p();
        b((com.sigmob.sdk.manager.b) this);
    }

    public void o() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_ORIENTATION;
        ac.a("play", windAdError, this.k);
        a(windAdError, false);
        n();
    }

    public void p() {
        this.r.removeCallbacksAndMessages(null);
    }

    public String q() {
        return h(this.k);
    }

    public Map<String, BiddingResponse> r() {
        return i(this.k);
    }
}

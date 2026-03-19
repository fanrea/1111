package com.sigmob.sdk;

import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.utils.c;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.c;
import com.sigmob.sdk.manager.f;
import com.sigmob.sdk.videoAd.j;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class c<T extends f> extends m {
    protected final Handler a;
    protected int b;
    protected T c;
    protected T d;
    protected LoadAdRequest e;
    protected j f;
    protected c<T>.a g;
    private final String i;

    /* renamed from: com.sigmob.sdk.c$1, reason: invalid class name */
    class AnonymousClass1 implements l {
        final /* synthetic */ l a;

        AnonymousClass1(final l val$showListener) {
            this.a = val$showListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(c.a aVar, String str, l lVar) {
            if (n.b(c.this.c)) {
                HashMap map = new HashMap();
                Integer numValueOf = Integer.valueOf(aVar == null ? 0 : aVar.a.intValue());
                Integer numValueOf2 = Integer.valueOf(aVar == null ? com.sigmob.sdk.base.utils.c.b : aVar.b.intValue());
                map.put(ClickCommon.CLICK_LOSE_RATE, String.valueOf(numValueOf));
                map.put(ClickCommon.CLICK_CB_STATE, String.valueOf(numValueOf2));
                c.this.c.a("click_callback", map);
            }
            if (com.sigmob.sdk.base.utils.c.a(aVar)) {
                SigmobLog.i("onAdClicked: placementId = " + str);
                if (n.b(lVar)) {
                    lVar.onAdClicked(str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(l lVar, WindAdError windAdError, String str) {
            if (n.b(lVar)) {
                lVar.onAdShowError(windAdError, str);
            }
            if (n.b(c.this.d)) {
                if (n.b(c.this.c)) {
                    c.this.c.p();
                }
                c cVar = c.this;
                cVar.c = cVar.d;
                c.this.mADStatus = AdStatus.AdStatusReady;
                c.this.d = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(l lVar, String str) {
            if (n.b(c.this.c)) {
                c.this.c.a("close_callback", null);
            }
            if (n.b(lVar)) {
                lVar.onAdClosed(str);
            }
            if (n.b(c.this.d)) {
                if (n.b(c.this.c)) {
                    c.this.c.p();
                }
                c cVar = c.this;
                cVar.c = cVar.d;
                c.this.mADStatus = AdStatus.AdStatusReady;
                c.this.d = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(l lVar, String str) {
            if (n.b(lVar)) {
                lVar.onVideoAdPlayEnd(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(l lVar, String str) {
            if (n.b(lVar)) {
                lVar.onVideoAdPlayComplete(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(l lVar, String str) {
            if (n.b(c.this.c)) {
                c.this.c.a("show_callback", null);
            }
            if (n.b(lVar)) {
                lVar.onAdShow(str);
            }
        }

        @Override // com.sigmob.sdk.videoAd.l
        public void onAdClicked(final String placementId) {
            final c.a aVarB = com.sigmob.sdk.base.utils.c.b(c.this.i, c.this.c == null ? null : c.this.c.i());
            Handler handler = c.this.a;
            final l lVar = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.c$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(aVarB, placementId, lVar);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.l
        public void onAdClosed(final String placementId) {
            SigmobLog.i("onAdClosed: placementId = " + placementId);
            c.this.mADStatus = AdStatus.AdStatusClose;
            Handler handler = c.this.a;
            final l lVar = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.c$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(lVar, placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.l
        public void onAdShow(final String placementId) {
            SigmobLog.i("onAdShow: placementId = " + placementId);
            c.this.mADStatus = AdStatus.AdStatusPlaying;
            Handler handler = c.this.a;
            final l lVar = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.c$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d(lVar, placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.l
        public void onAdShowError(final WindAdError error, final String placementId) {
            SigmobLog.e("onAdShowError: error = " + error.toString() + ", placementId = " + placementId);
            c.this.mADStatus = AdStatus.AdStatusClose;
            Handler handler = c.this.a;
            final l lVar = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.c$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(lVar, error, placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.l
        public void onVideoAdPlayComplete(final String placementId) {
            SigmobLog.i("onVideoAdPlayComplete: placementId = " + placementId);
            Handler handler = c.this.a;
            final l lVar = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.c$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    c.AnonymousClass1.c(lVar, placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.l
        public void onVideoAdPlayEnd(final String placementId) {
            SigmobLog.i("onVideoAdPlayEnd: placementId = " + placementId);
            Handler handler = c.this.a;
            final l lVar = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.c$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    c.AnonymousClass1.b(lVar, placementId);
                }
            });
        }
    }

    protected class a implements j {
        private j b;

        public a(j windAdLoadListener) {
            this.b = windAdLoadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(WindAdError windAdError, String str) {
            if (n.b(this.b)) {
                this.b.onAdLoadError(windAdError, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            if (n.b(this.b)) {
                this.b.onAdPreLoadSuccess(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(WindAdError windAdError, String str) {
            if (n.b(this.b)) {
                this.b.onAdPreLoadFail(windAdError, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            if (n.b(this.b)) {
                this.b.onAdLoadSuccess(str);
            }
        }

        public void a() {
            this.b = null;
        }

        @Override // com.sigmob.sdk.videoAd.j
        public void onAdLoadError(final WindAdError error, final String placementId) {
            SigmobLog.e("onAdLoadError: error = " + error.toString() + ", placementId = " + placementId + ", adStatus = " + c.this.mADStatus);
            if (c.this.mADStatus != AdStatus.AdStatusPlaying) {
                c.this.mADStatus = AdStatus.AdStatusNone;
            }
            c.this.a.post(new Runnable() { // from class: com.sigmob.sdk.c$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(error, placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.j
        public void onAdLoadSuccess(final String placementId) {
            SigmobLog.i("onAdLoadSuccess: placementId = " + placementId + ", adStatus = " + c.this.mADStatus);
            if (c.this.mADStatus != AdStatus.AdStatusPlaying) {
                c.this.mADStatus = AdStatus.AdStatusReady;
            }
            c.this.a.post(new Runnable() { // from class: com.sigmob.sdk.c$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.j
        public void onAdPreLoadFail(final WindAdError error, final String placementId) {
            SigmobLog.e("onAdPreLoadFail: error = " + error.toString() + ", placementId = " + placementId + ", adStatus = " + c.this.mADStatus);
            if (c.this.mADStatus != AdStatus.AdStatusPlaying) {
                c.this.mADStatus = AdStatus.AdStatusNone;
            }
            c.this.a.post(new Runnable() { // from class: com.sigmob.sdk.c$a$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(error, placementId);
                }
            });
        }

        @Override // com.sigmob.sdk.videoAd.j
        public void onAdPreLoadSuccess(final String placementId) {
            SigmobLog.i("onAdPreLoadSuccess: placementId = " + placementId);
            c.this.a.post(new Runnable() { // from class: com.sigmob.sdk.c$a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(placementId);
                }
            });
        }
    }

    protected c(WindAdRequest windAdRequest, boolean z, int i) {
        super(windAdRequest, z);
        this.i = getClass().getSimpleName();
        this.a = new Handler(Looper.getMainLooper());
        this.b = i;
        g.g().a(d(), windAdRequest.getAdType());
        this.c = (T) createAdManager();
    }

    private void a(T adManager) {
        String strJ = com.sigmob.sdk.manager.b.j();
        a((x) null, strJ);
        adManager.a(this.e, strJ);
    }

    protected void a(k windAdRewardListener) {
    }

    @Override // com.sigmob.sdk.base.m
    protected void a(WindAdError error) {
        if (this.mADStatus != AdStatus.AdStatusLoading) {
            this.mADStatus = AdStatus.AdStatusNone;
        }
        if (n.b(this.f)) {
            String strD = d();
            this.f.onAdPreLoadFail(error, strD);
            this.f.onAdLoadError(error, strD);
        }
    }

    protected void a(WindAdError error, String errMsg) {
        PointEntitySigmobError pointEntitySigmobErrorSigmobError = PointEntitySigmobError.SigmobError("error", error.getErrorCode(), errMsg);
        pointEntitySigmobErrorSigmobError.setAdtype(String.valueOf(this.b));
        pointEntitySigmobErrorSigmobError.setPlacement_id(d());
        pointEntitySigmobErrorSigmobError.commit();
    }

    @Override // com.sigmob.sdk.base.m
    protected void a(String key, String value) {
        T t = this.c;
        if (t == null) {
            return;
        }
        t.a(key, value);
    }

    protected boolean a() {
        T t;
        String strD = d();
        try {
            if (!loadAdFilter()) {
                return false;
            }
            if (n.b(this.g)) {
                this.g.a();
                this.g = null;
            }
            this.g = new a(this.f);
            T t2 = this.c;
            if (t2 == null) {
                this.c = (T) createAdManager();
            } else if (t2.c() && this.mADStatus == AdStatus.AdStatusReady) {
                this.g.onAdPreLoadSuccess(strD);
                this.g.onAdLoadSuccess(strD);
                return true;
            }
            LoadAdRequest loadAdRequest = new LoadAdRequest(this.h);
            this.e = loadAdRequest;
            loadAdRequest.setBidToken(getBid_token());
            this.e.setBidFloor(getBidFloor());
            this.e.setCurrency(getCurrency());
            this.c.a(this.g);
            if (this.mADStatus != AdStatus.AdStatusPlaying) {
                this.mADStatus = AdStatus.AdStatusLoading;
                t = this.c;
            } else {
                if (this.d != null) {
                    if (n.b(this.f)) {
                        SigmobLog.i("onVideoAdLoadSuccess: placementId = " + strD);
                        this.f.onAdLoadSuccess(strD);
                    }
                    return true;
                }
                T t3 = (T) createAdManager();
                this.d = t3;
                t3.a(this.g);
                t = this.d;
            }
            a((c<T>) t);
            return true;
        } catch (Throwable th) {
            PointEntitySigmobError pointEntitySigmobErrorSigmobError = PointEntitySigmobError.SigmobError("error", WindAdError.ERROR_SIGMOB_REQUEST.getErrorCode(), th.getMessage());
            pointEntitySigmobErrorSigmobError.setAdtype(String.valueOf(this.b));
            pointEntitySigmobErrorSigmobError.setPlacement_id(strD);
            pointEntitySigmobErrorSigmobError.commit();
            SigmobLog.e("onVideoAdLoadError: error = " + th.getMessage() + ", placementId = " + strD + ", adStatus = " + this.mADStatus);
            if (n.b(this.f)) {
                this.f.onAdLoadError(WindAdError.ERROR_SIGMOB_REQUEST, strD);
            }
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.m
    protected Map<String, BiddingResponse> b() {
        T t = this.c;
        if (t == null) {
            return null;
        }
        return t.b();
    }

    @Override // com.sigmob.sdk.base.m
    protected com.sigmob.sdk.manager.b c() {
        return this.c;
    }

    public abstract T createAdManager();

    public void destroy() {
        this.a.removeCallbacksAndMessages(null);
        if (n.b(this.g)) {
            this.g.a();
            this.g = null;
        }
        this.f = null;
        if (n.b(this.c)) {
            this.c.p();
            this.c = null;
        }
        if (n.b(this.d)) {
            this.d.p();
            this.d = null;
        }
    }

    @Override // com.sigmob.sdk.base.m
    public String getEcpm() {
        T t = this.c;
        if (t == null) {
            return null;
        }
        return t.a();
    }

    public boolean isReady() {
        return f();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd() {
        super.loadAd();
        return a();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd(String bidToken) {
        super.loadAd(bidToken);
        return a();
    }

    public void setAdLoadListener(j adLoadListener) {
        this.f = adLoadListener;
    }

    public boolean show(HashMap<String, String> options, l windAdShowListener) {
        return show(options, windAdShowListener, null);
    }

    public boolean show(HashMap<String, String> options, l showListener, k rewardListener) {
        try {
        } catch (Throwable th) {
            a(WindAdError.ERROR_SIGMOB_REQUEST, th.getMessage());
            SigmobLog.e("show: error = " + th.getMessage());
        }
        if (this.e == null) {
            a(WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY, "loadAdRequest is null.");
            if (!n.b(showListener)) {
                return false;
            }
            showListener.onAdShowError(WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY, d());
            return false;
        }
        if (n.b(options)) {
            if (options.containsKey(WindAds.AD_SCENE_ID)) {
                this.e.setAd_scene_id(options.get(WindAds.AD_SCENE_ID));
            }
            if (options.containsKey(WindAds.AD_SCENE_DESC)) {
                this.e.setAd_scene_desc(options.get(WindAds.AD_SCENE_DESC));
            }
        }
        if (this.b == 1) {
            a(rewardListener);
        }
        this.c.a(this.e, new AnonymousClass1(showListener));
        return true;
    }
}

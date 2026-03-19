package com.sigmob.windad.natives;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.manager.b;
import com.sigmob.sdk.nativead.w;
import com.sigmob.sdk.nativead.y;
import com.sigmob.windad.WindAdError;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindNativeUnifiedAd extends m {
    private WindNativeAdLoadListener a;
    private final Handler b;
    private final w c;

    /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1, reason: invalid class name */
    class AnonymousClass1 implements y {
        final /* synthetic */ WindNativeAdRequest a;

        AnonymousClass1(final WindNativeAdRequest val$request) {
            this.a = val$request;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, String str, WindNativeAdRequest windNativeAdRequest) {
            if (WindNativeUnifiedAd.this.a == null) {
                return;
            }
            WindAdError windAdError = WindAdError.getWindAdError(i);
            if (windAdError == null) {
                windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                windAdError.setErrorMessage(i, str);
                windAdError.setMessage(str);
            }
            WindNativeUnifiedAd.this.a.onAdError(windAdError, windNativeAdRequest.getPlacementId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(List list) {
            if (WindNativeUnifiedAd.this.a == null) {
                return;
            }
            WindNativeUnifiedAd.this.a.onAdLoad(list, WindNativeUnifiedAd.this.d());
        }

        @Override // com.sigmob.sdk.nativead.y
        public void onNativeAdLoadFail(final int errorCode, final String errorMsg) {
            WindNativeUnifiedAd.this.mADStatus = AdStatus.AdStatusNone;
            Handler handler = WindNativeUnifiedAd.this.b;
            final WindNativeAdRequest windNativeAdRequest = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(errorCode, errorMsg, windNativeAdRequest);
                }
            });
        }

        @Override // com.sigmob.sdk.nativead.y
        public void onNativeAdLoaded(final List<WindNativeAdData> adUnits) {
            WindNativeUnifiedAd.this.mADStatus = AdStatus.AdStatusNone;
            WindNativeUnifiedAd.this.b.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(adUnits);
                }
            });
        }
    }

    public interface WindNativeAdLoadListener {
        void onAdError(final WindAdError error, final String placementId);

        void onAdLoad(final List<WindNativeAdData> adDataList, final String placementId);
    }

    public WindNativeUnifiedAd(WindNativeAdRequest request) {
        super(request, false);
        this.b = new Handler(Looper.getMainLooper());
        this.c = new w(request, new AnonymousClass1(request));
    }

    private void a(Throwable e) {
        PointEntitySigmobError pointEntitySigmobErrorSigmobError = PointEntitySigmobError.SigmobError("error", WindAdError.ERROR_SIGMOB_REQUEST.getErrorCode(), e.getMessage());
        pointEntitySigmobErrorSigmobError.setAdtype(String.valueOf(5));
        pointEntitySigmobErrorSigmobError.setPlacement_id(d());
        pointEntitySigmobErrorSigmobError.commit();
        a(WindAdError.ERROR_SIGMOB_REQUEST);
    }

    private boolean a(int adCount) {
        try {
            if (!loadAdFilter()) {
                return false;
            }
            String strJ = b.j();
            this.mADStatus = AdStatus.AdStatusLoading;
            if (this.c.a(adCount, getBid_token(), getBidFloor(), getCurrency(), strJ) == 1) {
                a(x.a(d()), strJ);
            }
            return true;
        } catch (Throwable th) {
            SigmobLog.i(getClass().getSimpleName() + " catch throwable " + th);
            if (this.a == null) {
                return false;
            }
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setMessage(th.getMessage());
            this.a.onAdError(windAdError, d());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WindAdError windAdError) {
        this.mADStatus = AdStatus.AdStatusNone;
        if (this.a == null) {
            return;
        }
        SigmobLog.i("onVideoAdLoadFail " + windAdError.toString() + "|" + d());
        this.a.onAdError(windAdError, d());
    }

    @Override // com.sigmob.sdk.base.m
    protected void a(final WindAdError error) {
        this.b.post(new Runnable() { // from class: com.sigmob.windad.natives.WindNativeUnifiedAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(error);
            }
        });
    }

    @Override // com.sigmob.sdk.base.m
    protected void a(String key, String value) {
        w wVar = this.c;
        if (wVar == null) {
            return;
        }
        wVar.a(key, value);
    }

    @Override // com.sigmob.sdk.base.m
    protected Map<String, BiddingResponse> b() {
        w wVar = this.c;
        if (wVar == null) {
            return null;
        }
        return wVar.b();
    }

    @Override // com.sigmob.sdk.base.m
    protected b c() {
        return null;
    }

    public void destroy() {
        Object[] objArr = new Object[1];
        objArr[0] = this.h != null ? this.h.getPlacementId() : ILogConst.CACHE_PLAY_REASON_NULL;
        SigmobLog.i(String.format("native ad %s is Destroy", objArr));
        this.a = null;
    }

    @Override // com.sigmob.sdk.base.m
    public String getEcpm() {
        w wVar = this.c;
        if (wVar == null) {
            return null;
        }
        return wVar.a();
    }

    @Override // com.sigmob.sdk.base.m
    @Deprecated
    public boolean loadAd() {
        try {
            super.loadAd();
            return a(this.h.getAdCount());
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public boolean loadAd(int adCount) {
        try {
            super.loadAd();
            int iMax = Math.max(this.h.getAdCount(), adCount);
            this.h.setAdCount(iMax);
            return a(iMax);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd(String bidToken) {
        try {
            super.loadAd(bidToken);
            return a(this.h.getAdCount() > 0 ? this.h.getAdCount() : 1);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public boolean loadAd(String bidToken, int adCount) {
        try {
            super.loadAd(bidToken);
            return a(adCount);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public void setNativeAdLoadListener(WindNativeAdLoadListener nativeAdLoadListener) {
        this.a = nativeAdLoadListener;
    }
}

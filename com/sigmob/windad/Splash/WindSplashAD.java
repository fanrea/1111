package com.sigmob.windad.Splash;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.manager.b;
import com.sigmob.sdk.splash.e;
import com.sigmob.windad.WindAdError;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class WindSplashAD extends m implements AdLifecycleManager.LifecycleListener, WindSplashADListener {
    private WindSplashADListener a;
    private ViewGroup b;
    private final int c;
    private RelativeLayout d;
    private final boolean e;
    private boolean f;
    private boolean g;
    private final e i;
    private final Handler j;

    public WindSplashAD(WindSplashAdRequest adRequest, WindSplashADListener adListener) {
        super(adRequest, false);
        this.f = false;
        this.j = new Handler(Looper.getMainLooper());
        this.a = adListener;
        this.i = new e(adRequest, this);
        this.c = adRequest.getFetchDelay();
        this.e = adRequest.isDisableAutoHideAd();
    }

    private void a() {
        if (this.b == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.b.getContext());
        this.d = relativeLayout;
        relativeLayout.setVisibility(4);
        this.d.setId(ClientMetadata.generateViewId());
        this.b.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void a(final WindAdError error, final String placementId) {
        SigmobLog.e("onSplashError: error = " + error + ", placementId = " + placementId);
        if (this.f) {
            return;
        }
        this.j.removeMessages(1);
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(error, placementId);
            }
        });
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdSkip(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WindAdError windAdError) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdLoadFail(windAdError, d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WindAdError windAdError, String str) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdShowError(windAdError, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdClose(str);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(WindAdError windAdError, String str) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdLoadFail(windAdError, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdLoadSuccess(str);
        }
        if (this.g) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(WindAdError windAdError, String str) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        this.f = true;
        windSplashADListener.onSplashAdLoadFail(windAdError, str);
    }

    private void g() {
        if (this.i == null) {
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, d());
            return;
        }
        a();
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.k();
            }
        });
        this.mADStatus = AdStatus.AdStatusPlaying;
    }

    private boolean h() {
        if (this.i.c() && this.mADStatus == AdStatus.AdStatusReady) {
            SigmobLog.i("load: ready");
            return true;
        }
        if (!loadAdFilter()) {
            return false;
        }
        AdLifecycleManager.getInstance().addLifecycleListener(this);
        this.mADStatus = AdStatus.AdStatusLoading;
        String strJ = b.j();
        a((x) null, strJ);
        this.i.a(getBid_token(), getBidFloor(), getCurrency(), this.c, false, j.NormalRequest, strJ);
        return true;
    }

    private void i() {
        ViewGroup viewGroup;
        Activity activityC;
        if (Build.VERSION.SDK_INT < 19 || (viewGroup = this.b) == null || (activityC = o.c(viewGroup)) == null) {
            return;
        }
        Window window = activityC.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = 2050;
        window.setAttributes(attributes);
        window.addFlags(1024);
    }

    private void j() {
        if (this.e) {
            return;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            this.d.removeAllViews();
            this.d = null;
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.i.a((ViewGroup) this.d);
    }

    @Override // com.sigmob.sdk.base.m
    protected void a(final WindAdError adError) {
        this.mADStatus = AdStatus.AdStatusNone;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(adError);
            }
        });
    }

    @Override // com.sigmob.sdk.base.m
    protected void a(String key, String value) {
        e eVar = this.i;
        if (eVar == null) {
            return;
        }
        eVar.a(key, value);
    }

    @Override // com.sigmob.sdk.base.m
    protected Map<String, BiddingResponse> b() {
        e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        return eVar.r();
    }

    @Override // com.sigmob.sdk.base.m
    protected b c() {
        return this.i;
    }

    public void destroy() {
        Object[] objArr = new Object[1];
        objArr[0] = this.h != null ? this.h.getPlacementId() : ILogConst.CACHE_PLAY_REASON_NULL;
        SigmobLog.i(String.format("splash ad %s is Destroy", objArr));
        e eVar = this.i;
        if (eVar != null) {
            eVar.n();
            this.j.removeCallbacksAndMessages(null);
            this.a = null;
            this.b = null;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null && !this.e) {
            relativeLayout.setVisibility(8);
            this.d.removeAllViews();
        }
        this.d = null;
    }

    @Override // com.sigmob.sdk.base.m
    public String getEcpm() {
        e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        return eVar.q();
    }

    public boolean isReady() {
        return f();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd() {
        this.g = false;
        super.loadAd();
        return h();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd(String bid_token) {
        super.loadAd(bid_token);
        return h();
    }

    public void loadAndShow(ViewGroup adContainer) {
        if (adContainer == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd();
        this.b = adContainer;
        this.g = true;
        h();
    }

    public void loadAndShow(String bidToken, ViewGroup adContainer) {
        if (adContainer == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd(bidToken);
        this.b = adContainer;
        this.g = true;
        h();
    }

    public void onCreate(Activity activity) {
    }

    public void onDestroy(Activity activity) {
    }

    public void onPause(Activity activity) {
        e eVar = this.i;
        if (eVar == null) {
            return;
        }
        eVar.a(activity);
    }

    public void onResume(Activity activity) {
        e eVar = this.i;
        if (eVar == null) {
            return;
        }
        eVar.b(activity);
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClick(String placementId) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdClick(placementId);
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClose(final String placementId) {
        this.mADStatus = AdStatus.AdStatusClose;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(placementId);
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadFail(final WindAdError error, final String placementId) {
        this.mADStatus = AdStatus.AdStatusNone;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(error, placementId);
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadSuccess(final String placementId) {
        this.mADStatus = AdStatus.AdStatusReady;
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(placementId);
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShow(String placementId) {
        WindSplashADListener windSplashADListener = this.a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdShow(placementId);
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShowError(final WindAdError error, final String placementId) {
        this.mADStatus = AdStatus.AdStatusNone;
        b bVar = this.i;
        bVar.b(bVar);
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(error, placementId);
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdSkip(final String placementId) {
        this.j.post(new Runnable() { // from class: com.sigmob.windad.Splash.WindSplashAD$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(placementId);
            }
        });
    }

    public void onStart(Activity activity) {
    }

    public void onStop(Activity activity) {
    }

    public void show(ViewGroup adContainer) {
        e eVar;
        if (this.g || (eVar = this.i) == null) {
            if (n.b(this.i)) {
                b bVar = this.i;
                bVar.b(bVar);
            }
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, d());
            return;
        }
        if (eVar.d()) {
            onSplashAdShowError(WindAdError.ERROR_SIGMOB_EXPIRED, d());
            return;
        }
        if (!isReady()) {
            b bVar2 = this.i;
            bVar2.b(bVar2);
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, d());
        } else if (adContainer == null) {
            onSplashAdShowError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL, d());
        } else {
            this.b = adContainer;
            g();
        }
    }
}

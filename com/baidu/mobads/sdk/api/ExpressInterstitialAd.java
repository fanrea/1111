package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.de;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private long mLoadTime;
    private de mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    public ExpressInterstitialAd(Context context, String str, int i, int i2) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void setDialogFrame(boolean z) {
        this.mUseDialogFrame = z;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.a(expressInterstitialListener);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void load() {
        this.mLoadTime = System.currentTimeMillis();
        if (this.mContext == null) {
            az.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void show() {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null) {
            return;
        }
        if (deVar.f()) {
            this.mNativeInterstitialAdProd.g();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void show(Activity activity) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null) {
            return;
        }
        deVar.a(activity);
        show();
    }

    public void destroy() {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null) {
            return;
        }
        deVar.p();
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    private void initNativeInterstitialAdProd() {
        System.currentTimeMillis();
        cs csVar = new cs(this.mContext);
        csVar.a(new cs.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return i == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onLayoutComplete(int i, int i2) {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onWindowVisibilityChanged(int i) {
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void dispatchTouchEvent(MotionEvent motionEvent) {
                ExpressInterstitialAd.this.mNativeInterstitialAdProd.a(motionEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.cs.a
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.o();
                }
            }
        });
        this.mNativeInterstitialAdProd = new de(this.mContext, csVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.q = this.mAppsid;
        }
        this.mNativeInterstitialAdProd.r = this.mBidFloor;
        this.mNativeInterstitialAdProd.t = this.onlyFetchAd;
        this.mNativeInterstitialAdProd.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    public String getECPMLevel() {
        a aVarX;
        de deVar = this.mNativeInterstitialAdProd;
        return (deVar == null || (aVarX = deVar.x()) == null) ? "" : aVarX.z();
    }

    public String getPECPM() {
        a aVarX;
        de deVar = this.mNativeInterstitialAdProd;
        return (deVar == null || (aVarX = deVar.x()) == null) ? "" : aVarX.A();
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public boolean isReady() {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar == null || deVar.m == null) {
            return false;
        }
        return this.mNativeInterstitialAdProd.m.isAdReady();
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.a(false, linkedHashMap, biddingListener);
        }
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.l();
    }

    public void loadBiddingAd(String str) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.c(str);
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            deVar.b(str);
        }
    }

    public void useUseDialogContainer(boolean z) {
        this.mUseDialogContainer = z;
    }

    public Object getAdDataForKey(String str) {
        de deVar = this.mNativeInterstitialAdProd;
        if (deVar != null) {
            return deVar.a(str);
        }
        return null;
    }
}

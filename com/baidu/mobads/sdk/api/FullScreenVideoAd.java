package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.dg;
import com.baidu.mobads.sdk.internal.di;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private di mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        this.mContext = context;
        dg dgVar = new dg(context, str, z);
        this.mAdProd = dgVar;
        dgVar.a(fullScreenVideoAdListener);
    }

    public synchronized void load() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a();
        }
    }

    public String getBiddingToken() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.l();
        }
        return null;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        di diVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (diVar = this.mAdProd) == null) {
            return;
        }
        diVar.a(requestParameters);
    }

    public void loadBiddingAd(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.c(str);
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.b(str);
        }
    }

    public synchronized void show() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.e();
        }
    }

    public synchronized void show(Context context) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(context);
        }
    }

    public boolean isReady() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.f();
        }
        return false;
    }

    public void setAppSid(String str) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.h(str);
        }
    }

    public String getECPMLevel() {
        di diVar = this.mAdProd;
        return diVar != null ? diVar.g() : "";
    }

    public String getPECPM() {
        di diVar = this.mAdProd;
        return diVar != null ? diVar.x() : "";
    }

    public void setBidFloor(int i) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.r = i;
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.a(false, linkedHashMap, biddingListener);
        }
    }
}

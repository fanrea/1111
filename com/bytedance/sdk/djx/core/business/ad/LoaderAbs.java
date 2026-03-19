package com.bytedance.sdk.djx.core.business.ad;

import android.text.TextUtils;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.utils.LG;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class LoaderAbs {
    private static final String TAG = "LoaderAbs";
    protected AdKey mAdKey;
    protected boolean mIsLoading = false;

    public interface Callback {
        void onAdLoadError(int i, String str);

        void onAdLoadSuccess(List<IDJXAd> list);
    }

    protected abstract void doLoad();

    protected abstract void doLoad(LoaderModel loaderModel, Callback callback);

    public String getToken() {
        return null;
    }

    public LoaderAbs(AdKey adKey) {
        this.mAdKey = adKey;
    }

    public void load(LoaderModel loaderModel, Callback callback) {
        AdKey adKey = this.mAdKey;
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId()) || loaderModel == null) {
            return;
        }
        AdLog.getInstance().sendAdRequest(this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
        if (AdManager.inst().mAdListenerMap != null) {
            HashMap map = new HashMap();
            map.put(IDJXAd.AD_CODE_ID, this.mAdKey.getCodeId());
            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(this.mAdKey.getParamsCode()));
            if (iDJXAdListener != null) {
                iDJXAdListener.onDJXAdRequest(map);
            }
        }
        doLoad(loaderModel, callback);
    }

    public void load() {
        AdKey adKey = this.mAdKey;
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            return;
        }
        if (this.mIsLoading) {
            LG.d("AdLog-LoaderAbs", "ad is loading...: " + this.mAdKey.getCodeId());
            return;
        }
        this.mIsLoading = true;
        LG.d("AdLog-LoaderAbs", "ad load start: " + this.mAdKey.getCodeId());
        AdLog.getInstance().sendAdRequest(this.mAdKey, null, false);
        if (AdManager.inst().mAdListenerMap != null) {
            HashMap map = new HashMap();
            map.put(IDJXAd.AD_CODE_ID, this.mAdKey.getCodeId());
            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(this.mAdKey.getParamsCode()));
            if (iDJXAdListener != null) {
                iDJXAdListener.onDJXAdRequest(map);
            }
        }
        doLoad();
    }
}

package com.bytedance.sdk.djx.core.business.ad.open;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class OpenLoaderAbs extends LoaderAbs {
    private static final String TAG = "OpenLoaderAbs";
    protected TTAdNative mTTAdNative;

    protected AdSlot.Builder buildAdSlot() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(LoaderModel loaderModel, LoaderAbs.Callback callback) {
    }

    public OpenLoaderAbs(AdKey adKey) {
        super(adKey);
        this.mTTAdNative = TTAdSdk.getAdManager().createAdNative(InnerManager.getContext());
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
        if (this.mTTAdNative == null) {
            LG.d("AdLog-OpenLoaderAbs", "open ad load error: ttAdNative = null");
        } else {
            super.load();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        if (this.mTTAdNative == null) {
            LG.d("AdLog-OpenLoaderAbs", "open ad load error: ttAdNative = null");
        } else {
            super.load(loaderModel, callback);
        }
    }
}

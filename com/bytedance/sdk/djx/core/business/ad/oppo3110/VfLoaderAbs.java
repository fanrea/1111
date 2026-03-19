package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.TTVfSdk;
import com.bykv.vk.openvk.VfSlot;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class VfLoaderAbs extends LoaderAbs {
    private static final String TAG = "VfLoaderAbs";
    protected TTVfNative mTTAdNative;

    protected VfSlot.Builder buildAdSlot() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(LoaderModel loaderModel, LoaderAbs.Callback callback) {
    }

    public VfLoaderAbs(AdKey adKey) {
        super(adKey);
        this.mTTAdNative = TTVfSdk.getVfManager().createVfNative(InnerManager.getContext());
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
        if (this.mTTAdNative == null) {
            LG.d("AdLog-VfLoaderAbs", "vf ad load error: ttAdNative = null");
        } else {
            super.load();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        if (this.mTTAdNative == null) {
            LG.d("AdLog-VfLoaderAbs", "vf ad load error: ttAdNative = null");
        } else {
            super.load(loaderModel, callback);
        }
    }
}

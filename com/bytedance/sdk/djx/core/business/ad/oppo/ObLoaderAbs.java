package com.bytedance.sdk.djx.core.business.ad.oppo;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.ttshell.sdk.api.TTObNative;
import com.ttshell.sdk.api.config.TTObSdk;
import com.ttshell.sdk.api.model.TTObSlot;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class ObLoaderAbs extends LoaderAbs {
    private static final String TAG = "ObLoaderAbs";
    protected TTObNative mTTAdNative;

    protected TTObSlot.Builder buildAdSlot() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected abstract void doLoad();

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(LoaderModel loaderModel, LoaderAbs.Callback callback) {
    }

    public ObLoaderAbs(AdKey adKey) {
        super(adKey);
        this.mTTAdNative = TTObSdk.getAdManager().createObNative(InnerManager.getContext());
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
        if (this.mTTAdNative == null) {
            LG.d("AdLog-ObLoaderAbs", "ob ad load error: ttAdNative = null");
        } else {
            super.load();
        }
    }
}

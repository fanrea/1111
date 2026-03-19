package com.bytedance.sdk.djx.core.business.ad.oppo;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderAdapter;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ObLoaderAdapter implements LoaderAdapter {
    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAdapter
    public LoaderAbs build(boolean z, int i, AdKey adKey, IDJXAdListener iDJXAdListener) {
        if (i == 1) {
            return new Loader4ObExpressDrawFeed(adKey);
        }
        if (i == 2) {
            return new Loader4ObNativeExpress(adKey);
        }
        if (i == 3) {
            return new Loader4ObFeed(adKey);
        }
        if (i == 5) {
            return new Loader4ObExpressReward(adKey);
        }
        return null;
    }
}

package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderAdapter;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfLoaderAdapter implements LoaderAdapter {
    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAdapter
    public LoaderAbs build(boolean z, int i, AdKey adKey, IDJXAdListener iDJXAdListener) {
        if (z) {
            if (i == 1) {
                return new LoaderMix4VfExpressDrawFeed(adKey);
            }
            if (i == 4) {
                return new LoaderMix4VfNativeDrawFeed(adKey);
            }
            if (i == 2) {
                return new LoaderMix4VfNativeExpress(adKey);
            }
            if (i == 6) {
                return new LoaderMix4VfInteractionExpress(adKey);
            }
            if (i == 7) {
                return new LoaderMix4VfInteractionExpressNew(adKey);
            }
            return null;
        }
        if (i == 1) {
            return new Loader4VfExpressDrawFeed(adKey);
        }
        if (i == 2) {
            return new Loader4VfNativeExpress(adKey);
        }
        if (i == 3) {
            return new Loader4VfFeed(adKey);
        }
        if (i == 4) {
            return new Loader4VfNativeDrawFeed(adKey);
        }
        if (i == 5) {
            return new Loader4VfExpressReward(adKey);
        }
        if (i == 7) {
            return new Loader4VfInteractionExpressNew(adKey);
        }
        return null;
    }
}

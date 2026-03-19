package com.bytedance.sdk.djx.core.business.ad.open;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderAdapter;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenLoaderAdapter implements LoaderAdapter {
    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAdapter
    public LoaderAbs build(boolean z, int i, AdKey adKey, IDJXAdListener iDJXAdListener) {
        if (z) {
            if (i == 1) {
                return new LoaderMix4ExpressDrawFeed(adKey);
            }
            if (i == 4) {
                return new LoaderMix4NativeDrawFeed(adKey);
            }
            if (i == 2) {
                return new LoaderMix4NativeExpress(adKey);
            }
            if (i == 6) {
                return new LoaderMix4InteractionExpress(adKey);
            }
            if (i == 7) {
                return new LoaderMix4InteractionExpressNew(adKey);
            }
            return null;
        }
        if (i == 1) {
            return new Loader4ExpressDrawFeed(adKey);
        }
        if (i == 2) {
            return new Loader4NativeExpress(adKey);
        }
        if (i == 3) {
            return new Loader4Feed(adKey);
        }
        if (i == 4) {
            return new Loader4NativeDrawFeed(adKey);
        }
        if (i == 5) {
            return new Loader4ExpressReward(adKey);
        }
        if (i == 7) {
            return new Loader4InteractionExpressNew(adKey);
        }
        if (i == 8) {
            return new Loader4Banner(adKey);
        }
        return null;
    }
}

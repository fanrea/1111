package com.bytedance.sdk.djx.core.business.ad;

import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DefaultLoaderAdapter implements LoaderAdapter {
    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAdapter
    public LoaderAbs build(boolean z, int i, AdKey adKey, IDJXAdListener iDJXAdListener) {
        return new DefaultLoader(adKey);
    }
}

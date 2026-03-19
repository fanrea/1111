package com.kwad.components.ad.nativead.a;

import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public c mApkDownloadHelper;
    public KsNativeAd.VideoPlayListener qH;
    public d.a qN;
    public AdBasePvFrameLayout rb;
    public com.kwad.components.ad.nativead.c.a rh;
    public boolean rm = false;
    public boolean rn = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.rh.release();
    }
}

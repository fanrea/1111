package com.kwad.components.ad;

import com.kwad.components.core.internal.api.c;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements com.kwad.components.core.internal.api.a {
    public c dl = new c();
    protected final AdResultData mAdResultData;
    protected final AdTemplate mAdTemplate;

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    public b(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bi(e.eP(this.mAdTemplate));
    }

    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aV(e.eP(this.mAdTemplate));
    }

    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    public void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, j);
    }

    public Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.Yf()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.bk(e.eP(this.mAdTemplate));
    }

    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aU(e.eP(this.mAdTemplate));
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.dl.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.dl.b(bVar);
    }
}

package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.ba;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private IAdLiveEndRequest kJ;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.kJ = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return ba.appendUrl(this.kJ.getUrl(), this.kJ.getUrlParam());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.kJ;
        if (iAdLiveEndRequest == null || iAdLiveEndRequest.getHeader() == null || this.kJ.getHeader().size() <= 0) {
            return super.getHeader();
        }
        for (String str : this.kJ.getHeader().keySet()) {
            if (!TextUtils.isEmpty(this.kJ.getHeader().get(str))) {
                addHeader(str, this.kJ.getHeader().get(str));
            }
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.kJ.getBodyMap();
    }
}

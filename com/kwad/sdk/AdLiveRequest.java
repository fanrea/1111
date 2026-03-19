package com.kwad.sdk;

import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.live.audience.api.KSLiveRequest;
import com.kwad.sdk.live.audience.api.KSLiveRequestHelper;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AdLiveRequest implements IAdLiveEndRequest {
    private KSLiveRequest mKSLiveRequest;

    public AdLiveRequest(String str) {
        this.mKSLiveRequest = KSLiveRequestHelper.buildGetEndSummaryRequest(str);
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest
    public String getUrl() {
        KSLiveRequest kSLiveRequest = this.mKSLiveRequest;
        return kSLiveRequest != null ? kSLiveRequest.mUrl : "";
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest
    public Map<String, String> getUrlParam() {
        KSLiveRequest kSLiveRequest = this.mKSLiveRequest;
        if (kSLiveRequest != null) {
            return kSLiveRequest.mUrlParam;
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest
    public Map<String, String> getBodyMap() {
        KSLiveRequest kSLiveRequest = this.mKSLiveRequest;
        if (kSLiveRequest != null) {
            return kSLiveRequest.mBodyParam;
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest
    public Map<String, String> getHeader() {
        KSLiveRequest kSLiveRequest = this.mKSLiveRequest;
        if (kSLiveRequest != null) {
            return kSLiveRequest.mHeaderParam;
        }
        return null;
    }
}

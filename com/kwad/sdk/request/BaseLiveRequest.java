package com.kwad.sdk.request;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.utils.LiveRequestDataUtils;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.live.audience.api.KSLiveRequest;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class BaseLiveRequest implements IOfflineCompoRequest {
    private final KSLiveRequest mKSLiveRequest;

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public boolean encryptDisable() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public JSONObject getBody() {
        return null;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getRequestHost() {
        return null;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public KsScene getScene() {
        return null;
    }

    public BaseLiveRequest(KSLiveRequest kSLiveRequest) {
        this.mKSLiveRequest = kSLiveRequest;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getUrl() {
        return LiveRequestDataUtils.appendUrl(this.mKSLiveRequest.mUrl, this.mKSLiveRequest.mUrlParam);
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map<String, String> getHeader() {
        return this.mKSLiveRequest.mHeaderParam;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map<String, String> getBodyMap() {
        return this.mKSLiveRequest.mBodyParam;
    }
}

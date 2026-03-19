package com.kwad.sdk.init;

import com.kwad.sdk.live.audience.api.KSLiveRequest;
import com.kwad.sdk.live.audience.listener.KSLiveHttpDelegate;
import com.kwad.sdk.utils.KSHttpClient;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSHttpDelegate implements KSLiveHttpDelegate {
    private KSHttpClient mHttpClient = new KSHttpClient();

    @Override // com.kwad.sdk.live.audience.listener.KSLiveHttpDelegate
    public String syncHttpRequest(KSLiveRequest kSLiveRequest) {
        return this.mHttpClient.doHttpRequest1(kSLiveRequest);
    }
}

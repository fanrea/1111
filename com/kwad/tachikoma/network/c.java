package com.kwad.tachikoma.network;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoRequest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class c extends OfflineCompoRequest {
    public abstract IOfflineCompoRequest iL();

    public c() {
        if (iL() != null) {
            putBody(iL().getBody());
            Map<String, String> header = iL().getHeader();
            if (header != null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getUrl() {
        if (iL() != null) {
            return iL().getUrl();
        }
        return null;
    }
}

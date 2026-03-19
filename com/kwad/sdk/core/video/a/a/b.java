package com.kwad.sdk.core.video.a.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.request.model.d;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b extends com.kwad.sdk.core.network.b {
    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public b(List<c> list) {
        putBody("actionList", list);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Tj();
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((f) ServiceProvider.get(f.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((f) ServiceProvider.get(f.class)).getApiVersionCode());
        putBody("sdkType", 2);
        putBody("appInfo", com.kwad.sdk.core.request.model.a.abA());
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.cx(false));
        putBody("networkInfo", d.abE());
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.abD());
    }
}

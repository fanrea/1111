package com.kwad.sdk.core.network;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.audience.model.KSLiveTopUser;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    protected boolean enablePrivateInfoObtain() {
        return true;
    }

    protected boolean needAppList() {
        return false;
    }

    protected boolean needAppendKuaHeader() {
        return true;
    }

    public d() {
        this(0, null);
    }

    public d(int i, SceneImpl sceneImpl) {
        if (needAppendKuaHeader()) {
            appendKUAHeader();
        }
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.k(needAppList(), i));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.r(sceneImpl));
        }
    }

    private void appendKUAHeader() {
        com.kwad.sdk.service.a.f fVar;
        com.kwad.sdk.core.i.c cVarR = com.kwad.sdk.core.i.a.r(true, false);
        if (cVarR == null || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null) {
            return;
        }
        addHeader("KUA", cVarR.bY(fVar.getContext()));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseBody() {
        try {
            putBody("protocolVersion", "2.0");
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            putBody("sdkType", 2);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.abA());
            putBody("tkVersion", "6.1.7");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.abE());
            int i = 1;
            putBody("liveSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).qI() ? 1 : 0);
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).qH()) {
                i = 0;
            }
            putBody("waynePlayerSupportMode", i);
            putBody(KSLiveTopUser.KEY_USER_INFO, com.kwad.sdk.core.request.model.g.abH());
            putBody("requestSessionData", q.aas().fp(getUrl()));
            putBody(com.alipay.sdk.m.t.a.k, System.currentTimeMillis());
            if (enablePrivateInfoObtain()) {
                buildBaseBodyWithPrivateInfo();
            }
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        putBody("mediumDisableSensor", bd.useSensorManagerDisable());
    }

    protected void buildBaseBodyWithPrivateInfo() {
        try {
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.abD());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TV());
            putBody("ext", com.kwad.sdk.core.request.model.e.abG());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseHeader() {
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        }
    }
}

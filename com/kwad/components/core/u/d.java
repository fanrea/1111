package com.kwad.components.core.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static boolean tu() {
        com.kwad.sdk.core.d.c.d("AdxUtils", "isUseAdx BuildConfig.isUseAdx: " + com.kwad.components.core.a.OT);
        boolean z = false;
        if (!com.kwad.components.core.a.OT.booleanValue()) {
            return false;
        }
        com.kwad.sdk.core.d.c.d("AdxUtils", "isUseAdx KsAdSDKImpl.get().isAdxEnable(): " + com.kwad.sdk.l.UL().Vo());
        if (!com.kwad.sdk.l.UL().Vo()) {
            return false;
        }
        com.kwad.components.adx.api.a aVar = (com.kwad.components.adx.api.a) com.kwad.sdk.components.d.g(com.kwad.components.adx.api.a.class);
        if (aVar != null && aVar.oc()) {
            z = true;
        }
        com.kwad.sdk.core.d.c.d("AdxUtils", "AdxComponents " + aVar + " useAdx() :" + z);
        return z;
    }
}

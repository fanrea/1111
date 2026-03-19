package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.be;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String bGG;
    public String bGH;
    public int bGI;
    public int operatorType;

    public static d abE() {
        d dVar = new d();
        try {
            Context contextAnu = ServiceProvider.anu();
            dVar.bGG = be.ei(contextAnu);
            dVar.bGH = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TU();
            dVar.bGI = ao.dX(contextAnu);
            dVar.operatorType = ao.d(contextAnu, be.el(contextAnu), bd.useNetworkStateDisable());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return dVar;
    }

    public static d abF() {
        d dVar = new d();
        dVar.bGI = ao.dX(ServiceProvider.getContext());
        return dVar;
    }
}

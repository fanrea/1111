package com.kwad.components.offline.c;

import android.content.Context;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.p.b.a<IObiwanOfflineCompo> {
    @Override // com.kwad.components.core.p.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qM() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qN() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qO() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qP() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qQ() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qR() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qS() {
        return IObiwanOfflineCompo.IMPL;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.kwad.components.core.p.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IObiwanOfflineCompo) iOfflineCompo);
    }

    static final class a {
        private static final b bbK = new b(0);
    }

    private static b LS() {
        return a.bbK;
    }

    private b() {
    }

    public static void aQ(Context context) {
        LS().init(context);
    }

    @Override // com.kwad.components.core.p.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.byJ)).booleanValue();
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.c.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    final com.kwad.components.offline.c.a aVar = new com.kwad.components.offline.c.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.d.a(com.kwad.components.core.p.a.d.a.class, aVar);
                    com.kwad.sdk.core.d.c.a(new c(aVar.getLog()));
                    b.this.qL();
                    h.b(new h.a() { // from class: com.kwad.components.offline.c.b.1.1
                        @Override // com.kwad.components.core.request.h.a
                        public final void sF() {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.h.a
                        public final void d(SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        private void updateConfigs() {
                            com.kwad.sdk.core.d.c.a(e.a(com.kwad.sdk.core.config.c.byJ) ? new c(aVar.getLog()) : null);
                            aVar.updateConfigs();
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.aP(i);
            }
        });
    }
}

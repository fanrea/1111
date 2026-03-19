package com.kwad.components.offline.a;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.so.BuildConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.p.b.a<IAdLiveOfflineCompo> {
    @Override // com.kwad.components.core.p.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qM() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qN() {
        return "com.kwad.components.adLive";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qO() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qP() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.76-089e702802-65.zip";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qQ() {
        return "611820df0455699043f4a75e86ea0e69";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qR() {
        return "ks_live_3376";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qS() {
        return IAdLiveOfflineCompo.IMPL;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.kwad.components.core.p.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IAdLiveOfflineCompo) iOfflineCompo);
    }

    static final class a {
        private static final b bbe = new b(0);
    }

    private static b LN() {
        return a.bbe;
    }

    private b() {
    }

    public static void aQ(Context context) {
        LN().init(context);
    }

    @Override // com.kwad.components.core.p.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.byg)).booleanValue();
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.p.a.b.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                    b.this.qL();
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

package com.kwad.components.offline.b;

import android.content.Context;
import android.os.Build;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.p.b.a<IAdWaynePlayerOfflineCompo> {
    @Override // com.kwad.components.core.p.b.a
    public final String getTag() {
        return "AdWaynePlayerInitModule";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qM() {
        return "WAYNEPLAYER";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qN() {
        return IAdWaynePlayerOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qO() {
        return "4.4.20.1";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qP() {
        return "https://p5-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adWaynePlayer/ks_so-adWaynePlayerNoSoRelease-4.4.20.1-f5fa94106c-87.zip";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qQ() {
        return "de8902ac8ffc6225035515217d960ba1";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qR() {
        return "ks_wayne_player_44201";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qS() {
        return IAdWaynePlayerOfflineCompo.IMPL;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.kwad.components.core.p.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IAdWaynePlayerOfflineCompo) iOfflineCompo);
    }

    static final class a {
        private static final b bbq = new b(0);
    }

    private static b LQ() {
        return a.bbq;
    }

    private b() {
    }

    public static void aQ(Context context) {
        LQ().init(context);
    }

    private void a(Context context, final IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        iAdWaynePlayerOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.p.a.a.a.class, new com.kwad.components.offline.b.a(iAdWaynePlayerOfflineCompo));
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

    @Override // com.kwad.components.core.p.b.a
    public final boolean isEnabled() {
        e.a(com.kwad.sdk.core.config.c.bAi);
        if (Build.VERSION.SDK_INT < 18) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        return false;
    }
}

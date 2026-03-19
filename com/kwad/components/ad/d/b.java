package com.kwad.components.ad.d;

import android.text.TextUtils;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static boolean a(AdTemplate adTemplate, boolean z, final AdVideoPreCacheConfig adVideoPreCacheConfig, final a aVar) {
        String strL = com.kwad.sdk.core.response.b.a.L(e.eP(adTemplate));
        if (TextUtils.isEmpty(strL)) {
            return false;
        }
        final long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        String str = "";
        boolean zA = true;
        if (adVideoPreCacheSize > 0) {
            long j = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0589a c0589a = new a.C0589a();
            f fVarCh = com.kwad.sdk.core.videocache.c.a.ch(ServiceProvider.getContext());
            if (fVarCh.gb(strL)) {
                a(aVar);
            } else {
                zA = fVarCh.a(strL, j, c0589a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.d.b.1
                    private boolean dT = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j2, long j3) {
                        if ((j2 >= adVideoPreCacheSize || j2 >= j3) && !this.dT) {
                            this.dT = true;
                            b.a(aVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }
            str = c0589a.msg;
        } else if (adVideoPreCacheSize < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strL);
            if (!w.Y(fileDw)) {
                a.C0589a c0589a2 = new a.C0589a();
                zA = com.kwad.sdk.core.diskcache.b.a.ZH().a(strL, c0589a2);
                str = c0589a2.msg;
            }
            adTemplate.setDownloadSize(fileDw != null ? fileDw.length() : 0L);
            if (zA) {
                a(aVar);
            }
        } else {
            a(aVar);
        }
        if (zA) {
            m.m(strL, adVideoPreCacheConfig.getAdVideoPreCacheSize());
        } else {
            c.a(z, adTemplate, str);
            com.kwad.components.ad.reward.monitor.b.a(z, adTemplate);
            a(aVar, str);
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.aj();
    }

    private static void a(a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.ak();
    }
}

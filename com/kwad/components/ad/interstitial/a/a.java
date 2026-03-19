package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static boolean t(AdTemplate adTemplate) {
        boolean zA;
        f fVarCh;
        String strL = com.kwad.sdk.core.response.b.a.L(e.eP(adTemplate));
        if (TextUtils.isEmpty(strL)) {
            b.eV().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.eV().y(adTemplate);
        int iUw = com.kwad.sdk.core.config.e.Uw();
        String str = "";
        if (iUw < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strL);
            if (w.Y(fileDw)) {
                zA = true;
            } else {
                a.C0589a c0589a = new a.C0589a();
                zA = com.kwad.sdk.core.diskcache.b.a.ZH().a(strL, c0589a);
                str = c0589a.msg;
            }
            adTemplate.setDownloadSize(fileDw != null ? fileDw.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (iUw > 0) {
            a.C0589a c0589a2 = new a.C0589a();
            if (com.kwad.sdk.core.config.e.YR() == 1) {
                fVarCh = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0);
            } else if (com.kwad.sdk.core.config.e.YR() == 2) {
                fVarCh = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1);
            } else {
                fVarCh = com.kwad.sdk.core.videocache.c.a.ch(ServiceProvider.getContext());
            }
            zA = !fVarCh.gc(strL) ? fVarCh.a(strL, iUw * 1024, c0589a2, null) : true;
            str = c0589a2.msg;
            adTemplate.setDownloadSize(iUw * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            zA = true;
        }
        if (!zA) {
            adTemplate.setDownloadStatus(2);
            b.eV().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.fb();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        } else {
            adTemplate.setDownloadStatus(1);
        }
        return zA;
    }
}
